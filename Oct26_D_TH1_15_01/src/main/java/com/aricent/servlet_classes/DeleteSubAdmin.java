
package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.MailInformationHolder;

/**
 * Servlet implementation class OrganizationRegistration
 */
public class DeleteSubAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSubAdmin() {
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
		
		int success;
		//System.out.println(request.getParameter("empId"));
		
		//get previous session
				HttpSession session = request.getSession(false);
				
				
						
						String data = request.getParameter("empId");
						
						String dataa[] = data.split("&");
						String empId = dataa[0];
						int locationAccess = Integer.parseInt(dataa[1]);
						
					
						PreparedStatement statement = null;
						ResultSet resultSet = null;
						//connect to common database for fetching database name
						String orgDBName = MailingSystemQueries.getOrgDBName((int)session.getAttribute("orgId"));
						
						try
						{
							MailInformationHolder mailDetails = new MailInformationHolder();
						Connection conn=DatabaseConnection.getConnection(orgDBName);
						Statement stmt = conn.createStatement();
					      String sql = "DELETE FROM organizer_access " +
					                   "WHERE employee_id='"+empId+"' and location_access='"+locationAccess+"'";
					      stmt.executeUpdate(sql);
					      success = 1;
					      
					      //mailing details
					      
					    //get employee name and id
							MailInformationHolder mailDetails2 = MailingSystemQueries.getEmployeeNameAndEmailID(mailDetails, empId, conn);
							mailDetails2.setMessage("Your access to location " + locationAccess + " is removed");
					      
					      
					      
					      
					      statement = conn.prepareStatement("SELECT employee_id FROM organizer_access WHERE employee_id='"+empId+"'");
							resultSet = statement.executeQuery();
					      boolean valuePresent = resultSet.next();
					      if(valuePresent == false)
					      {
					    	  //if all the location access is removed of the employee the update user_type_id of employee to 3 again 
					    	  String updateTableSQL = "UPDATE employee_details SET user_type_id = ? WHERE employee_id = ?";
								PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
								preparedStatement.setInt(1, 3);
								preparedStatement.setString(2, empId);
								// execute update SQL statement
								preparedStatement .executeUpdate();
								//remove password from organizer_login tables also
								Statement stmt1 = conn.createStatement();
							      String sql1 = "DELETE FROM organizer_login " +
							                   "WHERE employee_id='"+empId+"'";
							      stmt1.executeUpdate(sql1);
					      }
					      mailDetails2.setSubject("Location Access removed");
					      mailDetails2.setListOfTeamEmployeeID(new ArrayList<String>());
					      DeleteSubAdmin.showDetails(mailDetails2);
					    //  response.sendRedirect("AddDeleteSubAdmin.jsp");
						}
						catch(SQLException e)
						{
							e.printStackTrace();
							success = 0;
						}
						
		response.getWriter().print(success);
	}
	
	public static void showDetails(MailInformationHolder mailDetails)
	{
		System.out.println("Mail to: " + mailDetails.getEmployeeName());
		System.out.println("Email ID: " + mailDetails.getEmployeeEmailID());
		System.out.println("Subject: "+mailDetails.getSubject());
		System.out.println("Message: " + mailDetails.getMessage());
	}
	

}