/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: EmployeeManagementQueries.java
	  Principal Author      	: Sumukh Chitrashekar gur43182
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 11, 2016
	  Author					: gur43182
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

***********************************************************************/
package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.aricent.exception_classes.NullConnectionException;
import com.aricent.java_classes.LocationAccessChecker;
import com.aricent.pojo_classes.LocationAddress;

/**
 * @author gur43182
 *
 */
public class EmployeeManagementQueries {
	
	/**
	 * @param argEmployeeId employee id
	 * @param argOrgId organization id
	 * @return Null if no employee is present, else return it's data
	 */
	public static EmployeeDetailsHolder findEmployeeDetails(String argEmployeeId, Integer argOrgId){
		EmployeeDetailsHolder employee = null;
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		connect = DatabaseConnection.getConnection(orgDbName);
		if(connect != null){
			try {
				stmt = connect.prepareStatement("SELECT * FROM employee_details WHERE employee_id='"+argEmployeeId+"'");
				rs = stmt.executeQuery();
				if(rs.next()){
					employee = new EmployeeDetailsHolder();
					employee.setEmpID(argEmployeeId);
					employee.setFirstName(rs.getString("first_name"));
					employee.setLastName(rs.getString("last_name"));
					employee.setEmpBirthDate(rs.getDate("birthday"));
					employee.setEmpAnniversaryDate(rs.getDate("work_anniversary"));
					employee.setDepartmentID(rs.getInt("department_id"));
					employee.setEmail(rs.getString("email_id"));
					employee.setUserTypeID(rs.getShort("user_type_id"));
					employee.setContact(rs.getString("employee_contact"));
					employee.setLocationID(rs.getInt("location_id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stmt.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return employee;		
	}
	
	/**
	 * Deletes an employee from the databases
	 * @param argEmployeeId
	 * @param argOrgId
	 * @return
	 */
	public static boolean deleteEmployee(String argEmployeeId, Integer argOrgId){
		int rowsDeleted = 0;
		boolean deleted = false;
		Connection connect = null;
		PreparedStatement stmtTeam = null;
		PreparedStatement stmtEmployee = null;
		
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		connect = DatabaseConnection.getConnection(orgDbName);
		if(connect != null){
			try {
				stmtTeam = connect.prepareStatement("DELETE FROM team_members WHERE employee_id='"+argEmployeeId+"'");
				stmtEmployee = connect.prepareStatement("DELETE FROM employee_details WHERE employee_id='"+argEmployeeId+"'");
				stmtTeam.execute();
				rowsDeleted = stmtEmployee.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmtTeam.close();
					stmtEmployee.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(rowsDeleted > 0) deleted = true;
		return deleted;
	}
	
	/**
	 * Returns list of addresses 
	 * @param argOrgId
	 * @return location address list
	 */
	public static ArrayList<LocationAddress> listOfAddresses(int argOrgId, HttpSession argSess) {
		ArrayList<LocationAddress> locationAddresses = new ArrayList<>();
		String orgDBName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connection = DatabaseConnection.getConnection(orgDBName);
		//Local variables
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		PreparedStatement statement3 = null;
		PreparedStatement statement4 = null;
		
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		
		
		if (connection != null) {
			try {
				statement1 = connection.prepareStatement("SELECT location_id, "
						+ "country_id, city_id, office_id FROM "
						+ "location_details"+LocationAccessChecker.SQLLocationCondition(argSess, true));
				resultSet1 = statement1.executeQuery();
				while (resultSet1.next()) {
					statement2 = connection.prepareStatement("SELECT country_name "
							+ "FROM country_details where country_id=" + resultSet1.getInt("country_id"));
					statement3 = connection.prepareStatement("SELECT city_name "
							+ "FROM city_details where city_id=" + resultSet1.getInt("city_id"));
					statement4 = connection.prepareStatement("SELECT office_address "
							+ "FROM office_details where office_id=" + resultSet1.getInt("office_id"));
					resultSet2 = statement2.executeQuery();
					resultSet3 = statement3.executeQuery();
					resultSet4 = statement4.executeQuery();
					resultSet2.next();
					resultSet3.next();
					resultSet4.next();
					String country_name = resultSet2.getString("country_name");
					String city_name = resultSet3.getString("city_name");
					String office_address = resultSet4.getString("office_address");
					String finalAddress = office_address + " " + city_name + " " + country_name;
					locationAddresses.add(new LocationAddress(resultSet1.getInt("location_id"), 
							finalAddress));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					resultSet1.close();
					resultSet2.close();
					resultSet3.close();
					resultSet4.close();
					statement1.close();
					statement2.close();
					statement3.close();
					statement4.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		} else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		if (!locationAddresses.isEmpty()) {
			return locationAddresses;
		} else {
			return null;
		}
	
	}
	
	/**
	 * This method adds employee to database 
	 * @param argEmployee employee details
	 * @param argOrgId id of organization
	 * @return true if employee is added , false if employee is not added
	 */
	public static boolean employeeAddition(EmployeeDetailsHolder argEmployee, int argOrgId) {
		String orgDBName = MailingSystemQueries.getOrgDBName(argOrgId);
		int rows = 0;
		Connection connection = DatabaseConnection.getConnection(orgDBName);
		String query = "INSERT INTO employee_details (employee_id, first_name, "
				+ "last_name, birthday, work_anniversary, location_id, user_type_id, "
				+ "email_id, employee_contact ) values(?,?,?,?,?,?,3,?,?)";
		PreparedStatement preparedStatement = null;
		
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, argEmployee.getEmpID());
				preparedStatement.setString(2, argEmployee.getFirstName());
				preparedStatement.setString(3, argEmployee.getLastName());
				preparedStatement.setDate(4, new java.sql.Date(argEmployee
						.getEmpBirthDate().getTime()));
				preparedStatement.setDate(5, new java.sql.Date(argEmployee
						.getEmpAnniversaryDate().getTime()));
				preparedStatement.setInt(6, argEmployee.getLocationID());
				preparedStatement.setString(7, argEmployee.getEmail());
				//preparedStatement.setInt(9, argEmployee.getDepartmentID());
				preparedStatement.setString(8, argEmployee.getContact());
				rows = preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
				if(rows == 1)return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 	
		} else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	

	/**
	 * This method updates employee to database 
	 * @param argEmployee employee details
	 * @param argOrgId id of organization
	 * @return true if employee is updated , false if employee is not updated
	 */
	public static boolean employeeUpdation(EmployeeDetailsHolder argEmployee, int argOrgId) {
		String orgDBName = MailingSystemQueries.getOrgDBName(argOrgId);
		int rows = 0;
		Connection connection = DatabaseConnection.getConnection(orgDBName);
		String query = "UPDATE employee_details SET first_name=?, last_name=?, birthday=?, work_anniversary=?, location_id=?, email_id=?, employee_contact=? WHERE employee_id=? ";
		PreparedStatement preparedStatement = null;
		
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(8, argEmployee.getEmpID());
				preparedStatement.setString(1, argEmployee.getFirstName());
				preparedStatement.setString(2, argEmployee.getLastName());
				preparedStatement.setDate(3, new java.sql.Date(argEmployee
						.getEmpBirthDate().getTime()));
				preparedStatement.setDate(4, new java.sql.Date(argEmployee
						.getEmpAnniversaryDate().getTime()));
				preparedStatement.setInt(5, argEmployee.getLocationID());
				preparedStatement.setString(6, argEmployee.getEmail());
				//preparedStatement.setInt(7, argEmployee.getDepartmentID());
				preparedStatement.setString(7, argEmployee.getContact());
				rows = preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
				if(rows == 1) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 	
		} else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	

}
