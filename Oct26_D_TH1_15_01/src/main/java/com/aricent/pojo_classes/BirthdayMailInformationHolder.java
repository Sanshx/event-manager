/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: MailInformationHolder.java
	  Principal Author      	: Gursimran Kaur Maken gur43131
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 7, 2016
	  Author					: gur43131
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
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
