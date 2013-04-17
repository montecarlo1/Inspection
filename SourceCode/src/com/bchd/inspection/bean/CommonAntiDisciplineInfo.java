package com.bchd.inspection.bean;

/** 
常见违纪类型
*/
public class CommonAntiDisciplineInfo extends CategoryInfo
{

	private CategoryInfo privateAntiDisciplineType;
	public final CategoryInfo getAntiDisciplineType()
	{
		return privateAntiDisciplineType;
	}
	public final void setAntiDisciplineType(CategoryInfo value)
	{
		privateAntiDisciplineType = value;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	///#region 构造函数
	public CommonAntiDisciplineInfo(int id, String name)
	{
		super(id,name);
	}

	public CommonAntiDisciplineInfo(int id, String name, String code)
	{
		super(id, name,code);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	///#endregion
}