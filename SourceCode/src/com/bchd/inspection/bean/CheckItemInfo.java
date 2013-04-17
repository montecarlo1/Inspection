package com.bchd.inspection.bean;

import java.util.UUID;

/** 
检查记录
*/
public class CheckItemInfo
{
	/** 
	 被稽查人工作号
	*/
	private String privateWorkNo;
	public final String getWorkNo()
	{
		return privateWorkNo;
	}
	public final void setWorkNo(String value)
	{
		privateWorkNo = value;
	}

	/** 
	 被稽查人的编号
	*/
	private int privateWorker;
	public final int getWorker()
	{
		return privateWorker;
	}
	public final void setWorker(int value)
	{
		privateWorker = value;
	}

	/** 
	 被稽查人班组
	*/
	private CategoryInfo privateWorkGroup;
	public final CategoryInfo getWorkGroup()
	{
		return privateWorkGroup;
	}
	public final void setWorkGroup(CategoryInfo value)
	{
		privateWorkGroup = value;
	}

	/** 
	 被查的班组，替班时它将与被查人的班组不一致
	*/
	private int privateWorkGroupRecordID;
	public final int getWorkGroupRecordID()
	{
		return privateWorkGroupRecordID;
	}
	public final void setWorkGroupRecordID(int value)
	{
		privateWorkGroupRecordID = value;
	}

	/** 
	 站点
	*/
	private int privateStation;
	public final int getStation()
	{
		return privateStation;
	}
	public final void setStation(int value)
	{
		privateStation = value;
	}



	/** 
	 检查时间
	*/
	private java.util.Date privateCheckedTime = new java.util.Date(0);
	public final java.util.Date getCheckedTime()
	{
		return privateCheckedTime;
	}
	public final void setCheckedTime(java.util.Date value)
	{
		privateCheckedTime = value;
	}

	/** 
	 备注
	*/
	private String privateComment;
	public final String getComment()
	{
		return privateComment;
	}
	public final void setComment(String value)
	{
		privateComment = value;
	}



	private UUID privateCheckSheetNO = UUID.randomUUID();
	public final UUID getCheckSheetNO()
	{
		return privateCheckSheetNO;
	}
	public final void setCheckSheetNO(UUID value)
	{
		privateCheckSheetNO = value;
	}


	private UUID privateCheckRecordID = UUID.randomUUID();
	public final UUID getCheckRecordID()
	{
		return privateCheckRecordID;
	}
	public final void setCheckRecordID(UUID value)
	{
		privateCheckRecordID = value;
	}


	private RecordStatus privateStatus;
	public final RecordStatus getStatus()
	{
		return privateStatus;
	}
	public final void setStatus(RecordStatus value)
	{
		privateStatus = value;
	}

	/** 
	 道次
	*/
	private CategoryInfo privateLane;
	public final CategoryInfo getLane()
	{
		return privateLane;
	}
	public final void setLane(CategoryInfo value)
	{
		privateLane = value;
	}

	private int privateLaneRecordID;
	public final int getLaneRecordID()
	{
		return privateLaneRecordID;
	}
	public final void setLaneRecordID(int value)
	{
		privateLaneRecordID = value;
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

	/** 
	 班次ID
	*/
	private CategoryInfo privateShift;
	public final CategoryInfo getShift()
	{
		return privateShift;
	}
	public final void setShift(CategoryInfo value)
	{
		privateShift = value;
	}

	/** 
	 待检查项目
	*/
	private java.util.HashMap<Integer,CheckExtensionItemInfo> privateExtentItems;
	private java.util.HashMap<Integer,CheckExtensionItemInfo> getExtentItems()
	{
		return privateExtentItems;
	}
	private void setExtentItems(java.util.HashMap<Integer,CheckExtensionItemInfo> value)
	{
		privateExtentItems = value;
	}

}