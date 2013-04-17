package com.bchd.inspection.bean;

//import java.io.Serializable;

/** 
×ÖµäµÄ»ùÀà
*/
public class CategoryInfoBase extends SelectField //implements Serializable
{

	/** 
	 ±àºÅ¡¡
	*/
	//private static final long serialVersionUID = 1L;
	public int getID()
	{
		return (Integer)super.getValue();
	}
	public void setID(int value)
	{
		super.setValue(value);
	}


	/** 
	 Ãû³Æ
	*/
	public String getTitle()
	{
		return super.getText();
	}
	public void setTitle(String value)
	{
		super.setText(value);
	}

	/** 
	 ±àÂë
	*/
	private String privateCode;
	public String getCode()
	{
		return privateCode;
	}
	public void setCode(String value)
	{
		privateCode = value;
	}


	
	public CategoryInfoBase(int id, String name)
	{
		super(id,name);
		this.setCode(null);
	}

	public CategoryInfoBase(int id, String name, String code)
	{
		super(id, name);
		this.setCode(code);
	}

	
}
