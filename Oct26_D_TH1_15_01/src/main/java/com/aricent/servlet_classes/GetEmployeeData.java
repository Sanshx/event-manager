package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_queries.EmployeeManagementQueries;
import com.aricent.java_classes.LocationAccessChecker;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

/**
 * Servlet implementation class ValidateSession
 */
public class GetEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeData() {
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
		
		//Take data
		String xml = "";
		String employeeId = request.getParameter("empId");
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(false);
		Integer orgId = (Integer) sess.getAttribute("orgId");
		String currentAdminId = (String) sess.getAttribute("employeeId");
		
		
		EmployeeDetailsHolder employee = EmployeeManagementQueries.findEmployeeDetails(employeeId, orgId);
		
		if(employee == null) out.print(xml);
		else {
			//Checking access
			String access = null;
			if(currentAdminId.equals(employee.getEmpID())){
				access = "UpdateAccess";
			}
			else {
				access = LocationAccessChecker.targetEmployeeAccess(sess, employee.getUserTypeID(), employee.getLocationID());
			}
			//making XML
			xml = "<EMPLOYEE>"
					+ "<EMP_ID>"+employee.getEmpID()+"</EMP_ID>"
					+ "<F_NAME>"+employee.getFirstName()+"</F_NAME>"
					+ "<L_NAME>"+employee.getLastName()+"</L_NAME>"
					+ "<BDAY>"+employee.getEmpBirthDate()+"</BDAY>"
					+ "<WA>"+employee.getEmpAnniversaryDate()+"</WA>"
					+ "<EMAIL>"+employee.getEmail()+"</EMAIL>"
					+ "<USER_TYPE>"+employee.getUserTypeID()+"</USER_TYPE>"
					+ "<CONTACT>"+employee.getContact()+"</CONTACT>"
					+ "<LOCATION>"+employee.getLocationID()+"</LOCATION>"
					+ "<DEPART_ID>"+employee.getDepartmentID()+"</DEPART_ID>"
					+ "<ACCESS>"+access+"</ACCESS>"
					+ "</EMPLOYEE>";
			out.print(xml);
		}
	}

}
