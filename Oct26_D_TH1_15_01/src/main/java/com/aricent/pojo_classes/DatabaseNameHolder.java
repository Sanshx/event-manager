/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: DatabaseNameHolder.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
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
public class DatabaseNameHolder {
	
	private int orgId;
	private String orgDbName;
	
	
	
	/**
	 * @param argOrgId
	 * @param argOrgDbName
	 */
	public DatabaseNameHolder(int argOrgId, String argOrgDbName) {
		super();
		this.orgId = argOrgId;
		this.orgDbName = argOrgDbName;
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
	 * @return the org_db_name
	 */
	public String getOrgDbName() {
		return orgDbName;
	}
	/**
	 * @param argOrgDbName the org_db_name to set
	 */
	public void setOrgDbName(String argOrgDbName) {
		this.orgDbName = argOrgDbName;
	}
	
	
	
}
