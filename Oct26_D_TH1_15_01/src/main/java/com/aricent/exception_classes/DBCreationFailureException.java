/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : DBCreationFailureException.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : Company Registration
	  Date of First Release : Jan 5, 2016
	  Author				: Gaurav Kumar
	  Description           : This file contains DBCreationFailureException


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 5, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.exception_classes;

/**
 * @author gur43128
 *This exception is thrown if organization database can not be created
 */
public class DBCreationFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1545850051028647439L;

	/**
	 * 
	 */
	public DBCreationFailureException() {
		super("Database creation problem");
	}
}
