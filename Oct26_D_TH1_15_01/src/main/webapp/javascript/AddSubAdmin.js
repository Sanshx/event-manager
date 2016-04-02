$(document).ready(

		function() {

			$("#addSubAdmin").click(
					function() {

						var emp_id = $('#employee_id').val();

						if (jQuery.trim(emp_id).length <= 0) {

							alert("Employee ID is empty");

						}

						else {
							//alert('outside dropdown');
							//alert($('#office_add_modal2').val());
							var office_address = '';
							$('#office_add_modal2 option:selected').each(function(){
							        //alert($(this).val());
							        office_address += $(this).val();
							        office_address += '&';
							    });
							 if (jQuery.trim(office_address).length <= 0) {

									alert("No office selected");

								}
							 //var office_address;
							//alert(office_address);
							 else{
								 $.post("AddSubAdmin", {
										emp_id : emp_id,
										office_address : office_address
									}, function(data, status) {
										if (data != 2) {
											alert('Employee does not exist');
										}
										else {
											alert('Sub admin added');
											$('#employee_id').val('');
											$('#office_add_modal2 option:selected').each(function(){
										        //alert($(this).val());
												$(this).prop('selected',false);
										    });
										}
									});
							 }
						}

					});

		});