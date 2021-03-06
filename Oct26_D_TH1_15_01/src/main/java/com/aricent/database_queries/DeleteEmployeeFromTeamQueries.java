package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;

/**
 * @author gur43128
 *
 */
public class DeleteEmployeeFromTeamQueries {

	/**
	 * @param teamID
	 * @param employeeId
	 * @param orgDbName
	 * @return
	 * @throws SQLException 
	 * @throws NullConnectionException 
	 */
	public int deleteEmployeeFromTeam(int teamId,
			String employeeId, String orgDbName) throws NullConnectionException, SQLException {
		this.deleteEmployee(employeeId, orgDbName);
		return 1;
	}

	/**
	 * @param teamId
	 * @param employeeId
	 * @param orgDbName
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public void deleteEmployee(String employeeId, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "DELETE FROM team_members WHERE employee_id = ?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, employeeId);
		preparedStatement.execute();
		orgConnection.close();
	}

	/**
	 * @param employeeId
	 * @param orgDbName
	 * @return
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

}
