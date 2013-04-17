package com.bchd.inspection.ui.Control;

import com.bchd.inspection.R;
import com.bchd.inspection.bean.IValueText;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class TextControl extends CheckItemControl {

	EditText txt;
	
	public TextControl(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 当使用静态加载控件时，也就是直接在xml中声明控件时，需在此处引入布局文件
		// LayoutInflater.from(context).inflate(R.layout.selectcheckitemcontrol_view,
		// this, true);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		this.txt = (EditText) this.findViewById(R.id.txtValue);
		
	}
	
	@Override
	public IValueText getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(IValueText value) {
		// TODO Auto-generated method stub
		
	}

}
