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


/**
 * <p>Java class for getRecordByGuid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRecordByGuid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordScope" type="{http://com.ibm.sk.ubus.ws}recordScope" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecordByGuid", propOrder = {
    "recordGuid",
    "recordScope"
})
public class GetRecordByGuid {

    protected String recordGuid;
    @XmlSchemaType(name = "string")
    protected RecordScope recordScope;

    /**
     * Gets the value of the recordGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordGuid() {
        return recordGuid;
    }

    /**
     * Sets the value of the recordGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordGuid(String value) {
        this.recordGuid = value;
    }

    /**
     * Gets the value of the recordScope property.
     * 
     * @return
     *     possible object is
     *     {@link RecordScope }
     *     
     */
    public RecordScope getRecordScope() {
        return recordScope;
    }

    /**
     * Sets the value of the recordScope property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordScope }
     *     
     */
    public void setRecordScope(RecordScope value) {
        this.recordScope = value;
    }

}
