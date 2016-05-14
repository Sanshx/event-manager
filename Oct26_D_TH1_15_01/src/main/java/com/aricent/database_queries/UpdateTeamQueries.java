package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;

/**
 * @author gur43128
 *
 */
public class UpdateTeamQueries {

	/**
	 * @param teamID
	 * @param orgDbName
	 * @param argNewDescription 
	 * @return
	 * @throws SQLException 
	 * @throws NullConnectionException argNewDescription
	 */
	public int updateTeam(int teamId, String argNewDescription, String orgDbName) throws NullConnectionException, SQLException {
		this.updateTeamInDatabase(teamId, argNewDescription, orgDbName);
		return 1;
	}

	/**
	 * @param teamId
	 * @param orgDbName
	 * @param argNewDescription 
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public void updateTeamInDatabase(int teamId, String argNewDescription, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "UPDATE team_details SET team_desc =? WHERE team_id = ?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, argNewDescription);
		preparedStatement.setInt(2, teamId);
		preparedStatement.execute();
		orgConnection.close();
		
	}

}
