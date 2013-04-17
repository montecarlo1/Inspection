package com.bchd.inspection.bean;

/** 
配置信息
*/
public final class ConfigData
{
	static
	{
		InitFieldDataTypes();
		InitCheckResultTypes();
	}


	//检查结果项目 正常： 0，不正常：1 ，未查： 2

	private static void InitCheckResultTypes()
	{
		CheckResultTypes = new java.util.HashMap<Integer, SelectField>();

		CheckResultTypes.put(0, new SelectField(0, "正常"));
		CheckResultTypes.put(1, new SelectField(1, "不正常"));
		CheckResultTypes.put(2, new SelectField(2, "未查"));
	}

	/** 
	 字段类型
	*/
	private static java.util.HashMap<Integer, SelectField> CheckResultTypes = null;

	public static SelectField GetCheckResultType(int id)
	{
		return CheckResultTypes.get(id);
	}






	//初始化字段类型数据

	private static void InitFieldDataTypes()
	{
		FieldDataTypes = new java.util.HashMap<Integer, FieldDataTypeInfo>();

		FieldDataTypes.put(FieldType.Select.ordinal(), new FieldDataTypeInfo(FieldType.Select.ordinal(), "选择类型", FieldType.Select));
		FieldDataTypes.put(FieldType.Text.ordinal(), new FieldDataTypeInfo(FieldType.Text.ordinal(), "文本类型", FieldType.Text));
		FieldDataTypes.put(FieldType.DateTime.ordinal(), new FieldDataTypeInfo(FieldType.DateTime.ordinal(), "日期时间类型", FieldType.DateTime));
		FieldDataTypes.put(FieldType.Number.ordinal(), new FieldDataTypeInfo(FieldType.Number.ordinal(), "数值类型", FieldType.Number));


	}

	/** 
	 字段类型
	*/
	private static java.util.HashMap<Integer, FieldDataTypeInfo> FieldDataTypes = null;

	public static FieldDataTypeInfo GetFieldDataType(int id)
	{
		return FieldDataTypes.get(id);
	}

	/** 
	 checksheet中的postType已经没有什么实际意义了，所以默认情况下都使用收费员的录入
	*/
	public static int DefaultCheckSheetPostType = 112;

	/** 
	 通知单的CheckMethodID
	*/
	public static int NotificationCheckMethod = 22;

	public static int DefaultCheckNoticeHandleStatus = 0;

	public static final String NoneWorkID = "无工号人员";
}