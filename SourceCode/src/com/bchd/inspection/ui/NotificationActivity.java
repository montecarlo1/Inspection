package com.bchd.inspection.ui;

import java.util.ArrayList;

import com.bchd.inspection.R;
import com.bchd.inspection.bean.EmployeeInfo;
import com.bchd.inspection.dal.CommonDataAccess;
import com.bchd.inspection.dal.DDLItem;
import com.bchd.inspection.ui.SpotCheckActivity.SpinnerOnItemSelectListener;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
 * 稽查通知单
 */
public class NotificationActivity extends BaseActivity {

	// 通知单号
	private EditText txtCheckNoticeNumber = null;
	// 检查情况
	private EditText txtCheckResult = null;
	// 备注
	private EditText txtComments = null;
	// 违纪类型
	private Spinner cmbAntiDisciplineType = null;
	// 常见违纪类型
	private Spinner cmbCommonAntiDisciplineType = null;

	// 提交按钮
	private Button btn_submit = null;

	// 配置数据的数据访问类
	private CommonDataAccess commondata = new CommonDataAccess(this);

	
	private EmployeeInfo mWorkerInfo; //当前被稽查人;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_activity);
		prepareView();
		InitData();
	}

	/*
	 * 从布局中加载控件
	 */
	private void prepareView() {
		this.txtCheckNoticeNumber = (EditText) this
				.findViewById(R.id.txtCheckNoticeNo);
		this.txtCheckResult = (EditText) this.findViewById(R.id.txtCheckResult);
		this.txtComments = (EditText) this.findViewById(R.id.txtComments);
		
		this.cmbAntiDisciplineType = (Spinner) findViewById(R.id.cmbAntiDisciplineType);
				
		this.cmbCommonAntiDisciplineType = (Spinner) findViewById(R.id.cmbCommonAntiDisciplineType);
		Button btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(btn_Submit_OnClickListener);
	}

	/*
	 * 初始化数据
	 */
	private void InitData() {
		
		//违纪类型
		ArrayList<DDLItem> AntiDisciplineType_items = null;
		
		int postTypeID=112;//mWorkerInfo.getPostType().getID()
		AntiDisciplineType_items = commondata.GetAntiDisciplineTypes(postTypeID);
		ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(this,
				android.R.layout.simple_spinner_item, AntiDisciplineType_items); // 第二个参数表示spinner没有展开前的UI类型
		cmbAntiDisciplineType.setAdapter(aa); // 之前已经通过来获取spin对象
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cmbAntiDisciplineType.setOnItemSelectedListener(cmbAntiDisciplineTypeOnItemSelectListener);
	}
	
	/*
	 * 提交按钮事件
	 */
	private View.OnClickListener btn_Submit_OnClickListener=new View.OnClickListener()
	{

		@Override
		public void onClick(View v) {
					
		}	
		
	};
	
	/*
	 * 违纪类型下列列表被选事件
	 */
	private OnItemSelectedListener cmbAntiDisciplineTypeOnItemSelectListener=new OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			//如果取TEXT值则可以直接取:Sp.getSelectedItem.ToString()或者:((CItem)Sp.getSelectedItem). GetValue() ;
	    	//如果取Value值则可以这样取:((CItem)Sp.getSelectedItem).GetID();

	    	//String selected = AdapterView.getItemAtPosition(position).toString();  
	    	String id = ((DDLItem)cmbAntiDisciplineType.getSelectedItem()).GetID();
	    	
	    	//加载常见违纪类型下拉框
	    	ArrayList<DDLItem> items=  null;
	    	items = commondata.GetCommonAntiDisciplineTypes(id);
			ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(NotificationActivity.this,android.R.layout.simple_spinner_item,items); //第二个参数表示spinner没有展开前的UI类型 
			cmbCommonAntiDisciplineType.setAdapter(aa); //之前已经通过来获取spin对象 
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    	
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}}; 


}
