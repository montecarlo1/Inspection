package com.bchd.inspection.ui.Control;

import com.bchd.inspection.R;
import com.bchd.inspection.bean.ConfigData;
import com.bchd.inspection.bean.IValueText;
import com.bchd.inspection.bean.SelectField;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;


public class SelectCheckItemControl extends CheckItemControl {

	//private RadioGroup radioGroup;
	private RadioButton radPass, radFail, radNA;

	// public SelectCheckItemControl(Context context){
	// super(context);
	// LayoutInflater.from(context).inflate(R.layout.selectcheckitemcontrol_view,
	// this, true);
	// }

	public SelectCheckItemControl(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 当使用静态加载控件时，也就是直接在xml中声明控件时，需在此处引入布局文件
		// LayoutInflater.from(context).inflate(R.layout.selectcheckitemcontrol_view,
		// this, true);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		//this.radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup);
		this.radPass = (RadioButton) this.findViewById(R.id.adCheckNoticeType1);
		this.radFail = (RadioButton) this.findViewById(R.id.radFail);
		this.radNA = (RadioButton) this.findViewById(R.id.radNA);
	}

	@Override
	public IValueText getValue() {
		SelectCheckItemControlValue internalValue = SelectCheckItemControlValue.Pass;

		if (radFail.isChecked())
			internalValue = SelectCheckItemControlValue.Fail;
		else if (radNA.isChecked())
			internalValue = SelectCheckItemControlValue.NA;

		return ConfigData.GetCheckResultType(internalValue.ordinal());
	}

	@Override
	public void setValue(IValueText value) {
		if (value instanceof SelectField) {

			int intValue=(Integer)value.getValue();
			SelectCheckItemControlValue internalValue = SelectCheckItemControlValue.values()[intValue];
				
			switch (internalValue) {
			case Pass:
				radPass.setChecked(true);
				break;
			case Fail:
				radFail.setChecked(true);
				break;
			case NA:
				radNA.setChecked(true);
				break;
			}
		}
	}
}
