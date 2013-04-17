package com.bchd.inspection.bean;

import java.util.UUID;

/** 
录像稽查
*/
public class VideoCheckItemInfo
{
	/** 
	 编号
	*/
	private UUID privateVideoCheckMainID =UUID.randomUUID();
	public final UUID getVideoCheckMainID()
	{
		return privateVideoCheckMainID;
	}
	public final void setVideoCheckMainID(UUID value)
	{
		privateVideoCheckMainID = value;
	}

	/** 
	 被查员工的联网工号
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

	private int privateStaffID;
	public final int getStaffID()
	{
		return privateStaffID;
	}
	public final void setStaffID(int value)
	{
		privateStaffID = value;
	}



	/** 
	 被查班组
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
	 值班开始时间
	*/
	private java.util.Date privateOnDutyStartTime = new java.util.Date(0);
	public final java.util.Date getOnDutyStartTime()
	{
		return privateOnDutyStartTime;
	}
	public final void setOnDutyStartTime(java.util.Date value)
	{
		privateOnDutyStartTime = value;
	}

	/** 
	 值班下班时间
	*/
	private java.util.Date privateOnDutyEndTime = new java.util.Date(0);
	public final java.util.Date getOnDutyEndTime()
	{
		return privateOnDutyEndTime;
	}
	public final void setOnDutyEndTime(java.util.Date value)
	{
		privateOnDutyEndTime = value;
	}

	/** 
	 监控有卡总流量
	*/
	private double privateCenterFlux;
	public final double getCenterFlux()
	{
		return privateCenterFlux;
	}
	public final void setCenterFlux(double value)
	{
		privateCenterFlux = value;
	}

	/** 
	 实际有卡总流量
	*/
	private double privateCardFlux;
	public final double getCardFlux()
	{
		return privateCardFlux;
	}
	public final void setCardFlux(double value)
	{
		privateCardFlux = value;
	}

	/** 
	 录像带核对总流量
	*/
	private double privateVideoCheckFlux;
	public final double getVideoCheckFlux()
	{
		return privateVideoCheckFlux;
	}
	public final void setVideoCheckFlux(double value)
	{
		privateVideoCheckFlux = value;
	}

	/** 
	 监控有卡总金额
	*/
	private double privateCenterAccount;
	public final double getCenterAccount()
	{
		return privateCenterAccount;
	}
	public final void setCenterAccount(double value)
	{
		privateCenterAccount = value;
	}

	/** 
	 实际有卡总金额
	*/
	private double privateCardAccount;
	public final double getCardAccount()
	{
		return privateCardAccount;
	}
	public final void setCardAccount(double value)
	{
		privateCardAccount = value;
	}

	/** 
	 实交现金
	*/
	private double privateRealCommitAccount;
	public final double getRealCommitAccount()
	{
		return privateRealCommitAccount;
	}
	public final void setRealCommitAccount(double value)
	{
		privateRealCommitAccount = value;
	}


	private String privateComment;
	public final String getComment()
	{
		return privateComment;
	}
	public final void setComment(String value)
	{
		privateComment = value;
	}

	/** 
	 通知单号
	*/
	private String privateCheckNoticeNo;
	public final String getCheckNoticeNo()
	{
		return privateCheckNoticeNo;
	}
	public final void setCheckNoticeNo(String value)
	{
		privateCheckNoticeNo = value;
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
	 录像编号
	*/
	private String privateVideoCheckNo;
	public final String getVideoCheckNo()
	{
		return privateVideoCheckNo;
	}
	public final void setVideoCheckNo(String value)
	{
		privateVideoCheckNo = value;
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
	 稽查员班组
	*/
	private CategoryInfo privateCheckerGroup;
	public final CategoryInfo getCheckerGroup()
	{
		return privateCheckerGroup;
	}
	public final void setCheckerGroup(CategoryInfo value)
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

}