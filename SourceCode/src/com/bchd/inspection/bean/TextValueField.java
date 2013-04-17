package com.bchd.inspection.bean;

/** 
ÓÃÓÚ´¦ÀíÓÐÖµ£¬ºÍÎÄ±¾µÄÒ»ÖÖÌØÊâµÄÀàÐÍ
*/
public class TextValueField implements IValueText
{
	private String value;
	private String text;

	public final Object getValue()
	{
		return value;
	}
	public final void setValue(Object value)
	{
		this.value = (String)((value instanceof String) ? value : null);
	}

	public final String getText()
	{
		return text;
	}
	public final void setText(String value)
	{
		text = value;
	}

	public TextValueField(String value, String text)
	{
		this.value = value;
		this.text = text;
	}
}
