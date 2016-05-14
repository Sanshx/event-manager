package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aricent.database_connection.DatabaseConnection;

/**
 * @author gur43194
 *
 */
public class LocationManageQueries {


	/**
	 * @param argOrgDbName organization database name
	 * @param argCountry country name
	 * @return Null if no employee is present, else return it's data
	 */
	public static int getCountryId(String argOrgDbName,String argCountry) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int countryId = -1;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("SELECT country_id FROM country_details where country_name=?");
			ps.setString(1,argCountry);
			rs = ps.executeQuery();
			if(rs.next()){			
				countryId = rs.getInt("country_id");
			}

		} catch (SQLException e) {

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countryId;
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argCity city name
	 * @return Null if no employee is present, else return it's data
	 */
	public static int getCityId(String argOrgDbName,String argCity) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cityId = -1;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("SELECT city_id FROM city_details where city_name=?");
			ps.setString(1,argCity);
			rs = ps.executeQuery();
			if(rs.next()){			
				cityId = rs.getInt("city_id");
			}

		} catch (SQLException e) {

		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cityId;
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argAddress address name
	 * @return address id
	 */
	public static int getAddressId(String argOrgDbName,String argAddress) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int addressId = -1;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("SELECT office_id FROM office_details where office_address=?");
			ps.setString(1,argAddress);
			rs = ps.executeQuery();
			if(rs.next()){			
				addressId = rs.getInt("office_id");
			}
		} catch (SQLException e) {
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return addressId;
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argCountry country name
	 */
	public static void setCountry(String argOrgDbName,String argCountry) {
		PreparedStatement ps = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("insert into country_details(country_name) values(?)");
			ps.setString(1,argCountry);
			ps.executeUpdate();

		} catch (SQLException e) {
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argCity city name
	 */
	public static void setCity(String argOrgDbName,String argCity) {
		PreparedStatement ps = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("insert into city_details(city_name) values(?)");
			ps.setString(1,argCity);
			ps.executeUpdate();

		} catch (SQLException e) {
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argAddress address
	 */
	public static void setAddress(String argOrgDbName,String argAddress) {
		PreparedStatement ps = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);
		try {
			ps = con.prepareStatement("insert into office_details(office_address) values(?)");
			ps.setString(1,argAddress);
			ps.executeUpdate();
		} catch (SQLException e) {
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argCountryId country id
	 * @param argCityId city id
	 * @param argAddressId address id
	 * @param argTimezone timezone
	 */
	public static void setLocation(String argOrgDbName, int argCountryId,int argCityId,int argAddressId,String argTimezone) {
		PreparedStatement ps = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("insert into location_details(country_id,city_id,office_id,location_timezone) values(?,?,?,?)");
			ps.setInt(1, argCountryId);
			ps.setInt(2, argCityId);
			ps.setInt(3, argAddressId);
			ps.setString(4,argTimezone);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			try {

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	/**
	 * @param argOrgDbName organization database name
	 * @param argCountryId country id
	 * @param argCityId city id
	 * @param argAddressId address id
	 * @return location id
	 */
	public static int getLocation(String argOrgDbName, int argCountryId, int argCityId,int argAddressId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int locationId = -1;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("SELECT location_id FROM location_details where country_id=? AND city_id=? AND office_id=?");
			ps.setInt(1, argCountryId);
			ps.setInt(2, argCityId);
			ps.setInt(3, argAddressId);
			rs = ps.executeQuery();
			if(rs.next()){			
				locationId = rs.getInt("location_id");
			}
		} catch (SQLException e) {
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return locationId;
	}

	/**
	 * @param argOrgDbName organization database name
	 * @param argEmployeeId employee id
	 * @param argLocationId location id
	 */
	public static void setOrganizerAccess(String argOrgDbName, String argEmployeeId,int argLocationId) {
		PreparedStatement ps = null;
		Connection con = DatabaseConnection.getConnection(argOrgDbName);

		try {
			ps = con.prepareStatement("insert into organizer_access(employee_id,location_access) values(?,?)");
			ps.setString(1, argEmployeeId);
			ps.setInt(2, argLocationId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean checkLocationForEmp(int argOrgId, int argLocationId){
		boolean found = false;
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connect.prepareStatement("SELECT employee_id FROM employee_details WHERE location_id=?");
			stmt.setInt(1, argLocationId);
			rs = stmt.executeQuery();
			while(rs.next()){
				found = true;
				break;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return found;
	}

	public static boolean removeLocation(int argOrgId, int argLocationId) {
		int rowsEffected = 0;
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		PreparedStatement deleteOffice = null;
		PreparedStatement deleteLocation = null;
		PreparedStatement deleteAccess = null;
		ResultSet rs = null;
		int officeId = 0;
		try{
			stmt = connect.prepareStatement("SELECT office_id FROM location_details WHERE location_id=?");
			stmt.setInt(1, argLocationId);
			rs = stmt.executeQuery();
			while(rs.next()){
				officeId = rs.getInt("office_id");
			}
			if(officeId == 0) return false;
			else{
				deleteAccess = connect.prepareStatement("DELETE FROM organizer_access WHERE location_access = ?");
				deleteAccess.setInt(1, argLocationId);
				deleteAccess.executeUpdate();
				deleteLocation = connect.prepareStatement("DELETE FROM location_details WHERE location_id = ?");
				deleteLocation.setInt(1, argLocationId);
				rowsEffected += deleteLocation.executeUpdate();
				deleteOffice = connect.prepareStatement("DELETE FROM office_details WHERE office_id = ?");
				deleteOffice.setInt(1, officeId);
				rowsEffected += deleteOffice.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rowsEffected == 2){
			return true;
		}else{
			return false;
		}
	}


	
}
