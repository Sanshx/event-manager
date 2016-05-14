package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gur43131
 *
 */
public class OfficeAddress {

	/**@param argConn connection to database
	 * @param argLocationId id of location
	 * @return database name list
	 */
	public static String getOfficeAddress(Connection argConn,int argLocationId)
	{
		String address="";
		try
		{
			PreparedStatement statement2 = argConn.prepareStatement("SELECT office_id,city_id,country_id FROM location_details WHERE location_id=" + argLocationId);
			ResultSet resultSet2 = statement2.executeQuery();
			while(resultSet2.next())
			{
				PreparedStatement statement3 = argConn.prepareStatement("SELECT office_address FROM office_details WHERE office_id=" + resultSet2.getInt("office_id"));
				ResultSet resultSet3 = statement3.executeQuery();
				resultSet3.next();
				
				address+=resultSet3.getString("office_address");
				PreparedStatement statement4 = argConn.prepareStatement("SELECT city_name FROM city_details WHERE city_id=" + resultSet2.getInt("city_id"));
				ResultSet resultSet4 = statement4.executeQuery();
				resultSet4.next();
				address+=" "+ resultSet4.getString("city_name");
				
				PreparedStatement statement5 = argConn.prepareStatement("SELECT country_name FROM country_details WHERE country_id=" + resultSet2.getInt("country_id"));
				ResultSet resultSet5 = statement5.executeQuery();
				resultSet5.next();
				address+=" "+resultSet5.getString("country_name");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return address;
	}
	
}
