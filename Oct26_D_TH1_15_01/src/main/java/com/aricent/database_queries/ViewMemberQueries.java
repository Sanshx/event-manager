package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.EmpBday;

/**
 * @author gur43128
 *
 */
public class ViewMemberQueries {

	/**
	 * @param teamID 
	 * @param orgDbName
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public ArrayList<EmpBday> getMembers(int teamID, String orgDbName) throws NullConnectionException, SQLException {
		Connection orgConnection = DatabaseConnection.getConnection(orgDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		ArrayList<EmpBday> members = new ArrayList<EmpBday>();
		String query = "SELECT employee_id FROM team_members WHERE team_id=?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, teamID);
		ResultSet set = preparedStatement.executeQuery();
		while (set.next()) {
			String empID = set.getString("employee_id");
			String query2 = "SELECT * FROM employee_details WHERE employee_id=?";
			PreparedStatement preparedStatement2 = orgConnection
					.prepareStatement(query2);
			preparedStatement2.setString(1, empID);
			ResultSet set2 = preparedStatement2.executeQuery();
			if (set2.next()) {
				EmpBday employee = new EmpBday();
				employee.setEmpID(set2.getString("employee_id"));
				employee.setFirstName(set2.getString("first_name"));
				employee.setLastName(set2.getString("last_name"));
				members.add(employee);
			}
		}
		orgConnection.close();
		return members;
	}

}
