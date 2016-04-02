/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: ViewMembers.java
	  Principal Author      	: Gaurav Kumar
	  Subsystem Name        	:
	  Module Name           	: Employee Details Manager
	  Date of First Release 	: Jan 5, 2016
	  Author					: Gaurav Kumar
	  Description           	: This file contains ViewMembers Servlet


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/

package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.AddTeamQueries;
import com.aricent.database_queries.ViewMemberQueries;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.EmpBday;

/**
 * Servlet implementation class OrganizationRegistration
 */
public class ViewMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMembers() {
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
		String id = request.getParameter("id");
		int teamID = Integer.parseInt(id);
		int orgID = (int) request.getSession(false).getAttribute("orgId");
		AddTeamQueries addTeamQueries = new AddTeamQueries();
		try {
			String orgDbName = addTeamQueries.getOrgDbName(orgID);
			ViewMemberQueries mQueries = new ViewMemberQueries();
			ArrayList<EmpBday> employees = mQueries.getMembers(teamID, orgDbName);
			Iterator<EmpBday> iterator = employees.iterator();
			String xmlString = "<EMPLOYEES>";
			while (iterator.hasNext()) {
				EmpBday employee = (EmpBday) iterator.next();
				xmlString += "<EMPLOYEE>"
						+ "<EMP_ID>"+employee.getEmpID()+"</EMP_ID>"
						+ "<FIRST_NAME>"+employee.getFirstName()+"</FIRST_NAME>"
						+ "<LAST_NAME>"+employee.getLastName()+"</LAST_NAME>"
						+ "</EMPLOYEE>";
			}
			xmlString += "</EMPLOYEES>";
			response.getWriter().println(xmlString);

		} catch (NullConnectionException | SQLException | InvalidSessionException e) {
			e.printStackTrace();
		}
	}

}