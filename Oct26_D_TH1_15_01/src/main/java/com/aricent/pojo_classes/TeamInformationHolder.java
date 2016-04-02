/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: TeamInformationHolder.java
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
