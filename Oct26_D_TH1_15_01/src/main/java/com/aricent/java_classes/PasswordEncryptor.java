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
