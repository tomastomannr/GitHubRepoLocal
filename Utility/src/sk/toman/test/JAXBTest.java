package sk.toman.test;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sk.toman.ubusws.IngestResponse;
import sk.toman.ubusws.IngestResponseType;
import sk.toman.ubusws.ResponseStatusType;


public class JAXBTest {

	public static void main(String[] args) {

		File file = new File("c://test.txt");
		System.out.println(file.exists());
		String sb = "";
		String sb2="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			//sb+=line.trim();
			while(line!=null){
				sb+=line.trim();
				line=br.readLine();				
			}
			
//			System.out.println(sb);
//			IngestResponse ir = (IngestResponse) stringToJaxb(sb.toString(), IngestResponse.class);
//			IngestResponseType irt = ir.getReturn();
//			System.out.println("irt - "+irt!=null);
//			//ResponseStatusType rst = irt.getResponseStatus();
//			System.out.println("rst - "+irt.getResponseStatus()!=null);

		    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(sb);
		    NodeList nodes = doc.getElementsByTagName("IngestResponse");
		    Element lineOne = (Element) nodes.item(0);
		    System.out.println("Name: " + lineOne.getFirstChild());
	        //String request = element.toString();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String jaxbToXml(java.lang.Object jaxbElement, @SuppressWarnings("rawtypes") Class... classesToBeBound) throws JAXBException
    {
           if (jaxbElement == null) return null;
           JAXBContext jContext = JAXBContext.newInstance(classesToBeBound);
     javax.xml.bind.Marshaller m = jContext.createMarshaller();
     StringWriter sw = new StringWriter();
     m.marshal(jaxbElement, sw);
     return sw.toString();
    }
    
    public static byte[] jaxbToByteArr(java.lang.Object jaxbElement, @SuppressWarnings("rawtypes") Class... classesToBeBound) throws JAXBException
    {
           if (jaxbElement == null) return null;
           JAXBContext jContext = JAXBContext.newInstance(classesToBeBound);
     javax.xml.bind.Marshaller m = jContext.createMarshaller();
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     m.marshal(jaxbElement, baos);
     return baos.toByteArray();
    }
    public static java.lang.Object stringToJaxb(String xmlIn, Class<?> classesToBeBound) throws JAXBException
    {
           JAXBContext context = JAXBContext.newInstance(classesToBeBound);
     javax.xml.bind.Unmarshaller um = context.createUnmarshaller();
     javax.xml.transform.Source source = new StreamSource(new StringReader(xmlIn));
     return um.unmarshal(source, classesToBeBound).getValue();
    }
    
    public static java.lang.Object stringToJaxbValid(String inXml, String inXsd, Class<?> classesToBeBound) throws JAXBException, SAXException
    {
           SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
     Schema schema = sf.newSchema(new File(inXsd));
           
           JAXBContext context = JAXBContext.newInstance(classesToBeBound);
     javax.xml.bind.Unmarshaller um = context.createUnmarshaller();
     um.setSchema(schema);
     javax.xml.transform.Source source = new StreamSource(new StringReader(inXml));
     return um.unmarshal(source, classesToBeBound).getValue();
    }


}
