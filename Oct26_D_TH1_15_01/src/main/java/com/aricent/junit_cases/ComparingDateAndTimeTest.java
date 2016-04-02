/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : ComparingDateAndTime.java
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

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.aricent.java_classes.ComparingDateAndTime;

/**
 * @author gur43128
 *
 */
public class ComparingDateAndTimeTest {

	@Test
	public void testEqualDatePositive() {
		Calendar calendar1 = new GregorianCalendar(2015, 1, 22);
		Calendar calendar2 = new GregorianCalendar(2015, 1, 22);
		assertEquals(true, ComparingDateAndTime.dateComparison(calendar1, calendar2));
	}

	@Test
	public void testEqualDateNegative() {
		Calendar calendar1 = new GregorianCalendar(2014, 1, 21);
		Calendar calendar2 = new GregorianCalendar(2014, 1, 23);
		assertEquals(true, ComparingDateAndTime.dateComparison(calendar1, calendar2));
	}
}
