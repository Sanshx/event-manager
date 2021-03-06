package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.java_classes.ComparingDateAndTime;
import com.aricent.java_classes.CurrentTimeFetcher;
import com.aricent.pojo_classes.MailInformationHolder;
import com.aricent.pojo_classes.DatabaseNameHolder;
import com.aricent.pojo_classes.EmployeeWishHolder;
import com.aricent.pojo_classes.LocationZoneHolder;


import java.sql.PreparedStatement;


/**
 * @author gur43194
 *
 */
/**
 * @author gur43182
 *
 */
/**
 * @author gur43131
 * 
 */
public class MailingSystemQueries {

	/**
	 * @return database name list
	 */
	public static ArrayList<DatabaseNameHolder> getAllDatabasesList() {
		ArrayList<DatabaseNameHolder> allDatabaseList = new ArrayList<>();

		Connection connect = DatabaseConnection.getConnection("ih_ems_common");
		PreparedStatement statement = null;
		ResultSet result = null;
		
		if(connect != null){
			try {
				statement = connect.prepareStatement
						("SELECT org_id, org_db_name FROM org_record");
				result = statement.executeQuery();
				while(result.next()){
					allDatabaseList.add(new DatabaseNameHolder
						(result.getInt("org_id"), result.getString("org_db_name")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					result.close();
					statement.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return allDatabaseList;
	}
	
	/**
	 * @param argOrgId organization id
	 */
	public static String getOrgDBName(int argOrgId) {
		Connection connect = DatabaseConnection.getConnection("ih_ems_common");
		//Local variables
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String orgDBName = null;
		
		if(connect != null){
			try {
				//Fetches the organization name for specified org_id
				statement = connect.prepareStatement("SELECT org_db_name "
						+ "FROM org_record WHERE org_id=" + argOrgId);
				resultSet = statement.executeQuery();
				resultSet.next();
				orgDBName = resultSet.getString("org_db_name");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					resultSet.close();
					statement.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return orgDBName;
	
	}
	
	/**
	 * @param argOrgId organization id
	 */
	public static ArrayList<EmployeeWishHolder> getEmpIDForLocation(String argOrgDbName, int argLocationID) {
		Connection connect = DatabaseConnection.getConnection(argOrgDbName);
		//Local variables 
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Calendar todaysDate = null;
		Calendar birthdayDate = null;
		Calendar anniversaryDate = null;
		//This ArrayList is for holding employee details for wishing
		ArrayList<EmployeeWishHolder> employeeWishHolder = new ArrayList<>();
		if (connect != null) {
			try {
				//Fetches employee_id, birthday and work_anniversary for specified location
				statement1 = connect
						.prepareStatement("SELECT employee_id, birthday, work_anniversary "
								+ "FROM employee_details WHERE location_id="
								+ argLocationID);
				resultSet1 = statement1.executeQuery();
				//Fetches the location_timezone for the specified location for getting current date of location
				statement2 = connect
						.prepareStatement("SELECT location_timezone "
								+ "FROM location_details WHERE location_id="
								+ argLocationID);
				resultSet2 = statement2.executeQuery();
				resultSet2.next();
				todaysDate = CurrentTimeFetcher.getCurrentTime(resultSet2
						.getString("location_timezone"));
				//Add employee information to ArrayList that is to be sent
				while (resultSet1.next()) {
					//Converting SQL Date to Calendar object
					birthdayDate = CurrentTimeFetcher.DateToCalendar(resultSet1
							.getDate("birthday"));
					//Comparing birthday with the current date of location
					if (ComparingDateAndTime.dateComparison(todaysDate,
							birthdayDate)) {
						employeeWishHolder.add(new EmployeeWishHolder(
								resultSet1.getString("employee_id"), 1,
								argLocationID));
					}
					//Converting SQL Date to Calendar object
					anniversaryDate = CurrentTimeFetcher
							.DateToCalendar(resultSet1
									.getDate("work_anniversary"));
					//Comparing anniversary date with the current date of location
					if (ComparingDateAndTime.dateComparison(todaysDate,
							anniversaryDate)) {
						employeeWishHolder.add(new EmployeeWishHolder(
								resultSet1.getString("employee_id"), 2,
								argLocationID));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement1.close();
					statement2.close();
					resultSet1.close();
					resultSet2.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return employeeWishHolder;
	}
	
	/**
	 * @param argOrgId organization id
	 */
	public static ArrayList<LocationZoneHolder> getAllOrgLocationsList(String argOrgDbName){   
		ArrayList<LocationZoneHolder> allOrgLocationsList = new ArrayList<>();
		Connection connect = DatabaseConnection.getConnection(argOrgDbName);
		PreparedStatement statement = null;
		ResultSet result = null;
		
		if (connect != null) {
			try {
				statement = connect
						.prepareStatement("SELECT location_id, location_timezone FROM location_details");
				result = statement.executeQuery();
				while (result.next()) {
					allOrgLocationsList.add(new LocationZoneHolder(result
							.getInt("location_id"), result
							.getString("location_timezone")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					result.close();
					statement.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		else {
			try {
				throw new NullConnectionException();
			} catch (NullConnectionException e) {
				e.printStackTrace();
			}
		}
		return allOrgLocationsList;
	}
	
	
	/*
	 * It is used to get employee name and email ID
	 */
	public static MailInformationHolder getEmployeeNameAndEmailID(MailInformationHolder mailDetails,String emp_id, Connection argConn) throws SQLException
	{
		Statement stmt = argConn.createStatement();
		//fetching employee name and email ID
		String sql = "SELECT first_name,email_id FROM employee_details where employee_id='"+emp_id+"'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			String first_name = rs.getString("first_name");
			mailDetails.setEmployeeName(first_name);
			String emailID = rs.getString("email_id");
			mailDetails.setEmployeeEmailID(emailID);
		}
		return mailDetails;
	}
	
	
	/*
	 * It is used to get message for mail
	 */
	public static MailInformationHolder getMessage(MailInformationHolder mailDetails, int wish_type,Connection argConn) throws SQLException
	{
		Statement stmt5 = argConn.createStatement();
		String sql5="";
		ResultSet rs5;
		
		if(wish_type == 1)
		{
		//selecting random birthday message from messages_birthday database 
		sql5 = "SELECT message_text FROM messages_birthday ORDER BY RAND() LIMIT 1";
		mailDetails.setSubject("Hey! Happy Birthday to you");
		}
		else if(wish_type == 2)
		{
			//selecting random work anniversary message from messages_anniversary database 
			sql5 = "SELECT message_text FROM messages_anniversary ORDER BY RAND() LIMIT 1";
			mailDetails.setSubject("Hey! Happy work anniversary ... ");
		}
		rs5 = stmt5.executeQuery(sql5);
		while(rs5.next())
		{
			mailDetails.setMessage(rs5.getString("message_text"));
		}
		return mailDetails;
	}
	
	
	/*
	 * It is used to fetch CC for mail
	 */
	public static MailInformationHolder getCC(MailInformationHolder mailDetails, int wish_type, String emp_id, Connection argConn) throws SQLException
	{
		Statement stmt2 = argConn.createStatement();
		ArrayList<String> listOfTeamEmployeeID = new ArrayList<String>();
		//fetching team ID of employee
		String sql2 = "SELECT team_id FROM team_members where employee_id='"+emp_id+"'";
		ResultSet rs2 = stmt2.executeQuery(sql2);
		while(rs2.next())
		{
			int team_id = rs2.getInt("team_id");
			Statement stmt3 = argConn.createStatement();
			//fetching employee ID of team members
			String sql3 = "SELECT employee_id FROM team_members where team_id="+team_id+" AND NOT employee_id='"+emp_id+"'";
			ResultSet rs3 = stmt3.executeQuery(sql3);
			
			while(rs3.next())
			{
				String employeeID = rs3.getString("employee_id");
				Statement stmt4 = argConn.createStatement();
				//fetching name and email ID of team members
				String sql4 = "SELECT email_id FROM employee_details"
						+ " where employee_id='"+employeeID+"'";
				ResultSet rs4 = stmt4.executeQuery(sql4);
				while(rs4.next())
				{
					listOfTeamEmployeeID.add(rs4.getString("email_id"));
				}
			}
		}
		mailDetails.setListOfTeamEmployeeID(listOfTeamEmployeeID);
		return mailDetails;
	}
	
	
	/*
	 * It is used to delete entries from mailing list
	 */
	public static void deleteEntriesFromMailingList(String emp_id, Connection argConn) throws SQLException
	{
		//deleting entries of employees to whom mail is send from mailing list
		String query = "delete from mailling_list where employee_id = ?";
		PreparedStatement preparedStmt = argConn.prepareStatement(query);
		preparedStmt.setString(1, emp_id);
		// execute the preparedstatement
		preparedStmt.execute();
	}
}
