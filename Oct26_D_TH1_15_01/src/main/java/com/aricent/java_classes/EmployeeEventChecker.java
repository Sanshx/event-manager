/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: EmployeeEventChecker.java
	  Principal Author      	: Sumukh Chitrashekar gur43182
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43182
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import java.util.ArrayList;
import java.util.Iterator;

import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.EmployeeWishHolder;
import com.aricent.pojo_classes.LocationWishHolder;

/**
 * @author gur43182 This class appends locations to which mail has to be sent
 */

public class EmployeeEventChecker {

	/**
	 * This method appends locations to which mail has to be sent
	 * 
	 * @param argLocationWishHolders
	 */
	public static void mailListAppender(
			ArrayList<LocationWishHolder> argLocationWishHolders) {
		ArrayList<EmployeeWishHolder> employeeWishHolder = new ArrayList<>();
		Iterator<LocationWishHolder> iterator = argLocationWishHolders
				.iterator();
		while (iterator.hasNext()) {
			String orgDBName = null;
			LocationWishHolder lHolder = (LocationWishHolder) iterator.next();
			orgDBName = new String(MailingSystemQueries.getOrgDBName(lHolder
					.getOrgId()));
			employeeWishHolder = MailingSystemQueries.getEmpIDForLocation(
					orgDBName, lHolder.getLocationId());
			if (!employeeWishHolder.isEmpty()) {
				MailListCreator.createMailList(employeeWishHolder,
						lHolder.getOrgId());
			}
		}
	}
}
