package com.zhafei.onlymihan_scc.system.utils;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import org.apache.log4j.Logger;

public class StrUtil {

	static Logger log = Logger.getLogger(StrUtil.class);
	private static String varStr = "@";

	/**
	 * 根据传入字符串，返回整数类型，出错时放回0
	 * @param value
	 * @return
	 */
	public static int getNotNullIntValue(String value) {
		int i = 0;
		try {
			i = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// log.warn(paramString + "转换为整数错误" + e.getMessage(),e);
			i = 0;
		}
		return i;
	}

	
	/**
	 * 根据传入字符串，返回整数类型，出错时放回0
	 * @param value
	 * @param defultValue 为0返回值
	 * @return
	 */
	public static int getNotNullIntValue(String value, int defultValue) {
		int i = getNotNullIntValue(value);
		if (i == 0) {
			i = defultValue;
		}
		return i;
	}

	/**
	 * 根据日期格式返回日期对象，日期为空返回系统时间
	 * @param dateStr 日期格式字符串
	 * @param dateFormat 
	 * 		日期格式化 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Timestamp getNotNullTimestampValue(String dateStr,String dateFormat) {
		Timestamp result;
		try {
			if ((null == dateStr) || (dateStr.equals(""))) {
				result = new Timestamp(System.currentTimeMillis());
			} else {
				SimpleDateFormat df = new SimpleDateFormat(dateFormat);
				result = new Timestamp(df.parse(dateStr).getTime());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = new Timestamp(System.currentTimeMillis());
		}
		return result;
	}
  
  /**
   * 获得字符串值，value值为空或或去掉空格等于“”时返回defultValue值
   * @param value 原字符串值
   * @param defultValue 为空返回值
   * @return
   */
	public static String getNotNullStringValue(String value, String defultValue) {
		String str = value;
		if ((value == null) || (value.trim().equals(""))) {
			str = defultValue;
		}
		return str;
	}
  
  /**
   * 获得字符串值，value值为空或去掉空格等于“”时返回“”值
   * @param value 原字符串值
   * @return
   */
	public static String getNotNullStringValue(String value) {
		String str = value;
		if ((value == null) || (value.trim().equals(""))) {
			return "";
		}
		return str;
	}

	
	public static boolean isNumber(String value) {
		boolean bool = true;
		try {
			int i = Integer.parseInt(value.trim());
			if (i < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return bool;
	}
  
	public static boolean isFloat(String value) {
		boolean bool = true;
		try {
			float f = Float.parseFloat(value.trim());
			if (f < 0.0F) {
				return false;
			}
		} catch (NumberFormatException localNumberFormatException) {
			return false;
		}
		return bool;
	}
	
  /**
   * 字符串替换程序
   * @param oldString 原有字符串值
   * @param sourcestr 要被替换的字段值
   * @param repstr    替换字符
   * @return
   */
	public static String replaceAll(String oldString, String sourcestr,
			String repstr) {
		// log.info(oldString);
		// log.info(sourcestr + " 替换成 " + repstr);
		if (oldString == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		int i = oldString.length();
		int j = sourcestr.length();
		int m;
		int k = 0;
		for (k = 0; (m = oldString.indexOf(sourcestr, k)) >= 0; k = m + j) {
			sb.append(oldString.substring(k, m));
			sb.append(repstr);
		}
		if (k < i) {
			sb.append(oldString.substring(k));
		}

		// log.info(sb.toString());
		return sb.toString();
	}
  
  
  /**
   * 去掉字符串中所有" "
   * @param value
   * @return
   */
	public static String replaceAllSpace(String value) {
		return replaceAll(value, " ", "");
	}

	
  /**
   * 字符串是否非法
   * @param str
   * @return  str 含有非法字符时返回 false
   * 
   *  非法字符  < > . \" ' , $ # % ! ~ ^ & * ( ) = + | \\ ; : ? 
   */
	public static boolean checkStringRule(String str) {
		boolean bool = true;
		if ((null == str) || (str.trim().equals(""))) {
			return true;
		}
		if ((str.indexOf("<") > -1) || (str.indexOf(">") > -1)
				|| (str.indexOf(".") > -1)
				|| (str.indexOf("\"") > -1)
				|| (str.indexOf("'") > -1)
				|| (str.indexOf(",") > -1)
				|| (str.indexOf("$") > -1)
				|| (str.indexOf("#") > -1)
				|| (str.indexOf("%") > -1)
				|| (str.indexOf("!") > -1)
				|| (str.indexOf("~") > -1)
				|| (str.indexOf("^") > -1)
				|| (str.indexOf("&") > -1)
				|| (str.indexOf("*") > -1)
				|| (str.indexOf("(") > -1)
				|| (str.indexOf(")") > -1)
				|| (str.indexOf("=") > -1)
				|| (str.indexOf("+") > -1)
				|| (str.indexOf("|") > -1)
				|| (str.indexOf("\\") > -1)
				|| (str.indexOf(";") > -1)
				|| (str.indexOf(":") > -1)
				|| (str.indexOf("?") > -1)
				|| (str.indexOf("　") > -1)) {
			bool = false;
		}
		return bool;
	}
  
	/**
	 * 把HTML标签替换成转义符
	 *  "\"" 替换成  "&quot;"
	 *  "<" 替换成   "&lt;"
	 *  ">" 替换成  "&gt;"
	 * @param value
	 * @return
	 */
	public static String encodeHTML(String value) {
		if (null == value) {
			return value;
		}
		String str = value;
		str = replaceAll(str, "\"", "&quot;");
		str = replaceAll(str, "<", "&lt;");
		str = replaceAll(str, ">", "&gt;");
		return str;
	}

	/**
	 * HTML标签转义符替换成HTML标签
	 * "&quot;" 替换成   "\""
	 * "&lt;" 替换成   "<"
	 * "&gt;" 替换成   ">"
	 * @param value
	 * @return
	 */
	public static String decodeHTML(String value) {
		if (isNull(value)) {
			return "";
		}
		String str = value;
		str = replaceAll(str, "&quot;", "\"");
		str = replaceAll(str, "&lt;", "<");
		str = replaceAll(str, "&gt;", ">");
		return str;
	}

	
	public static Vector strToVector(String paramString) {
		Vector vec = new Vector();
		if ((null == paramString) || (paramString.trim().equals(""))) {
			return vec;
		}
		String[] arrayOfString = paramString.split("\\,");
		for (int i = 0; i < arrayOfString.length; i++) {
			String str = arrayOfString[i].trim().toLowerCase();
			if ((null != str) && (!str.equals(""))) {
				vec.add(str);
			}
		}
		return vec;
	}

	
  public static String strArrayToStr(String[] paramArrayOfString, String paramString)
  {
    String str = "";
    if ((null == paramArrayOfString) || (paramArrayOfString.length <= 0)) {
      return "";
    }
    for (int i = 0; i < paramArrayOfString.length; i++) {
      if (str.length() > 0) {
        str = str + "," + paramArrayOfString[i];
      } else {
        str = paramArrayOfString[i];
      }
    }
    return str;
  }
  
  public static Vector strArrayToVector(String[] paramArrayOfString)
  {
    Vector vec = new Vector();
    if ((null == paramArrayOfString) || (paramArrayOfString.length == 0)) {
      return vec;
    }
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      String str = paramArrayOfString[i].trim().toLowerCase();
      if ((null != str) && (!str.equals(""))) {
        vec.add(str);
      }
    }
    return vec;
  }
  
  public static Vector vectorUnite(Vector paramVector1, Vector paramVector2) {
    Vector vec = new Vector();
    vec.addAll(paramVector1);
    vec.addAll(paramVector2);
    return vec;
  }
  
  public static Collection mapToCollection(HashMap paramHashMap)
  {
    return paramHashMap.values();
  }
  
  
  	/**
  	 * 字符串是空字符串，判断依据为空或去掉空格后缀为""
  	 * @param value
  	 * @return
  	 */
	public static boolean isNull(String value) {
		return (null == value) || (value.trim().equals(""));
	}
	
  	/**
  	 * 字符串是非空字符串，判断依据为空或去掉空格后缀为""为空字符串
  	 * @param value
  	 * @return
  	 */
	public static boolean isNotNull(String value) {
		return (!"null".equals(value))&&(null != value) && (!value.trim().equals("")&& (!value.trim().equals("undefined")));
	}
  
  /**
   * 判断字符串是否是运算符
   * @param value
   * @return
   */
	public static boolean isCompareStr(String value) {
		boolean bool = false;
		if (isNull(value)) {
			return false;
		}
		if ((value.equals("<")) 
				|| (value.equals(">"))
				|| (value.equals(">=")) 
				|| (value.equals("<="))
				|| (value.equals("=")) 
				|| (value.equals("=="))) {
			bool = true;
		}
		return bool;
	}
  
  public static String removeLawlessStr(String paramString)
  {
    if ((null == paramString) || (paramString.trim().equals(""))) {
      return paramString;
    }
    String str = paramString;
    str = replaceAll(str, "'", "");
    str = replaceAll(str, "%", "");
    str = replaceAll(str, "SELECT", "[SELECT]");
    str = replaceAll(str, "UPDATE", "[UPDATE]");
    str = replaceAll(str, "DELETE", "[DELETE]");
    return str;
  }
  
  public static String removeHTMLTAG(String paramString)
  {
    int i;
    int j;
    StringBuffer sb = null;
    for (sb = new StringBuffer(paramString);; sb = sb.replace(i, j + 1, ""))
    {
      i = sb.indexOf("<");
      j = sb.indexOf(">");
      if ((i < 0) || (j < 0) || (i >= j)) {
        break;
      }
    }
    return sb.toString();
  }
  
  public static String encodeHTMLAndRemoveLawlessStr(String paramString)
  {
    String str = encodeHTML(paramString);
    return removeLawlessStr(str);
  }
  
  public static ArrayList split(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str = null;
    int i = 0;
    int j = 0;
    for (int k = 0; k < paramString.length(); k++) {
      if (paramString.charAt(k) == paramChar)
      {
        i = k;
        str = paramString.substring(j, i);
        localArrayList.add(str);
        j = k + 1;
      }
    }
    if (j < paramString.length()) {
      localArrayList.add(paramString.substring(j));
    }
    if (localArrayList.size() <= 0) {
      return null;
    }
    return localArrayList;
  }
  
  /**
   * Vector集合中字符串组装成以 ","连接的形式返回
   * @param vec
   * @return
   */
	public static String vectorToStr(Vector vec) {
		String result = "";
		Enumeration localEnumeration = vec.elements();
		while (localEnumeration.hasMoreElements()) {
			String str = (String) localEnumeration.nextElement();
			if (result.length() > 0) {
				result = result + "," + str;
			} else {
				result = str;
			}
		}
		return result;
	}

   /**
	 * 截取指定长度的回复内容
	 * [int left] 要截取的长度
	 * [String outStr] 超出的表示
	 * @return
	 */
	public static String substring(String content, int left, String outStr) {
		String str = content;
		int i = 0;
		int j = 0;
		byte[] arrayOfByte = content.getBytes();
		if (arrayOfByte.length <= left) {
			return str;
		}
		for (int k = 0; k < arrayOfByte.length; k++) {
			if (arrayOfByte[k] >= 0) {
				i += 1;
			} else {
				i += 2;
				k++;
			}
			j++;
			if (i >= left) {
				if ((i % 2 != 0) && (arrayOfByte[(i - 1)] < 0)) {
					j--;
				}
				str = str.substring(0, j);
				break;
			}
		}
		return str + outStr;
	}
	
	  public static String getMiddleStr(String paramString1, String paramString2, String paramString3)
	  {
	    return getMiddleStr(paramString1, paramString2, paramString3, false);
	  }


	  public static String getMiddleStr(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
	  {
	    String str = paramString1;
	    int i = -1;
	    if (isNotNull(paramString2))
	      i = str.indexOf(paramString2);
	    int j = -1;
	    if (isNotNull(paramString3))
	      j = str.indexOf(paramString3);
	    if (!paramBoolean)
	    {
	      if ((i < 0) || (j < 0))
	        return "";
	      if (i > j)
	      {
	        str = str.substring(i + paramString2.length(), str.length());
	        j = str.indexOf(paramString3);
	        if (j < 0)
	          return "";
	        str = str.substring(0, j);
	      }
	      else
	      {
	        str = str.substring(i + paramString2.length(), j);
	      }
	    }
	    else
	    {
	      if (i > j)
	        return "";
	      if (i > -1)
	        str = str.substring(i + paramString2.length(), str.length());
	      if (j > -1)
	        str = str.substring(0, j);
	    }
	    return str;
	  }
	/**
	 * 赶回字符串长度
	 * @param value
	 * @return
	 */
	public static int getLength(String value) {
		int i = value.length();
		try {
			i = value.getBytes("GBK").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return i;
	}
  
	/**
	 * 查询指定字符串是否在数组中存在存在返回true
	 * @param arrayOfString 数组
	 * @param value 查询值
	 * @return
	 */
	public static boolean isHasInArray(String[] arrayOfString, String value) {
		boolean bool = false;
		if (arrayOfString == null) 
			return false;
		
		for (int i = 0; i < arrayOfString.length; i++) {
			if (arrayOfString[i].equalsIgnoreCase(value)) {
				return true;
			}
		}
		return bool;
	}
	
	
	  public static double getNotNullDoubleValue(String paramString)
	  {
	    double d = 0.0D;
	    try
	    {
	      d = Double.parseDouble(paramString);
	    }
	    catch (NumberFormatException localNumberFormatException)
	    {
	      d = 0.0D;
	    }
	    return d;
	  }

	  public static long getNotNullLongValue(String paramString)
	  {
	    long l = 0L;
	    try
	    {
	      l = Long.parseLong(paramString);
	    }
	    catch (NumberFormatException localNumberFormatException)
	    {
	      l = 0L;
	    }
	    return l;
	  }
	  
	  
	  
	/**
	 * 右补位，左对齐
	 * 
	 * @param oriStr
	 *            原字符串
	 * @param len
	 *            目标字符串长度
	 * @param alexin
	 *            补位字符
	 * @return 目标字符串
	 */
	public static String padRight(String oriStr, int len, char alexin) {
		String str = "";
		int strlen = oriStr.length();
		if (strlen < len) {
			for (int i = 0; i < len - strlen; i++) {
				str = str + alexin;
			}
		}
		str = str + oriStr;
		return str;
	}

	/**
	 * 左补位，右对齐
	 * 
	 * @param oriStr
	 *            原字符串
	 * @param len
	 *            目标字符串长度
	 * @param alexin
	 *            补位字符
	 * @return 目标字符串
	 */
	public static String padLeft(String oriStr, int len, char alexin) {
		String str = "";
		int strlen = oriStr.length();
		if (strlen < len) {
			for (int i = 0; i < len - strlen; i++) {
				str = str + alexin;
			}
		}
		str = oriStr + str;
		return str;
	}
	  
	  
		/**
		 * @param args
		 * @throws ParseException 
		 */
		public static void main(String[] args) throws ParseException {
			System.out.println(StrUtil.padLeft("ffdsdf", 30, ' ') );
			System.out.println(StrUtil.padRight("ffdsdf", 30, '#') );
		}
}
