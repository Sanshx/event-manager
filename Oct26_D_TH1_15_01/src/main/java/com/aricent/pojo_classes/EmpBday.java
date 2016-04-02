/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : EmpBday.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 11, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 11, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.pojo_classes;

import java.util.Date;

/**
 * @author gur43128
 *
 */
public class EmpBday {
	
	private String empID;
	private String firstName;
	private String lastName;
	private Date date;
	private String officeAddress;
	/**
	 * @return the empID
	 */
	public String getEmpID() {
		return empID;
	}
	/**
	 * @param argEmpID the empID to set
	 */
	public void setEmpID(String argEmpID) {
		this.empID = argEmpID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param argFirstName the firstName to set
	 */
	public void setFirstName(String argFirstName) {
		this.firstName = argFirstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param argLastName the lastName to set
	 */
	public void setLastName(String argLastName) {
		this.lastName = argLastName;
	}
	/**
	 * @return the birthDate
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param argBirthDate the birthDate to set
	 */
	public void setDate(Date argBirthDate) {
		this.date = argBirthDate;
	}
	/**
	 * @return the officeAddress
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}
	/**
	 * @param argOfficeAddress the officeAddress to set
	 */
	public void setOfficeAddress(String argOfficeAddress) {
		this.officeAddress = argOfficeAddress;
	}
	
	

}
