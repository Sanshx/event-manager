package com.aricent.pojo_classes;

/**
 * @author gur43131
 *
 *It is a POJO class for holding team details of employees
 */
public class TeamInformationHolder {

	
	private String employeeName;
	private String employeeEmailId;
	
	/**
	 * @param argEmployeeName the employeeName to set
	 */
	public void setEmployeeName(String argEmployeeName) {
		this.employeeName = argEmployeeName;
	}
	
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * @param argEmployeeEmailId the employeeEmailId to set
	 */
	public void setEmployeeEmailID(String argEmployeeEmailId) {
		this.employeeEmailId = argEmployeeEmailId;
	}
	
	/**
	 * @return the employeeEmailId
	 */
	public String getEmployeeEmailID() {
		return employeeEmailId;
	}
}
