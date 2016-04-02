$(document).ready(function() {
	$("#myBtn2b").click(
			function() {
				$("#showSubAdmin").find("tr:gt(0)").remove();
				$.post("ShowSubAdmin",{
					id : "Test"
				},
				 'xml').done(
						 function(data,status) {
							 //alert(data);
								$(data).find('EMPLOYEE').each(
									function() {
										var employeeId = $(this).find('EMP_ID').text();
										var firstName = $(this).find('FIRST_NAME').text();
										var lastName = $(this).find('LAST_NAME').text();
										var address = $(this).find('ADDRESS').text();
										var locationaccess = $(this).find('LOCATION_ACCESS').text();
										var deleteButtonID = employeeId+'&'+locationaccess;
										var newRow = $("<tr id="+deleteButtonID+"><td>&ensp;&ensp;"+ employeeId+"</td>" +
												"<td>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;"+firstName+ "</td>" +
														"<td>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;"+ lastName+ "</td>" +
																"<td>&ensp;&ensp;&ensp;"+ address+ "</td>" +
																		"<td>&ensp;&ensp;<button id='"+ deleteButtonID + "' type='button' " +
															"value='Delete' class='deleteSubAdminButton btn btn-danger'>Delete</button></td></tr>");
										$("#showSubAdmin").append(newRow);
									});
								 
							}
				 ).fail(function(xhr, textStatus, errorThrown) {
			        alert(xhr.responseText);
			    });
		});
	
	
	$('#showSubAdmin').on('click', '.deleteSubAdminButton',
			
			function() {
					var empId = $(this).attr('id');
					$.post("DeleteSubAdmin", {
						empId : empId
					}, function(data, status) {
						if (data == 0) {
							alert("Sub Admin can't be deleted");
						} else {
							alert("Sub Admin deleted");
							$('#showSubAdmin tr').each(function (i, row)
						            {
						                var rowId = $(row).attr('id');
						                if (rowId == empId)
						                {
						                    $(row).remove();
						                }
						            });
						}
					});
			});
	
	
});



					
		