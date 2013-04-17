package com.bchd.inspection.bean;

/** 
待检查项目的元数据，要通过CheckClassID and CheckMethodID
才能找到对应的检查项目
*/
public class CheckItemTypeInfo extends CategoryInfo
{
	/** 
	 数据类型
	*/
	private FieldDataTypeInfo privateDataType;
	public final FieldDataTypeInfo getDataType()
	{
		return privateDataType;
	}
	public final void setDataType(FieldDataTypeInfo value)
	{
		privateDataType = value;
	}

	/** 
	 默认值
	*/
	private IValueText privateDefaultValue;
	public final IValueText getDefaultValue()
	{
		return privateDefaultValue;
	}
	public final void setDefaultValue(IValueText value)
	{
		privateDefaultValue = value;
	}

	/** 
	 稽查手段
	*/
	private int privateCheckMethodID;
	public final int getCheckMethodID()
	{
		return privateCheckMethodID;
	}
	public final void setCheckMethodID(int value)
	{
		privateCheckMethodID = value;
	}

	/** 
	 岗位类别ID
	*/
	private int privateCheckClassID;
	public final int getCheckClassID()
	{
		return privateCheckClassID;
	}
	public final void setCheckClassID(int value)
	{
		privateCheckClassID = value;
	}


//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	///#region 构造函数

	public CheckItemTypeInfo(int id, String name)
	{
		super(id,name);
	}

	public CheckItemTypeInfo(int id, String name, String code)
	{
		super(id, name,code);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	///#endregion
}