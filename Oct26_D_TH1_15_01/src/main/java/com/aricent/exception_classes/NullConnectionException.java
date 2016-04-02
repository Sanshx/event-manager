/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : NullConnectionException.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 5, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 5, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.exception_classes;

/**
 * @author gur43128
 *This exception is thrown if connection to database could not be created
 */
public class NullConnectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5590217399729157188L;

	/**
	 * 
	 */
	public NullConnectionException() {
		super("Server is offline.");
	}



}
