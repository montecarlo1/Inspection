package com.bchd.inspection.ui;

import com.bchd.inspection.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MoreActivity extends BaseActivity {
	TextView mTitleView;
	
	TextView mtxtSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_activity);
		prepareView();
		mTitleView.setText(R.string.category_more);
		
		mtxtSettings.setOnClickListener(txtSettings_OnClickListener);
	}

	private void prepareView() {
		mTitleView = (TextView) findViewById(R.id.title_text);
		
		mtxtSettings=(TextView)findViewById(R.id.txtSetting);
	}
	
	private View.OnClickListener txtSettings_OnClickListener=new View.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent (MoreActivity.this,CameraActivity.class);			
			startActivity(intent);			
		}		
		
	};
	
}
