package com.bchd.inspection.ui;


import com.bchd.inspection.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Welcome extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }
    public void welcome_login(View v) {  
      	Intent intent = new Intent();
		intent.setClass(Welcome.this,Login.class);
		startActivity(intent);
		//this.finish();
      }  
    public void welcome_register(View v) {  
      	Intent intent = new Intent();
		intent.setClass(Welcome.this,MainActivity.class);
		startActivity(intent);
		//this.finish();
      }  
   
}
