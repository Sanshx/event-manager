
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
