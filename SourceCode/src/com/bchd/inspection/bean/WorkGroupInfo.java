package com.bchd.inspection.bean;

public class WorkGroupInfo extends CategoryInfo
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

		private int privatePostID;
		public final int getPostID()
		{
			return privatePostID;
		}
		public final void setPostID(int value)
		{
			privatePostID = value;
		}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 构造函数
		public WorkGroupInfo(int id, String name)
		{
			super(id,name);
		}

		public WorkGroupInfo(int id, String name, String code)
		{
			super(id, name,code);
		}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}