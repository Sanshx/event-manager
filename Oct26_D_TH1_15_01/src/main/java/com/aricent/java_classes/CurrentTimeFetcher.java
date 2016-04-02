/***********************************************************************
                         Aricent Technologies Proprietary



This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: CurrentTimeFetcher.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43194
	  Description           	: This file contains class to fetch the
	  							  current time on the basis of GMT


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author gur43194 This class has functions to fetch the current time according
 *         to GMT
 */
public class CurrentTimeFetcher {

	/**
	 * Takes GMT as string and returns a date object with current time
	 * 
	 * @param argGMT
	 * @return
	 */
	private static Date getTime(String argGMT) {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(argGMT));

		// Local time zone
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(
				"yyyy-MMM-dd HH:mm:ss");

		// Time in GMT
		try {
			return dateFormatLocal.parse(dateFormatGmt.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Convert a date object to calendar object
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar DateToCalendar(Date argDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(argDate);
		return cal;
	}

	/**
	 * Takes GMT as string and returns a calendar object with current time
	 * 
	 * @param argGMT
	 * @return
	 */
	public static Calendar getCurrentTime(String argGMT) {
		return DateToCalendar(getTime(argGMT));
	}

}
