/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: EmployeeWishHolder.java
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
public class EmployeeWishHolder {
	
	private String empId;
	private int wishType;
	private int locationId;
	/**
	 * @param argEmpId
	 * @param argWishType
	 */
	public EmployeeWishHolder(String argEmpId, int argWishType, int argLocationId) {
		super();
		this.empId = argEmpId;
		this.wishType = argWishType;
		this.locationId = argLocationId;
	}
	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * @param argEmpId the empId to set
	 */
	public void setEmpId(String argEmpId) {
		this.empId = argEmpId;
	}
	/**
	 * @return the wishType
	 */
	public int getWishType() {
		return wishType;
	}
	/**
	 * @param argWishType the wishType to set
	 */
	public void setWishType(int argWishType) {
		this.wishType = argWishType;
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
