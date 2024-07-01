package org.config;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailSender {

	public static void sendEmail(String fromName, String toEmailId, String toName, String emailSubject,
			String emailContent) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		// get Session
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("shreyash123kawane@gmail.com", "oklmxkgkccyhzjja");
			}
		});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("shreyash123kawane@gmail.com", fromName));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmailId, toName));
			message.setSubject(emailSubject);
			message.setContent(emailContent, "text/html");
			// send message
			Transport.send(message);
			System.out.println("Email send successfully");
		} catch (MessagingException messagingException) {
			System.out.println("Email not sent!");
			throw new RuntimeException(messagingException);
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			unsupportedEncodingException.printStackTrace();
		}
	}
}