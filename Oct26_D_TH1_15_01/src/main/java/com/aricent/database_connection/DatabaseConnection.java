package com.aricent.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * @author gur43194
 * This class gives connection to given database name
 */
public class DatabaseConnection {
	

	/**This method gives connection to given database name
	 * 
	 * @param argDatabaseName name of database to which connection is to be made
	 * 
	 * @return connection to database
	 */
	public static Connection getConnection(String argDatabaseName){
		Connection connect = null;
		String host = "10.203.161.109";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+argDatabaseName,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("Exception occurred during database Connection" );
			e.printStackTrace();
		}  	
		return connect;
		
	}
	
}
