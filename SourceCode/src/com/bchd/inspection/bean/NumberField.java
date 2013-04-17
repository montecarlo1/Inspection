package com.bchd.inspection.bean;

public class NumberField implements IValueText
{
		/** 
		 ±£´æÊý×Ö×Ö¶ÎµÄÖµ
		*/
		private double mValue;

		/** 
		 ÓÃÓÚÏÔÊ¾×Ö¶ÎÄÚÈÝµÄÎÄ±¾
		*/
		public final String getText()
		{
			return (new Double(mValue)).toString();
		}

		/** 
		 ·µ»Ø×Ö¶ÎÖÐµÄÖµ
		*/
		public final Object getValue()
		{
			return mValue;
		}

		public NumberField(double value)
		{
			mValue = value;
		}
}