package com.bchd.inspection.bean;

public class FieldDataTypeInfo extends SelectField
{
		private FieldType privateDateType;
		public final FieldType getDateType()
		{
			return privateDateType;
		}
		private void setDateType(FieldType value)
		{
			privateDateType = value;
		}

		public FieldDataTypeInfo(int id, String title, FieldType type)
		{
			super(id,title);
			this.setDateType(type);
		}

		public FieldDataTypeInfo(int id, String title, int type)
		{
			super(id, title);
			this.setDateType(FieldType.values()[type]);
		}
}