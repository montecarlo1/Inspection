package com.bchd.inspection.bean;

/** 
ÎÄ±¾×Ö¶Î
*/
public class TextField implements IValueText
{
	/** 
	 ÎÄ±¾×Ö¶ÎÊµ¼Ê±£´æµÄÖµ
	*/
	private String mValue;

	/** 
	 ÏÔÊ¾µÄÎÄ±¾
	*/
	public final String getText()
	{
		return mValue;
	}

	/** 
	 ÎÄ±¾×Ö¶ÎµÄÖµ
	*/
	public final Object getValue()
	{
		return mValue;
	}

	public TextField(String value)
	{
		mValue = value;
	}
}
