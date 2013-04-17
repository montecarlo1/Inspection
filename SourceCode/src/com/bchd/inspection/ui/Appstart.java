package com.bchd.inspection.ui;

import com.bchd.inspection.R;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

/*
 * 程序启动页
 */
public class Appstart extends BaseActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.appstart);
		
		//延迟1秒后，启动登录页并关闭当前页
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				//Intent intent = new Intent (Appstart.this,Login.class);
				Intent intent = new Intent (Appstart.this,Login.class);		
				startActivity(intent);			
				Appstart.this.finish();
			}
		}, 1000);
   }
}