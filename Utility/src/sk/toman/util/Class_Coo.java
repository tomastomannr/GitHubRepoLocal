package sk.toman.util;


import static sk.dwcslovakia.skwsadmin.generated.DUCX.coort;
import static sk.dwcslovakia.skwsadmin.generated.DUCX.cootx;
import sk.dwcslovakia.skwsadmin.generated.SYS.SYS;
import sk.dwcslovakia.skwsadmin.generated.SYS.classes.AttributeDefinition;
import CooLib.CooAggregate;
import CooLib.CooBool;
import CooLib.CooContent;
import CooLib.CooDateTime;
import CooLib.CooDictionary;
import CooLib.CooEnum;
import CooLib.CooException;
import CooLib.CooFlags;
import CooLib.CooFloat;
import CooLib.CooInt;
import CooLib.CooMethod;
import CooLib.CooObject;
import CooLib.CooSearchResult;
import CooLib.CooTransaction;
import CooLib.CooValue;

class Class_Coo
{
  public static final String DLL_NAME = "SKWSADMINIAMFBS2.";
  
  private final static String finalStringEmpty = "";
  private final static int finalIntObjectLockSeconds = 5;
  
  public static CooValue[] CastAsCooValueArray(CooObject[] cooObjectArray)
  {
    if (null == cooObjectArray)
      return null;
    CooValue[] cooValueArrayReturn = new CooValue[cooObjectArray.length];
    for (int intI = 0; intI < cooObjectArray.length; intI++)
      cooValueArrayReturn[intI] = CooValue.asValue(cooObjectArray[intI]);
    return cooValueArrayReturn;
  }
  
  // public static boolean CleanParameterValue(CooMethod coometh, uint pos,
  // CooObject cooTypeDefinition)
  // {
  // return CleanParameterValue(coometh, pos, cooTypeDefinition);//, null);
  // }
  public static boolean CleanParameterValue(CooMethod coometh, int pos, CooObject cooTypeDefinition) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return false;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(cooTypeDefinition.GetAddress()))
      return false;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return false;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return false;
    // if (inx != null && !coometh.HasParameterValue(pos, cooTypeDefinition,
    // (uint)inx)) return false;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return false;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // false;
    // if (inx != null && null == coometh.GetParameterValue(pos,
    // cooTypeDefinition, (uint)inx)) return false;
    // if (value == null) return true;
    // if (inx != null)
    // coometh.SetParameterValue(pos, cooTypeDefinition, (uint)inx, value);
    // else
    coometh.SetParameterValue(pos, cooTypeDefinition, null);
    return true;
  }
  
  // #endregion
  // #region Clean
  public static boolean ClearVariable(CooObject swc, int id) throws CooException
  {
    if (IsNullOrDead(cootx) || IsNullOrDead(swc))
      return false;
    cootx.ClearVariable(swc, id);
    return true;
  }
  
  public static boolean Compare(Long longValueA, Long longValueB)
  {
    if (longValueA == null && longValueB == null)
      return true;
    
    if (longValueA == null || longValueB == null)
      return false;
    
    return longValueA.equals(longValueB);
  }
  
  public static boolean CompareNotNull(Long longValueA, Long longValueB)
  {
    if (longValueA == null || longValueB == null)
      return false;
    
    return CompareNotNull(longValueA, longValueB);
  }

  public static boolean Compare(CooObject cooObjectValueA, CooObject cooObjectValueB) throws CooException
  {
    if (cooObjectValueA == null && cooObjectValueB == null)
      return true;
    
    if (cooObjectValueA == null || cooObjectValueB == null)
      return false;
    
    return cooObjectValueA.GetAddress().equals(cooObjectValueB.GetAddress());
  }
  
  public static boolean CompareNotNull(CooObject cooObjectValueA, CooObject cooObjectValueB)
  {
    if (cooObjectValueA == null || cooObjectValueB == null)
      return false;
    
    return CompareNotNull(cooObjectValueA, cooObjectValueB);
  }
  
  /**
   * byte[] CooContentGetByteArray
   * 
   * @param cooContent
   * @return
   * @throws CooException
   */
  public static byte[] CooContentGetByteArray(CooContent cooContent) throws CooException
  {
    if (cooContent == null)
      return null;
    String stringBase64Content = cooContent.GetContent(cootx, CooFlags.COOGC_BASE64, CooFlags.COOGC_UTF8);
    
    // j8// return java.util.Base64.getDecoder().decode(stringBase64Content);
    return javax.xml.bind.DatatypeConverter.parseBase64Binary(stringBase64Content);
  }
  
  /**
   * String CooContentGetString
   * @param cooContent
   * @return
   * @throws CooException
   */
  public static String CooContentGetString(CooContent cooContent) throws CooException
  {
    if (cooContent == null)
      return null;
    return cooContent.GetContent(cootx, CooFlags.COOGC_MULTIBYTEFILE, CooFlags.COOGC_ACP);
  }
  
  /**
   * String CooContentGetStringBase64
   * 
   * @param cooContent
   * @return
   * @throws CooException
   */
  public static String CooContentGetStringBase64(CooContent cooContent) throws CooException
  {
    if (cooContent == null)
      return null;
    return cooContent.GetContent(cootx, CooFlags.COOGC_BASE64, CooFlags.COOGC_UTF8);
  }

  /**
   * CooContent CooContentSetByteArray
   * 
   * @param cooContent
   * @param byteArrayValue
   * @return
   * @throws CooException
   */
  public static CooContent CooContentSetByteArray(CooContent cooContent, byte[] byteArrayValue) throws CooException
  {
    if (cooContent == null)
      cooContent = new CooContent();
    
    if (byteArrayValue == null)
    {
      cooContent.SetContent(cootx, CooFlags.COOGC_BASE64, CooFlags.COOGC_UTF8, null);
      return cooContent;
    }
    
    // j8// String stringBase64Content = java.util.Base64.encodeBytes(byteArrayValue);
    String stringBase64Content = javax.xml.bind.DatatypeConverter.printBase64Binary(byteArrayValue);
    cooContent.SetContent(cootx, CooFlags.COOGC_BASE64, CooFlags.COOGC_UTF8, stringBase64Content);
    return cooContent;
  }
  
  /**
   * CooContent CooContentSetString
   * 
   * @param cooContent
   * @param stringContent
   * @return
   * @throws CooException
   */
  public static CooContent CooContentSetString(CooContent cooContent, String stringContent) throws CooException
  {
    if (cooContent == null)
      cooContent = new CooContent();
    
    cooContent.SetContent(cootx, CooFlags.COOGC_MULTIBYTEFILE, CooFlags.COOGC_ACP, stringContent);
    return cooContent;
  }
  
  /**
   * CooContent CooContentSetStringBase64
   * 
   * @param cooContent
   * @param stringBase64Content
   * @return
   * @throws CooException
   */
  public static CooContent CooContentSetStringBase64(CooContent cooContent, String stringBase64Content) throws CooException
  {
    if (cooContent == null)
      cooContent = new CooContent();
    
    cooContent.SetContent(cootx, CooFlags.COOGC_BASE64, CooFlags.COOGC_UTF8, stringBase64Content);
    return cooContent;
  }

  public static String CooValue2string(CooValue cooValue) throws CooException
  {
    if (cooValue == null)
      return "null";
    
    if (IsNullOrDead(cooValue) && cooValue.getType() == CooValue.OBJECT)
      return "dead " + cooValue.getObject().GetAddress();
    
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
      	if(null == cooValue.getAggregate())
      		return finalStringEmpty;
      	else
      		return cooValue.getAggregate().toString();
      case CooValue.BOOL:
      	if(
      			null == cooValue.getBool()
      			|| !cooValue.getBool().isValid()
      			)
      		return finalStringEmpty;
      	else
      		return cooValue.getBool().toString();
      case CooValue.CONTENT:
      	if(null == cooValue.getContent())
      		return finalStringEmpty;
      	else
      		return cooValue.getContent().toString();
      case CooValue.DATETIME:
      	if(
      			null == cooValue.getDateTime()
      			|| !cooValue.getDateTime().isValid() 
      			)
      		return finalStringEmpty;
      	else
      		return cooValue.getDateTime().toString();
        // case CooValue.DATETIME:
        // return
        // cooValue.AsCooDateTime().Value.ToString("yyyy-MM-ddTHH:mm:ss.fffzzz");
      case CooValue.DICTIONARY:
      	if(null == cooValue.getDictionary())
      		return finalStringEmpty;
      	else
      		return cooValue.getDictionary().toString();
        // case CooValue.DOUBLE:
        // return cooValue.AsCooDouble().isValid ?
        // cooValue.AsCooDouble().ToString() : finalStringEmpty;
      case CooValue.ENUM:
      	if(
      			null == cooValue.getEnum()
      			|| !cooValue.getEnum().isValid() 
      			)
      		return finalStringEmpty;
      	else
      		return cooValue.getEnum().toString();
      case CooValue.FLOAT:
      	if(
      			null == cooValue.getFloat()
      			|| !cooValue.getFloat().isValid() 
      			)
      		return finalStringEmpty;
      	else
      		return cooValue.getFloat().toString();
      case CooValue.INTEGER:
      	if(
      			null == cooValue.getInteger()
      			|| !cooValue.getInteger().isValid() 
      			)
      		return finalStringEmpty;
      	else
      		return cooValue.getInteger().toString();
      case CooValue.INTERFACE:
      	if(null==cooValue.getObject())
	    		return finalStringEmpty;
	    	else
	        return cooValue.getObject().toString();
        // case CooValue.LONG:
        // return cooValue.getLong().isValid() ? cooValue.getLong().toString() :
        // finalStringEmpty;
      case CooValue.OBJECT:
      	if(null==cooValue.getObject())
	    		return finalStringEmpty;
	    	else
	    		return cooValue.getObject().toString();
      case CooValue.STRING:
        return cooValue.getString();
      case CooValue.VOID:
      	if(null==cooValue.getObject())
	    		return finalStringEmpty;
	    	else
	    		return cooValue.getObject().toString();
      default:
        return cooValue.toString();
    }
  }
  
  
  // #endregion
//  // #region
//  public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull, Boolean booleanValue) throws CooException
//  {
//    if (cooValue == null || IsNullOrDead(cooValue) || !(CooValue.BOOL == cooValue.getType()) || cooValue.getBool().isInvalid())
//    {
//      if (booleanSetNull)
//        booleanValue = null;
//      return booleanSetNull;
//    }
//    
//    booleanValue = cooValue.getBool().getValue();
//    return true;
//  }
  
//  // public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull,
//  // ref DateTime? dateTimeValue)
//  @Deprecated
//  public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull, Date dateTimeValue) throws CooException
//  {
//    if (cooValue == null
//        || IsNullOrDead(cooValue)
//        || !(CooValue.DATETIME == cooValue.getType())
//        || cooValue.getDateTime().isInvalid())
//    {
//      if (booleanSetNull)
//        dateTimeValue = null;
//      return booleanSetNull;
//    }
//    
//    dateTimeValue = cooValue.getDateTime().getValue();
//    return true;
//  }
  
//  // public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull,
//  // ref Double doubleValue)
//  @Deprecated
//  public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull, Double doubleValue) throws CooException
//  {
//    if (cooValue == null
//        || IsNullOrDead(cooValue)
//        || !(CooValue.FLOAT == cooValue.getType())
//        || cooValue.getFloat().isInvalid())
//    {
//      if (booleanSetNull)
//        doubleValue = null;
//      return booleanSetNull;
//    }
//    
//    doubleValue = cooValue.getFloat().getValue();
//    return true;
//  }
  
//  // public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull,
//  // ref Long longValue)
//  @Deprecated
//  public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull, Long longValue) throws CooException
//  {
//    if (cooValue == null
//        || IsNullOrDead(cooValue)
//        || !(CooValue.INTEGER == cooValue.getType())
//        || cooValue.getInteger().isInvalid())
//    {
//      if (booleanSetNull)
//        longValue = null;
//      return booleanSetNull;
//    }
//    
//    longValue = cooValue.getInteger().getValue();
//    return true;
//  }
  
//  // public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull,
//  // ref string stringValue)
//  @Deprecated
//  public static boolean cooValueAs(CooValue cooValue, boolean booleanSetNull, String stringValue) throws CooException
//  {
//    if (cooValue == null
//        || IsNullOrDead(cooValue)
//        || !(CooValue.INTEGER == cooValue.getType())
//        || !stringIsNullOrEmpty(cooValue.getString()))
//    {
//      if (booleanSetNull)
//        stringValue = null;
//      return booleanSetNull;
//    }
//    
//    stringValue = cooValue.getString();
//    return true;
//  }
  
  // #endregion
  public static Boolean CooValueAsBoolean(CooValue cooValue)
  {
    if (
    		cooValue == null 
        || !(CooValue.BOOL == cooValue.getType())
    		|| cooValue.getBool() == null 
    		|| !cooValue.getBool().isValid()
     // || !((CooBool)cooValue.AsCooBool()).HasValue
    )
      return null;
    return cooValue.getBool().getValue();
  }
  
  public static CooAggregate CooValueAsCooAggregate(CooValue cooValue)
  {
    if (cooValue == null)
      return null;
    return cooValue.getAggregate();
  }
  
  public static CooBool CooValueAsCooBool(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getBool() == null || !cooValue.getBool().isValid())
      return null;
    return cooValue.getBool();
  }
  
  public static CooContent CooValueAsCooContent(CooValue cooValue)
  {
    if (cooValue == null)
      return null;
    return cooValue.getContent();
  }
  
  public static CooDateTime CooValueAsCooDateTime(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getDateTime() == null || !cooValue.getDateTime().isValid())
      return null;
    return cooValue.getDateTime();
  }
  
  public static CooDictionary CooValueAsCooDictionary(CooValue cooValue)
  {
    if (cooValue == null)
      return null;
    return cooValue.getDictionary();
  }
  
  public static CooFloat CooValueAsCooDouble(CooValue cooValue)
  {
    if (cooValue == null || !cooValue.getFloat().isValid())
      return null;
    return cooValue.getFloat();
  }
  
  public static CooEnum CooValueAsCooEnum(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getEnum() == null || !cooValue.getEnum().isValid())
      return null;
    return cooValue.getEnum();
  }
  
  // //#if DEBUG
  // //[Obsolete("USE CooValueAsCooEnumAsLong", true)]
  // public static Long CooValueAsCooEnumAsInt(CooValue cooValue)
  // {
  // if (
  // cooValue == null
  // || !cooValue.AsCooEnum().IsValid
  // ) return null;
  // return cooValue.AsCooEnum().IntValue;
  // }
  // //#endif
  public static Long CooValueAsCooEnumAsLong(CooValue cooValue)
  {
    if (
    		cooValue == null 
    		|| cooValue.getEnum() == null 
    		|| !cooValue.getEnum().isValid()
    		)
      return null;
    return cooValue.getEnum().getValue();
  }
  
  public static CooFloat CooValueAsCooFloat(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getFloat() == null || !cooValue.getFloat().isValid())
      return null;
    return cooValue.getFloat();
  }
  
  // //#if DEBUG
  // /// <summary>
  // /// [Obsolete("USE CooValueAsCooLong", true)]
  // /// </summary>
  // /// <param name="cooValue"></param>
  // /// <returns></returns>
  // //[Obsolete("USE CooValueAsCooLong", true)]
  // public static CooInt CooValueAsCooInt(CooValue cooValue)
  // {
  // if (
  // cooValue == null
  // || !cooValue.AsCooInt().IsValid
  // ) return null;
  // return cooValue.AsCooInt();
  // }
  // /// <summary>
  // /// [Obsolete("USE CooValueAsCooLong", true)]
  // /// </summary>
  // /// <param name="cooValue"></param>
  // /// <returns></returns>
  // //[Obsolete("USE CooValueAsCooLong", true)]
  // public static Long CooValueAsInt(CooValue cooValue)
  // {
  // if (
  // cooValue == null
  // || !cooValue.AsCooInt().IsValid
  // ) return null;
  // return cooValue.AsCooInt().Value;
  // }
  // //#endif
  public static CooInt CooValueAsCooLong(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getInteger() == null || !cooValue.getInteger().isValid())
      return null;
    return cooValue.getInteger();
  }
  
  public static CooObject CooValueAsCooObject(CooValue cooValue)
  {
    if (cooValue == null)
      return null;
    return cooValue.getObject();
  }
  
  public static java.util.Date CooValueAsDateTime(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getDateTime() == null || !cooValue.getDateTime().isValid())
      return null;
    return cooValue.getDateTime().getValue();
  }
  
  public static Double CooValueAsDouble(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getFloat() == null || !cooValue.getFloat().isValid())
      return null;
    return cooValue.getFloat().getValue();
  }
  
  public static Float CooValueAsFloat(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getFloat() == null || !cooValue.getFloat().isValid())
      return null;
    return (float) cooValue.getFloat().getValue();
  }
  
  public static Long CooValueAsLong(CooValue cooValue)
  {
    if (cooValue == null || cooValue.getInteger() == null || !cooValue.getInteger().isValid())
      return null;
    return cooValue.getInteger().getValue();
  }
  
  // public static CooUnknown CooValueAsCooUnknown(CooValue cooValue)
  // {
  // if (cooValue == null) return null;
  // return cooValue.getUnknown();
  // }
  public static String CooValueAsString(CooValue cooValue)
  {
    if (cooValue == null)
      return null;
    return cooValue.getString();
  }
  
  public static String CooValueAsStringNotNull(CooValue cooValue)
  {
    return StringNull2Empty(CooValueAsString(cooValue));
  }
  
  // #endregion
//  public static CooObject GetAttrDef(String stringAttrDef) throws CooException
//  {
//    try
//    {
//      // #if DEBUG
//      // //Variable(true,
//      // "private static CooObject GetAttrDef(string stringAttrDef)",
//      // stringAttrDef);
//      // Trace(true,
//      // "private static CooObject GetAttrDef(string stringAttrDef) " +
//      // stringAttrDef);
//      // #endif
//      return coort.GetObject(stringAttrDef);
//    }
//    catch (Exception exception)
//    {
//      // TO DO X X X - nechat viplavat do booleanError = true - mozno len
//      // throw exception;
//      // zaremova+t catch
//      TraceCatch(exception, "private static CooObject GetAttrDef(string stringAttrDef='" + stringAttrDef + "')");
//      // #if DEBUG
//      // throw;
//      // #endif
//    }
//    // #if !DEBUG
//    return null;
//    // #endif
//  }
  
  // #region "GetAttribute"
  public static CooValue[] GetAttribute(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    if (IsNullOrDead(cooValue)
        || IsNullOrDead(AttrDef)
        || (cooValue.getType() == CooValue.AGGREGATE && cooValue.getAggregate() == null )
        || (cooValue.getType() == CooValue.AGGREGATE && !cooValue.getAggregate().HasAttribute(AttrDef))
        || (cooValue.getType() == CooValue.OBJECT && cooValue.getObject() == null )
        || (cooValue.getType() == CooValue.OBJECT && !cooValue.getObject().HasAttribute(cootx, AttrDef)))
      return null;
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
        return cooValue.getAggregate().GetAttribute(AttrDef);
      case CooValue.OBJECT:
        return cooValue.getObject().GetAttribute(cootx, AttrDef);
      default:
        return null;
    }
  }
  
  // #endregion
  // #endregion
  
  // #region "GetAttributeString"
  // #region "public static String GetAttributeString("
  public static String GetAttributeString(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    CooValue cooValueAttr = GetAttributeValue(cooValue, AttrDef);
    if (IsNullOrDead(cooValueAttr))
      return null;
    // switch (cooValueAttr.Type)
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
      	if(null == cooValue.getAggregate())
      		return null;
      	else
      		return cooValue.getAggregate().GetAttributeString(AttrDef);
        // return cooValue.AsCooAggregate().GetAttributeString(AttrDef,
        // coort.GetCurrentUserLanguage());
      case CooValue.OBJECT:
      	if(null == cooValue.getObject())
      		return null;
      	else
      		return cooValue.getObject().GetAttributeString(AttrDef);
        // return cooobj.GetAttributeString(AttrDef,
        // coort.GetCurrentUserLanguage());
      default:
        return null;
    }
  }
  
  // #endregion
  // #region "public static String GetAttributeStringNotNull("
  public static String GetAttributeStringNotNull(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return StringNull2Empty(GetAttributeString(cooValue, AttrDef));
  }
  
  // #endregion
  // #endregion
  // #region "GetAttribute"
  // #region "getAttributeValue"
  public static CooValue GetAttributeValue(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return GetAttributeValue(cooValue, AttrDef, null);
  }
  
  public static CooValue GetAttributeValue(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return GetAttributeValue(cooValue, AttrDef, (Integer) inx);
  }
  
  private static CooValue GetAttributeValue(CooValue cooValue, AttributeDefinition AttrDef, Integer inx) throws CooException
  {
    if (IsNullOrDead(cooValue) || IsNullOrDead(AttrDef))
      return null;
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
      {
        if (
        		null == cooValue.getAggregate()
        		|| !cooValue.getAggregate().HasAttribute(AttrDef)
            || !cooValue.getAggregate().HasAttributeValue(AttrDef)
            || null == cooValue.getAggregate().GetAttribute(AttrDef))
          return null;
        if (inx == null)
        {
          return cooValue.getAggregate().GetAttributeValue(AttrDef);
        }
        if (!cooValue.getAggregate().HasAttributeValue(AttrDef, (int) inx))
          return null;
        return cooValue.getAggregate().GetAttributeValue(AttrDef, (int) inx);
      }
      case CooValue.OBJECT:
      {
        if (
        		null == cooValue.getObject()
        		|| !cooValue.getObject().HasAttribute(cootx, AttrDef)
            || !cooValue.getObject().HasAttributeValue(cootx, AttrDef)
            || null == cooValue.getObject().GetAttribute(cootx, AttrDef))
          return null;
        if (inx == null)
        {
          return cooValue.getObject().GetAttributeValue(cootx, AttrDef);
        }
        if (!cooValue.getObject().HasAttributeValue(cootx, AttrDef, (int) inx))
          return null;
        return cooValue.getObject().GetAttributeValue(cootx, AttrDef, (int) inx);
      }
      default:
        return null;
    }
  }
  
  // #endregion
  // #region "public static Boolean GetAttributeValueAsBoolean("
  public static Boolean GetAttributeValueAsBoolean(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsBoolean(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static Boolean GetAttributeValueAsBoolean(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsBoolean(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooAggregate GetAttributeValueAsCooAggregate("
  public static CooAggregate GetAttributeValueAsCooAggregate(CooValue cooValue, AttributeDefinition AttrDef)
      throws CooException
  {
    return CooValueAsCooAggregate(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooAggregate GetAttributeValueAsCooAggregate(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooAggregate(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooBool GetAttributeValueAsCooBool("
  public static CooBool GetAttributeValueAsCooBool(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooBool(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooBool GetAttributeValueAsCooBool(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsCooBool(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooContent GetAttributeValueAsCooContent("
  public static CooContent GetAttributeValueAsCooContent(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooContent(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooContent GetAttributeValueAsCooContent(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooContent(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooDateTime GetAttributeValueAsCooDateTime("
  public static CooDateTime GetAttributeValueAsCooDateTime(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooDateTime(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooDateTime GetAttributeValueAsCooDateTime(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooDateTime(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooDictionary GetAttributeValueAsCooDictionary("
  public static CooDictionary GetAttributeValueAsCooDictionary(CooValue cooValue, AttributeDefinition AttrDef)
      throws CooException
  {
    return CooValueAsCooDictionary(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooDictionary GetAttributeValueAsCooDictionary(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooDictionary(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooFloat GetAttributeValueAsCooDouble("
  public static CooFloat GetAttributeValueAsCooDouble(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooDouble(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooFloat GetAttributeValueAsCooDouble(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooDouble(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #region "public static CooEnum GetAttributeValueAsCooEnum("
  public static CooEnum GetAttributeValueAsCooEnum(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooEnum(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooEnum GetAttributeValueAsCooEnum(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsCooEnum(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static Long GetAttributeValueAsCooEnumAsLong("
  public static Long GetAttributeValueAsCooEnumAsLong(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static Long GetAttributeValueAsCooEnumAsLong(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooEnumAsLong(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static CooFloat GetAttributeValueAsCooFloat("
  public static CooFloat GetAttributeValueAsCooFloat(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooFloat(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooFloat GetAttributeValueAsCooFloat(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooFloat(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static CooLong GetAttributeValueAsCooLong("
  public static CooInt GetAttributeValueAsCooLong(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooLong(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooInt GetAttributeValueAsCooLong(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsCooLong(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static CooObject GetAttributeValueAsCooObject("
  public static CooObject GetAttributeValueAsCooObject(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsCooObject(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static CooObject GetAttributeValueAsCooObject(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsCooObject(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static DateTime? GetAttributeValueAsDateTime("
  public static java.util.Date GetAttributeValueAsDateTime(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsDateTime(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static java.util.Date GetAttributeValueAsDateTime(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsDateTime(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static Double GetAttributeValueAsDouble("
  public static Double GetAttributeValueAsDouble(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsDouble(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static Double GetAttributeValueAsDouble(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsDouble(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  
  // #region "public static Long GetAttributeValueAsLong("
  public static Long GetAttributeValueAsLong(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsLong(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static Long GetAttributeValueAsLong(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsLong(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  public static String GetAttributeValueAsString(CooObject cooObject, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsString(GetAttributeValue(CooValue.asValue(cooObject), AttrDef));
  }
  
  public static String GetAttributeValueAsString(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsString(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static String GetAttributeValueAsString(CooValue cooValue, AttributeDefinition AttrDef, int inx) throws CooException
  {
    return CooValueAsString(GetAttributeValue(cooValue, AttrDef, inx));
  }
  // #endregion
  
  // #region "public static String GetAttributeValueAsStringNotNull("
  public static String GetAttributeValueAsStringNotNull(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return CooValueAsStringNotNull(GetAttributeValue(cooValue, AttrDef));
  }
  
  public static String GetAttributeValueAsStringNotNull(CooValue cooValue, AttributeDefinition AttrDef, int inx)
      throws CooException
  {
    return CooValueAsStringNotNull(GetAttributeValue(cooValue, AttrDef, inx));
  }
  
  // #endregion
  // #endregion
  // #region "public static Integer GetAttributeValueCount("
  public static Integer GetAttributeValueCount(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    if (IsNullOrDead(cooValue) || IsNullOrDead(AttrDef))
      return null;
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
        if (
        		null == cooValue.getAggregate()
            || !cooValue.getAggregate().HasAttribute(AttrDef)
            || !cooValue.getAggregate().HasAttributeValue(AttrDef)
            || null == cooValue.getAggregate().GetAttribute(AttrDef)
            || null == cooValue.getAggregate().GetAttributeValue(AttrDef))
          return null;
        return cooValue.getAggregate().GetAttributeValueCount(AttrDef);
      case CooValue.OBJECT:
        if (
        		null == cooValue.getObject()
            || !cooValue.getObject().HasAttribute(cootx, AttrDef)
            || !cooValue.getObject().HasAttributeValue(cootx, AttrDef)
            || null == cooValue.getObject().GetAttribute(cootx, AttrDef)
            || null == cooValue.getObject().GetAttributeValue(cootx, AttrDef))
          return null;
        return cooValue.getObject().GetAttributeValueCount(cootx, AttrDef);
      default:
        return null;
    }
  }
  
  // #endregion
  // #region "public static uint GetAttributeValueCountNotNull("
  public static int GetAttributeValueCountNotNull(CooValue cooValue, AttributeDefinition AttrDef) throws CooException
  {
    return IntegerNull2Zero(GetAttributeValueCount(cooValue, AttrDef));
  }
  
  // #endregion
  public static CooObject GetCooTypeDefinition(CooValue value) throws CooException
  {
    switch (value.getType())
    {
      case CooValue.AGGREGATE:
        return SYS.getTypeObjectDef_OBJECTLIST(); // CooTypeDefinition.OBJECTLIST;
      case CooValue.BOOL:
        return SYS.getTypeBoolDef_BOOLEANLIST(); // CooTypeDefinition.BOOLEANLIST;
      case CooValue.CONTENT:
        return SYS.getTypeContentDef_CONTENTLIST(); // CooTypeDefinition.CONTENTLIST;
      case CooValue.DATETIME:
        return SYS.getTypeDateTimeDef_DATETIMELIST(); // CooTypeDefinition.DATETIMELIST;
      case CooValue.DICTIONARY:
        return SYS.getTypeDictionaryDef_DICTIONARYLIST(); // CooTypeDefinition.DICTIONARYLIST;
      case CooValue.ENUM:
        return SYS.getTypeIntegerDef_INTEGERLIST(); // CooTypeDefinition.INTEGERLIST;
      case CooValue.FLOAT:
        return SYS.getTypeFloatDef_FLOATLIST(); // CooTypeDefinition.FLOATLIST;
      case CooValue.INTEGER:
        return SYS.getTypeIntegerDef_INTEGERLIST(); // CooTypeDefinition.INTEGERLIST;
      case CooValue.INTERFACE:
        return SYS.getTypeObjectDef_OBJECTLIST(); // CooTypeDefinition.OBJECTLIST;
      case CooValue.OBJECT:
        return SYS.getTypeObjectDef_OBJECTLIST(); // CooTypeDefinition.OBJECTLIST;
      case CooValue.STRING:
        return SYS.getTypeStringDef_STRINGLIST(); // CooTypeDefinition.STRINGLIST;
      case CooValue.VOID:
        return SYS.getTypeObjectDef_OBJECTLIST(); // CooTypeDefinition.OBJECTLIST;
      default:
        return SYS.getTypeObjectDef_OBJECTLIST(); // CooTypeDefinition.OBJECTLIST;
    }
  }
  
  // #region "public static Long GetAttributeValueAsCooEnumAsInt("
  // //#if DEBUG
  // //[Obsolete("USE GetAttributeValueAsCooEnumAsLong", true)]
  // public static Long GetAttributeValueAsCooEnumAsInt(CooValue cooValue,
  // AttributeDefinition AttrDef) throws CooException
  // {
  // return CooValueAsCooEnumAsLong(GetAttributeValue(cooValue, AttrDef));
  // }
  // //[Obsolete("USE GetAttributeValueAsCooEnumAsLong", true)]
  // public static Long GetAttributeValueAsCooEnumAsInt(CooValue cooValue,
  // AttributeDefinition AttrDef, uint inx) throws CooException
  // {
  // return CooValueAsCooEnumAsLong(GetAttributeValue(cooValue, AttrDef, inx));
  // }
  // //#endif
  // #endregion
  
  // public static Integer GetCount<Aray>(Aray[] aray)
  public static Integer GetCount(java.lang.Object[] aray)
  {
    if (aray == null)
      return null;
    return aray.length;
  }
  
  public static int GetCountNotNull(java.lang.Object[] aray)
  {
    return IntegerNull2Zero(GetCount(aray));
  }
  
  // #region "GetDictionaryString"
  // #region "public static String GetDictionaryString("
  public static String GetDictionaryString(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    if (null == cooDictionary)
      return null;
    return cooDictionary.GetEntryString(stringKey);
  }
  
  // #endregion
  // #region "public static String GetDictionaryStringNotNull("
  public static String GetDictionaryStringNotNull(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return StringNull2Empty(GetDictionaryString(cooDictionary, stringKey));
  }
  
  // #endregion
  // #endregion
  
  // #region "GetDictionary"
  // #region "GetDictionaryValue"
  public static CooValue GetDictionaryValue(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    if (null == cooDictionary)
      return null;
    return cooDictionary.GetEntryValue(stringKey);
  }
  
  public static CooValue GetDictionaryValue(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    if (null == cooDictionary)
      return null;
    return cooDictionary.GetEntryValue(stringKey, inx);
  }
  
  // #endregion
  
  // #region "public static Boolean GetDictionaryValueAsBoolean("
  public static Boolean GetDictionaryValueAsBoolean(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsBoolean(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static Boolean GetDictionaryValueAsBoolean(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsBoolean(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // //#region "public static CooUnknown GetAttributeValueAsCooUnknown("
  // public static CooUnknown GetAttributeValueAsCooUnknown(CooValue cooValue,
  // AttributeDefinition AttrDef) throws CooException
  // {
  // return CooValueAsCooUnknown(GetAttributeValue(cooValue, AttrDef));
  // }
  // public static CooUnknown GetAttributeValueAsCooUnknown(CooValue cooValue,
  // AttributeDefinition AttrDef, int inx) throws CooException
  // {
  // return CooValueAsCooUnknown(GetAttributeValue(cooValue, AttrDef, inx));
  // }
  // //#endregion
  
  // #region "public static CooAggregate GetDictionaryValueAsCooAggregate("
  public static CooAggregate GetDictionaryValueAsCooAggregate(CooDictionary cooDictionary, String stringKey)
      throws CooException
  {
    return CooValueAsCooAggregate(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooAggregate GetDictionaryValueAsCooAggregate(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooAggregate(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static CooBool GetDictionaryValueAsCooBool("
  public static CooBool GetDictionaryValueAsCooBool(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooBool(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooBool GetDictionaryValueAsCooBool(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsCooBool(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static CooContent GetDictionaryValueAsCooContent("
  public static CooContent GetDictionaryValueAsCooContent(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooContent(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooContent GetDictionaryValueAsCooContent(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooContent(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static CooDateTime GetDictionaryValueAsCooDateTime("
  public static CooDateTime GetDictionaryValueAsCooDateTime(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooDateTime(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooDateTime GetDictionaryValueAsCooDateTime(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooDateTime(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static CooDictionary GetDictionaryValueAsCooDictionary("
  public static CooDictionary GetDictionaryValueAsCooDictionary(CooDictionary cooDictionary, String stringKey)
      throws CooException
  {
    return CooValueAsCooDictionary(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooDictionary GetDictionaryValueAsCooDictionary(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooDictionary(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static CooFloat GetDictionaryValueAsCooDouble("
  public static CooFloat GetDictionaryValueAsCooDouble(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooDouble(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  // //#region "CleanAttributeValue"
  // //public static boolean CleanAttributeValue(CooValue cooValue,
  // AttributeDefinition AttrDef)
  // //{
  // // return CleanAttributeValue(cooValue, AttrDef);//, null);
  // //}
  // public static boolean CleanAttributeValue(CooValue cooValue, AttributeDefinition AttrDef)
  // {
  // if (
  // IsNullOrDead(cooValue)
  // || IsNullOrDead(AttrDef)
  // || (cooValue.Type == CooValue.CooType.AGGREGATE &&
  // !cooValue.AsCooAggregate().HasAttribute(AttrDef))
  // || (cooValue.Type == CooValue.CooType.OBJECT &&
  // !cooValue.AsCooObject().HasAttribute(cootx, AttrDef))
  // ) return false;
  // //if (!cooobj.HasAttributeValue(cootx, AttrDef)) return false;
  // //if (inx != null && !cooobj.HasAttributeValue(cootx, AttrDef, (uint)inx))
  // return false;
  // //if (null == cooobj.GetAttribute(cootx, AttrDef)) return false;
  // //if (null == cooobj.GetAttributeValue(cootx, AttrDef)) return false;
  // //if (inx != null && null == cooobj.GetAttributeValue(cootx, AttrDef,
  // (uint)inx)) return false;
  // //if (value == null) return true;
  // //if (inx != null)
  // // cooobj.SetAttributeValue(cootx, AttrDef, (uint)inx, value);
  // //else
  // switch (cooValue.Type)
  // {
  // case CooValue.CooType.AGGREGATE:
  // cooValue.AsCooAggregate().SetAttributeValue(AttrDef, null);
  // return true;
  // case CooValue.CooType.OBJECT:
  // cooValue.AsCooObject().SetAttributeValue(cootx, AttrDef, null);
  // return true;
  // default:
  // return false;
  // }
  // }
  // //#endregion
  
  public static CooFloat GetDictionaryValueAsCooDouble(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooDouble(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static CooEnum GetDictionaryValueAsCooEnum("
  public static CooEnum GetDictionaryValueAsCooEnum(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooEnum(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooEnum GetDictionaryValueAsCooEnum(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsCooEnum(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region " Parameter"
  
  // #region "public static Long GetDictionaryValueAsCooEnumAsLong("
  public static Long GetDictionaryValueAsCooEnumAsLong(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static Long GetDictionaryValueAsCooEnumAsLong(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooEnumAsLong(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static CooInt GetDictionaryValueAsCooLong("
  public static CooInt GetDictionaryValueAsCooLong(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooLong(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooInt GetDictionaryValueAsCooLong(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsCooLong(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static CooObject GetDictionaryValueAsCooObject("
  public static CooObject GetDictionaryValueAsCooObject(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsCooObject(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static CooObject GetDictionaryValueAsCooObject(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsCooObject(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static DateTime? GetDictionaryValueAsDateTime("
  public static java.util.Date GetDictionaryValueAsDateTime(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsDateTime(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static java.util.Date GetDictionaryValueAsDateTime(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsDateTime(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static Double GetDictionaryValueAsDouble("
  public static Double GetDictionaryValueAsDouble(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsDouble(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static Double GetDictionaryValueAsDouble(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsDouble(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static Long GetDictionaryValueAsLong("
  public static Long GetDictionaryValueAsLong(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsLong(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static Long GetDictionaryValueAsLong(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsLong(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #region "public static String GetDictionaryValueAsString("
  public static String GetDictionaryValueAsString(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsString(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static String GetDictionaryValueAsString(CooDictionary cooDictionary, String stringKey, int inx) throws CooException
  {
    return CooValueAsString(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  
  // #region "public static String GetDictionaryValueAsStringNotNull("
  public static String GetDictionaryValueAsStringNotNull(CooDictionary cooDictionary, String stringKey) throws CooException
  {
    return CooValueAsStringNotNull(GetDictionaryValue(cooDictionary, stringKey));
  }
  
  public static String GetDictionaryValueAsStringNotNull(CooDictionary cooDictionary, String stringKey, int inx)
      throws CooException
  {
    return CooValueAsStringNotNull(GetDictionaryValue(cooDictionary, stringKey, inx));
  }
  
  // #endregion
  // #endregion
  public static CooObject GetObject(String stringCooAdr) throws CooException
  {
    if (!StringIsNullOrEmpty(stringCooAdr))
      return coort.GetObject(stringCooAdr);
    return null;
    
  }
  
  public static CooValue[] GetParameter(CooMethod coometh, int pos) throws CooException
  {
    if (IsNullOrDead(coometh))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return null;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return null;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // null;
    return coometh.GetParameter(pos);
  }
  
  public static CooValue[] GetParameter(CooMethod coometh, int pos, CooObject cooTypeDefinition) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return null;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(cooTypeDefinition.GetAddress()))
      return null;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return null;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return null;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return null;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // null;
    return coometh.GetParameter(pos, cooTypeDefinition);
  }
  
  // #region "GetParameter"
  // #region "GetParameterValue"
  public static CooValue GetParameterValue(CooMethod coometh, int pos) throws CooException
  {
    if (IsNullOrDead(coometh))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    if (!coometh.HasParameterValue(pos, 0))
      return null; // Y//,0
    if (null == coometh.GetParameter(pos))
      return null;
    if (null == coometh.GetParameterValue(pos))
      return null;
    return coometh.GetParameterValue(pos);
  }
  
  // public static CooValue[] GetParameter(CooMethod coometh, uint pos,
  // CooObject type)
  // {
  // if (IsNullOrDead(coometh) || IsNullOrDead(type)) return null;
  // if (!coometh.HasParameter(pos)) return null;
  // if
  // (!coometh.GetParameterTypeDefinition(pos).GetAddress().Equals(type.GetAddress()))
  // return null;
  // if (!coometh.HasParameter(pos, type)) return null;
  // if (!coometh.HasParameterValue(pos, type)) return null;
  // if (null == coometh.GetParameter(pos, type)) return null;
  // //if (null == coometh.GetParameterValue(pos, type)) return null;
  // //return coometh.GetParameterValue(pos, type);
  // return coometh.GetParameter(pos, type);
  // }
  
  public static CooValue GetParameterValue(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(type))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(type.GetAddress()))
      return null;
    if (!coometh.HasParameter(pos, type))
      return null;
    if (!coometh.HasParameterValue(pos, type))
      return null;
    if (null == coometh.GetParameter(pos, type))
      return null;
    if (null == coometh.GetParameterValue(pos, type))
      return null;
    return coometh.GetParameterValue(pos, type);
    // return coometh.GetParameter(pos, type);
  }
  
  public static CooValue GetParameterValue(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(type))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(type.GetAddress()))
      return null;
    if (!coometh.HasParameter(pos, type))
      return null;
    if (!coometh.HasParameterValue(pos, type))
      return null;
    if (!coometh.HasParameterValue(pos, type, inx))
      return null;
    if (null == coometh.GetParameter(pos))
      return null;
    if (null == coometh.GetParameter(pos, type))
      return null;
    // if (null == coometh.GetParameterValue(pos, type)) return null;
    return coometh.GetParameterValue(pos, type, inx);
  }
  
  // #endregion
  public static CooValue GetParameterValue(CooMethod coometh, int pos, int inx) throws CooException
  {
    if (IsNullOrDead(coometh))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    // if (!coometh.HasParameterValue(pos)) return null;
    if (!coometh.HasParameterValue(pos, inx))
      return null;
    if (null == coometh.GetParameter(pos))
      return null;
    if (null == coometh.GetParameterValue(pos))
      return null;
    if (null == coometh.GetParameterValue(pos, inx))
      return null;
    return coometh.GetParameterValue(pos, inx);
  }
  
  // #region "public static Boolean GetParameterValueAsBoolean("
  public static Boolean GetParameterValueAsBoolean(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsBoolean(GetParameterValue(coometh, pos));
  }
  
  public static Boolean GetParameterValueAsBoolean(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsBoolean(GetParameterValue(coometh, pos, type));
  }
  
  public static Boolean GetParameterValueAsBoolean(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsBoolean(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  
  // #region "public static CooAggregate GetParameterValueAsCooAggregate("
  public static CooAggregate GetParameterValueAsCooAggregate(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooAggregate(GetParameterValue(coometh, pos));
  }
  
  public static CooAggregate GetParameterValueAsCooAggregate(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooAggregate(GetParameterValue(coometh, pos, type));
  }
  
  public static CooAggregate GetParameterValueAsCooAggregate(CooMethod coometh, int pos, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsCooAggregate(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  
  public static CooAggregate GetParameterValueAsCooAggregate(CooMethod coometh, int pos, int inx) throws CooException
  {
    return CooValueAsCooAggregate(GetParameterValue(coometh, pos, inx));
  }
  
  // #region "public static CooBool GetParameterValueAsCooBool("
  public static CooBool GetParameterValueAsCooBool(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooBool(GetParameterValue(coometh, pos));
  }
  
  public static CooBool GetParameterValueAsCooBool(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooBool(GetParameterValue(coometh, pos, type));
  }
  
  public static CooBool GetParameterValueAsCooBool(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooBool(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooContent GetParameterValueAsCooContent("
  public static CooContent GetParameterValueAsCooContent(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooContent(GetParameterValue(coometh, pos));
  }
  
  public static CooContent GetParameterValueAsCooContent(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooContent(GetParameterValue(coometh, pos, type));
  }
  
  public static CooContent GetParameterValueAsCooContent(CooMethod coometh, int pos, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsCooContent(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooDateTime GetParameterValueAsCooDateTime("
  public static CooDateTime GetParameterValueAsCooDateTime(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooDateTime(GetParameterValue(coometh, pos));
  }
  
  public static CooDateTime GetParameterValueAsCooDateTime(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooDateTime(GetParameterValue(coometh, pos, type));
  }
  
  public static CooDateTime GetParameterValueAsCooDateTime(CooMethod coometh, int pos, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsCooDateTime(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooDictionary GetParameterValueAsCooDictionary("
  public static CooDictionary GetParameterValueAsCooDictionary(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooDictionary(GetParameterValue(coometh, pos));
  }
  
  public static CooDictionary GetParameterValueAsCooDictionary(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooDictionary(GetParameterValue(coometh, pos, type));
  }
  
  // //#region "public static CooUnknown GetParameterValueAsCooUnknown("
  // public static CooUnknown GetParameterValueAsCooUnknown(CooMethod coometh,
  // int pos) throws CooException
  // {
  // return CooValueAsCooUnknown(GetParameterValue(coometh, pos));
  // }
  // public static CooUnknown GetParameterValueAsCooUnknown(CooMethod coometh,
  // int pos, CooObject type) throws CooException
  // {
  // return CooValueAsCooUnknown(GetParameterValue(coometh, pos, type));
  // }
  // public static CooUnknown GetParameterValueAsCooUnknown(CooMethod coometh,
  // int pos, CooObject type, int inx) throws CooException
  // {
  // return CooValueAsCooUnknown(GetParameterValue(coometh, pos, type, inx));
  // }
  // //#endregion
  
  public static CooDictionary GetParameterValueAsCooDictionary(CooMethod coometh, int pos, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsCooDictionary(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooFloat GetParameterValueAsCooDouble("
  public static CooFloat GetParameterValueAsCooDouble(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooDouble(GetParameterValue(coometh, pos));
  }
  
  public static CooFloat GetParameterValueAsCooDouble(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooDouble(GetParameterValue(coometh, pos, type));
  }
  
  public static CooFloat GetParameterValueAsCooDouble(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooDouble(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #region "public static CooEnum GetParameterValueAsCooEnum("
  public static CooEnum GetParameterValueAsCooEnum(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooEnum(GetParameterValue(coometh, pos));
  }
  
  public static CooEnum GetParameterValueAsCooEnum(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooEnum(GetParameterValue(coometh, pos, type));
  }
  
  public static CooEnum GetParameterValueAsCooEnum(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooEnum(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static Long GetParameterValueAsCooEnumAsLong("
  public static Long GetParameterValueAsCooEnumAsLong(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetParameterValue(coometh, pos));
  }
  
  public static Long GetParameterValueAsCooEnumAsLong(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetParameterValue(coometh, pos, type));
  }
  
  public static Long GetParameterValueAsCooEnumAsLong(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #endregion
  // #region "public static CooFloat GetParameterValueAsCooFloat("
  public static CooFloat GetParameterValueAsCooFloat(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooFloat(GetParameterValue(coometh, pos));
  }
  
  public static CooFloat GetParameterValueAsCooFloat(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooFloat(GetParameterValue(coometh, pos, type));
  }
  
  public static CooFloat GetParameterValueAsCooFloat(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooFloat(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooInt GetParameterValueAsCooLong("
  public static CooInt GetParameterValueAsCooLong(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooLong(GetParameterValue(coometh, pos));
  }
  
  public static CooInt GetParameterValueAsCooLong(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooLong(GetParameterValue(coometh, pos, type));
  }
  
  public static CooInt GetParameterValueAsCooLong(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooLong(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static CooObject GetParameterValueAsCooObject("
  public static CooObject GetParameterValueAsCooObject(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsCooObject(GetParameterValue(coometh, pos));
  }
  
  public static CooObject GetParameterValueAsCooObject(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsCooObject(GetParameterValue(coometh, pos, type));
  }
  
  public static CooObject GetParameterValueAsCooObject(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooObject(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  
  // #region "public static Double GetParameterValueAsDouble("
  public static Double GetParameterValueAsDouble(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsDouble(GetParameterValue(coometh, pos));
  }
  
  public static Double GetParameterValueAsDouble(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsDouble(GetParameterValue(coometh, pos, type));
  }
  
  public static Double GetParameterValueAsDouble(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsDouble(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static Long GetParameterValueAsLong("
  // / <summary>
  // / GetParameterValueAsInt
  // / </summary>
  // / <param name="coometh"></param>
  // / <param name="pos"></param>
  // / <returns></returns>
  public static Long GetParameterValueAsLong(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsLong(GetParameterValue(coometh, pos));
  }
  
  public static Long GetParameterValueAsLong(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsLong(GetParameterValue(coometh, pos, type));
  }
  
  public static Long GetParameterValueAsLong(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsLong(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static String GetParameterValueAsString("
  public static String GetParameterValueAsString(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsString(GetParameterValue(coometh, pos));
  }
  
  public static String GetParameterValueAsString(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsString(GetParameterValue(coometh, pos, type));
  }
  
  // #endregion
  
  // #endregion
  
  // #region "GetVariable"
  
  public static String GetParameterValueAsString(CooMethod coometh, int pos, CooObject type, int inx) throws CooException
  {
    return CooValueAsString(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #region "public static String GetParameterValueAsStringNotNull("
  public static String GetParameterValueAsStringNotNull(CooMethod coometh, int pos) throws CooException
  {
    return CooValueAsStringNotNull(GetParameterValue(coometh, pos));
  }
  
  public static String GetParameterValueAsStringNotNull(CooMethod coometh, int pos, CooObject type) throws CooException
  {
    return CooValueAsStringNotNull(GetParameterValue(coometh, pos, type));
  }
  
  public static String GetParameterValueAsStringNotNull(CooMethod coometh, int pos, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsStringNotNull(GetParameterValue(coometh, pos, type, inx));
  }
  
  // #endregion
  // #endregion
  public static Integer GetParameterValueCount(CooMethod coometh, int pos) throws CooException
  {
    if (IsNullOrDead(coometh))
      return null;
    if (!coometh.HasParameter(pos))
      return null;
    if (!coometh.HasParameterValue(pos, 0))
      return null; // Y//,0
    if (null == coometh.GetParameter(pos))
      return null;
    if (null == coometh.GetParameterValue(pos))
      return null;
    return coometh.GetParameterValueCount(pos);
  }
  
  public static Integer GetParameterValueCount(CooMethod coometh, int pos, CooObject cooTypeDefinition) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return null;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return null;
    if (!coometh.HasParameterValue(pos, cooTypeDefinition))
      return null;
    if (null == coometh.GetParameter(pos, cooTypeDefinition))
      return null;
    if (null == coometh.GetParameterValue(pos, cooTypeDefinition))
      return null;
    return coometh.GetParameterValueCount(pos, cooTypeDefinition);
  }
  
  public static int GetParameterValueCountNotNull(CooMethod coometh, int pos) throws CooException
  {
    return IntegerNull2Zero(GetParameterValueCount(coometh, pos));
  }
  
  public static int GetParameterValueCountNotNull(CooMethod coometh, int pos, CooObject cooTypeDefinition) throws CooException
  {
    return IntegerNull2Zero(GetParameterValueCount(coometh, pos, cooTypeDefinition));
  }
  
//  public static CooObject GetTypeDefinition(String stringTypeDefinition) throws CooException
//  {
//    return GetAttrDef(stringTypeDefinition);
//  }
  
  // #region "GetVariable"
  // #region "GetVariableValue"
  public static CooValue[] GetVariable(CooObject swc, int id) throws CooException
  {
    return GetVariable(swc, id, null);
  }
  
  public static CooValue[] GetVariable(CooObject swc, int id, CooObject type) throws CooException
  {
    if (IsNullOrDead(swc))
      return null;
    if (IsNullOrDead(type))
    {
      if (!cootx.HasVariable(swc, id) || !cootx.HasVariableValue(swc, id))
        return null;
      return cootx.GetVariable(swc, id);
    }
    else
    {
      if (!cootx.HasVariable(swc, id, type))
        return null;
      return cootx.GetVariable(swc, id, type);
    }
  }
  
  public static CooValue GetVariableValue(CooObject swc, int id) throws CooException
  {
    return GetVariableValue(swc, id, null, null);
  }
  
  public static CooValue GetVariableValue(CooObject swc, int id, CooObject type) throws CooException
  {
    return GetVariableValue(swc, id, type, null);
  }
  
  public static CooValue GetVariableValue(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return GetVariableValue(swc, id, type, (Integer) inx);
  }
  
  private static CooValue GetVariableValue(CooObject swc, int id, CooObject type, Integer inx) throws CooException
  {
    if (IsNullOrDead(cootx) || IsNullOrDead(swc) || !cootx.HasVariable(swc, id) || !cootx.HasVariableValue(swc, id))
      return null;
    if (IsNullOrDead(type))
    {
      if (inx == null)
        return cootx.GetVariableValue(swc, id);
      if (!cootx.HasVariableValue(swc, id, (int) inx))
        return null;
      return cootx.GetVariableValue(swc, id, (int) inx);
    }
    else
    {
      if (!cootx.HasVariable(swc, id, type))
        return null;
      if (inx == null)
        return cootx.GetVariableValue(swc, id, type);
      if (!cootx.HasVariableValue(swc, id, type, (int) inx))
        return null;
      return cootx.GetVariableValue(swc, id, type, (int) inx);
    }
  }
  
  // #endregion
  
  public static CooValue GetVariableValue(CooObject swc, int id, int inx) throws CooException
  {
    return GetVariableValue(swc, id, (CooObject) null, inx);
  }
  
  // #region "public static Boolean GetVariableValueAsBoolean("
  public static Boolean GetVariableValueAsBoolean(CooObject swc, int id) throws CooException
  {
    return CooValueAsBoolean(GetVariableValue(swc, id));
  }
  
  public static Boolean GetVariableValueAsBoolean(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsBoolean(GetVariableValue(swc, id, type));
  }
  
  public static Boolean GetVariableValueAsBoolean(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsBoolean(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static Boolean GetVariableValueAsBoolean(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsBoolean(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooAggregate GetVariableValueAsCooAggregate("
  public static CooAggregate GetVariableValueAsCooAggregate(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooAggregate(GetVariableValue(swc, id));
  }
  
  public static CooAggregate GetVariableValueAsCooAggregate(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooAggregate(GetVariableValue(swc, id, type));
  }
  
  public static CooAggregate GetVariableValueAsCooAggregate(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooAggregate(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooAggregate GetVariableValueAsCooAggregate(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooAggregate(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooBool GetVariableValueAsCooBool("
  public static CooBool GetVariableValueAsCooBool(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooBool(GetVariableValue(swc, id));
  }
  
  public static CooBool GetVariableValueAsCooBool(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooBool(GetVariableValue(swc, id, type));
  }
  
  public static CooBool GetVariableValueAsCooBool(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooBool(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooBool GetVariableValueAsCooBool(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooBool(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooContent GetVariableValueAsCooContent("
  public static CooContent GetVariableValueAsCooContent(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooContent(GetVariableValue(swc, id));
  }
  
  public static CooContent GetVariableValueAsCooContent(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooContent(GetVariableValue(swc, id, type));
  }
  
  public static CooContent GetVariableValueAsCooContent(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooContent(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooContent GetVariableValueAsCooContent(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooContent(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooDateTime GetVariableValueAsCooDateTime("
  public static CooDateTime GetVariableValueAsCooDateTime(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooDateTime(GetVariableValue(swc, id));
  }
  
  public static CooDateTime GetVariableValueAsCooDateTime(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooDateTime(GetVariableValue(swc, id, type));
  }
  
  public static CooDateTime GetVariableValueAsCooDateTime(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooDateTime(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooDateTime GetVariableValueAsCooDateTime(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooDateTime(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooDictionary GetVariableValueAsCooDictionary("
  public static CooDictionary GetVariableValueAsCooDictionary(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooDictionary(GetVariableValue(swc, id));
  }
  
  public static CooDictionary GetVariableValueAsCooDictionary(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooDictionary(GetVariableValue(swc, id, type));
  }
  
  public static CooDictionary GetVariableValueAsCooDictionary(CooObject swc, int id, CooObject type, int inx)
      throws CooException
  {
    return CooValueAsCooDictionary(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooDictionary GetVariableValueAsCooDictionary(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooDictionary(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooFloat GetVariableValueAsCooDouble("
  public static CooFloat GetVariableValueAsCooDouble(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooDouble(GetVariableValue(swc, id));
  }
  
  public static CooFloat GetVariableValueAsCooDouble(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooDouble(GetVariableValue(swc, id, type));
  }
  
  public static CooFloat GetVariableValueAsCooDouble(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooDouble(GetVariableValue(swc, id, type, inx));
  }
  
  public static CooFloat GetVariableValueAsCooDouble(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooDouble(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooEnum GetVariableValueAsCooEnum("
  public static CooEnum GetVariableValueAsCooEnum(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooEnum(GetVariableValue(swc, id));
  }
  
  public static CooEnum GetVariableValueAsCooEnum(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooEnum(GetVariableValue(swc, id, type));
  }
  
  public static CooEnum GetVariableValueAsCooEnum(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooEnum(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooEnum GetVariableValueAsCooEnum(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooEnum(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static Long GetVariableValueAsCooEnumAsLong("
  public static Long GetVariableValueAsCooEnumAsLong(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetVariableValue(swc, id));
  }
  
  public static Long GetVariableValueAsCooEnumAsLong(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetVariableValue(swc, id, type));
  }
  
  public static Long GetVariableValueAsCooEnumAsLong(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static Long GetVariableValueAsCooEnumAsLong(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooEnumAsLong(GetVariableValue(swc, id, inx));
  }
  
  // #endregion
  // #region "public static CooFloat GetVariableValueAsCooFloat("
  public static CooFloat GetVariableValueAsCooFloat(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooFloat(GetVariableValue(swc, id));
  }
  
  public static CooFloat GetVariableValueAsCooFloat(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooFloat(GetVariableValue(swc, id, type));
  }
  
  public static CooFloat GetVariableValueAsCooFloat(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooFloat(GetVariableValue(swc, id, type, inx));
  }
  
  // public static CooUnknown GetVariableValueAsCooUnknown(
  // CooObject swc, int id) throws CooException
  // {
  // return CooValueAsCooUnknown(GetVariableValue(swc, id));
  // }
  // public static CooUnknown GetVariableValueAsCooUnknown(
  // CooObject swc, int id, CooObject type) throws CooException
  // {
  // return CooValueAsCooUnknown(GetVariableValue(swc, id, type));
  // }
  // public static CooUnknown GetVariableValueAsCooUnknown(
  // CooObject swc, int id, int inx) throws CooException
  // {
  // return CooValueAsCooUnknown(GetVariableValue(swc, id, inx));
  // }
  // public static CooUnknown GetVariableValueAsCooUnknown(
  // CooObject swc, int id, CooObject type, int inx) throws CooException
  // {
  // return CooValueAsCooUnknown(GetVariableValue(swc, id, type, inx));
  // }
  
  public static CooFloat GetVariableValueAsCooFloat(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooFloat(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooInt GetVariableValueAsCooLong("
  public static CooInt GetVariableValueAsCooLong(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooLong(GetVariableValue(swc, id));
  }
  
  public static CooInt GetVariableValueAsCooLong(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooLong(GetVariableValue(swc, id, type));
  }
  
  public static CooInt GetVariableValueAsCooLong(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooLong(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooInt GetVariableValueAsCooLong(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooLong(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static CooObject GetVariableValueAsCooObject("
  public static CooObject GetVariableValueAsCooObject(CooObject swc, int id) throws CooException
  {
    return CooValueAsCooObject(GetVariableValue(swc, id));
  }
  
  public static CooObject GetVariableValueAsCooObject(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsCooObject(GetVariableValue(swc, id, type));
  }
  
  public static CooObject GetVariableValueAsCooObject(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsCooObject(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  
  public static CooObject GetVariableValueAsCooObject(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsCooObject(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static String GetVariableValueAsString("
  public static String GetVariableValueAsString(CooObject swc, int id) throws CooException
  {
    return CooValueAsString(GetVariableValue(swc, id));
  }
  
  public static String GetVariableValueAsString(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsString(GetVariableValue(swc, id, type));
  }
  
  public static String GetVariableValueAsString(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsString(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  public static String GetVariableValueAsString(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsString(GetVariableValue(swc, id, inx));
  }
  
  // #region "public static String GetVariableValueAsStringNotNull("
  public static String GetVariableValueAsStringNotNull(CooObject swc, int id) throws CooException
  {
    return CooValueAsStringNotNull(GetVariableValue(swc, id));
  }
  
  public static String GetVariableValueAsStringNotNull(CooObject swc, int id, CooObject type) throws CooException
  {
    return CooValueAsStringNotNull(GetVariableValue(swc, id, type));
  }
  
  public static String GetVariableValueAsStringNotNull(CooObject swc, int id, CooObject type, int inx) throws CooException
  {
    return CooValueAsStringNotNull(GetVariableValue(swc, id, type, inx));
  }
  
  // #endregion
  // #endregion
  public static String GetVariableValueAsStringNotNull(CooObject swc, int id, int inx) throws CooException
  {
    return CooValueAsStringNotNull(GetVariableValue(swc, id, inx));
  }
  
  // #endregion
  
  public static Integer GetVariableValueCount(CooObject swc, int id) throws CooException
  {
    return GetVariableValueCount(swc, id, (CooObject) null);
  }
  
  public static Integer GetVariableValueCount(CooObject swc, int id, CooObject type) throws CooException
  {
    if (IsNullOrDead(cootx) || IsNullOrDead(swc) || !cootx.HasVariable(swc, id) || !cootx.HasVariableValue(swc, id))
      return null;
    
    if (IsNullOrDead(type))
      return cootx.GetVariableValueCount(swc, id);
    if (!cootx.HasVariable(swc, id, type) || !cootx.HasVariableValue(swc, id, type))
      return null;
    return cootx.GetVariableValueCount(swc, id, type);
  }
  
  public static int GetVariableValueCountNotNull(CooObject swc, int id) throws CooException
  {
    return IntegerNull2Zero(GetVariableValueCount(swc, id, (CooObject) null));
  }
  
  public static int GetVariableValueCountNotNull(CooObject swc, int id, CooObject type) throws CooException
  {
    return IntegerNull2Zero(GetVariableValueCount(swc, id, type));
  }
  
  public static Boolean IsLocked(CooObject cooObject) throws CooException
  {
    if (IsNullOrDead(cooObject))
      return null;

    sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object object
      = sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object.from(cooObject);

//    object.SYS_ObjectLockRefresh();
    
    return (
        null != object.SYS_objlock  
        && null != object.SYS_objlock.SYS_objlocked 
        && object.SYS_objlock.SYS_objlocked.booleanValue() == true
        );
  }
  
  public static boolean IsNullOrDead(CooMethod coometh) throws CooException
  {
    return IsNullOrDead(CooValue.asValue(coometh));
  }
  
  public static boolean IsNullOrDead(CooObject cooObject) throws CooException
  {
    return IsNullOrDead(CooValue.asValue(cooObject));
  }
  
  public static boolean IsNullOrDead(CooTransaction cootx) throws CooException
  {
    return IsNullOrDead(CooValue.asValue(cootx));
  }
  
  public static boolean IsNullOrDead(CooValue cooValue) throws CooException
  {
    if (cooValue == null)
      return true;
    switch (cooValue.getType())
    {
      case CooValue.OBJECT:
        return !cooValue.getObject().HasClass(SYS.getClass_Object());
      default:
        return false;
    }
  }

  public static boolean ObjectLockTry(CooObject cooObject) throws CooException
  {
    try
    {
      // --------------------------------------------------------------------------------
      if (IsNullOrDead(cooObject))
        return false;
      // --------------------------------------------------------------------------------
      if (cootx.IsCreated(cooObject))
        return true;
      // --------------------------------------------------------------------------------
      sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object object
        = sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object.from(cooObject);

      object.SYS_ObjectLock(false, true, (long) 5000, false);
      return true;
    }
    catch (Exception exception)
    {
      TraceCatch(exception);
      return false;
    }
  }
  
  public static boolean ObjectUnLockTry(CooObject cooObject) throws CooException
  {
    try
    {
      // --------------------------------------------------------------------------------
      if (IsNullOrDead(cooObject))
        return false;
      // --------------------------------------------------------------------------------
      if (cootx.IsCreated(cooObject))
        return true;
      // --------------------------------------------------------------------------------
      sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object object
        = sk.dwcslovakia.skwsadmin.generated.SYS.classes.Object.from(cooObject);

//      object.SYS_ObjectLockRefresh();
      
      if(! IsLocked(object)) return true;      
      
      object.SYS_ObjectUnlock(false);
//      object.SYS_ObjectUnlockPermanent();
      return (!Class_Coo.IsLocked(object));
    }
    catch (Exception exception)
    {
      TraceCatch(exception);
      return false;
    }
  }

  // #endregion
  public static boolean ObjectLockWithWait(CooObject cooObject) throws CooException
  {
    return ObjectLockWithWait(cooObject, finalIntObjectLockSeconds);
  }
  
  public static boolean ObjectLockWithWait(CooObject[] cooObjectArray) throws CooException
  {
    return ObjectLockWithWait(cooObjectArray, finalIntObjectLockSeconds);
  }
  
  public static boolean ObjectLockWithWait(CooObject[] cooObjectArray, int intSeconds) throws CooException
  {
    if (cooObjectArray == null)
      return true;
    boolean booleanreturn = true;
    for (CooObject cooObject : cooObjectArray)
    {
      booleanreturn &= ObjectLockWithWait(cooObject, intSeconds);
    }
    return booleanreturn;
  }
  
  public static boolean ObjectLockWithWait(CooObject cooObject, int intSeconds) throws CooException
  {
    try
    {
      if (IsNullOrDead(cooObject))
        return false;
      // --------------------------------------------------------------------------------
      if (cootx.IsCreated(cooObject))
        return true;
      // --------------------------------------------------------------------------------
      //java.util.Date dateTimeMax = new java.util.Date(); // DateTime.Now.AddSeconds(intSeconds);
      java.util.Calendar calendar = java.util.Calendar.getInstance();
      calendar.setTime(new java.util.Date());
      calendar.add(java.util.Calendar.SECOND, intSeconds);
      java.util.Date dateTimeMax = calendar.getTime(); 
      do
      {
        // --------------------------------------------------------------------------------
        if (ObjectLockTry(cooObject))
          return true;
        // --------------------------------------------------------------------------------
        // Èakaj ak je zamknuty
        Thread.sleep(1000);
      } while (dateTimeMax.after(new java.util.Date())); 
      return false;
    }
    catch (Exception exception)
    {
      TraceCatch(exception);
      return false;
    }
  }
  
  public static String SearchInputFormat(CooValue cooValue) throws CooException
  {
    // return SearchInputFormat(GetAttributeValueAsString(cooObject, cootx,
    // CooAttributeDefinition.objaddress));
    if (cooValue == null)
      return " null ";
    switch (cooValue.getType())
    {
      //case CooValue.AGGREGATE:
      case CooValue.BOOL:
        if(
            null == cooValue.getBool()
            || !cooValue.getBool().isValid()
            )
          break;
        return SearchInputFormat(cooValue.getBool().getValue());
      //case CooValue.CONTENT:
      case CooValue.DATETIME:
        if(
            null == cooValue.getDateTime()
            || !cooValue.getDateTime().isValid()
            )
          break;
        return SearchInputFormat(cooValue.getDateTime().getValue());

      //case CooValue.DICTIONARY:
      case CooValue.ENUM:
        if(
            null == cooValue.getEnum()
            || !cooValue.getEnum().isValid()
            )
          break;
        return SearchInputFormat(cooValue.getEnum().getValue());
      case CooValue.FLOAT:
        if(
            null == cooValue.getFloat()
            || !cooValue.getFloat().isValid()
            )
          break;
        return SearchInputFormat(cooValue.getFloat().getValue());
      case CooValue.INTEGER:
        if(
            null == cooValue.getInteger()
            || !cooValue.getInteger().isValid()
            )
          break;
        return SearchInputFormat(cooValue.getInteger().getValue());
//      case CooValue.INTERFACE:
      case CooValue.OBJECT:
        return SearchInputFormat(cooValue.getObject());
      case CooValue.STRING:
        return SearchInputFormat(cooValue.getString());
      //case CooValue.VOID:
      //default:
    }
    return " null ";
  }
  
  public static String SearchInputFormat(Boolean bool) throws CooException
  {
    // return SearchInputFormat(GetAttributeValueAsString(cooObject, cootx,
    // CooAttributeDefinition.objaddress));
    if (bool == null)
      return " null ";
    else if(bool)
    {
      return " true ";
    }else{
      return " false ";
    }
  }

  //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
  public static final java.text.SimpleDateFormat simpleDateFormat4Database 
    = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public static String SearchInputFormat(java.util.Date date) throws CooException
  {
    if (date == null)
      return " null ";
    
    return " " + simpleDateFormat4Database.format(date) + " ";
  }

  static java.text.DecimalFormat decimalFormat4Database = null;
  public static java.text.DecimalFormat GetDecimalFormat4Database(){
    if(null!=decimalFormat4Database)
      return decimalFormat4Database;
    
    java.text.DecimalFormatSymbols decimalFormatSymbols = new java.text.DecimalFormatSymbols(); //currentLocale);
    decimalFormatSymbols.setDecimalSeparator(',');
    decimalFormatSymbols.setGroupingSeparator(' ');
    
    decimalFormat4Database = new java.text.DecimalFormat(); //formatString, decimalFormatSymbols);
    decimalFormat4Database.setDecimalFormatSymbols(decimalFormatSymbols);
    decimalFormat4Database.setGroupingUsed(false);
      
    return decimalFormat4Database;
  } 
  
  public static String SearchInputFormat(Double doubleValue) throws CooException
  {
    if (doubleValue == null)
      return " null ";
    
    return " " + GetDecimalFormat4Database().format(doubleValue) + " ";
  }
  
  public static String SearchInputFormat(CooObject cooObject) throws CooException
  {
    if (cooObject == null)
      return " null ";
    return " " + cooObject.GetAddress() + " ";
  }
  
  // #endregion
  
  public static String SearchInputFormat(Integer intValue)
  {
    if (intValue == null)
      return " null ";
    String stringValue = " " + intValue.toString() + " ";
    return stringValue;
  }
  
  @Deprecated
  public static String SearchInputFormat(Long longValue)
  {
    if (longValue == null)
      return " null ";
    String stringValue = " " + longValue.toString() + " ";
    return stringValue;
  }
  
  // #region "SearchInputFormat"
  public static String SearchInputFormat(String stringValue)
  {
    if (stringValue == null)
      return " null ";

    stringValue = " \"" + SearchInputFormatPart( stringValue ) + "\" ";
    return stringValue;
  }
  
  public static String SearchInputFormatPart(String stringValue)
  {
    if (stringValue == null)
      return " null ";

    stringValue = stringValue.replace("\\", "\\\\");
    stringValue = stringValue.replace("\"", "\"\"");
    return stringValue;
  }
  
  // #if useEventLog
  public static CooObject[] SearchObjects(EventLog eventLog, String stringSearchObjects, String stringDescription)
      throws CooException
  {
    if (eventLog != null)
      eventLog.debug("stringSearchObjects " + stringDescription + " " + stringSearchObjects);
    
    return SearchObjects(stringSearchObjects, stringDescription);
    // return coort.SearchObjects(cootx, stringSearchObjects);
  }
  
  // Y//2014-01-01 END
  // #region "SearchObjects"
  public static CooObject[] SearchObjects(String stringSearchObjects) throws CooException
  {
    // Variable(true, "stringSearchObjects", stringSearchObjects);
    return coort.SearchObjects(cootx, stringSearchObjects);
  }
  
  // #endif
  public static CooObject[] SearchObjects(String stringSearchObjects, String stringDescription) throws CooException
  {
    // #if DEBUG
    Trace(true, "stringSearchObjects " + stringDescription + " " + stringSearchObjects);
    // #endif
    return coort.SearchObjects(cootx, stringSearchObjects);
  }
  
  // #endregion
  // #if useEventLog
  public static CooSearchResult SearchObjectsAsync(EventLog eventLog, String stringSearchObjects, String stringDescription)
      throws CooException
  {
    if (eventLog != null)
      eventLog.debug("stringSearchObjects " + stringDescription + " " + stringSearchObjects);
    
    return SearchObjectsAsync(stringSearchObjects, stringDescription);
  }
  
  public static CooSearchResult SearchObjectsAsync(String stringSearchObjects) throws CooException
  {
    // Variable(true, "stringSearchObjects", stringSearchObjects);
    return coort.SearchObjectsAsync(cootx, stringSearchObjects);
  }
  
  // #endif
  public static CooSearchResult SearchObjectsAsync(String stringSearchObjects, String stringDescription) throws CooException
  {
    // #if DEBUG
    Trace(true, "stringSearchObjects " + stringDescription + " " + stringSearchObjects);
    // #endif
    return coort.SearchObjectsAsync(cootx, stringSearchObjects);
  }
  
  // #if useEventLog
  public static CooValue[] SearchValues(EventLog eventLog, String stringSearchObjects, String stringDescription) throws CooException
  {
    return CastAsCooValueArray(SearchObjects(eventLog, stringSearchObjects, stringDescription));
  }
  
  // #endif
  public static CooValue[] SearchValues(String stringSearchObjects, String stringDescription) throws CooException
  {
    return CastAsCooValueArray(SearchObjects(stringSearchObjects, stringDescription));
  }
  
  // #region "SetAttribute"
  public static boolean SetAttribute(
      boolean booleanSetNull,
      CooValue cooValue,
      AttributeDefinition AttrDef,
      CooValue[] cooValueArrayValue) throws CooException
  {
    //cooValueArrayValue = CooValueArrayRemoveNullItems(cooValueArrayValue);
    if (IsNullOrDead(cooValue)
        || IsNullOrDead(AttrDef)
        || (cooValue.getType() == CooValue.AGGREGATE && !cooValue.getAggregate().HasAttribute(AttrDef))
        || (cooValue.getType() == CooValue.OBJECT && !cooValue.getObject().HasAttribute(cootx, AttrDef)))
      return false;
    if (!booleanSetNull && cooValueArrayValue == null)
      return true;
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
        cooValue.getAggregate().SetAttribute(AttrDef, cooValueArrayValue);
        return true;
      case CooValue.OBJECT:
        ObjectLockWithWait(cooValue.getObject());
        cooValue.getObject().SetAttribute(cootx, AttrDef, cooValueArrayValue);
        return true;
      default:
        return false;
    }
  }
  
  // #region "SetAttribute"
  // #region "SetAttributeValue"
  public static boolean SetAttributeValue(
      boolean booleanSetNull,
      CooValue cooValue,
      AttributeDefinition AttrDef,
      CooValue cooValueValue) throws CooException
  {
    return SetAttributeValue(booleanSetNull, cooValue, AttrDef, null, cooValueValue);
  }
  
  public static boolean SetAttributeValue(
      boolean booleanSetNull,
      CooValue cooValue,
      AttributeDefinition AttrDef,
      int inx,
      CooValue cooValueValue) throws CooException
  {
    return SetAttributeValue(booleanSetNull, cooValue, AttrDef, (Integer) inx, cooValueValue);
  }
  
  private static boolean SetAttributeValue(
      boolean booleanSetNull,
      CooValue cooValue,
      AttributeDefinition AttrDef,
      Integer inx,
      CooValue cooValueValue) throws CooException
  {
    if (IsNullOrDead(cooValue)
        || IsNullOrDead(AttrDef)
        || (cooValue.getType() == CooValue.AGGREGATE && !cooValue.getAggregate().HasAttribute(AttrDef))
        || (cooValue.getType() == CooValue.OBJECT && !cooValue.getObject().HasAttribute(cootx, AttrDef)))
      return false;
    if (!booleanSetNull && (cooValueValue == null || cooValueValue.getType() == CooValue.VOID))
      return true;
    switch (cooValue.getType())
    {
      case CooValue.AGGREGATE:
        if (inx != null)
          cooValue.getAggregate().SetAttributeValue(AttrDef, (Integer) inx, cooValueValue);
        else
          cooValue.getAggregate().SetAttributeValue(AttrDef, cooValueValue);
        return true;
      case CooValue.OBJECT:
        ObjectLockWithWait(cooValue.getObject());
        if (inx != null)
          cooValue.getObject().SetAttributeValue(cootx, AttrDef, (Integer) inx, cooValueValue);
        else
          cooValue.getObject().SetAttributeValue(cootx, AttrDef, cooValueValue);
        return true;
      default:
        return false;
    }
  }
  
  // #endregion
  
  public static boolean SetParameter(
      boolean booleanSetNull,
      CooMethod coometh,
      int pos,
      CooObject cooTypeDefinition,
      CooValue[] value) throws CooException
  {
    //value = CooValueArrayRemoveNullItems(value);
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return false;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(cooTypeDefinition.GetAddress()))
      return false;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return false;
    if (!booleanSetNull && value == null)
      return true;
    coometh.SetParameter(pos, cooTypeDefinition, value);
    return true;
  }
  
  public static boolean SetParameter(boolean booleanSetNull, CooMethod coometh, int pos, CooValue[] value) throws CooException
  {
    return SetParameter(booleanSetNull, coometh, pos, coometh.GetParameterTypeDefinition(pos), value);
  }
  
  // #region Set
  // public static boolean SetParameterValue(boolean booleanSetNull, CooMethod
  // coometh, uint pos, CooValue value)
  // {
  // if (IsNullOrDead(coometh) ) return false;
  // if (!coometh.HasParameter(pos)) return false;
  // //if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return false;
  // //if (inx != null && !coometh.HasParameterValue(pos, cooTypeDefinition,
  // (uint)inx)) return false;
  // //if (null == coometh.GetParameter(pos, cooTypeDefinition)) return false;
  // //if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
  // false;
  // //if (inx != null && null == coometh.GetParameterValue(pos,
  // cooTypeDefinition, (uint)inx)) return false;
  // if (
  // !booleanSetNull
  // && (
  // value == null
  // || value.Type == CooValue.CooType.VOID
  // )
  // ) return true;
  // coometh.SetParameterValue(pos, value);
  // return true;
  // }
  public static boolean SetParameterValue(
      boolean booleanSetNull,
      CooMethod coometh,
      int pos,
      CooObject cooTypeDefinition,
      CooValue value) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return false;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(cooTypeDefinition.GetAddress()))
      return false;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return false;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return false;
    // if (inx != null && !coometh.HasParameterValue(pos, cooTypeDefinition,
    // (uint)inx)) return false;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return false;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // false;
    // if (inx != null && null == coometh.GetParameterValue(pos,
    // cooTypeDefinition, (uint)inx)) return false;
    if (!booleanSetNull && (value == null || value.getType() == CooValue.VOID))
      return true;
    coometh.SetParameterValue(pos, cooTypeDefinition, value);
    return true;
  }
  
  public static boolean SetParameterValue(
      boolean booleanSetNull,
      CooMethod coometh,
      int pos,
      CooObject cooTypeDefinition,
      int inx,
      CooValue value) throws CooException
  {
    if (IsNullOrDead(coometh) || IsNullOrDead(cooTypeDefinition))
      return false;
    if (!coometh.GetParameterTypeDefinition(pos).GetAddress().equals(cooTypeDefinition.GetAddress()))
      return false;
    if (!coometh.HasParameter(pos, cooTypeDefinition))
      return false;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return false;
    // if (inx != null && !coometh.HasParameterValue(pos, cooTypeDefinition,
    // (uint)inx)) return false;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return false;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // false;
    // if (inx != null && null == coometh.GetParameterValue(pos,
    // cooTypeDefinition, (uint)inx)) return false;
    if (!booleanSetNull && (value == null || value.getType() == CooValue.VOID))
      return true;
    coometh.SetParameterValue(pos, cooTypeDefinition, inx, value);
    return true;
  }
  
  public static boolean SetParameterValue(boolean booleanSetNull, CooMethod coometh, int pos, CooValue value)
      throws CooException
  {
    if (IsNullOrDead(coometh))
      return false;
    
    if (value == null)
    {
      if (booleanSetNull)
        coometh.ClearParameter(pos);
      return true;
    }
    
    // if (!coometh.HasParameter(pos)) return false;
    
    if (!booleanSetNull && (value == null || value.getType() == CooValue.VOID))
      return true;
    
    if (null != coometh.GetParameterTypeDefinition(pos))
    {
      coometh.SetParameterValue(pos, coometh.GetParameterTypeDefinition(pos), value);
      return true;
    }
    
    coometh.SetParameterValue(pos, GetCooTypeDefinition(value), value);
    return true;
  }
  
  public static boolean SetParameterValue(boolean booleanSetNull, CooMethod coometh, int pos, int inx, CooValue value)
      throws CooException
  {
    if (IsNullOrDead(coometh))
      return false;
    if (!coometh.HasParameter(pos))
      return false;
    // if (!coometh.HasParameterValue(pos, cooTypeDefinition)) return false;
    // if (inx != null && !coometh.HasParameterValue(pos, cooTypeDefinition,
    // (uint)inx)) return false;
    // if (null == coometh.GetParameter(pos, cooTypeDefinition)) return false;
    // if (null == coometh.GetParameterValue(pos, cooTypeDefinition)) return
    // false;
    // if (inx != null && null == coometh.GetParameterValue(pos,
    // cooTypeDefinition, (uint)inx)) return false;
    if (!booleanSetNull && (value == null || value.getType() == CooValue.VOID))
      return true;
    coometh.SetParameterValue(pos, coometh.GetParameterTypeDefinition(pos), inx, value);
    return true;
  }
  
  // #region Set
  public static boolean SetVariable(CooObject swc, int id, CooObject type, CooValue[] list) throws CooException
  {
    //list = CooValueArrayRemoveNullItems(list);
    if (IsNullOrDead(cootx) || IsNullOrDead(swc) || IsNullOrDead(type))
      return false;
    cootx.SetVariable(swc, id, type, list);
    return true;
  }
  
  public static boolean SetVariableValue(boolean booleanSetNull, CooObject swc, int id, CooObject type, CooValue value)
      throws CooException
  {
    return SetVariableValue(booleanSetNull, swc, id, type, (Integer) null, value);
  }
  
  public static
      boolean
      SetVariableValue(boolean booleanSetNull, CooObject swc, int id, CooObject type, int inx, CooValue value)
          throws CooException
  {
    return SetVariableValue(booleanSetNull, swc, id, type, (Integer) inx, value);
  }
  
  private static boolean SetVariableValue(
      boolean booleanSetNull,
      CooObject swc,
      int id,
      CooObject type,
      Integer inx,
      CooValue value) throws CooException
  {
    if (IsNullOrDead(cootx) || IsNullOrDead(swc) || IsNullOrDead(type))
      return false;
    if (!booleanSetNull && (value == null || value.getType() == CooValue.VOID))
      return true;
    
    if (inx == null)
    {
      cootx.SetVariableValue(swc, id, type, value);
    }
    else
    {
      cootx.SetVariableValue(swc, id, type, (int) inx, value);
    }
    return true;
  }
  
  // //#region "public static CooUnknown GetDictionaryValueAsCooUnknown("
  // public static CooUnknown GetDictionaryValueAsCooUnknown(CooDictionary
  // cooDictionary, String stringKey) throws CooException
  // {
  // return CooValueAsCooUnknown(GetDictionaryValue(cooDictionary, stringKey));
  // }
  // public static CooUnknown GetDictionaryValueAsCooUnknown(CooDictionary
  // cooDictionary, String stringKey, int inx) throws CooException
  // {
  // return CooValueAsCooUnknown(GetDictionaryValue(cooDictionary, stringKey,
  // inx));
  // }
  // //#endregion
  
  private static boolean StringIsNullOrEmpty(String string)
  {
    return (string == null || string.length() == 0);
  }
  
  public static String StringMethodName()
  {
    return StringMethodName(1);
  }
  
  public static String StringMethodName(int intI)
  {
    // //StackTrace stackTrace = new StackTrace(true);
    // ////StackFrame stackFrame = stackTrace.GetFrame(stackTrace.FrameCount -
    // 2);
    // //StackFrame stackFrame = stackTrace.GetFrame(1 + Math.Abs(intI));
    // //MethodBase methodBase = stackFrame.GetMethod();
    // //return methodBase.Name;
    //
    // intI++;
    //
    // string stringReturn = "|";
    // System.Diagnostics.StackTrace stackTrace = new
    // System.Diagnostics.StackTrace(true);
    // foreach (System.Diagnostics.StackFrame stackFrame in
    // stackTrace.GetFrames())
    // {
    // if (string.IsNullOrEmpty(stackFrame.GetFileName()))
    // continue;
    //
    // if (intI-- > 0)
    // continue;
    //
    // System.Reflection.MethodBase methodBase = stackFrame.GetMethod();
    //
    // if (methodBase.Name.Equals(".ctor"))
    // continue;
    //
    // stringReturn
    // = "|"
    // + methodBase.DeclaringType.FullName
    // + "."
    // + methodBase.Name
    // + stringReturn;
    // }
    // return stringReturn;
    return "";
  }
  
  // #endregion
  // #region CooValueAS
  public static String StringNull2Empty(String stringValue)
  {
    if (StringIsNullOrEmpty(stringValue))
      return finalStringEmpty;
    return stringValue;
  }
  public static int IntegerNull2Zero(Integer integer)
  {
    if (null == integer)
      return 0;
    return integer.intValue();
  }
  
  // #region COORT
  // //private static void RtSetError( boolean booleanDebug , string Exception
  // ex )
  // public static void SetError(string CooObjectClass_ErrorMessage, string
  // errortext)
  // {
  // coort.Trace(DLL_NAME + stringMethodName() +
  // " SetError: CooObjectClass.ErrorMessage = " + CooObjectClass_ErrorMessage);
  // coort.Trace(DLL_NAME + stringMethodName() + " SetError: errortext = " +
  // errortext);
  // coort.SetError(coort.GetComponentObject(CooObjectClass.ErrorMessage,
  // CooObjectClass_ErrorMessage), errortext);
  // }
  // //private static void RtSetError( boolean booleanDebug , string Exception
  // ex )
  // public static void SetError(string CooObjectClass_ErrorMessage)
  // {
  // coort.Trace(DLL_NAME + stringMethodName() +
  // " SetError: CooObjectClass.ErrorMessage = " + CooObjectClass_ErrorMessage);
  // coort.SetError(coort.GetComponentObject(CooObjectClass.ErrorMessage,
  // CooObjectClass_ErrorMessage));
  // }
  // //private static void RtSetError( boolean booleanDebug , string Exception
  // ex )
  // public static void SetError(Exception ex)
  // {
  // coort.Trace(DLL_NAME + stringMethodName() + " - SetError: " +
  // ex.ToString());
  // coort.SetError(coort.GetComponentObject(CooObjectClass.ErrorMessage,
  // "COOSYSTEM@1.1:COOSTERR_UNKNOWN"), ex.Message);
  // }
  public static void Trace(boolean booleanDebug, String sTrace) throws CooException
  {
    // #if !DEBUG
    if (!booleanDebug)
      return;
    // #endif
    coort.Trace(DLL_NAME + StringMethodName() + ": " + sTrace);
  }
  
  public static void TraceCatch(Exception exception) throws CooException
  {
    // coort.Trace(DLL_NAME + stringMethodName() + " Trace Catch " +
    // exception.GetType().ToString() + " exception.Message = '" +
    // exception.Message + "'");
    coort.Trace(DLL_NAME
        + StringMethodName()
        + " Trace Catch "
        + exception.getLocalizedMessage()
        + " exception.Message = '"
        + exception.getMessage()
        + "'");
  }
  
  public static void TraceCatch(Exception exception, String stringTrace) throws CooException
  {
    // coort.Trace(DLL_NAME + stringMethodName() + " Trace: '" + stringTrace +
    // "' Catch " + exception.GetType().ToString() + " exception.Message = '" +
    // exception.Message + "'");
    coort.Trace(DLL_NAME
        + StringMethodName()
        + " Trace: '"
        + stringTrace
        + "' Catch "
        + exception.getLocalizedMessage()
        + " exception.Message = '"
        + exception.getMessage()
        + "'");
  }
  
  public static void Variable(boolean booleanDebug, String sVariable, String sValue) throws CooException
  {
    // #if !DEBUG
    if (!booleanDebug)
      return;
    // #endif
    coort.Trace(DLL_NAME + StringMethodName() + " Variable: " + sVariable + " = '" + sValue + "'");
  }
  
  public static javax.xml.datatype.XMLGregorianCalendar GetXMLGregorianCalendar(
      EventLog eventLog, 
      java.util.Date date
      ) throws javax.xml.datatype.DatatypeConfigurationException, CooException
	{
		if (null == date)
			return null;
		
		java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar();
		gregorianCalendar.setTime(date);
		javax.xml.datatype.XMLGregorianCalendar xmlGregorianCalendar 
		  = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		
//		if (getBoolTimeZoneRemove(eventLog))
//			xmlGregorianCalendar.setTimezone(0);
		
		return xmlGregorianCalendar;
	}
	
  public static java.util.Date GetDate(
      EventLog eventLog, 
      javax.xml.datatype.XMLGregorianCalendar xmlGregorianCalendar
      ) throws javax.xml.datatype.DatatypeConfigurationException, CooException
	{
		if (null == xmlGregorianCalendar)
			return null;
		
//		if (getBoolTimeZoneRemove(eventLog))
//			xmlGregorianCalendar.setTimezone(0);
		
		return xmlGregorianCalendar.toGregorianCalendar().getTime();
	}  

  /**
   * getAttributeString nacitanie jazikoveho rekladu z rs
   * @param string SKWSADM.getString_StrErrMsg()
   * @return
   * @throws CooException
   */
  private static String GetAttributeString(sk.dwcslovakia.skwsadmin.generated.SYS.classes.String string) throws CooException
  {
    return string.GetAttributeString(SYS.getProperty_string());
  }
  
  public static Exception exceptionMessageFormat(
      EventLog eventLog,
      sk.dwcslovakia.skwsadmin.generated.SYS.classes.String stringMessage, 
      String...stringArray
      ) throws CooException
  {
    String stringMessageFormat = stringMessageFormat(stringMessage, stringArray);
    eventLog.error("1","ERROR", stringMessageFormat);
    return new Exception(stringMessageFormat);
  }

  public static String stringMessageFormat(
      sk.dwcslovakia.skwsadmin.generated.SYS.classes.String stringMessage, 
      String...stringArray
      ) throws CooException  
  {
    if(null==stringMessage)
      return "No Input for MessageFormat";
    
    String stringMessageValue = Class_Coo.GetAttributeString(stringMessage);
    
    if(
        null==stringMessageValue
        )
      return "No Input for MessageFormat " + stringMessage.GetAddress();
    
    try
    {
      java.text.MessageFormat messageFormat = new java.text.MessageFormat(stringMessageValue);
//      return messageFormat.format(stringArray);
      String stringReturn = messageFormat.format(stringArray);
      if(
          null!=stringReturn 
          && null!=stringArray
          )
      for(int intI=0;intI<stringArray.length;intI++) // (String string : stringArray)
      {
        String stringReplace = stringArray[intI];
        if(null==stringReplace) stringReplace=finalStringEmpty;
        stringReturn = stringReturn .replace("{"+String.valueOf(intI)+"}", stringReplace);
      }
      return stringReturn ;
    }
    catch(Exception exception)
    {
      return stringMessageValue;
    }
  }
  
}
