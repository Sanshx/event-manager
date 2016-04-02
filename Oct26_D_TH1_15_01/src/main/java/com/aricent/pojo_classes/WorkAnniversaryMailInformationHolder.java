/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: WorkAnniversaryMailInformationHolder.java
	  Principal Author      	: Gursimran Kaur Maken gur43131
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 8, 2016
	  Author					: gur43131
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
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
