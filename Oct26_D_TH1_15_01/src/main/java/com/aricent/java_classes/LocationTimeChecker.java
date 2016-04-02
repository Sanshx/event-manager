/***********************************************************************
                         Aricent Technologies Proprietary



This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LocationTimeChecker.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43194
	  Description           	: This file contain class which has function
	   							  to find the locations which had a new day.
	   							  Those locations are passed to next function
	   							  for fetching the birthdays and work anniversary
	   							  of the employees of that locations


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import java.util.ArrayList;

import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.DatabaseNameHolder;
import com.aricent.pojo_classes.LocationZoneHolder;
import com.aricent.pojo_classes.LocationWishHolder;

/**
 * @author gur43194 This class contains to find the locations which had a new
 *         day It compares the time of a location to 12am - 12:30am, checks that
 *         whether the time is in range or not
 */
public class LocationTimeChecker {

	/**
	 * This method find locations to which birthday and anniversary messages
	 * have to be sent
	 */
	public void findWishLocations() {

		// Array of wish lists
		ArrayList<LocationWishHolder> wishOrgLocationArray = new ArrayList<>();

		// Getting all data
		ArrayList<DatabaseNameHolder> allDatabaseList = MailingSystemQueries
				.getAllDatabasesList();
		// Iterating over all organizations databases
		for (DatabaseNameHolder databaseName : allDatabaseList) {
			// Fetching all locations in and organization
			ArrayList<LocationZoneHolder> allOrgLocationsList = MailingSystemQueries
					.getAllOrgLocationsList(databaseName.getOrgDbName());
			// Iterating over all locations to get the location with new day
			for (LocationZoneHolder locationZone : allOrgLocationsList) {

				if (ComparingDateAndTime.timeInRange(CurrentTimeFetcher
						.getCurrentTime(locationZone.getLocationTimezone()))) {
					// Adding those locations and org_id to array list
					wishOrgLocationArray.add(new LocationWishHolder(
							databaseName.getOrgId(), locationZone
									.getLocationId()));
				}

			}

		}

		// Sending array list forward of finding birthdays
		EmployeeEventChecker.mailListAppender(wishOrgLocationArray);
	}

}
