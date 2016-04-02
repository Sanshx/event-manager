/***********************************************************************
                         Aricent Technologies Proprietary



This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LocationAccessChecker.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 13, 2016
	  Author					: gur43194
	  Description           	: This file contains class to check access of
	  							  a admin to a employee or location data


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

/**
 * @author gur43194 This class has the functions to restrict a sub admin to
 *         access a location or employee which is not under its access location
 */
public class LocationAccessChecker {

	/**
	 * Checks if a employee is within the access of sub admin or not
	 * 
	 * @param sess
	 * @param targetUserType
	 * @param targetLocationId
	 * @return 'Access' if access, and 'NoAccess' if employee is not under
	 *         access
	 */
	public static String targetEmployeeAccess(HttpSession argSess,
			int argTargetUserType, int argTargetLocationId) {
		boolean resultUserType = false;
		boolean resultLocation = false;
		// Checking for user type
		int adminUserType = (int) argSess.getAttribute("userTypeId");
		if (adminUserType < argTargetUserType)
			resultUserType = true;

		// Checking for location access of admin and location on employee
		@SuppressWarnings("unchecked")
		ArrayList<Integer> locationAccess = (ArrayList<Integer>) argSess
				.getAttribute("locations");
		for (Integer location : locationAccess) {
			if (location == argTargetLocationId) {
				resultLocation = true;
				break;
			}
		}

		if (resultLocation && resultUserType)
			return "Access";
		else
			return "NoAccess";
	}

	/**
	 * Returns a string of Location ids by fetching it from admin's session
	 * 
	 * @param sess
	 * @param argWhereNeeded
	 *            To Add 'WHERE' or 'ADD' Clause in query
	 * @return String to be attached in queries to restrict results
	 */
	public static String SQLLocationCondition(HttpSession argSess,
			boolean argWhereNeeded) {
		String result = "";
		boolean first = false;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> locationAccess = (ArrayList<Integer>) argSess
				.getAttribute("locations");
		if (locationAccess.size() > 0) {
			if (argWhereNeeded)
				result = result.concat(" WHERE");
			else
				result = result.concat(" AND");
			result = result.concat(" location_id  IN (");
			for (Integer location : locationAccess) {
				if (first)
					result = result.concat(" ,");
				result = result.concat(String.valueOf(location));
				first = true;
			}
			result = result.concat(")");

		}
		return result;
	}

}
