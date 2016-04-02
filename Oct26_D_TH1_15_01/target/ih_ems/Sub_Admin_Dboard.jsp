<!DOCTYPE html>
<html lang="en">
<head>
<title>EMS-Sub-Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Ubuntu:700'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="javascript/EmployeeManage.js"></script>
<script src="javascript/LocationsManage.js"></script>
<script src="javascript/MessageManage.js"></script>
<script src="SubAdminTeamManagementJS.js"></script>
</head>
<style>
.white, .white a {
  color: #fff;
}
h1 {
	font-size: 6.2vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

h2 {
	font-size: 5.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

p.p1 {
	font-size: 4.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

p.p2 {
	font-size: 1.5vw;
	font-family: 'Ubuntu', Helvetica, Arial, sans-serif !important;
	padding: 0px;
	display: inline
}

li {
	font-size: 1.2vw;
	font-family: 'Lato Hairline Light';
}

th,td {
	font-family: 'Lato Hairline Light';
	padding: 10px;
	border-radius: 5px;
}

.btn {
	padding: 5px 5px;
}

.btn-success {
	color: #fff;
	background-color: #286090;
	border-color: #286090;
}

.btn-success:hover {
	color: #fff;
	background-color: #286090;
	border-color: #286090;
}

.btn-danger {
	color: #fff;
	background-color: red;
	border-color: red;
}

.btn-danger:hover {
	color: #fff;
	background-color: red;
	border-color: red;
}

.modal-header,h4,.close {
	background-color: #084B8A;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}

.modal-content {
	height: 100%;
	overflow: auto;
}
.modal-dialog{
    overflow-y: initial !important
}
input.img {
	border-radius: 10px;
	background-color: #084B8A;
	margin-right: 60px;
}

.img-responsive {
	display: block;
	max-width: 100%;
	width: 100%;
	height: 100%;
}

fieldset {
	display: none;
	width: 70%;
	padding: 10px;
	margin-top: 50px;
	margin-bottom: 100px;
	border-radius: 5px;
	box-shadow: 3px 3px 25px 1px gray;
}

#first {
	display: block;
	width: 70%;
	padding: 20px;
	margin-top: 50px;
	border-radius: 5px;
	box-shadow: 3px 3px 25px 1px gray;
}

.sign-in-facebook {
	background-image: url('facebook.png');
	background-size: cover;
	background-position: -9px -7px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-facebook:hover {
	background-image: url('facebook.png');
	background-size: cover;
	background-position: -9px -7px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-twitter {
	background-image: url('twitter.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-twitter:hover {
	background-image: url('twitter.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-linkedin {
	background-image: url('linkedin.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

.sign-in-linkedin:hover {
	background-image: url('linkedin.png');
	background-size: cover;
	background-position: -4px -5px;
	background-repeat: no-repeat;
	background-size: 39px 43px;
	padding-left: 18px;
	color: #000;
}

body {
	background: url(background_blur.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

$(
function () { // Setup drop down menu //$('.dropdown-toggle ').dropdown
	(); // Fix input element click problem $('.dropdown input,.dropdown
	label ').click (function(e) {e .stopPropagation();
	
}
);
}
);
</style>
<body>
	<%@ page session="false"%>
	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);
		HttpSession sess = request.getSession(false);
		if (sess == null
				|| (!sess.getAttribute("userTypeId").toString().equals("2")))
			response.sendRedirect("Home.html");
	%>
	<nav class="navbar navbar-fixed">
		<div class="container-fluid">
			<button type="button" style="background-color: white;"
				class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar" style="background-color: black;"></span> <span
					class="icon-bar" style="background-color: black;"></span> <span
					class="icon-bar" style="background-color: black;"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="Home.html"><font color="black"><b>Home</b></font></a></li>
					<li><a href="About_us.html"><font color="black"><b>About
									us</b></font></a></li>
					<li><a href="Contact_us.html"><font color="black"><b>Contact
									us</b></font></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="LogoutServlet?page=Home.html"><font color="black"><b>Logout</b></font></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div align="center">
		<fieldset id="first">
			<div class="container-fluid" align="center">
				<h1>
					<font color="black">Dashboard</font>
				</h1>
			</div>
			<div class="container-fluid table-responsive" align="center">
				<table style="margin-top: 50px;">
					<tr>
						<td style="padding:50px;"><div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Employee.png" id="myBtn3" />
								</button>

								<!-- Modal content FOR EMPLOYEE MANAGEMENT PART ONE-->
								<div class="modal fade" id="myModal3">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-user"></span> Employee
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<form>
													<div class="form-group">
														<label for="usrname">Employee Id</label> <input
															type="text" class="form-control" id="emp_id"
															placeholder="Enter Employee Id" required>
													</div>
													<button type="button" class="btn btn-success btn-block"
														value="add" id="myBtn3a">Add/Update Employee</button>
												</form>
											</div>

										</div>
									</div>
								</div>

								<!-- Modal content FOR EMPLOYEE PART 2-->
								<div class="modal fade" id="myModal3a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-user"></span>Add Employee
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<form id="modal_modify_emp">
													<div class="container-fluid" align="right"
														style="float: right">
														<button type="submit" class="btn btn-danger" value="add"
															id="myBtn3b">Delete Employee</button>
														<br />
													</div>
													<table>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Employee-Id
																		:</b></font></td>
															<td style="padding: 5px;"><input type="text"
																id="emp_id_fixed" name="emp_id" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>First
																		Name :</b></font></td>
															<td style="padding: 5px;"><input type="text"
																id="emp_fname" name="emp_fname" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Last
																		Name : </b></font></td>
															<td style="padding: 5px;"><input type="text"
																id="emp_lname" name="emp_lname" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Birthday
																		: </b></font></td>
															<td style="padding: 5px;"><input type="date"
																id="emp_bday" name="emp_bday" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Start
																		of Work : </b></font></td>
															<td style="padding: 5px;"><input type="date"
																id="emp_wannv" name="emp_wannv" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Address
																		: </b></font></td>
															<td style="padding: 5px;"><select id="emp_location"
																name="emp_location"></select></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Email-id
																		:</b></font></td>
															<td style="padding: 5px;"><input type="email"
																id="emp_mail" name="emp_mail" required></td>
														</tr>
														<tr>
															<td style="padding: 5px;"><font color="black"><b>Telephone
																		:</b></font></td>
															<td style="padding: 5px;"><input type="tel"
																id="emp_tel" name="emp_tel" required></td>
														</tr>
													</table>
													<br />
													<button type="button" class="btn btn-success btn-block"
														id="modify_emp_button" value="add">Add Employee</button>
												</form>
											</div>

										</div>
									</div>

								</div>
							</div></td>
						<td style="padding:50px;"><div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Message.png" id="myBtn5" />
								</button>
								
								
								
								
								
								<!--------------- Modal for Message Module------------------>
								<div class="modal fade" id="myModal5">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-comment"></span> Messages
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<button type="button" class="btn btn-success btn-block"
													id="myBtn5a" value="" data-dismiss="modal">Birthday
													Messages</button>
												<br />
												<button type="button" class="btn btn-success btn-block"
													id="myBtn5b" value="" data-dismiss="modal">Anniversary
													Messages</button>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Message Part Two-->
								<div class="modal fade" id="myModal5a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h5>
													<span class="glyphicon glyphicon-comment"></span> Birthday
													Messages
												</h5>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">
													<table>
														<tr>
															<td><textarea name="BMessage" id="birthday_text"
																	rows="5" cols="50"
																	placeholder="Enter Birthday Message here"></textarea></td>
															<td>
																<button type="button" class="btn btn-success"
																	id="add_msg_birthday" value="">Add Message</button>
															</td>
														</tr>
													</table>
												<h3>
													<b>Birthday Message List</b>
												</h3>
													<table id="messages_birthday">
													</table>
												</div>
	
											</div>
										</div>
									</div>
								</div>
							</div> <!-- Modal for Message Part Three-->
							<div class="modal fade" id="myModal5b">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header" style="padding: 35px 50px;">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<font><span class="glyphicon glyphicon-comment"></span>
												Anniversary Messages</font>
										</div>
										<div class="modal-body" style="padding: 40px 50px;">
											<div class="container-fluid" align="center">
												<table>
													<tr>
														<td><textarea name="AMessage" id="anniversary_text"
																rows="5" cols="50"
																placeholder="Enter Anniversary Message herte"></textarea></td>
														<td>
															<button type="button" class="btn btn-success"
																id="add_msg_anniversary" value="">Add Message</button>
														</td>
													</tr>
												</table>

												<h3>
													<b>Anniversary Message List</b>
												</h3>

												<table id='messages_anniversary'>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
								
								
								
								
						</td>
					</tr>
					<tr>
						<td style="padding:50px;"><div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Team.jpg" id="viewTeam" />
								</button>
								
								<!-- Modal for Team Module-->
								<div class="modal fade" id="myModal4">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Team
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<h3>Manage Team</h3>
													<table>
														<tr>
															<td><select class="teamList" id="teamList1"></select></td>
															<td><button type="button" class="btn btn-danger"
																	id="deleteTeam" value="Delete Team">Delete
																	Team</button></td>
															<td><button type="button" class="btn btn-success"
																	id="updateTeam" value="Update Team">Update
																	Team</button></td>
														</tr>
													</table>
													<table>
														<tr>
															<td><textarea id="addTeamDescription" cols="50"
																	rows="5">Team Description here</textarea></td>
															<td><button type="button" class="btn btn-success"
																	id="addTeam" value="Add Team">Add Team</button></td>
														</tr>
													</table>
													<h3>Manage Team Members</h3>
													<table>
														<tr>
															<td><select class="teamList" id="teamList2"></select></td>
															<td><button type="button" class="btn btn-success"
																	id="viewMembers" value="View Members">View
																	Members</button></td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Team Part Two-->
								<div class="modal fade" id="myModal4a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Update Team
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<div id="updateTeamDiv">
														<textarea id="updateTeamDescription" cols="50" rows="5">New Description here</textarea>
														<br />
														<button type="button" id="updateConfirmTeam"
															class="btn btn-success btn-block" value="Update Team">Update
															Team</button>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Modal for Team Part Three-->
								<div class="modal fade" id="myModal4b">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-globe"></span> Team
													Members
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<div id="employeeDiv">
														<table>
															<tr>
																<td><label>Enter employee id</label></td>
																<td><input type="text" id="addEmployeeId"></td>
																<td><button type="button" class="btn btn-success"
																		id="addMember" value="Add Member">Add Member</button>
																</td>
															</tr>
														</table>
														<table id="myTable" border="1">
															<tr>
																<th>Employee Id</th>
																<th>Employee First Name</th>
																<th>Employee Last Name</th>
																<th>Delete</th>
															</tr>
														</table>
													</div>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div></td>
						<td style="padding:50px;"><div class="container-fluid">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">
									<img src="Event.jpg" id="myBtn6" />
								</button>

								<div class="modal fade" id="myModal6">
									<div class="modal-dialog modal-lg">

										<!-- Modal content for event-->
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span>Upcoming
													Events
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">
												<div class="container-fluid" align="center">

													<form action="BdayDisplay" method="post">
														<table>
															<tr>
																<td style="padding: 50px"><font color="black"><b>Select
																			Birth-day Month: </b></font></td>
																<td style="padding: 30px"><select name="month"
																	id="bdaymonth">
																		<option value="-1">Select Month</option>
																		<option value="1">January</option>
																		<option value="2">February</option>
																		<option value="3">March</option>
																		<option value="4">April</option>
																		<option value="5">May</option>
																		<option value="6">June</option>
																		<option value="7">July</option>
																		<option value="8">August</option>
																		<option value="9">September</option>
																		<option value="10">October</option>
																		<option value="11">November</option>
																		<option value="12">December</option>
																</select></td>
																<td style="padding: 50px">
																	<div class="container-fluid">
																		<button type="button" class="btn btn-default"
																			id="myBtn6a" value="Show BTable" data-dismiss="modal">Show
																			Birthday</button>
																	</div>

																</td>
															</tr>
														</table>
													</form>

													<form action="AnniversaryDisplay" method="post">
														<table>

															<tr>
																<td style="padding: 20px"><font color="black"><b>Select
																			Anniversary-day Month: </b></font></td>
																<td style="padding: 20px"><select name="month"
																	id="anniversarymonth">
																		<option value="-1">Select Month</option>
																		<option value="1">January</option>
																		<option value="2">February</option>
																		<option value="3">March</option>
																		<option value="4">April</option>
																		<option value="5">May</option>
																		<option value="6">June</option>
																		<option value="7">July</option>
																		<option value="8">August</option>
																		<option value="9">September</option>
																		<option value="10">October</option>
																		<option value="11">November</option>
																		<option value="12">December</option>
																</select></td>
																<td style="padding: 30px">
																	<div class="container-fluid">
																		<button type="button" class="btn btn-default"
																			id="myBtn6b" value="Show ATable" data-dismiss="modal">Show
																			Anniversary</button>

																		<!-- Modal for showing Birthday  -->
																		<div class="modal fade" id="bdayModal">
																			<div class="modal-dialog"></div>
																		</div>
																	</div>
																</td>
															</tr>

														</table>
													</form>
												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="modal fade" id="myModal6a">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span>Upcoming
													Birthdays
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">

												<table id="myBTable">
													<tr>
														<th style="padding: 20px">Employee Id</th>
														<th style="padding: 20px">Employee First Name</th>
														<th style="padding: 20px">Employee Last Name</th>
														<th style="padding: 20px">Employee Birth Date</th>
														<th style="padding: 20px">Employee Office Address</th>

													</tr>
												</table>

												<button type="submit" class="btn btn-success btn-block"
													id="bclose" value="Show Table" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
								<div class="modal fade" id="myModal6b">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
											<div class="modal-header" style="padding: 35px 50px;">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4>
													<span class="glyphicon glyphicon-gift"></span>Upcoming
													Anniversaries
												</h4>
											</div>
											<div class="modal-body" style="padding: 40px 50px;">

												<table id="myATable">
													<tr>
														<th style="padding: 20px">Employee Id</th>
														<th style="padding: 20px">Employee First Name</th>
														<th style="padding: 20px">Employee Last Name</th>
														<th style="padding: 20px">Employee Anniversary Date</th>
														<th style="padding: 20px">Employee Office
															Address</th>

													</tr>
												</table>


												<button type="submit" class="btn btn-success btn-block"
													id="aclose" value="Show Table" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>

							</div></td>
					</tr>
				</table>
			</div>
		</fieldset>
	</div>
	<div class="footer navbar-fixed-bottom">
		<footer>
			<nav class="navbar-left"
						style="margin-left: 20px; margin-right: 30px; margin-bottom: 10px">
						<span class="glyphicon glyphicon-copyright-mark white">
							<font color="white">Copyrights reserved by Aricent</font>
						</span>
			</nav>
			<nav class="navbar-right"
				style="margin-left: -20px; margin-right: 30px; margin-bottom: 10px">
				<p class="p2" style="margin-right: 10px">
					<font color="white"><b><i>Follow us on</i></b></font>
				</p>
				<input onclick="location.href='http://facebook.com';" type="button"
					class="btn btn-default sign-in-facebook" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
				<input onclick="location.href='http://twitter.com';" type="button"
					class="btn btn-default sign-in-twitter" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
				<input onclick="location.href='http://linkedin.com';" type="button"
					class="btn btn-default sign-in-linkedin" class="img-responsive"
					style="margin-top: 2px; margin-bottom: 2px; margin-right: 10px">
			</nav>
		</footer>
	</div>
	<script>
//On clicking Employee Picture
$(document).ready(function(){
    $("#myBtn3").click(function(){
        $("#myModal3").modal();
    });
});
//On clicking Message Picture
$(document).ready(function(){
    $("#viewTeam").click(function(){
        $("#myModal4").modal();
    });
});
//On clicking Team Picture
$(document).ready(function(){
    $("#myBtn5").click(function(){
        $("#myModal5").modal();
    });
});
//On clicking Event Picture
$(document).ready(function(){
    $("#myBtn6").click(function(){
        $("#myModal6").modal();
    });
});

//On clicking Employee first modal button
$(document).ready(function(){
    $("#myBtn3a").click(function(){
    	getLocations('emp_location');
    	findEmployee();
    	document.getElementById("emp_id").value=null;
    	$('#myModal3').modal('toggle');
        $("#myModal3a").modal('toggle');
    });
});
//On clicking Employee second modal button
$(document).ready(function(){
    $("#modify_emp_button").click(function(){
    	modifyEmployee();
    	$("#myModal3a").modal('toggle');
    });
});
//No button
$(document).ready(function(){
    $("#myBtn6").click(function(){
        $("#myModal6").modal();
    });
});
//Showing Birthday data
$(document).ready(function(){
    $("#myBtn6a").click(function(){
    	$("#myModal6").modal('toggle');
        $("#myModal6a").modal('toggle');
    });
});
//Showing anniversary data
$(document).ready(function(){
    $("#myBtn6b").click(function(){
    	$("#myModal6").modal('toggle');
        $("#myModal6b").modal('toggle');
    });
});
//Closing modal bday
$(document).ready(function(){
    $("#bclose").click(function(){
        $("#myModal6a").modal('toggle');
        $("#myModal6").modal('toggle');
    });
});
//Update Team modal
$(document).ready(function(){
    $("#updateTeam").click(function(){
    	$("#myModal4").modal('toggle');
        $("#myModal4a").modal('toggle');
    });
});
//View Members Modal
$(document).ready(function(){
    $("#viewMembers").click(function(){
    	$("#myModal4").modal('toggle');
        $("#myModal4b").modal('toggle');
    });
});
//Closing modal anniversary
$(document).ready(function(){
    $("#aclose").click(function(){
        $("#myModal6b").modal('toggle');
        $("#myModal6").modal('toggle');
    });
});
//Deleting a employee
$(document).ready(function(){
    $("#myBtn3b").click(function(){
        deleteEmployee();
        $("#myModal3a").modal('toggle');
    });
});
//Messages functions
$(document).ready(function(){
    $("#myBtn5").click(function(){
        $("#myModal5").modal();
    });
});
$(document).ready(function(){
    $("#myBtn5a").click(function(){
    	$("#myModal5").modal('toggle');
    	getMessage('messages_birthday');
        $("#myModal5a").modal('toggle');
    });
});
$(document).ready(function(){
    $("#myBtn5b").click(function(){
    	$("#myModal5").modal('toggle');
    	getMessage('messages_anniversary');
        $("#myModal5b").modal('toggle');
    });
});
//Adding birthday
$(document).ready(function(){
    $("#add_msg_birthday").click(function(){
        modifyMessage('messages_birthday');
    });
});
//Adding anniversary
$(document).ready(function(){
    $("#add_msg_anniversary").click(function(){
    	modifyMessage('messages_anniversary');
    });
});

//Event function
$(document).ready(function() {
	//$("#myTable").hide();
	$("#myBtn6b").click(function() {
		$("#myATable").find("tr:gt(0)").remove();
		var month = $('#anniversarymonth').find(":selected").val();
		$("#myModal6b").append(month);
		$.post("AnniversaryDisplay", {
			month : month 
		}, function(data, status) {
			$(data).find('EMPLOYEE').each(function() {
				var employeeId = $(this).find('EMP_ID').text();
				var firstName = $(this).find('FIRST_NAME').text();
				var lastName = $(this).find('LAST_NAME').text();
				var anniversaryDate = $(this).find('ANNIVERSARY_DATE').text();
				var officeAddress = $(this).find('OFFICE_ADDRESS').text();					
				$('#myATable').append('<tr><td style="padding:20px">'+employeeId +'</td><td style="padding:20px">'+firstName +'</td><td style="padding:20px">'+lastName +'</td><td style="padding:20px">'+anniversaryDate +'</td><td style="padding:20px">'+officeAddress +'</td></tr>');
				$("#myATable").show();
			}).fail(function() {
				alert("nothing found");
			});
		},
		'xml'
		);

		
	});
});
//Event function 
$(document).ready(function() {
	//$("#myTable").hide();
	$("#myBtn6a").click(function() {
		$("#myBTable").find("tr:gt(0)").remove();
		var month = $('#bdaymonth').find(":selected").val();
		$.post("BdayDisplay", {
			month : month 
		}, function(data, status) {
			$(data).find('EMPLOYEE').each(function() {
				var employeeId = $(this).find('EMP_ID').text();
				var firstName = $(this).find('FIRST_NAME').text();
				var lastName = $(this).find('LAST_NAME').text();
				var birthDate = $(this).find('BIRTH_DATE').text();
				var officeAddress = $(this).find('OFFICE_ADDRESS').text();					

				$('#myBTable').append('<tr><td style="padding:10px">'+employeeId +'</td><td style="padding:10px">'+firstName +'</td><td style="padding:10px">'+lastName +'</td><td style="padding:10px">'+birthDate +'</td><td style="padding:10px">'+officeAddress +'</td></tr>');
				$("#myBTable").show();
			}).fail(function() {
				alert("nothing found");
			});
		},
		'xml'
		);

	});
});
</script>
</body>
</html>