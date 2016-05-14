package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.AddTeamQueries;
import com.aricent.database_queries.DeleteEmployeeFromTeamQueries;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;

/**
 * Servlet implementation class OrganizationRegistration
 */
public class DeleteEmployeeFromTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployeeFromTeam() {
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
		String id = request.getParameter("teamID");
		String employeeId = request.getParameter("empId");
		int teamID = Integer.parseInt(id);
		int orgID = (int) request.getSession(false).getAttribute("orgId");
		AddTeamQueries addTeamQueries = new AddTeamQueries();
		try {
			String orgDbName = addTeamQueries.getOrgDbName(orgID);
			int result = new DeleteEmployeeFromTeamQueries().deleteEmployeeFromTeam(teamID, employeeId, orgDbName);
			PrintWriter out = response.getWriter();
			out.println(result);
		} catch (NullConnectionException | SQLException | InvalidSessionException e) {
			e.printStackTrace();
		}
	}

}