package sk.toman.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	public static void sendMail(String url, String domain, String email, String user, String pass)	{
				
		String from = email;
        String to = "tomastomannr@gmail.com";
        Properties props = new Properties(); 
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "yes");
//        props.put("mail.smtp.host", url);
//        props.put("mail.debug", "true");
//    	props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.auth.mechanisms", "NTLM");
//        //props.put("mail.smtp.auth.ntlm.domain", domain);
       
        
        
//        props.put("mail.smtps.ssl.enable", "true");
//        props.put("mail.smtps.starttls.enable", "true");
//        props.put("mail.smtps.auth", "true");
//        props.put("mail.smtps.port", "465");
        props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");	//587

        

        final String username = user;
        final String password = pass;
        
        Session session =
                Session.getInstance(props, new javax.mail.Authenticator() {
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
            message.setSubject("Testing!");
            
        	
        	if(url=="192.168.127.5" || domain.equals("dwc")){
        	  String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
			  html += "<head>";
			  html += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
			  html += "<title>TITUUUUUL</title>";
			  html += "</head>";
			  html += "<body>";
			  html += "<DIV style=\"font-family:times; font-weight:bold; font-size:14pt;\">Oznam o zaèatí pripomienkového konania<br><br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Názov materiálu:</b> Vyhláška Ministerstva školstva, vedy, výskumu a športu Slovenskej republiky, ktorou sa ustanovujú podrobnosti o postupe pri poskytovaní vládneho štipendia<br></DIV><DIV></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Predkladate¾:</b> Ministerstvo školstva, vedy, výskumu a športu Slovenskej republiky<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Rezortné èíslo:</b> spis è. 2015-22992-56AA<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dátum zaèatia MPK:</b> 20. 11. 2015<BR></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dátum ukonèenia MPK:</b> 10. 12. 2015<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Postup a lehota MPK:</b> bežný, 15 pracovných dní<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dôvod skrátenia MPK:</b> <br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Kontaktná osoba:</b> JUDr. Juraj Daniš, Ph.D., juraj.danis@minedu.sk<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Materiál sa nachádza na stránke:</b> https://www.slov-lex.sk/legislativne-procesy/SK/LP/2016/124  (priamy link na úvodnú stránku materiálu)<br></DIV>";
			  html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Pripomienky k materiálu:</b> zasielajte v elektronickej podobe prostredníctvom Portálu Slov-Lex<br></DIV>";
			  
			  html += "</body>";
			  html += "</html>";
	          //message.setText(html);		          
	          message.setContent(html, "text/html; charset=utf-8");
	         
        	}else{
	            message.setText("Hello world!");
        	}
        	
        	Transport.send(message);

            System.out.println("Sent message successfully");

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
		mailServerProperties.put("mail.smtp.port", "587");
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
