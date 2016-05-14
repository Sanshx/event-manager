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
