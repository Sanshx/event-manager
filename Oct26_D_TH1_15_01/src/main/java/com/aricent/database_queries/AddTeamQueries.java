package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;

/**
 * @author gur43128
 *
 */
public class AddTeamQueries {



	/**This method gives organization database name with given organization id
	 * @param argOrgID
	 * @return database name
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InvalidSessionException 
	 */
	public String getOrgDbName(int argOrgID) throws NullConnectionException, SQLException, InvalidSessionException {
		Connection orgConnection = DatabaseConnection.getConnection("ih_ems_common");
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "SELECT org_db_name FROM org_record WHERE org_id=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, argOrgID);;
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			String orgNameString = set.getString("org_db_name");
			orgConnection.close();
			return orgNameString;
		}
		else {
			throw new InvalidSessionException();
		}
	}

	/**This method adds team to database
	 * @param teamDescription
	 * @param orgDbNAme 
	 * @return -1 if team is not added, team id if team is added
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public int addTeam(String teamDescription, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		int id = this.getID(teamDescription, orgDbName);
		if (id != -1) {
			return -1;
		}
		else {
			String query = "INSERT INTO team_details (team_desc) values(?)";
			PreparedStatement preparedStatement = orgConnection
					.prepareStatement(query);
			preparedStatement.setString(1, teamDescription);
			preparedStatement.execute();
			int teamId = this.getID(teamDescription, orgDbName);
			return teamId;
		}
	}

	/**This method returns team id with given description
	 * @param teamDescription
	 * @param orgDbName
	 * @return team id
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public int getID(String teamDescription, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "SELECT team_id FROM team_details WHERE team_desc=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, teamDescription);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			int teamID = set.getInt("team_id");
			return teamID;
		}
		else {
			return -1;
		}
	}

}
