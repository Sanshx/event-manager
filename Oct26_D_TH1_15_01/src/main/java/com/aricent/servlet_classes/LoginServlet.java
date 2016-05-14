package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_queries.LoginSystemQueries;


/**
 * Servlet implementation class LoginServlet
 */
/**
 * @author gur43189
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public LoginServlet() {
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
		String password = null;
		String orgDbName = null;
		String employeeId = null;
		int orgId = -1;
		int userTypeId = -1;

		orgId = Integer.parseInt(request.getParameter("orgId"));
		employeeId = request.getParameter("userId");
		password = request.getParameter("password");

		orgDbName = LoginSystemQueries.getOrgDbName(orgId);
		PrintWriter out = response.getWriter();
		if(orgDbName != null){

			if(LoginSystemQueries.checkCredentials(orgDbName,employeeId,password)){
				HttpSession session = request.getSession(true);
	            session.setAttribute("employeeId", employeeId);
	            session.setAttribute("orgId", orgId);
	            session = LoginSystemQueries.fillSession(session);
	            
				userTypeId = LoginSystemQueries.getUserTypeId(orgDbName,employeeId);
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				response.setDateHeader("Expires", 0);
				if(userTypeId == 1){	
					out.print("superadmin");
				}else if(userTypeId == 2){						
					out.print("subadmin");
				}
			}else{
				out.print("Wrong credentials");
			}
		}else{		
			out.print("Organization not registered"); 
		}
	}
	
	

}
