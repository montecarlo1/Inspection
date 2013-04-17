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
import android.view.View;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

public class date_select_control extends LinearLayout
{
	EditText mEdit;
	ImageButton mBtn;
		
	private int year;
	private int month;
	private int day;
	
	public date_select_control(Context context, AttributeSet attrs) {
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
		setCurrentDateOnView();		
	}

	/*
	 * 选择日期按钮的单击事件
	 */
	private View.OnClickListener btnSelectDate_OnClickListener=new View.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			DatePickerDialog dialog=new android.app.DatePickerDialog(date_select_control.this.getContext(), date_select_control.this.datePickerListener, date_select_control.this.year, date_select_control.this.month,date_select_control.this.day);				//this.CreateDialog(DATE_DIALOG_ID);
	    	dialog.show();
		}	
		
	};
    
    /*
     * 日期对话框的回调函数 
     */
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

 		// when dialog box is closed, below method will be called.
 		public void onDateSet(DatePicker view, int selectedYear,
 				int selectedMonth, int selectedDay) {			
 			populateSetDate(selectedYear,selectedMonth,selectedDay);		

 		}
 	};
    
    /*
     * 设置当前日期到文本框
     */
   	public void setCurrentDateOnView() {

   		final Calendar c = Calendar.getInstance();
   		int year = c.get(Calendar.YEAR);
   		int month = c.get(Calendar.MONTH);
   		int day = c.get(Calendar.DAY_OF_MONTH);
   		populateSetDate(year,month,day);
   	}
     
   	/*
   	 * 设置日期到文本框中
   	 */
     public void populateSetDate(int year, int month, int day) {
     	this.year=year;
     	this.month=month;
     	this.day=day;
     	
     	mEdit.setText(year+"-"+(month+1)+"-"+day);
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
    		 populateSetDate(dt.getYear(), dt.getMonth(), dt.getDay());   		 
    	 }
    	 else
    		 this.mEdit.setText(null);
     }
}
