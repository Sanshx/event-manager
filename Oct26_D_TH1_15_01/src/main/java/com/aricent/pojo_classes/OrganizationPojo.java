
package com.aricent.pojo_classes;

import java.util.Date;

/**
 * @author gur43128
 *
 */
public class OrganizationPojo {

	private String orgName;
	private String orgDesc;
	private Date orgAnniversaryDate;
	private String orgRecoveryMail;
	
	/**
	 * 
	 */
	public OrganizationPojo() {
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param argOrgName the orgName to set
	 */
	public void setOrgName(String argOrgName) {
		this.orgName = argOrgName;
	}

	/**
	 * @return the orgDesc
	 */
	public String getOrgDesc() {
		return orgDesc;
	}

	/**
	 * @param argOrgDesc the orgDesc to set
	 */
	public void setOrgDesc(String argOrgDesc) {
		this.orgDesc = argOrgDesc;
	}

	/**
	 * @return the orgAnniversaryDate
	 */
	public Date getOrgAnniversaryDate() {
		return orgAnniversaryDate;
	}

	/**
	 * @param argOrgAnniversaryDate the orgAnniversaryDate to set
	 */
	public void setOrgAnniversaryDate(Date argOrgAnniversaryDate) {
		this.orgAnniversaryDate = argOrgAnniversaryDate;
	}

	/**
	 * @return the orgRecoveryMail
	 */
	public String getOrgRecoveryMail() {
		return orgRecoveryMail;
	}

	/**
	 * @param argOrgRecoveryMail the orgRecoveryMail to set
	 */
	public void setOrgRecoveryMail(String argOrgRecoveryMail) {
		this.orgRecoveryMail = argOrgRecoveryMail;
	}

	
}
