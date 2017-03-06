package sk.toman.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


public class Mail {
	
	public static void sendMail(String url, String domain, String email, String user, String pass)	{
		System.out.println("sendMail START");		
		String from = email;
        String to = "asdf@gmail.com";
        
        Properties props = new Properties(); 
//      props.put("mail.smtp.auth", "true");
//      props.put("mail.smtp.auth.mechanisms", "NTLM");
//      props.put("mail.smtp.auth.ntlm.domain", domain);
//      props.put("mail.smtps.ssl.enable", "true");
        
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");	//587 465
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

        final String username = user;
        final String password = pass;
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		                    @Override
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(username, password);
		                    }
                		  });
        session.setDebug(true);
       
        try {
            Message message = (Message) new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Subject");
        	

            String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
            html += "<head>";
            html += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
            html += "</head>";
            html += "<body>";
            html += "<DIV style=\"font-family:times; font-weight:bold; font-size:14pt;\">Testovaci TEXT<br><br></DIV>";			  
            html += "</body>";
            html += "</html>";
	          
	        message.setContent(html, "text/html; charset=utf-8");

    		for(int i=0;i<20;i++){
            	Transport.send(message);            	
    		}
            System.out.println("Sent message successfully");
    		System.out.println("sendMail END");		
        } catch (Exception e) {
        	
        }	
	}

	
	
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
//	public static void main(String args[]) throws AddressException, MessagingException {
//		generateAndSendEmail();
//		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
//	}
 
	public static void generateAndSendEmail()  {
		try{
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "465");//587 465
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("emailacc"));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 System.out.println("TTTTOO");
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "emailacc", "password");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
		}catch(Exception ex){
			System.out.println("Inner ex - " + ex);
		}
	}
	
}
