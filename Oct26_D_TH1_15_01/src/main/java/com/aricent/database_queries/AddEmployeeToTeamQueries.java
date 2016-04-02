/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : BdayDisplayQueries.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 11, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 11, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.EmpBday;

/**
 * @author gur43128
 *
 */
public class AddEmployeeToTeamQueries {



	

	/**This method adds employee to team
	 * @param teamId
	 * @param employeeId
	 * @param orgDbName 
	 * @return -2 if given employee id does not exist, 
	 * 			-3 if employee is in another team,
	 * 			1 if employee is added to team
	 * @throws SQLException 
	 * @throws NullConnectionException 
	 */
	public int addEmployeeToTeam(int teamId, String employeeId, String orgDbName) throws NullConnectionException, SQLException {
		boolean isEmployee = this.checkEmployee(employeeId, orgDbName);
		boolean isInAnotherTeam = this.checkTeam(employeeId, orgDbName);
		int result;
		if (!isEmployee) {
			result = -2;
		}
		else if (isInAnotherTeam) {
			result = -3;
		}
		else {
			this.addEmployee(teamId, employeeId, orgDbName);
			result = 1;
		}
		return result;
	}

	/**This method checks whether employee is in another team
	 * @param employeeId
	 * @param orgDbName
	 * @return true if employee is in another team
	 * 			false if employee is not in another team
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public boolean checkTeam(String employeeId, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "SELECT * FROM team_members WHERE employee_id=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, employeeId);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			orgConnection.close();
			return true;
		}
		else {
			orgConnection.close();
			return false;
		}

	}

	/**This method adds employee to team
	 * @param argTeamId
	 * @param argEmployeeId
	 * @param argOrgDbName
	 * @throws SQLException 
	 * @throws NullConnectionException 
	 */
	public void addEmployee(int argTeamId, String argEmployeeId, String argOrgDbName) throws SQLException, NullConnectionException {
		Connection orgConnection = DatabaseConnection.getConnection(argOrgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO team_members (team_id, employee_id) values(?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, argTeamId);
		preparedStatement.setString(2, argEmployeeId);
		preparedStatement.execute();
		orgConnection.close();
	}

	/**This method checks whether employee with given id exists
	 * @param employeeId
	 * @param orgDbName 
	 * @return true if employee exists
	 * 			false if employee does not exists
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	private boolean checkEmployee(String employeeId, String orgDbName ) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "SELECT * FROM employee_details WHERE employee_id=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, employeeId);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			orgConnection.close();
			return true;
		}
		else {
			orgConnection.close();
			return false;
		}
	}

	/**This method gives employee details of employee with given id
	 * @param employeeId
	 * @param orgDbName
	 * @return employee details
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public EmpBday getEmployee(String employeeId, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		EmpBday employee = new EmpBday();
		String query = "SELECT * FROM employee_details WHERE employee_id=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, employeeId);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			employee.setEmpID(set.getString("employee_id"));
			employee.setFirstName(set.getString("first_name"));
			employee.setLastName(set.getString("last_name"));
		}
		return employee;
	}

}
