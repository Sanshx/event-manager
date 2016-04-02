/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : PasswordEncryptor.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : Company Registration
	  Date of First Release : Jan 4, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 4, 2016
	  Modified by		:
	  Description of change :

 ***********************************************************************/

package com.aricent.java_classes;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author gur43128
 *
 */
public class PasswordEncryptor {

	public String encryptPassword(String argPlaintext) {
		String encryptedString = BCrypt.hashpw(argPlaintext, BCrypt.gensalt());
		return encryptedString;
	}

	public boolean matchPassword(String argPlaintext, String argOriginalHash) {
		boolean result = BCrypt.checkpw(argPlaintext, argOriginalHash);
		return result;
	}
}
