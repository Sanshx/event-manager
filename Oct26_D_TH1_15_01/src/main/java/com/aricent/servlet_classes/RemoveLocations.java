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
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aricent.database_queries.LocationManageQueries;

/**
 * Servlet implementation class ValidateSession
 */
public class RemoveLocations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLocations() {
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
		String locationId = request.getParameter("locationId");
		int locationIdInt = Integer.parseInt(locationId);
		HttpSession sess = request.getSession(false);
		int orgId = (int) sess.getAttribute("orgId");
		PrintWriter out = response.getWriter();
		
		boolean found = LocationManageQueries.checkLocationForEmp(orgId, locationIdInt);
		if(found){
			out.print("Employee exists: Location can't be deleted");
		}
		else{
			boolean deleted = LocationManageQueries.removeLocation(orgId, locationIdInt);
			if(deleted){
				out.print("Location deleted ");
				@SuppressWarnings("unchecked")
				ArrayList<Integer> locationAccess = (ArrayList<Integer>) sess.getAttribute("locations");
				locationAccess.remove(locationId);
				sess.setAttribute("locations", locationAccess);
			}
			else{
				out.print("Error! Location can't be deleted");
			}
		}

	}



}
