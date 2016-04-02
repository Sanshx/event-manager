/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: AddSubAdmin.java
	  Principal Author      	: Gursimran Kaur Maken gur43131
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 13, 2016
	  Author					: gur43131
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.java_classes.PasswordEncryptor;
import com.aricent.java_classes.PasswordGeneration;
import com.aricent.pojo_classes.MailInformationHolder;

/**
 * Servlet implementation class ValidateSession
 */
public class AddSubAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSubAdmin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String empId = request.getParameter("emp_id");
		String officeAddress = request.getParameter("office_address");

		// getting session data
		HttpSession session = request.getSession(false);
		String orgDBName = MailingSystemQueries.getOrgDBName((int) session
				.getAttribute("orgId"));

		// connect to particular company database
		Connection connect = DatabaseConnection.getConnection(orgDBName);

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			// employee is already a sub admin
			statement = connect
					.prepareStatement("SELECT user_type_id,email_id FROM employee_details WHERE employee_id='"
							+ empId + "'");
			resultSet = statement.executeQuery();
			boolean val = resultSet.next();
			// employee exists
			if (val == true) {
				MailInformationHolder mailDetails = new MailInformationHolder();
				int userType = resultSet.getInt("user_type_id");

				String message = "";

				// get employee name and id
				MailInformationHolder mailDetails2 = MailingSystemQueries
						.getEmployeeNameAndEmailID(mailDetails, empId, connect);

				if (userType == 3) {

					// change user_type_id in database
					String updateTableSQL = "UPDATE employee_details SET user_type_id = ? WHERE employee_id = ?";
					preparedStatement = connect
							.prepareStatement(updateTableSQL);
					preparedStatement.setInt(1, 2);
					preparedStatement.setString(2, empId);
					// execute insert SQL statement
					preparedStatement.executeUpdate();

					// generating password for sub admin
					String password = PasswordGeneration.generatePassword();
					PasswordEncryptor passwordEncrypt = new PasswordEncryptor();
					String encryptPassword = passwordEncrypt
							.encryptPassword(password);
					String query = " insert into organizer_login (employee_id, password)"
							+ " values (?, ?)";

					// create the mysql insert preparedstatement
					preparedStatement = connect.prepareStatement(query);
					preparedStatement.setString(1, empId);
					preparedStatement.setString(2, encryptPassword);

					// execute the preparedstatement
					preparedStatement.execute();

					message += "Password: " + password;
				}

				// adding details in organizer_access
				String query = " insert into organizer_access (employee_id, location_access)"
						+ " values (?, ?)";

				// create the mysql insert preparedstatement
				preparedStatement = connect.prepareStatement(query);

				String ofc[] = officeAddress.split("&");
				for (int i = 0; i < ofc.length; i++) {
					statement = connect.prepareStatement("SELECT employee_id, location_access FROM organizer_access WHERE employee_id='"+ empId+ "' and location_access='"+ Integer.parseInt(ofc[i]) + "'");
					resultSet = statement.executeQuery();
					boolean value = resultSet.next();
					if (value == false)
					{
						preparedStatement.setString(1, empId);
						preparedStatement.setInt(2, Integer.parseInt(ofc[i]));
						preparedStatement.execute();
					}
				}

				message += "Location access: ";
				statement = connect
						.prepareStatement("SELECT location_access FROM organizer_access WHERE employee_id='"
								+ empId + "'");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					message += resultSet.getInt("location_access") + " ";
				}
				mailDetails2.setMessage(message);
				mailDetails2.setSubject("Location access added");
				mailDetails2.setListOfTeamEmployeeID(new ArrayList<String>());
				AddSubAdmin.showMailDetails(mailDetails);

				response.getWriter().print(2);

				preparedStatement.close();

			}
			// employee does not exists
			else {
				response.getWriter().print(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void showMailDetails(MailInformationHolder mailDetails) {
		System.out.println("Mail to: " + mailDetails.getEmployeeName());
		System.out.println("Email ID: " + mailDetails.getEmployeeEmailID());
		System.out.println("Subject: "+mailDetails.getSubject());
		System.out.println("Message: " + mailDetails.getMessage());
	}

}
