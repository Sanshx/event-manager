package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.exception_classes.RegisterOrgErrorException;
import com.aricent.pojo_classes.OrganizationPojo;

/**
 * @author gur43128
 *
 */
public class OrganizationRegistrationQueries {

	/**
	 * @param orgName
	 * @throws SQLException
	 * @throws NullConnectionException
	 */
	public String getOrgDBNameFromDatabase(String orgName) throws SQLException,
			NullConnectionException {
		Connection connection = DatabaseConnection
				.getConnection("ih_ems_common");
		if (connection != null) {
			String query = "SELECT org_db_name FROM org_record WHERE org_name=?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(1, orgName);
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				String orgNameString = set.getString("org_db_name");
				connection.close();
				return orgNameString;
			}
		} else {
			throw new NullConnectionException();
		}
		connection.close();
		return null;
	}

	/**
	 * @param argOrganization organization details
	 * @return organization id
	 * @throws SQLException
	 * @throws NullConnectionException
	 */
	
	public String registerOrg(OrganizationPojo argOrganization) throws SQLException,
			NullConnectionException, RegisterOrgErrorException {
		
		Connection connection = DatabaseConnection
				.getConnection("ih_ems_common");
		if (connection != null) {
			String query = "INSERT INTO org_record "
					+ "(org_name,org_desc,org_db_name,org_anniversary,org_recovery_email) "
					+ "values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(1, argOrganization.getOrgName());
			preparedStatement.setString(2, argOrganization.getOrgDesc());
			preparedStatement.setString(3, argOrganization.getOrgName());
			preparedStatement.setDate(4, new java.sql.Date(argOrganization
					.getOrgAnniversaryDate().getTime()));
			preparedStatement.setString(5, argOrganization.getOrgRecoveryMail());
			preparedStatement.execute();
			query = "SELECT org_id FROM org_record WHERE org_name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, argOrganization.getOrgName());
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				int orgID = set.getInt("org_id");
				query = "UPDATE org_record SET org_db_name =? WHERE org_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, "ih_ems_"+orgID);
				preparedStatement.setInt(2, orgID);
				preparedStatement.execute();
				connection.close();
				return "ih_ems_"+orgID;
			}
			else {
				connection.close();
				throw new RegisterOrgErrorException();
			}
		} else {
			throw new NullConnectionException();
		}
	}
}
