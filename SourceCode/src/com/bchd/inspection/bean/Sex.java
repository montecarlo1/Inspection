package com.bchd.inspection.bean;

public enum Sex
{
		Male(0),

		Female(1);

		private int intValue;
		private static java.util.HashMap<Integer, Sex> mappings;
		private static java.util.HashMap<Integer, Sex> getMappings()
		{
			if (mappings == null)
			{
				synchronized (Sex.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, Sex>();
					}
				}
			}
			return mappings;
		}

		private Sex(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static Sex forValue(int value)
		{
			return getMappings().get(value);
		}
}
