//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.21 at 08:08:54 AM CET 
//


package sk.toman.ubusws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ingestByPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ingestByPath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ingestByPathRequest" type="{http://com.ibm.sk.ubus.ws}IngestByPathRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ingestByPath", propOrder = {
    "ingestByPathRequest"
})
public class IngestByPath {

    protected IngestByPathRequestType ingestByPathRequest;

    /**
     * Gets the value of the ingestByPathRequest property.
     * 
     * @return
     *     possible object is
     *     {@link IngestByPathRequestType }
     *     
     */
    public IngestByPathRequestType getIngestByPathRequest() {
        return ingestByPathRequest;
    }

    /**
     * Sets the value of the ingestByPathRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link IngestByPathRequestType }
     *     
     */
    public void setIngestByPathRequest(IngestByPathRequestType value) {
        this.ingestByPathRequest = value;
    }

}
