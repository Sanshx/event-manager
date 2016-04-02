/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : DatabaseConnectionTest.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 16, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 16, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

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
