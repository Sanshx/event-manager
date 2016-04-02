/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : CredentialTest.java
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
