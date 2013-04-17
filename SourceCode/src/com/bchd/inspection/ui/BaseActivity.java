package com.bchd.inspection.ui;

import com.bchd.inspection.util.AppManager;
import android.app.Activity;
import android.os.Bundle;

/**
 * 应用程序Activity的基类
 */
public class BaseActivity extends Activity implements IBaseActivity
{

	@Override
	public void Init() {
		InitActivity(this);
		
	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		DisposeActivity(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.Init();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		this.Dispose();
	}
	
	public static void InitActivity(Activity activity)
	{
		//添加Activity到堆栈
		AppManager.getAppManager().addActivity(activity);		
	}
	
	public static void DisposeActivity(Activity activity)
	{
		//结束Activity&从堆栈中移除
		AppManager.getAppManager().finishActivity(activity);		
	}
}
