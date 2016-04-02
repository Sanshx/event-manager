/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LocationZoneHolder.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43194
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

***********************************************************************/
package com.aricent.pojo_classes;

/**
 * @author gur43194
 *
 */
public class LocationZoneHolder {

	private int locationId;
	private String locationTimezone;
	
	
	/**
	 * @param argLocationId
	 * @param argLocationTimezone
	 */
	public LocationZoneHolder(int argLocationId, String argLocationTimezone) {
		super();
		this.locationId = argLocationId;
		this.locationTimezone = argLocationTimezone;
	}
	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}
	/**
	 * @param argLocationId the locationId to set
	 */
	public void setLocationId(int argLocationId) {
		this.locationId = argLocationId;
	}
	/**
	 * @return the locationTimezone
	 */
	public String getLocationTimezone() {
		return locationTimezone;
	}
	/**
	 * @param argLocationTimezone the locationTimezone to set
	 */
	public void setLocationTimezone(String argLocationTimezone) {
		this.locationTimezone = argLocationTimezone;
	}
	
	
	
}
