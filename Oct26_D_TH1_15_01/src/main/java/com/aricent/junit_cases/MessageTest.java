/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : MessageTest.java
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

import com.aricent.database_queries.MessageManageQueries;

/**
 * @author gur43128
 *
 */
public class MessageTest {

	@Test
	public void testAddBirthdayMessagePositive() {
		assertEquals("Insertion success", MessageManageQueries.addWishMessages("messages_birthday", "Happy Birthday", 1000));
	}
	
	@Test
	public void testEditBirthdayMessage() {
		assertEquals("Update success", MessageManageQueries.editMessages("messages_birthday", 1000, 24, "Celebrate your birthday today. Celebrate being Happy every day"));
	}

	@Test
	public void testDeleteBirthdayMessage() {
		assertEquals("Deletion success", MessageManageQueries.deleteMessages("messages_birthday", 1000, 24));
	}
	
	@Test
	public void testAddAniversaryMessage() {
		assertEquals("Insertion success", MessageManageQueries.addWishMessages("messages_anniversary", "Happy Anniversary", 1000));
	}
	
	@Test
	public void testEditAnniversaryMessage() {
		assertEquals("Update success", MessageManageQueries.editMessages("messages_anniversary", 1000, 10, "All the best for your anniversary!"));
	}
	
	@Test
	public void testDeleteAnniversaryMessage() {
		assertEquals("Deletion success", MessageManageQueries.deleteMessages("messages_anniversary", 1000, 10));
	}
}
