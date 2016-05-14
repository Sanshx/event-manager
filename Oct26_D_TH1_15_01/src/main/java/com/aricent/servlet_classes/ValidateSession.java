package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateSession
 */
public class ValidateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateSession() {
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
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		try{
			if(session == null){
				out.print("false");
			}
			else{
				int userTypeId = (int) session.getAttribute("userTypeId");		
				if(userTypeId == 1){
					out.print("superAdmin");
				}else if(userTypeId == 2){
					out.print("subAdmin");
				}
			}
		}catch(NullPointerException e){
			out.print("false");
		}
	}



}
