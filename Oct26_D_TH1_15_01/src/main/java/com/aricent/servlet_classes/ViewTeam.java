package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.database_queries.AddTeamQueries;
import com.aricent.database_queries.ViewTeamQueries;
import com.aricent.exception_classes.InvalidSessionException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.pojo_classes.TeamPojo;

/**
 * Servlet implementation class OrganizationRegistration
 */
public class ViewTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewTeam() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int orgID = (int) request.getSession(false).getAttribute("orgId");
		AddTeamQueries addTeamQueries = new AddTeamQueries();
		try {
			String orgDbName = addTeamQueries.getOrgDbName(orgID);
			ViewTeamQueries vQueries = new ViewTeamQueries();
			ArrayList<TeamPojo> teams = vQueries.getTeams(orgDbName);
			Iterator<TeamPojo> iterator = teams.iterator();
			String xmlString = "<TEAMS>";
			while (iterator.hasNext()) {
				TeamPojo team = (TeamPojo) iterator.next();
				xmlString += "<TEAM>"
						+ "<TEAM_ID>"+team.getTeamId()+"</TEAM_ID>"
						+ "<TEAM_DESC>"+team.getTeamDescription()+"</TEAM_DESC>"
						+ "</TEAM>";
			}
			xmlString += "</TEAMS>";
			response.getWriter().println(xmlString);
		} catch (NullConnectionException | SQLException | InvalidSessionException e) {
			e.printStackTrace();
		}
	}

}