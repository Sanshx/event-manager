/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LocationWishHolder.java
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
package com.aricent.pojo_classes;

/**
 * @author gur43182
 *
 */
public class LocationWishHolder {
	
	private int orgId;
	private int locationId;
	
	/**
	 * @param argOrgId
	 * @param argLocationId
	 */
	public LocationWishHolder(int argOrgId, int argLocationId) {
		super();
		this.orgId = argOrgId;
		this.locationId = argLocationId;
	}
	/**
	 * @return the orgId
	 */
	public int getOrgId() {
		return orgId;
	}
	/**
	 * @param argOrgId the orgId to set
	 */
	public void setOrgId(int argOrgId) {
		this.orgId = argOrgId;
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
	
}
