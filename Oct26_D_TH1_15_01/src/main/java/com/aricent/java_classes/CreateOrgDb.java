package com.aricent.java_classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.DBCreationFailureException;
import com.aricent.exception_classes.NullConnectionException;

/**
 * @author gur43128
 *
 */
public class CreateOrgDb {

	/**
	 * @param string
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 * @throws DBCreationFailureException
	 */
	public String createDataBase(String argOrgDBName)
			throws NullConnectionException, SQLException,
			DBCreationFailureException {
		Connection connection = DatabaseConnection.getConnection("?");
		if (connection == null) {
			throw new NullConnectionException();
		}
		Statement statement = connection.createStatement();
		int isCreated = statement.executeUpdate("CREATE DATABASE "
				+ argOrgDBName);
		if (isCreated == 0) {
			throw new DBCreationFailureException();
		}
		return "database created successfully";
	}

	boolean tableCreated = false;

	/**
	 * @param string
	 * @return
	 * @throws NullConnectionException
	 * @throws Exception
	 */
	public boolean createTables(String argOrgDBName)
			throws NullConnectionException {
		Connection connection = DatabaseConnection.getConnection(argOrgDBName);
		if (connection == null) {
			throw new NullConnectionException();
		}

		ScriptRunner runner = new ScriptRunner(connection, false, true);

		try {
			runner.runScript(new BufferedReader(new FileReader(
					"src/main/java/IH_EMS_org_BLANK_SCHEMA.sql")));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		tableCreated = true;
		return tableCreated;
	}

}
