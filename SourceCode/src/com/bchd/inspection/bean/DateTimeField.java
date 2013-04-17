package com.bchd.inspection.bean;

/** 
	 Ê±¼ä×Ö¶Î
*/
	public class DateTimeField implements IValueText
	{
		/** 
		 ±£´æÊ±¼ä×Ö¶ÎÀïµÄÖµ
		*/
		private java.util.Date mValue = new java.util.Date(0);

		/** 
		 ÓÃÓÚÏÔÊ¾µÄÎÄ±¾
		*/
		public final String getText()
		{
			return mValue.toString();
		}

		/** 
		 Ê±¼ä×Ö¶ÎÀïµÄÖµ
		*/
		public final Object getValue()
		{
			return mValue;
		}

		public DateTimeField(java.util.Date value)
		{
			mValue = value;
		}
	}