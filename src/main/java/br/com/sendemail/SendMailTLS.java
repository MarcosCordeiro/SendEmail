package br.com.sendemail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "marcoscbrito@gmail.com";
		final String password = "@#BlackLabel666";

		Properties props = new Properties();
		props.put("mail.smtp.connectiontimeout", 1000);
		props.put("mail.smtp.timeout", 1000);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("marcoscbrito@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("marcosc@riachuelo.com.br"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mr. Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}