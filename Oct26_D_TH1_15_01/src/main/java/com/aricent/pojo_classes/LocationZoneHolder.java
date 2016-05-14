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
