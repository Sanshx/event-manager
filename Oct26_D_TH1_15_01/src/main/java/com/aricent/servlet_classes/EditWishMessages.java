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
public class EditWishMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditWishMessages() {
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
		String messageText = request.getParameter("messageText");
		Integer messageIdInt = Integer.parseInt(messageId); 
		int orgId = (int) request.getSession(false).getAttribute("orgId");
		
		response.getWriter().print(MessageManageQueries.editMessages(messageType, orgId, messageIdInt, messageText));
	}

}
