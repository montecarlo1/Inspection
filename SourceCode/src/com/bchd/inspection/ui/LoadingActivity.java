package com.bchd.inspection.ui;



import com.bchd.inspection.R;

import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends BaseActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.loading);
			
	new Handler().postDelayed(new Runnable(){
		@Override
		public void run(){
//			Intent intent = new Intent (LoadingActivity.this,Whatsnew.class);			
//			startActivity(intent);			
//			LoadingActivity.this.finish();
//			Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
		}
	}, 200);
   }
}