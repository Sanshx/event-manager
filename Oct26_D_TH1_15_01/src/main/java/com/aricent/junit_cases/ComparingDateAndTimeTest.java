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
