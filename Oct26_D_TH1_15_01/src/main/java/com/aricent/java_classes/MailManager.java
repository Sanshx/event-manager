/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: MailManager.java
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

import com.aricent.database_connection.DatabaseConnection;

/**
 * @author gur43131
 *
 *         This class is used to manage mailing details
 */
public class MailManager {

	/*
	 * It is used to call mailingDetails() method
	 */
	public void sendMail(String argOrgDbName) {
		try {
			Connection conn = DatabaseConnection.getConnection(argOrgDbName);
			// sending mail details
			mailingDetails(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * It is used to send mail to employees and their sub admin
	 */
	public void mailingDetails(Connection argConn) throws SQLException {
		Statement stmt = argConn.createStatement();
		String sql = "SELECT distinct location_id FROM mailling_list";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int locationId = rs.getInt("location_id");
			// sending mail to sub admin

			SendSubAdminMail.mailToSubAdmin(locationId, argConn);
			// sending mail to employees
			SendEmployeeMail.mailToEmployees(locationId, argConn);
		}
		argConn.close();
	}

}
