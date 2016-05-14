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
