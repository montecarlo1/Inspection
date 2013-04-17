/*package com.bchd.inspection.util;

import com.bchd.inspection.bean.*;

*//** 
IValueText½Ó¿ÚÏà¹ØµÄÒ»Ð©£¬ÄÜÓÃ·½·¨
*//*
public final class IValueTextHelper
{
//C# TO JAVA CONVERTER TODO TASK: Extension methods are not available in Java:
//ORIGINAL LINE: public static string GetIValueTextDisplayText(this IValueText value)
	public static String GetIValueTextDisplayText(IValueText value)
	{
		if (value == null)
		{
			return null;
		}
		else
		{
			return value.getText();
		}
	}

//C# TO JAVA CONVERTER TODO TASK: Extension methods are not available in Java:
//ORIGINAL LINE: public static string GetIValueTextTextValue(this IValueText value)
	public static String GetIValueTextTextValue(IValueText value)
	{
		if (value == null)
		{
			return null;
		}
		else
		{
			return value.getValue() == null ? null : value.getValue().toString();
		}

	}

//C# TO JAVA CONVERTER TODO TASK: Extension methods are not available in Java:
//ORIGINAL LINE: public static Nullable<DateTime> GetIValueTextDateTime(this IValueText value)
	public static java.util.Date GetIValueTextDateTime(IValueText value)
	{
		if (value == null)
		{
			return null;
		}
		else
			Object tempVar = value.getValue();
			{
			return value.getValue() == null ? null : (java.util.Date)((tempVar instanceof java.util.Date) ? tempVar : null);
			}

	}

//C# TO JAVA CONVERTER TODO TASK: Extension methods are not available in Java:
//ORIGINAL LINE: public static Nullable<double> GetIValueTextNumber(this IValueText value)
	public static Double GetIValueTextNumber(IValueText value)
	{
		if (value == null)
		{
			return null;
		}
		else
			Object tempVar = value.getValue();
			{
			return value.getValue() == null ? null : (Double)((tempVar instanceof Double) ? tempVar : null);
			}

	}

//C# TO JAVA CONVERTER TODO TASK: Extension methods are not available in Java:
//ORIGINAL LINE: public static Nullable<int> GetIValueTextSelect(this IValueText value)
	public static Integer GetIValueTextSelect(IValueText value)
	{
		if (value == null)
		{
			return null;
		}
		else
			Object tempVar = value.getValue();
			{
			return value.getValue() == null ? null : (Integer)((tempVar instanceof Integer) ? tempVar : null);
			}

	}
}
*/