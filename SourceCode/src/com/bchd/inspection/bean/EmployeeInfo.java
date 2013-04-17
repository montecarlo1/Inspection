package com.bchd.inspection.bean;

public class EmployeeInfo extends CategoryInfo
{

		public final String getName()
		{
			return super.getTitle();
		}
		public final void setName(String value)
		{
			super.setTitle(value);
		}

		public final String getLoginName()
		{
			return super.getCode();
		}
		public final void setLoginName(String value)
		{
			super.setCode(value);
		}

		private String privatePassword;
		public final String getPassword()
		{
			return privatePassword;
		}
		public final void setPassword(String value)
		{
			privatePassword = value;
		}

		///// <summary>
		///// ÐÔ±ð
		///// </summary>
		//public Sex Sex { get; set; }

		//public DateTime? Birthday { get; set; }

		//public string TelephoneNo { get; set; }



		/** 
		 ¸ÚÎ»Àà±ð
		*/
		private CategoryInfo privatePostType;
		public final CategoryInfo getPostType()
		{
			return privatePostType;
		}
		public final void setPostType(CategoryInfo value)
		{
			privatePostType = value;
		}

		//public CategoryInfo Company { get; set; }

		//public CategoryInfo Department {get;set;}

		/** 
		 WorkNo´æÔÚCode×Ö¶ÎÖÐÁË
		*/
		private String privateWorkID;
		public final String getWorkID()
		{
			return privateWorkID;
		}
		public final void setWorkID(String value)
		{
			privateWorkID = value;
		}
		/*
		 * staffID
		 */
		private String privateStaffID;
		public final String getStaffID()
		{
			return privateStaffID;
		}
		public final void setStaffID(String value)
		{
			privateStaffID = value;
		}

		private Integer privateTicketRoomID;
		public final Integer getTicketRoomID()
		{
			return privateTicketRoomID;
		}
		public final void setTicketRoomID(Integer value)
		{
			privateTicketRoomID = value;
		}

		private CategoryInfo privateWorkGroup;
		public final CategoryInfo getWorkGroup()
		{
			return privateWorkGroup;
		}
		public final void setWorkGroup(CategoryInfo value)
		{
			privateWorkGroup = value;
		}

		public EmployeeInfo(int id, String name)
		{
			super(id, name);

		}

		public EmployeeInfo(int id, String name, String loginName)
		{
			super(id,name,loginName);

		}

}