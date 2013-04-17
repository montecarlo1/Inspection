package com.bchd.inspection.bean;

/** 
记录状态：1为修改，2为无效或删除，3为新增
*/
public enum RecordStatus
{
	Modify(1),
	Invalid(2),
	New(3);

	private int intValue;
	private static java.util.HashMap<Integer, RecordStatus> mappings;
	private static java.util.HashMap<Integer, RecordStatus> getMappings()
	{
		if (mappings == null)
		{
			synchronized (RecordStatus.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, RecordStatus>();
				}
			}
		}
		return mappings;
	}

	private RecordStatus(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static RecordStatus forValue(int value)
	{
		return getMappings().get(value);
	}
}