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
public class DeleteTeamQueries {

	/**
	 * @param teamID2
	 * @param orgDbName
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public int deleteTeam(int teamId, String orgDbName) throws NullConnectionException, SQLException {
		this.deleteTeamFromDatabase(teamId, orgDbName);
		return 1;
	}

	/**
	 * @param teamId
	 * @param orgDbName
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public void deleteTeamFromDatabase(int teamId, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "DELETE FROM team_members WHERE team_id = ?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, teamId);
		preparedStatement.execute();
		query = "DELETE FROM team_details WHERE team_id = ?";
		preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, teamId);
		preparedStatement.execute();
		orgConnection.close();
	}

}
