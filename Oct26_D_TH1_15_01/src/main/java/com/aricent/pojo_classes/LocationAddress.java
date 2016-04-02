/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LocationAddress.java
	  Principal Author      	: Sumukh Chitrashekar gur43182
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 11, 2016
	  Author					: gur43182
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

***********************************************************************/
package com.aricent.pojo_classes;

/**
 * @author gur43182
 *
 */
public class LocationAddress {
	
	private int locationId;
	private String officeAddress;
	
	
	/**
	 * 
	 * @param argLocationId
	 * @param argOfficeAddress
	 */
	public LocationAddress(int argLocationId, String argOfficeAddress) {
		super();
		this.locationId = argLocationId;
		this.officeAddress = argOfficeAddress;
	}


	/**
	 * @return the location_id
	 */
	public int getLocationId() {
		return locationId;
	}


	/**
	 * @param argLocationId the location_id to set
	 */
	public void setLocationId(int argLocationId) {
		this.locationId = argLocationId;
	}
	


	/**
	 * @return the office_address
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}


	/**
	 * @param argOfficeAddress the office_address to set
	 */
	public void setOfficeAddress(String argOfficeAddress) {
		this.officeAddress = argOfficeAddress;
	}
	
	

}
