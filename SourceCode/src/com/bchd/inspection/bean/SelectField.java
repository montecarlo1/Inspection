package com.bchd.inspection.bean;

//import java.io.Serializable;

/** 
±íÊ¾Ñ¡Ôñ×Ö¶Î
*/
public class SelectField implements IValueText//,Serializable
{
	//private static final long serialVersionUID = 1L;
	/** 
	 ±àºÅ
	*/
	private int value;

	/** 
	 ÏÔÊ¾ÎÄ±¾
	*/
	private String text;

	/** 
	 ±àºÅ
	*/
	public Object getValue()
	{
		return value;
	}
	public void setValue(Object value)
	{
		this.value = (Integer)value;
	}

	/** 
	 ÏÔÊ¾ÎÄ±¾
	*/
	public String getText()
	{
		return text;
	}
	public void setText(String value)
	{
		text = value;
	}

	public SelectField(int value, String text)
	{
		this.value = value;
		this.text = text;
	}
}