/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : OrgRegQueriesTest.java
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.aricent.database_queries.OrganizationRegistrationQueries;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.exception_classes.RegisterOrgErrorException;
import com.aricent.pojo_classes.OrganizationPojo;

/**
 * @author gur43128
 *
 */
public class OrgRegQueriesTest {

	@Test
	public void testGetDBNamePositive1() {
		try {
			assertEquals("ih_ems_1000", new OrganizationRegistrationQueries().getOrgDBNameFromDatabase("Aricent"));
		} catch (SQLException | NullConnectionException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testGetDBNamePositive2() {
		try {
			assertEquals(null, new OrganizationRegistrationQueries().getOrgDBNameFromDatabase("Dalpat"));
		} catch (SQLException | NullConnectionException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetDBNameNegative() {
		try {
			assertEquals("ih_ems_1000", new OrganizationRegistrationQueries().getOrgDBNameFromDatabase("Dalpat"));
		} catch (SQLException | NullConnectionException e) {
			e.printStackTrace();
		}
	}
	
	OrganizationPojo organizationPojo = new OrganizationPojo();
	
	@Before
	public void initializeOrganization(){
		try {
			organizationPojo.setOrgName("Gotham Police Dept");
			organizationPojo.setOrgDesc("Test2");
			String orgDateString = "1995-10-14";
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date orgAnniversaryDate = format.parse(orgDateString);
			organizationPojo.setOrgAnniversaryDate(orgAnniversaryDate);
			organizationPojo.setOrgRecoveryMail("batman@gotham.com");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	
	public void registerOrgTest(){
		try {
			assertEquals("ih_ems_1006", new OrganizationRegistrationQueries().registerOrg(organizationPojo));
		} catch (SQLException | NullConnectionException | RegisterOrgErrorException e) {
			e.printStackTrace();
		}
	}
}
