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
