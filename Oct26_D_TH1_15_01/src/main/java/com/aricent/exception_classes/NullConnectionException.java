
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
