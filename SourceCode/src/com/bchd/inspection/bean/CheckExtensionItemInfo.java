package com.bchd.inspection.bean;

import java.util.UUID;

/** 
´ý²éÏîÄ¿À©Õ¹ÐÅÏ¢ÏîÊµÌåÀà
*/
public class CheckExtensionItemInfo {

	/** 
	 ±àºÅ
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

	/** 
	 ËùÊôÖ÷¼ÇÂ¼±àºÅ
	*/
	private UUID privateMainRecordID =  UUID.randomUUID();
	public final UUID getMainRecordID()
	{
		return privateMainRecordID;
	}
	public final void setMainRecordID(UUID value)
	{
		privateMainRecordID = value;
	}

	/** 
	 Õâ¸ö×Ö¶ÎÖµµÄÔªÊý¾ÝÐÅÏ¢
	*/
	private CheckItemTypeInfo privateMetadataInfo;
	public final CheckItemTypeInfo getMetadataInfo()
	{
		return privateMetadataInfo;
	}
	public final void setMetadataInfo(CheckItemTypeInfo value)
	{
		privateMetadataInfo = value;
	}

	/** 
	 ×Ê²ú¾²Ì¬ÐÅÏ¢À©Õ¹ÏîµÄÊµ¼ÊÖµ
	*/
	private IValueText privateValue;
	public final IValueText getValue()
	{
		return privateValue;
	}
	public final void setValue(IValueText value)
	{
		privateValue = value;
	}

	/** 
	 ±¸×¢
	*/
	private String privateComments;
	public final String getComments()
	{
		return privateComments;
	}
	public final void setComments(String value)
	{
		privateComments = value;
	}

	public CheckExtensionItemInfo(UUID id, CheckItemTypeInfo metadataInfo, IValueText value)
	{
		this(id, UUID.randomUUID(), metadataInfo, value);

	}

	public CheckExtensionItemInfo(UUID id, UUID mainID, CheckItemTypeInfo metadataInfo, IValueText value)
	{
		this.setID(id);
		this.setMainRecordID(mainID);
		this.setMetadataInfo(metadataInfo);
		this.setValue(value);
	}
}