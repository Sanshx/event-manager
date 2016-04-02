/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: ValidateSession.java
	  Principal Author      	: Siddharth Jain gur43189
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43189
	  Description           	: This file contains ValidateSession Servlet


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
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
