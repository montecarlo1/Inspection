package com.bchd.inspection.util;

import java.util.Collection;
import java.util.regex.Pattern;

public class JavaHelper {
	
	
	public static boolean isNullOrEmpty(String s) {
	    return s == null || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
	    return s == null || isWhitespace(s);

	}
	private static boolean isWhitespace(String s) {
	    int length = s.length();
	    if (length > 0) {
	        for (int i = 0; i < length; i++) {
	            if (!Character.isWhitespace(s.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	    return false;
	}
	
	public static <T> String ConcatToString(Collection<T> source,IGetValueFormObject<T> getValueFun,String separator)
	{
		StringBuilder sb=new StringBuilder();
		int i=0;
		for(T item : source)
		{
			String temp=getValueFun.GetValue(item);
			if(i==0)
			{
				sb.append(temp);				
			}
			else				
			{
				sb.append(separator);
				sb.append(temp);									
			}
			i++;
		}
		
		return null;
	}
	
	
	/**
	 * 判断是不是一个合法的电子邮件地址
	 * @param email
	 * @return
	 */
	private final static Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	public static boolean isEmail(String email){
		if(email == null || email.trim().length()==0) 
			return false;
	    return emailer.matcher(email).matches();
	}
	/**
	 * 字符串转整数
	 * @param str
	 * @param defValue
	 * @return
	 */
	public static int toInt(String str, int defValue) {
		try{
			return Integer.parseInt(str);
		}catch(Exception e){}
		return defValue;
	}
	/**
	 * 对象转整数
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static int toInt(Object obj) {
		if(obj==null) return 0;
		return toInt(obj.toString(),0);
	}
	/**
	 * 对象转整数
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static long toLong(String obj) {
		try{
			return Long.parseLong(obj);
		}catch(Exception e){}
		return 0;
	}
	/**
	 * 字符串转布尔值
	 * @param b
	 * @return 转换异常返回 false
	 */
	public static boolean toBool(String b) {
		try{
			return Boolean.parseBoolean(b);
		}catch(Exception e){}
		return false;
	}
}
