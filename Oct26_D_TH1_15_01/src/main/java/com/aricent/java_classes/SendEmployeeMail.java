/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: SendEmployeeMail.java
	  Principal Author      	: Gursimran Kaur Maken gur43131
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 7, 2016
	  Author					: gur43131
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.MailInformationHolder;

/**
 * @author gur43131
 *
 *         This class is used to send mail to the employees
 */
public class SendEmployeeMail {

	/*
	 * It is used to fetch details of the employee who is having their birthday
	 * or work anniversary
	 */
	public static void mailToEmployees(int argLocationId, Connection argConn)
			throws SQLException {
		Statement stmt = argConn.createStatement();
		String sql = "SELECT employee_id,wish_type FROM mailling_list where location_id='"
				+ argLocationId + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String empId = rs.getString("employee_id");
			int wishType = rs.getInt("wish_type");
			MailInformationHolder mailDetails = sendMails(empId, argConn,
					wishType);

	
			//Sending mail
			MailController.mailController(mailDetails);

		}
	}

	/*
	 * It is used to send mails to employees who are having birthday or work
	 * anniversary
	 */
	public static MailInformationHolder sendMails(String argEmpId,
			Connection argConn, int argWishType) throws SQLException {
		MailInformationHolder mailDetails = new MailInformationHolder();
		MailInformationHolder mailDetails1 = MailingSystemQueries
				.getEmployeeNameAndEmailID(mailDetails, argEmpId, argConn);
		mailDetails1 = MailingSystemQueries.getMessage(mailDetails1,
				argWishType, argConn);
		if (argWishType == 1) {
			mailDetails1 = MailingSystemQueries.getCC(mailDetails1,
					argWishType, argEmpId, argConn);
		} else
			mailDetails1.setListOfTeamEmployeeID(new ArrayList<String>());
		MailingSystemQueries.deleteEntriesFromMailingList(argEmpId, argConn);

		return mailDetails1;
	}



}
