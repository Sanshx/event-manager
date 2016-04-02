/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : OrganizationPojo.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 5, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 5, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

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
