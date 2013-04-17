package com.bchd.inspection.ui.Control;

import com.bchd.inspection.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class CheckItemControl extends LinearLayout implements ICheckItemControl {

	public CheckItemControl(Context context, AttributeSet attrs) {
		super(context, attrs);		
	}

	//对应的配置项目编号
	private int mCheckItemID;

	//标题控件
	private TextView tvTitle;
	
	
	public int getCheckItemID() {
		return mCheckItemID;
	}

	public void setCheckItemID(int mCheckItemID) {
		this.mCheckItemID = mCheckItemID;
	}
	
	public void setTitle(String title)
	{
		tvTitle.setText(title);
	}
	
	public String getTitle()
	{		
		return tvTitle.getText().toString();
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		this.tvTitle=(TextView)this.findViewById(R.id.tvTitle);		
	}

}
