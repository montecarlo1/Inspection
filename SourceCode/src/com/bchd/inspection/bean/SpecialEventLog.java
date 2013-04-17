package com.bchd.inspection.bean;

public class SpecialEventLog
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 辅助参数
		private String staffID;
		public final String getStaffID()
		{
			return staffID;
		}
		public final void setStaffID(String value)
		{
			staffID = value;
		}
		private String workNO;
		public final String getWorkNO()
		{
			return workNO;
		}
		public final void setWorkNO(String value)
		{
			workNO = value;
		}
		private String workGroupName;
		public final String getWorkGroupName()
		{
			return workGroupName;
		}
		public final void setWorkGroupName(String value)
		{
			workGroupName = value;
		}
		private String checkClassID;
		public final String getCheckClassID()
		{
			return checkClassID;
		}
		public final void setCheckClassID(String value)
		{
			checkClassID = value;
		}
		private String ticketRoomID;
		public final String getTicketRoomID()
		{
			return ticketRoomID;
		}
		public final void setTicketRoomID(String value)
		{
			ticketRoomID = value;
		}

		private String shiftName;
		public final String getShiftName()
		{
			return shiftName;
		}
		public final void setShiftName(String value)
		{
			shiftName = value;
		}

		private String plazaName;
		public final String getPlazaName()
		{
			return plazaName;
		}
		public final void setPlazaName(String value)
		{
			plazaName = value;
		}

		private String laneName;
		public final String getLaneName()
		{
			return laneName;
		}
		public final void setLaneName(String value)
		{
			laneName = value;
		}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region 数据库实体
		private String specialEventID;
		public final String getSpecialEventID()
		{
			return specialEventID;
		}
		public final void setSpecialEventID(String value)
		{
			specialEventID = value;
		}

		private java.util.Date happenDate = new java.util.Date(0);
		public final java.util.Date getHappenDate()
		{
			return happenDate;
		}
		public final void setHappenDate(java.util.Date value)
		{
			happenDate = value;
		}

		private String workID;
		public final String getWorkID()
		{
			return workID;
		}
		public final void setWorkID(String value)
		{
			workID = value;
		}

		private int shiftID;
		public final int getShiftID()
		{
			return shiftID;
		}
		public final void setShiftID(int value)
		{
			shiftID = value;
		}

		private int workGroupID;
		public final int getWorkGroupID()
		{
			return workGroupID;
		}
		public final void setWorkGroupID(int value)
		{
			workGroupID = value;
		}

		private String staffName;
		public final String getStaffName()
		{
			return staffName;
		}
		public final void setStaffName(String value)
		{
			staffName = value;
		}

		private int plazaID;
		public final int getPlazaID()
		{
			return plazaID;
		}
		public final void setPlazaID(int value)
		{
			plazaID = value;
		}

		private int laneID;
		public final int getLaneID()
		{
			return laneID;
		}
		public final void setLaneID(int value)
		{
			laneID = value;
		}

		private String content;
		public final String getContent()
		{
			return content;
		}
		public final void setContent(String value)
		{
			content = value;
		}

		private int checkRecordMainConfirm;
		public final int getCheckRecordMainConfirm()
		{
			return checkRecordMainConfirm;
		}
		public final void setCheckRecordMainConfirm(int value)
		{
			if (value == 0 || value == 1)
			{
				checkRecordMainConfirm = value;
			}
			else
			{
				checkRecordMainConfirm = 1;
			}
		}

		private String checkerID;
		public final String getCheckerID()
		{
			return checkerID;
		}
		public final void setCheckerID(String value)
		{
			checkerID = value;
		}

		private String remark;
		public final String getRemark()
		{
			return remark;
		}
		public final void setRemark(String value)
		{
			remark = value;
		}

		private java.util.Date uploadTime = new java.util.Date(0);
		public final java.util.Date getUploadTime()
		{
			return uploadTime;
		}
		public final void setUploadTime(java.util.Date value)
		{
			uploadTime = value;
		}

		private int recordStatus;
		public final int getRecordStatus()
		{
			return recordStatus;
		}
		public final void setRecordStatus(int value)
		{
			recordStatus = value;
		}

		private int uploadStatus;
		public final int getUploadStatus()
		{
			return uploadStatus;
		}
		public final void setUploadStatus(int value)
		{
			uploadStatus = value;
		}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}