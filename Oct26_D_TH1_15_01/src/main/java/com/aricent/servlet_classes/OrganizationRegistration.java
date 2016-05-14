
package com.aricent.servlet_classes;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.aricent.database_queries.OrganizationRegistrationQueries;
import com.aricent.database_queries.SuperAdminRegistrationQueries;
import com.aricent.exception_classes.DBCreationFailureException;
import com.aricent.exception_classes.NullConnectionException;
import com.aricent.exception_classes.RegisterOrgErrorException;
import com.aricent.java_classes.CreateOrgDb;
import com.aricent.java_classes.MailController;
import com.aricent.pojo_classes.LocationPojo;
import com.aricent.pojo_classes.MailInformationHolder;
import com.aricent.pojo_classes.OrganizationPojo;
import com.aricent.pojo_classes.EmployeeDetailsHolder;

/**
 * Servlet implementation class OrganizationRegistration
 */
public class OrganizationRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrganizationRegistration() {
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
		RequestDispatcher requestDispatcher;
		try {
			// Taking data from Registration.html
			String orgName = request.getParameter("comp_name");
			String orgDescription = request.getParameter("comp_desc");
			String orgDateString = request.getParameter("comp_bday");
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date orgAnniversaryDate = format.parse(orgDateString);
			String orgRecoveryMail = request.getParameter("comp_mail");

			String empID = request.getParameter("adm_id");
			String firstName = request.getParameter("adm_fname");
			String lastName = request.getParameter("adm_lname");
			Date empBirthDate = format.parse(request.getParameter("adm_bday"));
			Date empAnniversaryDate = format.parse(request
					.getParameter("adm_wannv"));
			String empCountry = request.getParameter("adm_country");
			String empCity = request.getParameter("adm_city");
			String empOffice = request.getParameter("adm_add");
			String adm_timezone = request.getParameter("adm_timezone");
			if (!adm_timezone.startsWith("-")) {
				adm_timezone = "+" + adm_timezone;
			}
			String timezoneString = "GMT" + adm_timezone + ":00";
			String empEmail = request.getParameter("adm_mail");
			String empContact = request.getParameter("adm_tel");
			String empPasswordString = BCrypt.hashpw(
					request.getParameter("adm_pass"), BCrypt.gensalt());
			
			// check if company is already registered
			OrganizationRegistrationQueries oQueries = new OrganizationRegistrationQueries();
			String dbNameString = oQueries.getOrgDBNameFromDatabase(orgName);
			if (dbNameString != null) {
				request.setAttribute("message", "Company is already registered");
				requestDispatcher = request.getRequestDispatcher("Error.jsp");
				requestDispatcher.forward(request, response);
			}

			// company is not registered
			else {
				// creating organization's database and tables
				OrganizationPojo organization = this.createOrgPojo(orgName,
						orgDescription, orgAnniversaryDate, orgRecoveryMail);
				String orgDBName = oQueries.registerOrg(organization);
				CreateOrgDb createDB = new CreateOrgDb();
				createDB.createDataBase(orgDBName);
				createDB.createTables(orgDBName);
				orgName = organization.getOrgName();
				
				// registering super admin
				SuperAdminRegistrationQueries sQueries = new SuperAdminRegistrationQueries();
				short countryId = sQueries.insertCountry(empCountry, orgName);
				short cityID = sQueries.insertCity(empCity, orgName);
				int officeID = sQueries.insertOffice(empOffice, orgName);
				LocationPojo location = this.createLocationPojo(countryId,
						cityID, officeID, timezoneString);
				int locationID = sQueries.insertLocation(location, orgName);
				short userTypeID = (short) 1;
				EmployeeDetailsHolder superadmin = this.createSuperAdminPojo(empID,
						firstName, lastName, empBirthDate, empAnniversaryDate,
						locationID, userTypeID, empEmail, 
						empContact);
				sQueries.insertSuperAdmin(superadmin, orgName);
				sQueries.insertOrganizerLogin(empID, empPasswordString, orgName);
				int locationAccess = locationID;
				sQueries.insertOrganizerAccess(empID, locationAccess, orgName);
				
				//sending mail
				int orgID = this.getOrgID(orgDBName);
				MailInformationHolder superAdminMailInformationHolder = new MailInformationHolder();
				superAdminMailInformationHolder.setEmployeeEmailID(empEmail);
				superAdminMailInformationHolder.setEmployeeName(firstName + "" + lastName);
				superAdminMailInformationHolder.setListOfTeamEmployeeID(new ArrayList<String>());
				superAdminMailInformationHolder.setSubject("Registration success");
				String messageString = "Registration of "+ orgName +"is successful\n "
						+ "Your company id is "+orgID
						+". Please use your employee id for login purposes.\n"
						+ "Thanks\n"
						+ "Team: In-House EVENT MANAGEMENT SYSTEM";
				superAdminMailInformationHolder.setMessage(messageString);
				MailController.mailController(superAdminMailInformationHolder);
				
				String success = "Your company ID is " + orgID
						+ " and mail has been sent to "
						+ organization.getOrgRecoveryMail();
				request.setAttribute("message", success);
				requestDispatcher = request.getRequestDispatcher("Success.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (ParseException | SQLException | NullConnectionException
				| DBCreationFailureException e) {
			e.printStackTrace();
			request.setAttribute("message", "Some internal error");
			requestDispatcher = request.getRequestDispatcher("Error.jsp");
			requestDispatcher.forward(request, response);
		} catch (RegisterOrgErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**This method gives organization id with given organization database name
	 * @param orgDBName name of organization database name
	 * @return organization id
	 */
	public int getOrgID(String orgDBName) {
		String[] dbNames = orgDBName.split("_");
		int orgID = Integer.parseInt(dbNames[dbNames.length - 1]);
		return orgID;
	}

	/**This method gives organization pojo with organization details
	 * @param orgRecoveryMail
	 * @param orgAnniversaryDate
	 * @param orgDescription
	 * @param orgName
	 * @return object of organization pojo
	 * 
	 */
	public OrganizationPojo createOrgPojo(String orgName,
			String orgDescription, Date orgAnniversaryDate,
			String orgRecoveryMail) {
		OrganizationPojo org = new OrganizationPojo();
		org.setOrgName(orgName);
		org.setOrgDesc(orgDescription);
		org.setOrgAnniversaryDate(orgAnniversaryDate);
		org.setOrgRecoveryMail(orgRecoveryMail);
		return org;
	}

	/**This method gives location pojo with location details
	 * @param countryId
	 * @param cityID
	 * @param officeID
	 * @param timezoneString
	 * @return object of location pojo
	 */
	public LocationPojo createLocationPojo(short countryId, short cityID,
			int officeID, String timezoneString) {
		LocationPojo location = new LocationPojo();
		location.setCountryID(countryId);
		location.setCityID(cityID);
		location.setOfficeID(officeID);
		location.setTimezone(timezoneString);
		return location;
	}

	/**This method gives employee pojo with employee details
	 * @param empContact
	 * @param departmentID
	 * @param empEmail
	 * @param s
	 * @param locationID
	 * @param empAnniversaryDate
	 * @param empBirthDate
	 * @param lastName
	 * @param firstName
	 * @param empID
	 * @return object of employee pojo
	 */
	public EmployeeDetailsHolder createSuperAdminPojo(String empID, String firstName,
			String lastName, Date empBirthDate, Date empAnniversaryDate,
			int locationID, short userType, String empEmail,String empContact) {
		EmployeeDetailsHolder superadmin = new EmployeeDetailsHolder();
		superadmin.setEmpID(empID);
		superadmin.setFirstName(firstName);
		superadmin.setLastName(lastName);
		superadmin.setEmpBirthDate(empBirthDate);
		superadmin.setEmpAnniversaryDate(empAnniversaryDate);
		superadmin.setLocationID(locationID);
		superadmin.setUserTypeID(userType);
		superadmin.setEmail(empEmail);
		superadmin.setContact(empContact);
		return superadmin;
	}
}