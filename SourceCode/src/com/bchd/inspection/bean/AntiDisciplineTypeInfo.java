package com.bchd.inspection.bean;

public class AntiDisciplineTypeInfo extends CategoryInfo
{
	private CategoryInfo privateCheckClass;
	public final CategoryInfo getCheckClass()
	{
		return privateCheckClass;
	}
	public final void setCheckClass(CategoryInfo value)
	{
		privateCheckClass = value;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		 ///#region 构造函数
	public AntiDisciplineTypeInfo(int id, String name)
	{
		super(id,name);
	}

	public AntiDisciplineTypeInfo(int id, String name, String code)
	{
		super(id, name,code);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}
