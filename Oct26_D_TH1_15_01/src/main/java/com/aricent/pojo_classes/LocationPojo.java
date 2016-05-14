
package com.aricent.pojo_classes;

/**
 * @author gur43128
 *
 */
public class LocationPojo {

	private short countryID;
	private short cityID;
	private int officeID;
	private String timezone;
	/**
	 * @return the countryID
	 */
	public short getCountryID() {
		return countryID;
	}
	/**
	 * @param argCountryID the countryID to set
	 */
	public void setCountryID(short argCountryID) {
		this.countryID = argCountryID;
	}
	/**
	 * @return the cityID
	 */
	public short getCityID() {
		return cityID;
	}
	/**
	 * @param argCityID the cityID to set
	 */
	public void setCityID(short argCityID) {
		this.cityID = argCityID;
	}
	/**
	 * @return the officeID
	 */
	public int getOfficeID() {
		return officeID;
	}
	/**
	 * @param argOfficeID the officeID to set
	 */
	public void setOfficeID(int argOfficeID) {
		this.officeID = argOfficeID;
	}
	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
	/**
	 * @param argTimezone the timezone to set
	 */
	public void setTimezone(String argTimezone) {
		this.timezone = argTimezone;
	}
	
	
}
