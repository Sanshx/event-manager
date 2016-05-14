package com.aricent.exception_classes;

/**
 * @author gur43128
 *This exception is thrown if there is error in registering organization
 */
public class RegisterOrgErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public RegisterOrgErrorException() {
		super("Error in registering organization");
	}

}
