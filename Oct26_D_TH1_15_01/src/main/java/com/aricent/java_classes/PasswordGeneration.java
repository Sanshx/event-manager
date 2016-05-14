package com.aricent.java_classes;

import java.util.Random;

/**
 * @author gur43131
 *
 */
public class PasswordGeneration {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	public static String generatePassword() {
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
