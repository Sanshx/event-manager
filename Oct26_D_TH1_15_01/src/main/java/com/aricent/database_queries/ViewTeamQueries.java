package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.TeamPojo;

/**
 * @author gur43128
 *
 */
public class ViewTeamQueries {

	/**
	 * @param orgDbName
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public ArrayList<TeamPojo> getTeams(String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		ArrayList<TeamPojo> teams = new ArrayList<TeamPojo>();
		String query = "SELECT * FROM team_details";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		ResultSet set = preparedStatement.executeQuery();
		while (set.next()) {
			TeamPojo team = new TeamPojo();
			team.setTeamId(set.getInt("team_id"));
			team.setTeamDescription(set.getString("team_desc"));
			teams.add(team);
		}
		orgConnection.close();
		return teams;
	}
}
