/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: LoginServlet.java
	  Principal Author      	: Siddharth Jain gur43189
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43189
	  Description           	:


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.servlet_classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_queries.EmployeeManagementQueries;
import com.aricent.pojo_classes.LocationAddress;

/**
 * Servlet implementation class ValidateSession
 */
public class GetLocations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocations() {
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
		
		String locations = "";
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(false);
		Integer orgId = (Integer) sess.getAttribute("orgId");
		
		ArrayList<LocationAddress> allLocations = EmployeeManagementQueries.listOfAddresses(orgId, sess);
		
		for (LocationAddress locationAddress : allLocations) {
			locations += "<option value='"+locationAddress.getLocationId()+"'>"+locationAddress.getOfficeAddress()+"</option>\n";
		}
		
		out.print(locations);
		
	}

}
