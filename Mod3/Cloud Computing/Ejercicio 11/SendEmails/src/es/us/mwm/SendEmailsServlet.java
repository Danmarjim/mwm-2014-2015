package es.us.mwm;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SendEmailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
		try {			
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("probando@appiddmj.appspotmail.com", "Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("danmarjim@gmail.com","Mr. User"));
			msg.setSubject("Correo de prueba");
			msg.setText("Este es un correo de prueba");
			Transport.send(msg);			
		} catch (AddressException ex){			
			ex.printStackTrace();			
		} catch (MessagingException ex) {			
			ex.printStackTrace();			
		}
	}
}
