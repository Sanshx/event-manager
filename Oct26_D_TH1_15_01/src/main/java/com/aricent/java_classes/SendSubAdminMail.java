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
 *         This class is used to send mail to sub admin of each location
 */
public class SendSubAdminMail {

	/*
	 * sending mail to sub admin
	 */
	public static void mailToSubAdmin(int argLocationId, Connection argConn)
			throws SQLException {
		MailInformationHolder mailDetails2 = null;
		Statement stmt3 = argConn.createStatement();
		String sql3 = "SELECT employee_id FROM organizer_access where location_access='"
				+ argLocationId + "'";
		ResultSet rs3 = stmt3.executeQuery(sql3);
		boolean birthdaysExists = false;
		while (rs3.next()) {
			String empId = rs3.getString("employee_id");
			MailInformationHolder mailDetails = new MailInformationHolder();
			mailDetails2 = MailingSystemQueries.getEmployeeNameAndEmailID(
					mailDetails, empId, argConn);

			Statement stmt = argConn.createStatement();
			// fetching employee ID and wish type from mailing list
			String sql = "SELECT employee_id,wish_type FROM mailling_list where location_id='"
					+ argLocationId + "'";
			ResultSet rs = stmt.executeQuery(sql);
			String message = "Hey " + mailDetails2.getEmployeeName()
					+ ", following people have birthdays today...\n\n";
			while (rs.next()) {
				String empId2 = rs.getString("employee_id");
				int wishType = rs.getInt("wish_type");
				if (wishType == 1) {
					Statement stmt2 = argConn.createStatement();
					// fetching name, designation and email ID of employee who
					// all are having birthday
					String sql2 = "SELECT employee_id, first_name,designation,email_id FROM employee_details "
							+ "where employee_id='" + empId2 + "'";
					ResultSet rs2 = stmt2.executeQuery(sql2);
					while (rs2.next()) {
						birthdaysExists = true;
						message += "Name: " + rs2.getString("first_name")
								+ "\t ID: " + rs2.getString("employee_id")
								+ "\tEmail Id:" + rs2.getString("email_id")
								+ "\n";
					}
					mailDetails2
							.setSubject("Today's Birthdays at your place...");
					mailDetails2.setMessage(message);
					mailDetails2
							.setListOfTeamEmployeeID(new ArrayList<String>());
				}
			}
			if (birthdaysExists) {
				//Sending mail to subadmin
				MailController.mailController(mailDetails2);
			}

		}

	}
}
