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
