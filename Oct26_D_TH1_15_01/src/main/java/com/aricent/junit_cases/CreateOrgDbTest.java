
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
