package com.aricent.database_queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aricent.database_connection.DatabaseConnection;
import com.aricent.pojo_classes.MessageDetailsHolder;

/**
 * @author gur43194
 *
 */
public class MessageManageQueries {

	/**
	 * @param argMessageTable message table
	 * @param argOrgId organization id
	 */
	public static ArrayList<MessageDetailsHolder> getMessageList(String argMessageTable, int argOrgId){
		ArrayList<MessageDetailsHolder> messageList = new ArrayList<>();
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		if(connect != null){
			try {
				stmt = connect.prepareStatement("SELECT * FROM "+argMessageTable);
				rs = stmt.executeQuery();
				while(rs.next()){
					MessageDetailsHolder message = new MessageDetailsHolder();
					message.setMessage(rs.getString("message_text"));
					message.setMessage_id(rs.getInt("message_id"));
					messageList.add(message);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					stmt.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return messageList;
	}
	
	/**
	 * @param argMessageType message type 
	 * @param argOrgId organization id
	 */
	public static String addWishMessages(String argMessageType, String argMessageText, int argOrgId){
		int rowsEffected = 0;
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		
		if(connect != null){
			try {
				stmt = connect.prepareStatement("INSERT INTO "+argMessageType+" (message_text) VALUES (?)");
				stmt.setString(1, argMessageText);
				rowsEffected = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					stmt.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(rowsEffected == 1){
			return "Insertion success";
		}
		else{
			return "Insertion failed";
		}
		
	}
	
	
	/**
	 * @param argMessageType message type 
	 * @param argOrgId organization id
	 * @param argMessageId message id
	 */
	public static String deleteMessages(String argMessageType, int argOrgId, int argMessageId){
		int rowsEffected = 0;
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		
		if(connect != null){
			try {
				stmt = connect.prepareStatement("DELETE FROM "+argMessageType+" WHERE message_id = ?");
				stmt.setInt(1, argMessageId);
				rowsEffected = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					stmt.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(rowsEffected == 1){
			return "Deletion success";
		}
		else{
			return "Deletion failed";
		}

	}
	
	/**
	 * @param argMessageType message type 
	 * @param argOrgId organization id
	 * @param argMessageId message id
	 * @param argMessageText message text
	 */
	public static String editMessages(String argMessageType, int argOrgId, int argMessageId, String argMessageText){
		int rowsEffected = 0;
		String orgDbName = MailingSystemQueries.getOrgDBName(argOrgId);
		Connection connect = DatabaseConnection.getConnection(orgDbName);
		PreparedStatement stmt = null;
		
		if(connect != null){
			try {
				stmt = connect.prepareStatement("UPDATE "+argMessageType+" SET message_text = ? WHERE message_id = ?");
				stmt.setString(1, argMessageText);
				stmt.setInt(2, argMessageId);
				rowsEffected = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					stmt.close();
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(rowsEffected == 1){
			return "Update success";
		}
		else{
			return "Update failed";
		}
	}
	
	
}
