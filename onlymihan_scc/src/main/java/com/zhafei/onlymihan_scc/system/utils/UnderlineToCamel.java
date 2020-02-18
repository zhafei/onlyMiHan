package com.zhafei.onlymihan_scc.system.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnderlineToCamel {

	/**
	 * <Map> 下划线字符串转驼峰
	 * @param dataMap<dataMap>
	 * @return
	 */
	public static Map<String, String> underline2CamelAMap(Map<String, String> dataMap) {
		Map<String, String> tempMap = new HashMap<String, String>();
		try {
			// 遍历map中的键
			for (String key : dataMap.keySet()) {
				String newKey = underline2Camel(key, true);
				tempMap.put(newKey, String.valueOf(dataMap.get(key)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}


	public static Map<String, Object> underline2CamelAMapObj(Map<String, Object> dataMap) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		try {
			// 遍历map中的键
			for (String key : dataMap.keySet()) {
				String newKey = underline2Camel(key, true);
				tempMap.put(newKey, dataMap.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}



	/**
	 * 下划线字符串转驼峰
	 * @param dataMap
	 * @return
	 */
	public static List<Map<String, String>> underline2CamelAList(List<Map<String, String>> dataMap) {
		List<Map<String, String>> returnList = new ArrayList<>();
		try {
			for (Map<String, String> map : dataMap) {
				Map<String, String> tempMap = new HashMap<>();
				// 遍历map中的键
				for (String key : map.keySet()) {
					String newKey = underline2Camel(key, true);
					tempMap.put(newKey, String.valueOf(map.get(key)));
				}
				returnList.add(tempMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}


	public static List<Map<String, Object>> underline2CamelAListObj(List<Map<String, Object>> dataMap) {
		List<Map<String, Object>> returnList = new ArrayList<>();
		try {
			for (Map<String, Object> map : dataMap) {
				Map<String, Object> tempMap = new HashMap<>();
				// 遍历map中的键
				for (String key : map.keySet()) {
					String newKey = underline2Camel(key, true);
					tempMap.put(newKey, map.get(key));
				}
				returnList.add(tempMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}



	/**
	 * 下划线转驼峰法
	 * 
	 * @param line
	 *            源字符串
	 * @param smallCamel
	 *            大小驼峰,是否为小驼峰
	 * @return 转换后的字符串
	 */
	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0))
					: Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}
	/** 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)}) */
	public static String humpToLine(String str) {
	return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}
	private static Pattern humpPattern = Pattern.compile("[A-Z]");
	/** 驼峰转下划线,效率比上面高 */
	public static String humpToLine2(String str) {
	Matcher matcher = humpPattern.matcher(str);
	StringBuffer sb = new StringBuffer();
	while (matcher.find()) {
	matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
	}
	matcher.appendTail(sb);
	return sb.toString();
	}
	/**
	  * 驼峰转下划线
	  *
	  * @param str
	  * @return
	  */
	 public static String camelToUnderline(String str) {
	  if (str == null || str.trim().isEmpty()){
	   return "";
	  }
	  int len = str.length();
	  StringBuilder sb = new StringBuilder(len);
	  sb.append(str.substring(0, 1).toLowerCase());
	  for (int i = 1; i < len; i++) {
	   char c = str.charAt(i);
	   if (Character.isUpperCase(c)) {
	    sb.append("_");
	    sb.append(Character.toLowerCase(c));
	   } else {
	    sb.append(c);
	   }
	  }
	  return sb.toString();
	 }
}
