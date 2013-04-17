package com.bchd.inspection.bean;

public enum FieldType
{
		/** 
		 选择类型
		*/
		Select(0),
		/** 
		 ÎÄ±¾
		*/
		Text(1),
		/** 
		 ÈÕÆÚÊ±¼ä
		*/
		DateTime(2),
		/** 
		 Êý×Ö
		*/
		Number(3);

		private int intValue;
		private static java.util.HashMap<Integer, FieldType> mappings;
		private static java.util.HashMap<Integer, FieldType> getMappings()
		{
			if (mappings == null)
			{
				synchronized (FieldType.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, FieldType>();
					}
				}
			}
			return mappings;
		}

		private FieldType(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static FieldType forValue(int value)
		{
			return getMappings().get(value);
		}
}
