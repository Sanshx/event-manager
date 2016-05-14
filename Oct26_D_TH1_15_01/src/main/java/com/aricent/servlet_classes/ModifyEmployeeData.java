package com.aricent.servlet_classes;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.EmployeeManagementQueries;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

/**
 * Servlet implementation class ModifyEmployeeData
 */
public class ModifyEmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEmployeeData() {
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
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MM-dd");
	
		//'Add' for addition, 'Update' for updation
		String option = request.getParameter("option");
		PrintWriter out = response.getWriter();
		int orgId = (int) request.getSession(false).getAttribute("orgId");
		
		String employeeId = request.getParameter("empId");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		Date birthday = null;
		Date workAnni = null;
		try {
			birthday = dateFormatLocal.parse(request.getParameter("bday"));
			workAnni = dateFormatLocal.parse(request.getParameter("wa"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int locationId = Integer.parseInt(request.getParameter("locId"));
		String email_id = request.getParameter("email");
		String contact = request.getParameter("contact");
		
		
		EmployeeDetailsHolder employee = new EmployeeDetailsHolder();
		employee.setEmpID(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmpBirthDate(birthday);
		employee.setEmpAnniversaryDate(workAnni);
		employee.setContact(contact);
		employee.setEmail(email_id);
		employee.setLocationID(locationId);
		
		if(option.equals("Add")){
			if(EmployeeManagementQueries.employeeAddition(employee, orgId)){
				out.print("Employee Added");
			}
			else{
				out.print("Error! Employee not added");
			}
		}
		else if(option.equals("Update")){
			if(EmployeeManagementQueries.employeeUpdation(employee, orgId)){
				out.print("Employee data updated");
			}
			else{
				out.print("Error! Employee data not updated");
			}
		}
	}

}
