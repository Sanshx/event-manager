<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="TeamManagementTestJS.js"></script>
</head>
<body>
	<div>
		<input type="button" id="viewTeam" value="View Team">
		<table>
			<tr>
				<td><h1>Manage Team:</h1></td>
			</tr>
			<tr>
				<td><select class="teamList" id="teamList1"></select></td>
				<td><input type="button" id="deleteTeam" value="Delete Team">
				</td>
				<td><input type="button" id="updateTeam" value="Update Team">
				</td>
			</tr>
			<tr>
				<td><label>Team Description:</label>
				<input type="text" id="addTeamDescription"></td>
				<td><input type="button" id="addTeam" value="Add Team">
				</td>
			</tr>
			<tr>
				<td><h1>Manage Team Members:</h1></td>
			</tr>
			<tr>
				<td><select class="teamList" id="teamList2"></select></td>
				<td><input type="button" id="viewMembers" value="View Members">
				</td>
			</tr>
		</table>
		
		<div id="updateTeamDiv">
			<label>New Description:</label>
				<input type="text" id="updateTeamDescription">
				<input type="button" id="updateConfirmTeam" value="Update Team">
		</div>
	</div>
	<div id="employeeDiv">
		<table>
			<tr>
				<td><label>Enter employee id:</label></td>
				<td><input type="text" id="addEmployeeId"></td>
				<td><input type="button" id="addMember" value="Add Member">
				</td>
			</tr>
			<tr>
				<td>
					<table id="myTable" border="1">
						<tr>
							<th>Employee Id</th>
							<th>Employee First Name</th>
							<th>Employee Last Name</th>
							<th>Delete</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>