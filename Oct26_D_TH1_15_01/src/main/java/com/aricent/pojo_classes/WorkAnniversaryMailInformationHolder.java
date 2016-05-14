package com.aricent.pojo_classes;

/**
 * @author gur43131
 *
 *It is a POJO class for sending work anniversary mails to employees
 */
public class WorkAnniversaryMailInformationHolder {

	private String employeeName;
	private String employeeEmailID;
	private String anniversaryMessage;
	
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
	 * @param argEmployeeEmailID the employeeEmailID to set
	 */
	public void setEmployeeEmailID(String argEmployeeEmailID) {
		this.employeeEmailID = argEmployeeEmailID;
	}
	
	/**
	 * @return the employeeEmailID
	 */
	public String getEmployeeEmailID() {
		return employeeEmailID;
	}
	
	/**
	 * @param argAnniversaryMessage the anniversaryMessage to set
	 */
	public void setAnniversaryMessage(String argAnniversaryMessage) {
		this.anniversaryMessage = argAnniversaryMessage;
	}
	
	/**
	 * @return the anniversaryMessage
	 */
	public String getAnniversaryMessage() {
		return anniversaryMessage;
	}
}
