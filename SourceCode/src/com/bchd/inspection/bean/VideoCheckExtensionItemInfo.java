package com.bchd.inspection.bean;

import java.util.UUID;

/** 
录像稽查扩展项目
*/
public class VideoCheckExtensionItemInfo 
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

	/** 
	 所属主记录编号
	*/
	private UUID privateMainRecordID = UUID.randomUUID();
	public final UUID getMainRecordID()
	{
		return privateMainRecordID;
	}
	public final void setMainRecordID(UUID value)
	{
		privateMainRecordID = value;
	}

	/** 
	 这个字段值的元数据信息
	*/
	private int privateMetadataInfoID;
	public final int getMetadataInfoID()
	{
		return privateMetadataInfoID;
	}
	public final void setMetadataInfoID(int value)
	{
		privateMetadataInfoID = value;
	}

	/** 
	 资产静态信息扩展项的实际值
	*/
	private double privateValue;
	public final double getValue()
	{
		return privateValue;
	}
	public final void setValue(double value)
	{
		privateValue = value;
	}

	/** 
	 车型
	*/
	private CategoryInfo privateModel;
	public final CategoryInfo getModel()
	{
		return privateModel;
	}
	public final void setModel(CategoryInfo value)
	{
		privateModel = value;
	}

	public VideoCheckExtensionItemInfo(UUID id, int metadataInfoID, CategoryInfo model, double value)
	{
		this(id,UUID.randomUUID(), metadataInfoID, model, value);
	}

	public VideoCheckExtensionItemInfo(UUID id, UUID mainID, int metadataInfoID, CategoryInfo model, double value)
	{
		this.setID(id);
		this.setMainRecordID(mainID);
		this.setMetadataInfoID(metadataInfoID);
		this.setModel(model);
		this.setValue(value);
	}

}