package com.bchd.inspection.ui;


import com.bchd.inspection.R;
import android.os.Bundle;
import android.widget.TextView;

public class NoneRealTimeActivity extends BaseActivity {
	TextView mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nonerealtime_activity);
		prepareView();
		mTitleView.setText(R.string.category_nonerealtime);
	}

	private void prepareView() {
		mTitleView = (TextView) findViewById(R.id.title_text);
	}
}
