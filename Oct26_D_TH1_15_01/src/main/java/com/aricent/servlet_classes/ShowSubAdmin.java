package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.database_queries.OfficeAddress;

/**
 * Servlet implementation class ValidateSession
 */
public class ShowSubAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSubAdmin() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//getting session data
				HttpSession session = request.getSession(false);
				String orgDBName = MailingSystemQueries.getOrgDBName((int)session.getAttribute("orgId"));
				
				
				
				PreparedStatement statement = null;
				ResultSet resultSet = null;
				String xmlString = "<EMPLOYEES>";
				
				try
				{
				Connection conn = DatabaseConnection.getConnection(orgDBName);
				statement = conn.prepareStatement("SELECT employee_id,first_name,last_name FROM employee_details WHERE user_type_id=" + 2);
				resultSet = statement.executeQuery();
				
				while(resultSet.next())
				{
					
					String empId = resultSet.getString("employee_id");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					
					PreparedStatement stmt = conn.prepareStatement("SELECT location_access FROM organizer_access WHERE employee_id='"+empId+"'");
					ResultSet rs = stmt.executeQuery();
					while(rs.next())
					{
						xmlString += "<EMPLOYEE>";
						xmlString += "<EMP_ID>" + empId + "</EMP_ID>" + "<FIRST_NAME>" + firstName
								+ "</FIRST_NAME>" + "<LAST_NAME>" + lastName + "</LAST_NAME>";
					String address = OfficeAddress.getOfficeAddress(conn, rs.getInt("location_access"));
					xmlString += "<ADDRESS>" + address + "</ADDRESS>" + "<LOCATION_ACCESS>" +
					rs.getInt("location_access") + "</LOCATION_ACCESS></EMPLOYEE>";
					
					}
				}
				xmlString += "</EMPLOYEES>";
				
				
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				response.getWriter().println(xmlString);
		
		}

}
