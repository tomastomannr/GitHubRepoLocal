//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.21 at 08:08:54 AM CET 
//


package sk.toman.ubusws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for permission.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="permission">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="READ"/>
 *     &lt;enumeration value="WRITE"/>
 *     &lt;enumeration value="DELETE"/>
 *     &lt;enumeration value="MODIFY_ACL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "permission")
@XmlEnum
public enum Permission {

    READ,
    WRITE,
    DELETE,
    MODIFY_ACL;

    public String value() {
        return name();
    }

    public static Permission fromValue(String v) {
        return valueOf(v);
    }

}
