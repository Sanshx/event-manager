/***********************************************************************
                         Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            : SuperAdminRegistrationQueries.java
	  Principal Author      : Gaurav Kumar
	  Subsystem Name        :
	  Module Name           : 
	  Date of First Release : Jan 6, 2016
	  Author				: Gaurav Kumar
	  Description           :


	  Change History

	  Version      		:
	  Date(DD/MM/YYYY) 	: Jan 6, 2016
	  Modified by		:
	  Description of change :

 ***********************************************************************/

package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.LocationPojo;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

/**
 * @author gur43128
 *
 */
public class SuperAdminRegistrationQueries {

	/**
	 * @param empCountry
	 * @param argOrgName
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 */
	public short insertCountry(String empCountry, String argOrgName)
			throws SQLException, NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO country_details (country_name) values(?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empCountry);
		preparedStatement.execute();

		short countryID = -1;
		query = "SELECT country_id FROM country_details WHERE country_name = ?";
		preparedStatement = orgConnection.prepareStatement(query);
		preparedStatement.setString(1, empCountry);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			countryID = set.getShort("country_id");
		}
		orgConnection.close();
		return countryID;
	}

	/**
	 * @param empCity
	 * @param argOrgName
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 */
	public short insertCity(String empCity, String argOrgName)
			throws SQLException, NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO city_details (city_name) values(?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empCity);
		preparedStatement.execute();

		short cityID = -1;
		query = "SELECT city_id FROM city_details WHERE city_name = ?";
		preparedStatement = orgConnection.prepareStatement(query);
		preparedStatement.setString(1, empCity);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			cityID = set.getShort("city_id");
		}
		orgConnection.close();
		return cityID;
	}

	/**
	 * @param empOffice
	 * @param argOrgName
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 */
	public int insertOffice(String empOffice, String argOrgName)
			throws SQLException, NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO office_details (office_address) values(?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empOffice);
		preparedStatement.execute();

		int officeID = -1;
		query = "SELECT office_id FROM office_details WHERE office_address = ?";
		preparedStatement = orgConnection.prepareStatement(query);
		preparedStatement.setString(1, empOffice);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			officeID = set.getInt("office_id");
		}
		orgConnection.close();
		return officeID;
	}

	/**
	 * @param location
	 * @param argOrgName
	 * @return
	 * @throws SQLException
	 * @throws NullConnectionException
	 */
	public int insertLocation(LocationPojo location, String argOrgName)
			throws SQLException, NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		short countryID = location.getCountryID();
		short cityID = location.getCityID();
		int officeID = location.getOfficeID();
		String timezoneString = location.getTimezone();
		String query = "INSERT INTO location_details (country_id, city_id, office_id, location_timezone) values(?,?,?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setShort(1, countryID);
		preparedStatement.setShort(2, cityID);
		preparedStatement.setInt(3, officeID);
		preparedStatement.setString(4, timezoneString);
		preparedStatement.execute();

		int locationID = -1;
		query = "SELECT location_id FROM location_details WHERE country_id = ? AND city_id = ? AND office_id = ?";
		preparedStatement = orgConnection.prepareStatement(query);
		preparedStatement.setShort(1, countryID);
		preparedStatement.setShort(2, cityID);
		preparedStatement.setInt(3, officeID);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			locationID = set.getInt("location_id");
		}
		orgConnection.close();
		return locationID;
	}

	/**
	 * @param empDepartmentName
	 * @param deptAnniversaryDate
	 * @param argOrgName
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 */
	public int insertDepartment(String empDepartmentName,
			Date deptAnniversaryDate, String argOrgName) throws SQLException,
			NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		java.sql.Date anniversary = new java.sql.Date(
				deptAnniversaryDate.getTime());
		String query = "INSERT INTO department_details (department_name , work_anniversary) values(?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empDepartmentName);
		preparedStatement.setDate(2, anniversary);
		preparedStatement.execute();

		int departmentID = -1;
		query = "SELECT department_id FROM department_details WHERE department_name = ? AND work_anniversary = ?";
		preparedStatement = orgConnection.prepareStatement(query);
		preparedStatement.setString(1, empDepartmentName);
		preparedStatement.setDate(2, anniversary);
		ResultSet set = preparedStatement.executeQuery();
		if (set.next()) {
			departmentID = set.getInt("department_id");
		}
		orgConnection.close();
		return departmentID;
	}

	boolean isInserted = false;

	/**
	 * @param superadmin
	 * @param orgName
	 * @return
	 * @throws NullConnectionException
	 * @throws SQLException
	 */
	public boolean insertSuperAdmin(EmployeeDetailsHolder superadmin, String argOrgName)
			throws SQLException, NullConnectionException {
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO employee_details (employee_id, first_name, last_name, birthday, work_anniversary, location_id, user_type_id, email_id, employee_contact ) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, superadmin.getEmpID());
		preparedStatement.setString(2, superadmin.getFirstName());
		preparedStatement.setString(3, superadmin.getLastName());
		preparedStatement.setDate(4, new java.sql.Date(superadmin
				.getEmpBirthDate().getTime()));
		preparedStatement.setDate(5, new java.sql.Date(superadmin
				.getEmpAnniversaryDate().getTime()));
		preparedStatement.setInt(6, superadmin.getLocationID());
		preparedStatement.setShort(7, superadmin.getUserTypeID());
		preparedStatement.setString(8, superadmin.getEmail());
		//preparedStatement.setInt(9, superadmin.getDepartmentID());
		preparedStatement.setString(9, superadmin.getContact());
		preparedStatement.execute();
		isInserted = true;
		orgConnection.close();
		return isInserted;
	}

	/**
	 * @param empID
	 * @param empPasswordString
	 * @param argOrgName 
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public boolean insertOrganizerLogin(String empID, String empPasswordString, String argOrgName) throws SQLException, NullConnectionException {
		boolean isLoginInserted = false;
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO organizer_login (employee_id, password ) values(?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empID);
		preparedStatement.setString(2, empPasswordString);
		preparedStatement.execute();
		isLoginInserted = true;
		orgConnection.close();
		return isLoginInserted;
	}

	/**
	 * @param empID
	 * @param locationAccess
	 * @param argOrgName
	 * @return
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 */
	public boolean insertOrganizerAccess(String empID, int locationAccess,
			String argOrgName) throws SQLException, NullConnectionException {
		boolean isAccessInserted = false;
		String orgDBName = new OrganizationRegistrationQueries()
				.getOrgDBNameFromDatabase(argOrgName);
		Connection orgConnection = DatabaseConnection.getConnection(orgDBName);
		if (orgConnection == null) {
			throw new NullConnectionException();
		}
		String query = "INSERT INTO organizer_access (employee_id, location_access ) values(?,?)";
		PreparedStatement preparedStatement = orgConnection
				.prepareStatement(query);
		preparedStatement.setString(1, empID);
		preparedStatement.setInt(2, locationAccess);
		preparedStatement.execute();
		isAccessInserted = true;
		orgConnection.close();
		return isAccessInserted;

	}
	
}
