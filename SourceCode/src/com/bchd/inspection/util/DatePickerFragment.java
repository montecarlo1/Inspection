package com.bchd.inspection.util;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

	@Override 
	public Dialog onCreateDialog(Bundle savedInstanceState) 
	{
		return new DatePickerDialog(getActivity(), this, 2013, 3, 1);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}
}
