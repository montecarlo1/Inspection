package com.bchd.inspection.bean;

//import java.io.Serializable;

/** 
类别信息
*/
public class CategoryInfo extends CategoryInfoBase //implements Serializable
{

	//private static final long serialVersionUID = 1L;
	/** 
	 有限期的开始时间
	*/
	private java.util.Date privateStartTime;
	public java.util.Date getStartTime()
	{
		return privateStartTime;
	}
	public void setStartTime(java.util.Date value)
	{
		privateStartTime = value;
	}

	/** 
	 有限期的结束时间
	*/
	private java.util.Date privateEndTime;
	public java.util.Date getEndTime()
	{
		return privateEndTime;
	}
	public void setEndTime(java.util.Date value)
	{
		privateEndTime = value;
	}

	/** 
	 创建时间
	*/
	private java.util.Date privateCreatedRecordTime;
	public java.util.Date getCreatedRecordTime()
	{
		return privateCreatedRecordTime;
	}
	public void setCreatedRecordTime(java.util.Date value)
	{
		privateCreatedRecordTime = value;
	}

	/** 
	 显示的顺序
	*/
	private Integer privateDisplayOrder;
	public Integer getDisplayOrder()
	{
		return privateDisplayOrder;
	}
	public void setDisplayOrder(Integer value)
	{
		privateDisplayOrder = value;
	}

	/** 
	 备注
	*/
	private String privateComment;
	public String getComment()
	{
		return privateComment;
	}
	public void setComment(String value)
	{
		privateComment = value;
	}

	/** 
	 扩展属性
	*/
	private java.util.HashMap<String, Object> privateProperty;
	public final java.util.HashMap<String, Object> getProperty()
	{
		return privateProperty;
	}
	public final void setProperty(java.util.HashMap<String, Object> value)
	{
		privateProperty = value;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 构造函数
	public CategoryInfo(int id, String name)
	{
		super(id,name);
		setProperty(new java.util.HashMap<String, Object>());
	}

	public CategoryInfo(int id, String name, String code)
	{
		super(id, name,code);
		setProperty(new java.util.HashMap<String, Object>());
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}