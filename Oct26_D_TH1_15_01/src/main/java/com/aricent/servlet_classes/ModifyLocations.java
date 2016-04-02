/***********************************************************************
                         Aricent Technologies Proprietary


This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: ModifyLocations.java
	  Principal Author      	: Siddharth Jain gur43189
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43189
	  Description           	: This file contains ModifyLocations Servlet


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
import com.aricent.database_queries.MailingSystemQueries;

/**
 * Servlet implementation class ValidateSession
 */
public class ModifyLocations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyLocations() {
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
		PrintWriter pw = response.getWriter();
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String timezone = request.getParameter("timezone");
		String orgDbName = null;
		String employeeId = null;
		int locationId = -1;

		HttpSession session = request.getSession(false);
		orgDbName = MailingSystemQueries.getOrgDBName((int)session.getAttribute("orgId"));
		employeeId = (String)session.getAttribute("employeeId");

		int countryId = LocationManageQueries.getCountryId(orgDbName,country);
		int cityId = LocationManageQueries.getCityId(orgDbName,city);
		int addressId = LocationManageQueries.getAddressId(orgDbName,address);

		if(countryId != -1 && cityId != -1 && addressId != -1  ){		//Check if location already exists
			pw.print("Location: "+country+" "+city+" "+address+" already exists");
		}else{
			if(countryId == -1){		//if country name does not exist in database
				LocationManageQueries.setCountry(orgDbName,country);
				countryId = LocationManageQueries.getCountryId(orgDbName,country);	//get new country id
			}
			if(cityId == -1){			//if city name does not exist in database
				LocationManageQueries.setCity(orgDbName,city); 
				cityId = LocationManageQueries.getCityId(orgDbName,city);	//get new country id
			}
			if(addressId == -1){		//if address name does not exist in database
				LocationManageQueries.setAddress(orgDbName,address); 
				addressId = LocationManageQueries.getAddressId(orgDbName,address);	//get new country id
			}
			LocationManageQueries.setLocation(orgDbName, countryId, cityId, addressId, timezone);
			locationId = LocationManageQueries.getLocation(orgDbName, countryId, cityId, addressId);
			//add locationId,employeeId to organizer_access table
			LocationManageQueries.setOrganizerAccess(orgDbName, employeeId, locationId);
			//add locationId to array in session
			@SuppressWarnings("unchecked")
			ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("locations");
			list.add(locationId);
			session.setAttribute("locations", list);

			pw.print("Location: "+country+" "+city+" "+address+" has been added");
		}
	}

}
