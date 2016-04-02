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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.MessageManageQueries;

/**
 * Servlet implementation class ValidateSession
 */
public class DeleteWishMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWishMessages() {
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
		String messageType = request.getParameter("messageType");
		String messageId = request.getParameter("id");
		Integer messageIdInt = Integer.parseInt(messageId); 
		int orgId = (int) request.getSession(false).getAttribute("orgId");
		
		response.getWriter().print(MessageManageQueries.deleteMessages(messageType, orgId, messageIdInt));
	}

}
