package com.bchd.inspection.ui.Control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bchd.inspection.R;
import com.bchd.inspection.ui.MoreActivity;
import com.bchd.inspection.ui.RealTimeFormActivity;
import com.bchd.inspection.util.DatePickerFragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

public class time_select_control extends LinearLayout
{
	EditText mEdit;
	ImageButton mBtn;
		
	private int hour;
	private int minute;
	
	
	public time_select_control(Context context, AttributeSet attrs) {
		super(context, attrs);		
	}	
	
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		// 当使用静态加载控件时，也就是直接在xml中声明控件时，需在此处引入布局文件
		LayoutInflater.from(this.getContext()).inflate(R.layout.date_select_control,
						this, true);
		mEdit = (EditText)findViewById(R.id.txtDate);
		mBtn=(ImageButton)this.findViewById(R.id.btn_SelectDate);
		mBtn.setOnClickListener(btnSelectDate_OnClickListener);
		//设置当前日期到textView中
		setCurrentTimeOnView();		
	}

	/*
	 * 选择日期按钮的单击事件
	 */
	private View.OnClickListener btnSelectDate_OnClickListener=new View.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			TimePickerDialog dialog=new android.app.TimePickerDialog(time_select_control.this.getContext(), time_select_control.this.timeSetListener,time_select_control.this.hour,time_select_control.this.minute, true);
	    	dialog.show();
		}	
		
	};
    
    /*
     * 日期对话框的回调函数 
     */
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			time_select_control.this.populateSelectTime(hourOfDay, minute);
		}

 		
 	};
    
    /*
     * 设置当前日期到文本框
     */
   	public void setCurrentTimeOnView() {

   		final Calendar c = Calendar.getInstance();
   		int h = c.get(Calendar.HOUR_OF_DAY);
   		int m = c.get(Calendar.MINUTE);
   	
   		populateSelectTime(h,m);
   	}
     
   	/*
   	 * 设置日期到文本框中
   	 */
     public void populateSelectTime(int h, int m) {
     	this.hour=h;
     	this.minute=m;     	
     	mEdit.setText(h+":"+m);
     }
     
     /*
      * 获取日期
      */
     public Date getDate()
     {
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	 java.util.Date dt=null;
			try {
				dt = sdf.parse(mEdit.getText().toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 return dt;  	 
     }
     
     /*
      * 获取日期
      */
     public void setDate(Date dt)
     {
    	 if(dt!=null)
    	 {
    		 this.populateSelectTime(dt.getHours(),dt.getMinutes()) ;   		 
    	 }
    	 else
    		 this.mEdit.setText(null);
     }
}
