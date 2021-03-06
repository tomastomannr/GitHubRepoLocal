//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.21 at 08:08:54 AM CET 
//


package sk.toman.ubusws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AllocationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllocationResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentKey" type="{http://com.ibm.sk.ubus.ws}ContentKeyType" minOccurs="0"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="result" type="{http://com.ibm.sk.ubus.ws}allocationResult" minOccurs="0"/>
 *         &lt;element name="timeToLive" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllocationResponseType", propOrder = {
    "contentKey",
    "errorMessage",
    "result",
    "timeToLive"
})
public class AllocationResponseType {

    protected ContentKeyType contentKey;
    protected String errorMessage;
    @XmlSchemaType(name = "string")
    protected AllocationResult result;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeToLive;

    /**
     * Gets the value of the contentKey property.
     * 
     * @return
     *     possible object is
     *     {@link ContentKeyType }
     *     
     */
    public ContentKeyType getContentKey() {
        return contentKey;
    }

    /**
     * Sets the value of the contentKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentKeyType }
     *     
     */
    public void setContentKey(ContentKeyType value) {
        this.contentKey = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link AllocationResult }
     *     
     */
    public AllocationResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllocationResult }
     *     
     */
    public void setResult(AllocationResult value) {
        this.result = value;
    }

    /**
     * Gets the value of the timeToLive property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeToLive() {
        return timeToLive;
    }

    /**
     * Sets the value of the timeToLive property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeToLive(XMLGregorianCalendar value) {
        this.timeToLive = value;
    }

}
