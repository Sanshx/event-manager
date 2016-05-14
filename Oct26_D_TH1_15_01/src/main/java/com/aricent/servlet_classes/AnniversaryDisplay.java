
package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.AddTeamQueries;
import com.aricent.database_queries.AnniversaryDisplayQueries;
import com.aricent.exception_classes.InvalidEntryException;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.EmpBday;


/**
 * Servlet implementation class AnniversaryDisplay
 */
public class AnniversaryDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnniversaryDisplay() {
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
		String monthString = request.getParameter("month");
		int month = Integer.parseInt(monthString);
		PrintWriter out = response.getWriter();

		if (month == -1) {
			out.print("Invalid month");
		}
		else {
			AnniversaryDisplayQueries aQueries = new AnniversaryDisplayQueries();
			int orgID = (int) request.getSession(false).getAttribute("orgId");
			try {
				String dbName = new AddTeamQueries().getOrgDbName(orgID);
				ArrayList<EmpBday> employees = aQueries.getBday(month, dbName, request.getSession(false));
				Iterator<EmpBday> iterator = employees.iterator();
				String xmlString = "<EMPLOYEES>";
				while (iterator.hasNext()) {
					EmpBday employee = (EmpBday) iterator.next();
					xmlString += "<EMPLOYEE>"
							+ "<EMP_ID>"+employee.getEmpID()+"</EMP_ID>"
							+ "<FIRST_NAME>"+employee.getFirstName()+"</FIRST_NAME>"
							+ "<LAST_NAME>"+employee.getLastName()+"</LAST_NAME>"
							+ "<ANNIVERSARY_DATE>"+employee.getDate()+"</ANNIVERSARY_DATE>"
							+ "<OFFICE_ADDRESS>"+employee.getOfficeAddress()+"</OFFICE_ADDRESS>"
							+ "</EMPLOYEE>";
				}
				xmlString += "</EMPLOYEES>";
				response.getWriter().println(xmlString);
			} catch (NullConnectionException | SQLException | InvalidEntryException | InvalidSessionException e) {
				e.printStackTrace();
			}
		}

	}

}