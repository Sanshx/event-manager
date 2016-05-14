package com.aricent.pojo_classes;

import java.util.ArrayList;

/**
 * @author gur43131
 *
 *It is a POJO class for sending mails to employees and sub-admin
 */
public class MailInformationHolder {

	
	
	private String employeeName;
	private String employeeEmailID;
	private ArrayList<String> listOfTeamEmployeeID;
	private String message;
	private String subject;
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

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
	 * @param argListOfTeamEmployeeID the listOfTeamEmployeeID to set
	 */
	public void setListOfTeamEmployeeID(
			ArrayList<String> argListOfTeamEmployeeID) {
		this.listOfTeamEmployeeID = argListOfTeamEmployeeID;
	}
	
	/**
	 * @return the listOfTeamEmployeeID
	 */
	public ArrayList<String> getListOfTeamEmployeeID() {
		return listOfTeamEmployeeID;
	}
	
	/**
	 * @param argMessage the message to set
	 */
	
	public void setMessage(String argMessage) {
		this.message = argMessage;
	}
	
	/**
	 * @return the message
	 */
	
	public String getMessage() {
		return message;
	}

}
