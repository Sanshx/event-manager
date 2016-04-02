/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : CurrentTimeFetcherTest.java
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

import org.junit.Test;

import com.aricent.java_classes.CurrentTimeFetcher;

/**
 * @author gur43128
 *
 */
public class CurrentTimeFetcherTest {

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		assertEquals(1, calendar.compareTo(CurrentTimeFetcher.getCurrentTime("GMT+5:30")));
	}

}
