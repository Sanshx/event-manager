package com.aricent.java_classes;

import java.util.Calendar;

/**
 * @author gur43131 This class has functions for comparison of data and time
 * 
 */
public class ComparingDateAndTime {

	/**
	 * This functions checks that whether the time in a calendar object is in a
	 * particular range or not. The time range is specified in this function.
	 * 
	 * @param calobj
	 * @return True if the time is in range, else false
	 */
	public static boolean timeInRange(Calendar argCalObj) {
		// getting before time object

		Calendar beforeTime = Calendar.getInstance();
		beforeTime.set(Calendar.HOUR_OF_DAY, 0);
		beforeTime.set(Calendar.MINUTE, 0);

		// getting after time object
		Calendar afterTime = Calendar.getInstance();
		afterTime.set(Calendar.HOUR_OF_DAY, 23);
		afterTime.set(Calendar.MINUTE, 59);

		// comparing two times
		if (beforeAndAfter(beforeTime, argCalObj, afterTime) == true) {
			// System.out.println("time is b/w 12:00am to 12:30 am");
			return true;
		}
		return false;
	}

	/**
	 * This function checks of birthday and anniversary Compares the date and
	 * month of two calendar objects
	 * 
	 * @param cal1
	 * @param cal2
	 * @return True, if matches, else false
	 */
	public static boolean dateComparison(Calendar argCal1, Calendar argCal2) {
		int month1 = argCal1.get(Calendar.MONTH);
		int month2 = argCal2.get(Calendar.MONTH);
		int date1 = argCal1.get(Calendar.DATE);
		int date2 = argCal2.get(Calendar.DATE);
		if (month1 == month2 && date1 == date2) {
			return true;
		}
		return false;
	}

	/**
	 * This is a helper function for comparison method. It checks the time of
	 * calendar object and compares it with two objects for after and before.
	 * 
	 * @param argCal1
	 * @param argCal2
	 * @param argCal3
	 * @return True if the time is in range, else false
	 */
	public static boolean beforeAndAfter(Calendar argCal1, Calendar argCal2,
			Calendar argCal3) {
		int hour1 = argCal1.get(Calendar.HOUR_OF_DAY);
		int hour2 = argCal2.get(Calendar.HOUR_OF_DAY);
		int hour3 = argCal3.get(Calendar.HOUR_OF_DAY);
		int min1 = argCal1.get(Calendar.MINUTE);
		int min2 = argCal2.get(Calendar.MINUTE);
		int min3 = argCal3.get(Calendar.MINUTE);
		if (hour1 == hour2 && hour3 == hour2) {
			if (min2 >= min1 && min2 <= min3) {
				return true;
			}
		} else if (hour2 == hour1 && hour3 > hour2) {
			if (min2 >= min1 && min2 <= 59) {
				return true;
			}
		} else if (hour2 == hour3 && hour2 > hour1) {
			if (min2 >= 0 && min2 <= min3) {
				return true;
			}
		} else if (hour2 > hour1 && hour2 < hour3) {
			return true;
		}
		return false;
	}
}
