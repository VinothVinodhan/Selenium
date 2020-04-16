package mylearningAutomation;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingMail {

	public static void main(String Ethicsmessage) {

		
		String mFromEmailAddress = "vinothkumar280@gmail.com";
		String mToEmailAddress = "vinothkumar280@gmail.com";

		final String mUserName = "vinothkumar280@gmail.com";
		final String PASSWORD = "Vinothkids@27";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mUserName, PASSWORD);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mFromEmailAddress));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mToEmailAddress));
			message.setSubject("Testing");
			message.setText("Hello");
			System.out.println("Done");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}