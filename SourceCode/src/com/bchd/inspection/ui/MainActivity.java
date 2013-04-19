package com.bchd.inspection.ui;

import com.bchd.inspection.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener,IBaseActivity {

	@Override
	public void Init() {
		//添加Activity到堆栈
		BaseActivity.InitActivity(this);
	}

	@Override
	public void Dispose() {
		//结束Activity&从堆栈中移除
		BaseActivity.DisposeActivity(this);		
	}

	private RadioGroup mainTab;
	private TabHost mTabHost;

	// 待跳转的Intent
	private Intent mRealTimeIntent;
	private Intent mNoneRealTimeIntent; 
	private Intent mSearchIntent; 

	private final static String TAB_TAG_RealTime = "tab_tag_RealTime";
	private final static String TAB_TAG_NoneRealTime = "tab_tag_NoneRealTime"; 
	private final static String TAB_TAG_SEARCH = "tab_tag_search"; 
	/** Called when the activity is first created. */	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Init();
		
		//requestWindowFeature(Window.FEATURE_NO_TITLE); //设置窗口
		setContentView(R.layout.main);
		mainTab = (RadioGroup) findViewById(R.id.main_radio);
		mainTab.setOnCheckedChangeListener(this);
		prepareIntent();
		setupTabs();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy(); 
		this.Dispose();
	}

	/**
	 * 初始化Intent
	 */
	private void prepareIntent() {
		mRealTimeIntent = new Intent(this, RealTimeActivity.class);
		mNoneRealTimeIntent = new Intent(this, NoneRealTimeActivity.class); 
		mSearchIntent = new Intent(this, SearchActivity.class); 
	}

	/**
	 * 设置tab页
	 */
	private void setupTabs() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;
		localTabHost.addTab(buildTabSpec(TAB_TAG_RealTime,
				R.string.category_realtime, R.drawable.main_001,
				this.mRealTimeIntent));
		localTabHost.addTab(buildTabSpec(TAB_TAG_NoneRealTime,
				R.string.category_nonerealtime, R.drawable.main_002,
				this.mNoneRealTimeIntent)); 
		localTabHost.addTab(buildTabSpec(TAB_TAG_SEARCH,
				R.string.category_search, R.drawable.main_003, mSearchIntent));
		 
		
	}

	/**
	 * 创建单个Tab页
	 * 
	 * @param tag
	 *            标签
	 * @param resLabel
	 *            标题
	 * @param resIcon
	 *            图标
	 * @param content
	 *            内容Intent
	 * @return TabSpec
	 */
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),getResources().getDrawable(resIcon))
				.setContent(content);
	}

	/*
	 * 处理单选按钮组的事件
	 * @see android.widget.RadioGroup.OnCheckedChangeListener#onCheckedChanged(android.widget.RadioGroup, int)
	 */
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.radio_button0:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_RealTime);
			break;
		case R.id.radio_button1:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_NoneRealTime);
			break;
		case R.id.radio_button2:
			this.mTabHost.setCurrentTabByTag(TAB_TAG_SEARCH);
			break; 
		}
	}
}