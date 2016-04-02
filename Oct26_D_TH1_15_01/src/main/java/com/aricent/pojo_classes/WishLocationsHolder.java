/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: WishLocationsHolder.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 6, 2016
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
public class WishLocationsHolder {

	private int orgId;
	private int locationId;
	
	
	/**
	 * @param argOrgId
	 * @param argLocationId
	 */
	public WishLocationsHolder(int argOrgId, int argLocationId) {
		super();
		this.orgId = argOrgId;
		this.locationId = argLocationId;
	}
	/**
	 * @return the org_id
	 */
	public int getOrgId() {
		return orgId;
	}
	/**
	 * @param argOrgId the org_id to set
	 */
	public void setOrgId(int argOrgId) {
		this.orgId = argOrgId;
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
	
	
}
