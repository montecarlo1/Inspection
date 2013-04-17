package com.bchd.inspection.ui;

import java.util.Calendar;

import com.bchd.inspection.R;
import com.bchd.inspection.ui.Control.DateTimeControl;
import com.bchd.inspection.ui.Control.NumberControl;
import com.bchd.inspection.ui.Control.SelectCheckItemControl;
import com.bchd.inspection.ui.Control.TextControl;
import com.bchd.inspection.ui.Control.date_select_control;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

public class RealTimeFormActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_no_page);
        
        LinearLayout layout=(LinearLayout)this.findViewById(R.id.linearLayout);
        
        LayoutInflater inflater = LayoutInflater.from(this);
        SelectCheckItemControl c=(SelectCheckItemControl) inflater.inflate(R.layout.selectcheckitemcontrol_view,layout,false);
        
        layout.addView(c); 
        
        NumberControl n=(NumberControl) inflater.inflate(R.layout.numbercontrol_view,layout,false);
        
        layout.addView(n); 
        
        DateTimeControl d=(DateTimeControl) inflater.inflate(R.layout.datetimecontrol_view,layout,false);
        
        layout.addView(d); 
        
        TextControl t=(TextControl) inflater.inflate(R.layout.textcontrol_view,layout,false);
        
        layout.addView(t); 
        
        EditText et=new EditText(this);
        layout.addView(et);
        
    }
}
