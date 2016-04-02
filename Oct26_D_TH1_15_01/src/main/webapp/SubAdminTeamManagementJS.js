$(document).ready(
				function() {
					//$("#employeeDiv").hide();
					//$("#updateTeamDiv").hide();
					$("#viewTeam").click(viewTeams);
					$("#addTeam").click(function() {
						var teamDesc = $('#addTeamDescription').val();
						if (jQuery.trim(teamDesc).length <= 0) {
							alert("Team Description is empty");
						} else {
							$.post("AddTeam", {
								description : teamDesc
							}, function(data, status) {
								if (data == -1) {
									alert("Team is already added");
								} else {
									alert("Team is added");
									$('#viewTeam').trigger('click');
								}
							});
						}
					});

					$("#deleteTeam").click(
							function() {
								if (confirm("Are you sure?")) {
									var id = $('#teamList1').find(":selected")
											.val();
									$.post("DeleteTeam", {
										id : id
									}, function(data, status) {
										if (data != 1) {
											alert("Team can't be deleted");
										} else {
											alert("Team deleted");
											$('#teamList1').find(":selected")
													.prop("selected", false);
											$('#viewTeam').trigger('click');
										}
									});
								} else {
								}
							});

					$("#updateTeam").click(function() {
						$("#updateTeamDiv").show();
					});

					$("#updateConfirmTeam").click(
						function() {
							var newDesc = $('#updateTeamDescription').val();
							if (jQuery.trim(newDesc).length <= 0) {
								alert("Team Description is empty");
							} else {
								if (confirm("Are you sure?")) {
									var id = $('#teamList1').find(":selected").val();
									$.post("UpdateTeam",{
										id : id,
										newDesc : newDesc
									},function(data,status) {
										if (data != 1) {
											alert("Team can't be updated");
										} else {
											$("#updateTeamDiv").hide();
											alert("Team updated");
											$('#teamList1').find(":selected").prop("selected",false);
											$('#viewTeam').trigger('click');
										}
									});
								} else {
									}
								}
							});

					$("#viewMembers").click(
						function() {
							$('#employeeDiv').show();
							$("#myTable").find("tr:gt(0)").remove();
							var id = $('#teamList2').find(":selected").val();
							$.post("ViewMembers",{
								id : id
							},
							function(data, status) {
								$(data).find('EMPLOYEE').each(
									function() {
										var employeeId = $(this).find('EMP_ID').text();
										var firstName = $(this).find('FIRST_NAME').text();
										var lastName = $(this).find('LAST_NAME').text();
										var newRow = $("<tr id="+employeeId+"><td>"+ employeeId+ "</td><td>"+ firstName+ "</td><td>"+ lastName
													+ "</td> \
													\<td><input id='"+ employeeId+ "' type='button' value='Delete' class='deleteEmployeeButton'/></td> \
													\</tr>");
										$("#myTable").append(newRow);
									});
							}, 'xml');
					});

					$('#myTable').on('click', '.deleteEmployeeButton',
							function() {
									var empId = $(this).attr('id');
									var teamID = $('#teamList2').find(":selected").val();
									$.post("DeleteEmployeeFromTeam", {
										teamID : teamID,
										empId : empId
									}, function(data, status) {
										if (data != 1) {
											alert("Employee can't be deleted");
										} else {
											alert("Employee deleted from team");
											$('table#myTable tr#'+empId).remove();
										}
									});
							});
					
					$("#addMember").click(
							function() {
								var empId = $('#addEmployeeId').val();
								var teamID = $('#teamList2').find(":selected").val();
								var isAdded = false;
								if (jQuery.trim(empId).length <= 0) {
									alert("Employee Id is empty");
								} else {
									$.post("AddEmployeeToTeam", {
										empId : empId,
										teamID : teamID
									}, function(data, status) {
										$(data).find('EMPLOYEE').each(
												function() {
													isAdded = true;
													alert('Employee Added');
													var employeeId = $(this).find('EMP_ID').text();
													var firstName = $(this).find('FIRST_NAME').text();
													var lastName = $(this).find('LAST_NAME').text();
													var newRow = $("<tr id="+employeeId+"><td>"+ employeeId+ "</td><td>"+ firstName+ "</td><td>"+ lastName
																+ "</td> \
																\<td><input id='"+ employeeId+ "' type='button' value='Delete' class='deleteEmployeeButton'/></td> \
																\</tr>");
													$("#myTable").append(newRow);
												});
										if (!isAdded) {
											alert("Employee can't be added");
										}
									},'xml');
								}
						});
					
});

function viewTeams() {
	$('.teamList').empty();
	$.post("ViewTeam", {
		test : "Test"
	}, function(data, status) {
		$(data).find('TEAM').each(
				function() {
					var teamId = $(this).find('TEAM_ID').text();
					var teamDesc = $(this).find('TEAM_DESC').text();
					$('.teamList').append(
							'<option value = "' + teamId + '">' + teamDesc
									+ '</option');
				});
	}, 'xml');
}