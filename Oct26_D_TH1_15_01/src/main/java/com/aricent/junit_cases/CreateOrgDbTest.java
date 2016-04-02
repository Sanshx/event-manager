/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : CreateOrgDbTest.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 6, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 6, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.junit_cases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.aricent.database_queries.OrganizationRegistrationQueries;
import com.aricent.exception_classes.DBCreationFailureException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.java_classes.CreateOrgDb;

/**
 * @author gur43128
 *
 */
public class CreateOrgDbTest {

	@Test
	public void testCreateDB() {
		try {
			String orgNameString = new OrganizationRegistrationQueries().getOrgDBNameFromDatabase("Salman");
			assertEquals("database created successfully", new CreateOrgDb().createDataBase(orgNameString));
		} catch (NullConnectionException | SQLException
				| DBCreationFailureException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateTable() {
		try {
			String orgNameString = new OrganizationRegistrationQueries().getOrgDBNameFromDatabase("Salman");
			assertEquals(true, new CreateOrgDb().createTables(orgNameString));
		} catch (NullConnectionException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
