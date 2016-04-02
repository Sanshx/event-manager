/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : BdayDisplayQueries.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 11, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 11, 2016
	  Modified by		:
	  Description of change :

***********************************************************************/

package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.InvalidEntryException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.java_classes.LocationAccessChecker;
import com.aricent.pojo_classes.EmpBday;

/**
 * @author gur43128
 *
 */
public class BdayDisplayQueries {

	/**
	 * @param month
	 * @param dbName
	 * @return 
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InvalidEntryException 
	 */
	public ArrayList<EmpBday> getBday(int month, String dbName, HttpSession sess) throws NullConnectionException, SQLException, InvalidEntryException {
		Connection orgConnection = DatabaseConnection.getConnection(dbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		ArrayList<EmpBday> employees = new ArrayList<EmpBday>();
		String query = "SELECT * FROM employee_details WHERE MONTH(birthday) = ? "+LocationAccessChecker.SQLLocationCondition(sess, false);
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, month);
		ResultSet set = preparedStatement.executeQuery();
		while (set.next()) {
			EmpBday employee = new EmpBday();
			employee.setEmpID(set.getString("employee_id"));
			employee.setFirstName(set.getString("first_name"));
			employee.setLastName(set.getString("last_name"));
			employee.setDate(new Date(set.getDate("birthday").getTime()));
			String officeAddress = this.getOfficeAddress(set.getInt("location_id"), dbName);
			employee.setOfficeAddress(officeAddress);
			employees.add(employee);
		}
		orgConnection.close();
		return employees;
	}

	/**
	 * @param argLocationID
	 * @param argDbName 
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InvalidEntryException 
	 */
	private String getOfficeAddress(int argLocationID, String argDbName) throws NullConnectionException, SQLException, InvalidEntryException {
		Connection orgConnection = DatabaseConnection.getConnection(argDbName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "SELECT office_id FROM location_details WHERE location_id = ?";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setInt(1, argLocationID);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			int officeID = set.getInt("office_id");
			query = "SELECT office_address FROM office_details WHERE office_id = ?";
			PreparedStatement preparedStatement2 = orgConnection
					.prepareStatement(query);
			preparedStatement2.setInt(1, officeID);
			ResultSet office = preparedStatement2.executeQuery();
			if (office.next()) {
				String officeAddress = office.getString("office_address");
				orgConnection.close();
				return officeAddress;
			}
			else {
				orgConnection.close();
				throw new InvalidEntryException();
			}
		}
		else {
			orgConnection.close();
			throw new InvalidEntryException();
		}
	}

}
