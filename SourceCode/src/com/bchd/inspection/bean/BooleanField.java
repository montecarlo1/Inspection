package com.bchd.inspection.bean;

public class BooleanField implements IValueText
{
		public BooleanField(boolean value)
		{
			this.value = value;
		}

		private boolean value;

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region IValueText Members

		public final Object getValue()
		{
			return value;
		}

		public final String getText()
		{
			return (new Boolean(value)).toString();
		}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}
