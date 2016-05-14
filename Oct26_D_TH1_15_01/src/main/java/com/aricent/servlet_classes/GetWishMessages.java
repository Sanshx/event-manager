package com.aricent.servlet_classes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.MessageManageQueries;
import com.aricent.pojo_classes.MessageDetailsHolder;

/**
 * Servlet implementation class ValidateSession
 */
public class GetWishMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWishMessages() {
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
		int orgId = (int) request.getSession(false).getAttribute("orgId");
		String xml = "";
		
		//Get message list
		ArrayList<MessageDetailsHolder> messageList = MessageManageQueries.getMessageList(messageType, orgId);
		
		if(messageList.size() > 0){
			xml = xml.concat("<MESSAGES>");
			for (MessageDetailsHolder message : messageList) {
				xml = xml.concat("<MESSAGE><ID>"+message.getMessage_id()+"</ID><TEXT>"+message.getMessage()+"</TEXT></MESSAGE>");
			}
			xml = xml.concat("</MESSAGES>");
		}
		
		response.getWriter().print(xml);
	}
	
	

}
