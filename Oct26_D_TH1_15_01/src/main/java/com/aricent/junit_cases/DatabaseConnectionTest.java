
package com.aricent.junit_cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aricent.database_connection.DatabaseConnection;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

/**
 * @author gur43128
 *
 */
public class DatabaseConnectionTest {

	@Test (expected = MySQLSyntaxErrorException.class)
	public void testNegative() throws MySQLSyntaxErrorException {
		new DatabaseConnectionTest().testConnection("Invalid");
	}
	
	@Test
	public void testPositive(){
		assertNotNull(DatabaseConnection.getConnection("ih_ems_common"));
	}
	
	public void testConnection(String argDatabaseName) throws MySQLSyntaxErrorException {
		DatabaseConnection.getConnection(argDatabaseName);
	}

}
