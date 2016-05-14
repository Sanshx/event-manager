package com.aricent.pojo_classes;

import java.util.ArrayList;

/**
 * @author gur43131
 *
 *It is a POJO class for sending birthday mails to employees
 */
public class BirthdayMailInformationHolder {

	
	
	private String employeeName;
	private String employeeEmailID;
	private ArrayList<TeamInformationHolder> listOfTeamEmployeeID;
	private String birthdayMessage;
	
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
	 * @param argEmployeeEmailId the employeeEmailID to set
	 */
	public void setEmployeeEmailID(String argEmployeeEmailId) {
		this.employeeEmailID = argEmployeeEmailId;
	}
	
	/**
	 * @return the employeeEmailID
	 */
	public String getEmployeeEmailID() {
		return employeeEmailID;
	}
	
	/**
	 * @param argListOfTeamEmployeeId the listOfTeamEmployeeID to set
	 */
	public void setListOfTeamEmployeeID(
			ArrayList<TeamInformationHolder> argListOfTeamEmployeeId) {
		this.listOfTeamEmployeeID = argListOfTeamEmployeeId;
	}
	
	/**
	 * @return the listOfTeamEmployeeID
	 */
	public ArrayList<TeamInformationHolder> getListOfTeamEmployeeID() {
		return listOfTeamEmployeeID;
	}
	
	/**
	 * @param argBirthdayMessage the birthday_message to set
	 */
	public void setBirthdayMessage(String argBirthdayMessage) {
		this.birthdayMessage = argBirthdayMessage;
	}
	
	/**
	 * @return the birthday_message
	 */
	public String getBirthdayMessage() {
		return birthdayMessage;
	}

}
