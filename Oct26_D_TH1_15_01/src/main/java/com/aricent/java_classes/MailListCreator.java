package com.aricent.java_classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.EmployeeWishHolder;

/**
 * @author gur43131
 *
 */
public class MailListCreator extends Thread {

	static String status = "Running";
	String orgDbName;

	/*
	 * default constructor
	 */
	public MailListCreator() {

	}

	/*
	 * parameterized constructor for setting value to org_db_name
	 */
	public MailListCreator(String argOrgDbName) {
		this.orgDbName = argOrgDbName;
	}

	/*
	 * It is used to create mail list
	 */
	public static void createMailList(ArrayList<EmployeeWishHolder> argArray,
			int argOrgId) {

		try {
			// connection to common database
			MailListCreator mailListCreator = new MailListCreator();
			mailListCreator.orgDbName = MailingSystemQueries
					.getOrgDBName(argOrgId);

			// connect to organization database
			Connection conn2 = DatabaseConnection
					.getConnection(mailListCreator.orgDbName);
			Iterator<EmployeeWishHolder> iterator = argArray.iterator();
			while (iterator.hasNext()) {
				EmployeeWishHolder employeeEventCheckerHolder = iterator.next();
				// employee already exists in mail list
				boolean exists = employeeExists(employeeEventCheckerHolder,
						conn2);
				// if employee does not exists in mail list then add him/her in
				// the mail list
				if (exists == false) {
					Statement stmt2 = conn2.createStatement();
					String sql2 = "INSERT into mailling_list VALUES('"
							+ employeeEventCheckerHolder.getEmpId() + "','"
							+ employeeEventCheckerHolder.getWishType() + "',"
							+ employeeEventCheckerHolder.getLocationId() + ")";
					stmt2.executeUpdate(sql2);
					stmt2.close();
				}
			}

			conn2.close();

			// creating threads
			threadCreation(mailListCreator.orgDbName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * It is used to check whether an employee exists in mail list or not
	 */
	public static boolean employeeExists(
			EmployeeWishHolder argEmployeeEventCheckerHolder, Connection argConn)
			throws SQLException {
		String id = argEmployeeEventCheckerHolder.getEmpId();
		int wishType = argEmployeeEventCheckerHolder.getWishType();
		Statement stmt = argConn.createStatement();
		// fetching employee id and wish type from mailing list
		String sql = "SELECT employee_id,wish_type FROM mailling_list";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String emp_id = rs.getString("employee_id");
			int wish_type = rs.getInt("wish_type");
			// employee exists in mailing list
			if (id.equalsIgnoreCase(emp_id) == true && wishType == wish_type) {
				return true;
			}

		}
		return false;
	}

	/*
	 * It is used to create a thread and start sending mail to the employees
	 */
	public static void threadCreation(String argOrgDbName) {
		MailListCreator invokeMailManager = new MailListCreator(argOrgDbName);

		invokeMailManager.start();
		try {

			// Thread.sleep(1000);
			invokeMailManager.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		synchronized (status) {
			MailManager mailManager = new MailManager();
			mailManager.sendMail(orgDbName);
		}
	}

}
