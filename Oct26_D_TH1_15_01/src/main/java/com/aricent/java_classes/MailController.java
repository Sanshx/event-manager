/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: MailController.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 18, 2016
	  Author					: gur43194
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

***********************************************************************/
package com.aricent.java_classes;

import java.util.ArrayList;

import com.aricent.pojo_classes.MailInformationHolder;

/**
 * @author gur43194
 *
 */
public class MailController {
	
	/**
	 * TO SEND THE MAILS , MAKE THE sendMail boolean as TRUE
	 */
	public static void mailController(MailInformationHolder argMailDetails){
		boolean printOnConsole = true;
		boolean sendMail = false;
		
		if(printOnConsole) mailConsolePrinter(argMailDetails);
		if(sendMail) MailSender.formEmailMessage(argMailDetails);
	}
	
	
	public static void mailConsolePrinter(MailInformationHolder argMailDetails) {
		ArrayList<String> cc = argMailDetails.getListOfTeamEmployeeID();
		System.out.println("To: " + argMailDetails.getEmployeeName());
		for (String members : cc) {
			System.out.println(members);
		}
		System.out.println("Email: " + argMailDetails.getEmployeeEmailID());
		System.out.println("Subject: " + argMailDetails.getSubject());
		System.out.println("Message: " + argMailDetails.getMessage());

		System.out.println("\n\n");
	}
}
