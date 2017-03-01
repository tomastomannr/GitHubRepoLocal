package sk.toman.util;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SoapWS {
	
	
	
	private static SOAPMessage createSOAPRequest(String strRequest, String credentials, String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        Document doc = stringToXmlDoc(strRequest);
        soapBody.addDocument(doc);
       
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        headers.addHeader("Authorization", credentials);
        headers.addHeader("Content-Type", "text/xml; charset=utf-8");
        headers.addHeader("Method","POST");

        soapMessage.saveChanges();
        return soapMessage;
    }
	
	private static Document stringToXmlDoc(String xmlSource) 
	        throws SAXException, ParserConfigurationException, IOException {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    return builder.parse(new InputSource(new StringReader(xmlSource)));  
	}
}
