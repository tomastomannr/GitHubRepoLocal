//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.21 at 08:08:54 AM CET 
//


package sk.toman.ubusws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateRecordMetadataItemsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateRecordMetadataItemsRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="metadata" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="metadataItem" type="{http://com.ibm.sk.ubus.ws}MetadataItemType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateRecordMetadataItemsRequestType", propOrder = {
    "recordGuid",
    "metadata"
})
public class UpdateRecordMetadataItemsRequestType {

    protected String recordGuid;
    protected UpdateRecordMetadataItemsRequestType.Metadata metadata;

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
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateRecordMetadataItemsRequestType.Metadata }
     *     
     */
    public UpdateRecordMetadataItemsRequestType.Metadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateRecordMetadataItemsRequestType.Metadata }
     *     
     */
    public void setMetadata(UpdateRecordMetadataItemsRequestType.Metadata value) {
        this.metadata = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="metadataItem" type="{http://com.ibm.sk.ubus.ws}MetadataItemType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "metadataItem"
    })
    public static class Metadata {

        @XmlElement(nillable = true)
        protected List<MetadataItemType> metadataItem;

        /**
         * Gets the value of the metadataItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the metadataItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMetadataItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MetadataItemType }
         * 
         * 
         */
        public List<MetadataItemType> getMetadataItem() {
            if (metadataItem == null) {
                metadataItem = new ArrayList<MetadataItemType>();
            }
            return this.metadataItem;
        }

    }

}
