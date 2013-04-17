package com.bchd.inspection.ui;


import com.bchd.inspection.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OthersActivity extends BaseActivity {
	TextView mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.others_activity);
		prepareView();
		mTitleView.setText(R.string.category_others);
	}

	private void prepareView() {
		mTitleView = (TextView) findViewById(R.id.title_text);
	}
}
