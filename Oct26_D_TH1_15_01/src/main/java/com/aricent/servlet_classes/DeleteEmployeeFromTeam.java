/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: DeleteEmployeeFromTeam.java
	  Principal Author      	: Gaurav Kumar
	  Subsystem Name        	:
	  Module Name           	: Employee Details Manager
	  Date of First Release 	: Jan 12, 2016
	  Author					: Gaurav Kumar
	  Description           	: This file contains DeleteEmployeeFromTeam Servlet


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/

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