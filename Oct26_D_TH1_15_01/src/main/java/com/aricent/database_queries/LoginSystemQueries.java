/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LoginSystemQueries.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 11, 2016
	  Author					: gur43194
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
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.aricent.database_connection.DatabaseConnection;

/**
 * @author gur43194
 *
 */
public class LoginSystemQueries {


	/**
	 * @param argOrgName
	 * @return
	 */
	public static String getOrgDbName(int argOrgId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String orgDbName = null;
		Connection con = DatabaseConnection.getConnection("ih_ems_common");
		
		try {
			ps = con.prepareStatement("SELECT org_db_name FROM org_record where org_id=?");
			ps.setInt(1,argOrgId);
			rs = ps.executeQuery();
			if(rs.next()){			
				orgDbName = rs.getString("org_db_name");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orgDbName;
	}

	/**
	 * @param argOrgDbName
	 * @param argEmployeeId
	 * @param argPassword
	 * @return
	 */

	public static Boolean checkCredentials(String argOrgDbName, String argEmployeeId,String argPassword){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);
		try {
			ps = con.prepareStatement("SELECT password FROM organizer_login where employee_id=?");
			ps.setString(1,argEmployeeId);
			rs = ps.executeQuery();
			if(rs.next()){			
				if (BCrypt.checkpw(argPassword, rs.getString("password"))) {
					con.close();
					return true;				
				}
				else{
					con.close();
				}
			}
		} catch (SQLException e) {	
			e.printStackTrace();
			System.out.println("Exception");		
			return false;			
		}
		return false;
	}
	
	/**
	 * @param argOrgDbName
	 * @param argEmployeeId
	 * @return
	 */
	public static int getUserTypeId(String argOrgDbName,String argEmployeeId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userTypeId = 0;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);
		try {
			ps = con.prepareStatement("SELECT user_type_id FROM employee_details where employee_id=?");
			ps.setString(1,argEmployeeId);
			rs = ps.executeQuery();
			if(rs.next()){			
				userTypeId = rs.getInt("user_type_id");
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userTypeId;
	}
	
	/**
	 * @param argSession session
	 * @return
	 */
	public static HttpSession fillSession(HttpSession argSession){
		String employeeId = (String) argSession.getAttribute("employeeId");
		String databaseName = getOrgDbName((Integer) argSession.getAttribute("orgId"));
		
		Connection connect = DatabaseConnection.getConnection(databaseName);
		ResultSet rs = null;
		ResultSet rsLoc = null;
		PreparedStatement stmt = null;
		PreparedStatement stmtlocation = null;
		
		try {
			stmt = connect.prepareStatement("SELECT * FROM employee_details WHERE employee_id='"+employeeId+"'");
			stmtlocation = connect.prepareStatement("SELECT * from organizer_access WHERE employee_id='"+employeeId+"'");
			
			rs = stmt.executeQuery();
			rs.next();
			//Setting data
			argSession.setAttribute("userTypeId", rs.getInt("user_type_id"));
			argSession.setAttribute("userName", rs.getString("first_name")+" "+rs.getString("last_name"));
			//Setting locationss
			rsLoc = stmtlocation.executeQuery();
			ArrayList<Integer> accessLocations = new ArrayList<>();
			while(rsLoc.next()){
				accessLocations.add(rsLoc.getInt("location_access"));
			}
			argSession.setAttribute("locations", accessLocations);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				rsLoc.close();
				stmt.close();
				stmtlocation.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return argSession;
	}

	
}
