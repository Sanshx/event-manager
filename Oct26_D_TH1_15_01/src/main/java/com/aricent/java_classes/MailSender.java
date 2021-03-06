package com.aricent.java_classes;

import java.util.ArrayList;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.aricent.pojo_classes.MailInformationHolder;

/**
 * @author gur43182
 *
 */

// This class is responsible for the creation of message and
public class MailSender {
	
	private static final String senderAdminEmailID = "ihems.grp01@gmail.com"; //the admin's email id
	
	//This method returns a Session Object to the calling method


	// This method returns a Session Object to the calling method
	public static Session getSessionObject() {

		Properties properties = getPropertiesForMailer();
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderAdminEmailID,
								"InHouseEMS");// change accordingly
					}
				});
		return session;
	}

	// This method returns the Properties object, after all the properties have
	// been set as required
	private static Properties getPropertiesForMailer() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.connectiontimeout", "5000");
		return properties;
	}

	// This method forms the Email by putting the respective information about
	// the employee and other related information
	public static void formEmailMessage(MailInformationHolder argHolder) {
		Session sess = getSessionObject();
		MimeMessage message = new MimeMessage(sess);

		try {

			Address[] addresses = convertEmailIdToAddress(argHolder
					.getListOfTeamEmployeeID());
			message.setFrom(new InternetAddress(senderAdminEmailID));
			message.setSubject(argHolder.getSubject());
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					argHolder.getEmployeeEmailID()));
			if (!argHolder.getListOfTeamEmployeeID().isEmpty()) {
				message.addRecipients(Message.RecipientType.CC, addresses);
			}
			message.setText("Dear " + argHolder.getEmployeeName() + "," + "\n"
					+ argHolder.getMessage());
			message.saveChanges();
			sendEmail(message);
		} catch (MessagingException e) {
			System.out.println("Email Sending Error");
			e.printStackTrace();
		}
	}

	// This method sends the Email
	private static void sendEmail(MimeMessage argMessage)
			throws MessagingException {
		Transport.send(argMessage);
	}

	// This method converts the email ids in String format to InternetAddress
	// format
	private static Address[] convertEmailIdToAddress(
			ArrayList<String> argListOfEmailIds) throws AddressException {
		InternetAddress[] addresses = new InternetAddress[argListOfEmailIds
				.size()];
		int i = 0;
		for (String string : argListOfEmailIds) {
			addresses[i] = new InternetAddress(string);
			i++;
		}
		return addresses;

	}
}
