package com.bchd.inspection.bean;

import java.util.UUID;

import com.bchd.inspection.util.IGetValueFormObject;
import com.bchd.inspection.util.JavaHelper;

public class CheckSheetInfo
{
		public CheckSheetInfo()
		{
			this.setCreatedRecordTime(new java.util.Date());
			setCheckStartTime(new java.util.Date());
			setCheckSheetNo(UUID.randomUUID());
			setRecordStatus(getRecordStatus().Invalid);
		}

		/** 
		 稽查手段
		*/
		private CategoryInfo privateCheckMethod;
		public final CategoryInfo getCheckMethod()
		{
			return privateCheckMethod;
		}
		public final void setCheckMethod(CategoryInfo value)
		{
			privateCheckMethod = value;
		}

		/** 
		 被稽查人的岗位类别
		*/
		private CategoryInfo privateCheckClass;
		public final CategoryInfo getCheckClass()
		{
			return privateCheckClass;
		}
		public final void setCheckClass(CategoryInfo value)
		{
			privateCheckClass = value;
		}

		/** 
		 稽查开始时间，对现场类稽查是稽查员上岗时间
		*/
		private java.util.Date privateCheckStartTime = new java.util.Date(0);
		public final java.util.Date getCheckStartTime()
		{
			return privateCheckStartTime;
		}
		public final void setCheckStartTime(java.util.Date value)
		{
			privateCheckStartTime = value;
		}

		/** 
		 稽查结束时间，对现场类稽查，为稽查员下岗时间
		*/
		private java.util.Date privateCheckEndTime;
		public final java.util.Date getCheckEndTime()
		{
			return privateCheckEndTime;
		}
		public final void setCheckEndTime(java.util.Date value)
		{
			privateCheckEndTime = value;
		}


		//public CategoryInfo Auditor { get; set; }

		private String privateComment;
		public final String getComment()
		{
			return privateComment;
		}
		public final void setComment(String value)
		{
			privateComment = value;
		}

		//public CategoryInfo MonitorName { get; set; }

		private UUID privateCheckSheetNo =UUID.randomUUID();
		public final UUID getCheckSheetNo()
		{
			return privateCheckSheetNo;
		}
		public final void setCheckSheetNo(UUID value)
		{
			privateCheckSheetNo = value;
		}

		private RecordStatus privateRecordStatus;
		public final RecordStatus getRecordStatus()
		{
			return privateRecordStatus;
		}
		public final void setRecordStatus(RecordStatus value)
		{
			privateRecordStatus = value;
		}

		private String privateFirstNo;
		public final String getFirstNo()
		{
			return privateFirstNo;
		}
		public final void setFirstNo(String value)
		{
			privateFirstNo = value;
		}

		private String privateEndNo;
		public final String getEndNo()
		{
			return privateEndNo;
		}
		public final void setEndNo(String value)
		{
			privateEndNo = value;
		}

		/** 
		 稽查员
		*/
		private java.util.List<EmployeeInfo> privateCheckers;
		public final java.util.List<EmployeeInfo> getCheckers()
		{
			return privateCheckers;
		}
		public final void setCheckers(java.util.List<EmployeeInfo> value)
		{
			privateCheckers = value;
		}

		/** 
		 稽查员的班组，用于确定稽查班组工作量
		*/
		private int privateCheckerGroup;
		public final int getCheckerGroup()
		{
			return privateCheckerGroup;
		}
		public final void setCheckerGroup(int value)
		{
			privateCheckerGroup = value;
		}

		private java.util.Date privateCreatedRecordTime = new java.util.Date(0);
		public final java.util.Date getCreatedRecordTime()
		{
			return privateCreatedRecordTime;
		}
		public final void setCreatedRecordTime(java.util.Date value)
		{
			privateCreatedRecordTime = value;
		}


		public final String GetCheckSheetFromNO()
		{
			String temp = null;
			if (JavaHelper.isNullOrEmpty(this.getFirstNo()))
			{
				temp = this.getEndNo();
			}
			else if (JavaHelper.isNullOrEmpty(this.getEndNo()))
			{
				temp = this.getFirstNo();
			}
			else
			{
				temp = String.format("%1$s-%2$s",this.getFirstNo(), this.getEndNo());
			}
			return temp;
		}

		public final String GetCheckSheetChecker()
		{
			IGetValueFormObject<EmployeeInfo> getValueFun=new IGetValueFormObject<EmployeeInfo>()
			{

				@Override
				public String GetValue(EmployeeInfo obj) {
					return obj.getName();
				}				
				
			};
			
			return JavaHelper.ConcatToString(this.getCheckers(),getValueFun, ",");
		}
}
