package com.bchd.inspection.bean;

import java.util.UUID;

/** 
稽查通知单信息
*/
public class CheckNoticeInfo
{
	/** 
	 编号
	*/
	private UUID privateID = UUID.randomUUID();
	public final UUID getID()
	{
		return privateID;
	}
	public final void setID(UUID value)
	{
		privateID = value;
	}


	/**通知单编号，废弃字段
	*/
	//public CategoryInfo CheckNoticeNo {get;set;}

	/** 
	 岗位号
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
	 开通知单时间
	*/
	private java.util.Date privateNoticeTime = new java.util.Date(0);
	public final java.util.Date getNoticeTime()
	{
		return privateNoticeTime;
	}
	public final void setNoticeTime(java.util.Date value)
	{
		privateNoticeTime = value;
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
	private CategoryInfo privateLaneID;
	public final CategoryInfo getLaneID()
	{
		return privateLaneID;
	}
	public final void setLaneID(CategoryInfo value)
	{
		privateLaneID = value;
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
	 班次
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
	 被稽查班组
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
	 被稽查人班组
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
	 稽查结果
	*/
	private String privateCheckResult;
	public final String getCheckResult()
	{
		return privateCheckResult;
	}
	public final void setCheckResult(String value)
	{
		privateCheckResult = value;
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
	 违纪类型
	*/
	private CategoryInfo privateAntiDisciplineTypeID;
	public final CategoryInfo getAntiDisciplineTypeID()
	{
		return privateAntiDisciplineTypeID;
	}
	public final void setAntiDisciplineTypeID(CategoryInfo value)
	{
		privateAntiDisciplineTypeID = value;
	}

	/** 
	 常见违纪类型
	*/
	private CategoryInfo privateCommonAntiDisciplineID;
	public final CategoryInfo getCommonAntiDisciplineID()
	{
		return privateCommonAntiDisciplineID;
	}
	public final void setCommonAntiDisciplineID(CategoryInfo value)
	{
		privateCommonAntiDisciplineID = value;
	}

	/** 
	 通知类型，0为一般，1为严重，2为表扬
	*/
	private int privateCheckNoticeType;
	public final int getCheckNoticeType()
	{
		return privateCheckNoticeType;
	}
	public final void setCheckNoticeType(int value)
	{
		privateCheckNoticeType = value;
	}

	/** 
	 通知单单据号
	*/
	private String privateCheckNoticeNumber;
	public final String getCheckNoticeNumber()
	{
		return privateCheckNoticeNumber;
	}
	public final void setCheckNoticeNumber(String value)
	{
		privateCheckNoticeNumber = value;
	}

	private java.util.Date privateCreatNoticeTime = new java.util.Date(0);
	public final java.util.Date getCreatNoticeTime()
	{
		return privateCreatNoticeTime;
	}
	public final void setCreatNoticeTime(java.util.Date value)
	{
		privateCreatNoticeTime = value;
	}


	//稽查事件，其实主要就是用来关联checkmain表的中的编号的，其实个人觉得没有什么意义，有的多余了
	private UUID privateEventID;
	public final UUID getEventID()
	{
		return privateEventID;
	}
	public final void setEventID(UUID value)
	{
		privateEventID = value;
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
	 处理状态，分四个状态：未发送、为处理、未反馈、已反馈
	*/
	private int privateHandleStatus;
	public final int getHandleStatus()
	{
		return privateHandleStatus;
	}
	public final void setHandleStatus(int value)
	{
		privateHandleStatus = value;
	}

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

	/** 
	 发送时间
	*/
	private java.util.Date privateSendTime = new java.util.Date(0);
	public final java.util.Date getSendTime()
	{
		return privateSendTime;
	}
	public final void setSendTime(java.util.Date value)
	{
		privateSendTime = value;
	}

	/** 
	 反馈时间
	*/
	private java.util.Date privateBackTime = new java.util.Date(0);
	public final java.util.Date getBackTime()
	{
		return privateBackTime;
	}
	public final void setBackTime(java.util.Date value)
	{
		privateBackTime = value;
	}

	/** 
	 拒签标识，默认为0
	*/

	private boolean privateRejectSignFlag;
	public final boolean getRejectSignFlag()
	{
		return privateRejectSignFlag;
	}
	public final void setRejectSignFlag(boolean value)
	{
		privateRejectSignFlag = value;
	}

	//public CategoryInfo MistakeNum { get; set; }


}
