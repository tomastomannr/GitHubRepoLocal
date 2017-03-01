package sk.toman.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HelpersUtil {
	
	public void sendMail(){
		
//		final String username = "";
//	    final String password = "";
//	    
//	    Properties props = new Properties(); 
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "false");
//		props.put("mail.smtp.host", "server");//doplnit server
//	    props.put("mail.debug", "true");
//	    props.put("mail.smtp.port", "port");//doplnit port	
//	    props.put("mail.smtp.auth.mechanisms", "NTLM");	
//	    props.put("mail.smtp.auth.ntlm.domain", "domenaMail");//doplnit domenu
//	      	      
//	        
//	    Session session =
//	    Session.getInstance(props, new javax.mail.Authenticator() {
//	                    @Override
//	                    protected PasswordAuthentication getPasswordAuthentication() {
//	                        return new PasswordAuthentication(username, password);
//	                    }
//	                });
//	    session.setDebug(true);
//		
//		Message message = (Message) new MimeMessage(session);
//        message.setFrom(new InternetAddress("adresa@odosielatela.sk"));
//    	
//        String nazovPredpis = predpis.SKSLOVLEXDMS_AttrStrListPlnyNazov.toString();
//        nazovPredpis = nazovPredpis.substring(1, nazovPredpis.length()-1);
//        //ClassProces proces = ClassProces.from(predpis.SWF_AttrPtrListProcesy.get(0));
//        //String dovodSkrateniaMPK = "";
//
//        
//    	String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">";
//		html += "<head>";
//		html += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
//		html += "<title>Title</title>";
//		html += "</head>";
//		html += "<body>";
//		html += "<DIV style=\"font-family:times; font-weight:bold; font-size:14pt;\">Oznam o začatí pripomienkového konania<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Názov materiálu:</b> "+nazovPredpis+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Predkladateľ:</b> "+predpis.SKSLOVLEXDMS_AttrPtrPredkladatelskaInstitucia.SYS_grlongname+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Rezortné číslo:</b> spis č. "+predpis.SKSLOVLEXDMS_AttrStrRezortCislo+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dátum začatia MPK:</b> "+datumZaciatokMPK+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dátum ukončenia MPK:</b> "+datumKoniecMPK+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Postup a lehota MPK:</b> "+typLehoty+", "+uloha.SWF_AttrPtrLehotaZP.SYS_timeinterval+" pracovných dní<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Dôvod skrátenia MPK:</b> "+proces.SWF_AttrStrListDovodSkrateniaMPK+"<br><br></DIV>"; //proces.SWF_AttrStrListDovodSkrateniaMPK
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Kontaktná osoba:</b> "+menoP+", "+userP.MPI_emailinformation.get(0).MPI_emailaddress+"<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Materiál sa nachádza na stránke:</b> https://www.slov-lex.sk/legislativne-procesy/SK/"+predpis.SKWEBSVC_AttrStrForeignKey+"  (priamy link na úvodnú stránku materiálu)<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Pripomienky k materiálu:</b> zasielajte v elektronickej podobe prostredníctvom  <a href=\"https://www.slov-lex.sk/domov\">Portálu Slov-Lex</a><br><br><br><br></DIV>";
//
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Upozornenie</b><br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">Toto je automaticky generovaná správa preto na �?u neodpovedajte. V prípade problémov kontaktujte administrátora Portálu. helpdesk@slov-lex.sk<br><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\"><b>Portál Slov-Lex</b><br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">Ministerstvo spravodlivosti Slovenskej republiky<br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">Sekcia edičných činností, redakcia Slov-Lex<br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">Župné námestie 13<br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">813 11 Bratislava<br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">Tel: +421 2 888 91 131<br></DIV>";
//		html += "<DIV style=\"font-family:times; font-size:12pt;\">https://www.slov-lex.sk/<br></DIV>";
//
//
//		html += "</body>";
//		html += "</html>";
//        //message.setText(html);		          
//        message.setContent(html, "text/html; charset=utf-8");
//         
//        List<String> recipients = new ArrayList<String>();
//        
//        
//    	for(int i=0;i<recipients.size();i++){
//    		message.setRecipients(RecipientType.TO, InternetAddress.parse(recipients.get(i)));
//        	Transport.send(message);
//    	}
	}
	
}
