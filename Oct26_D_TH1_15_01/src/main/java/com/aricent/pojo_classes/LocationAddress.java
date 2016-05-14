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
