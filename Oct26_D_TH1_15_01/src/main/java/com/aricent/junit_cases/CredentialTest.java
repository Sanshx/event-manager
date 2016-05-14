
package com.aricent.junit_cases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aricent.database_queries.LoginSystemQueries;

/**
 * @author gur43128
 *
 */
public class CredentialTest {

	@Test
	public void testCredentialPositive() {
		assertEquals(true, LoginSystemQueries.checkCredentials("ih_ems_1000", "emp1001", "test123"));
	}
	
	@Test
	public void testCredentialNegative() {
		assertEquals(false, LoginSystemQueries.checkCredentials("ih_ems_1000", "emp1001", "test"));
	}

}
