package com.bchd.inspection.ui.Control;

import java.util.Date;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bchd.inspection.R;
import com.bchd.inspection.bean.DateTimeField;
import com.bchd.inspection.bean.IValueText;


public class DateTimeControl extends CheckItemControl {

	//EditText txt;
	private date_select_control txt;
	private TextView tvTitle = null;
	
	public DateTimeControl(Context context, AttributeSet attrs) {
		super(context, attrs);	
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		// 当使用静态加载控件时，也就是直接在xml中声明控件时，需在此处引入布局文件
				// LayoutInflater.from(context).inflate(R.layout.selectcheckitemcontrol_view,
				// this, true);
		//this.txt = (EditText) this.findViewById(R.id.txtValue);
		this.txt = (date_select_control) this.findViewById(R.id.txtValue);
	}
	
	@Override
	public IValueText getValue() {
		// TODO Auto-generated method stub
		Date dt= txt.getDate();
		DateTimeField df=null;
		if(dt!=null)
		{
			df=new DateTimeField(dt); 			
		}
		return df;
	}

	@Override
	public void setValue(IValueText value) {
		// TODO Auto-generated method stub
		if(value!=null)
		{
			DateTimeField df=(DateTimeField)value;
			
		}
	}
	/*
	 * 设置标题
	 */
	public void setTitle(String title)
	{
		tvTitle = (TextView)this.findViewById(R.id.tvTitle);
		tvTitle.setText(title);
	}

}
