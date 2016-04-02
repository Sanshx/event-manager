/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : EmployeeManagementTest.java
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

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.aricent.database_queries.EmployeeManagementQueries;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

/**
 * @author gur43128
 *
 */
public class EmployeeManagementTest {

	EmployeeDetailsHolder  employee = new EmployeeDetailsHolder();
	
	@Before
	public void initializeEmployee() {
		employee.setEmpID("43128");
		employee.setFirstName("Gaurav");
		employee.setLastName("Kumar");
		try {
			employee.setEmpAnniversaryDate(new SimpleDateFormat("yyyy-mm-dd").parse("2015-12-28"));
			employee.setEmpBirthDate(new SimpleDateFormat("yyyy-mm-dd").parse("1992-12-28"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setEmail("abc@xyz.com");
		employee.setContact("9876543210");
		employee.setLocationID(1);
		employee.setUserTypeID((short) 3);
	}
	
	
	@Test
	public void testAddEmployeePositive() {
		assertEquals(true, EmployeeManagementQueries.employeeAddition(employee, 1000));
	}

	
	@Test
	public void testEditEmployeePositive() {
		employee.setFirstName("Siddharth");
		assertEquals(true, EmployeeManagementQueries.employeeUpdation(employee, 1000));
	}
	
	@Test
	public void testDeleteEmployeePositive() {
		assertEquals(true, EmployeeManagementQueries.deleteEmployee("43128", 1000));
	}
}
