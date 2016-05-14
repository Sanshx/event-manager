
package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.AddEmployeeToTeamQueries;
import com.aricent.database_queries.AddTeamQueries;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.EmpBday;

/**
 * Servlet implementation class AddEmployeeToTeam
 */
public class AddEmployeeToTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeToTeam() {
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
		String teamIdString = request.getParameter("teamID");
		String employeeId = request.getParameter("empId");
		int teamID = Integer.parseInt(teamIdString);
		int orgID = (int) request.getSession(false).getAttribute("orgId");
		AddTeamQueries addTeamQueries = new AddTeamQueries();
		try {
			String orgDbName = addTeamQueries.getOrgDbName(orgID);
			int result = new AddEmployeeToTeamQueries().addEmployeeToTeam(teamID, employeeId, orgDbName);
			String xmlString = "<EMPLOYEES>";
			if (result == 1) {
				EmpBday employee = new AddEmployeeToTeamQueries().getEmployee(employeeId, orgDbName);
				xmlString += "<EMPLOYEE>"
						+ "<EMP_ID>"+employee.getEmpID()+"</EMP_ID>"
						+ "<FIRST_NAME>"+employee.getFirstName()+"</FIRST_NAME>"
						+ "<LAST_NAME>"+employee.getLastName()+"</LAST_NAME>"
						+ "</EMPLOYEE>";
			}
			xmlString += "</EMPLOYEES>";
			PrintWriter out = response.getWriter();
			out.println(xmlString);
		} catch (NullConnectionException | SQLException | InvalidSessionException e) {
			e.printStackTrace();
		}
	}

}