package com.bchd.inspection.ui;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bchd.inspection.AppContext;
import com.bchd.inspection.R;
import com.bchd.inspection.bean.CategoryInfo;
import com.bchd.inspection.bean.CheckSheetInfo;
import com.bchd.inspection.bean.RecordStatus;
import com.bchd.inspection.dal.CheckManager;
import com.bchd.inspection.dal.CommonDataAccess;
import com.bchd.inspection.dal.DDLItem;
import com.bchd.inspection.ui.Control.date_select_control;
import com.bchd.inspection.ui.Control.time_select_control;
/*
 * 上岗注册
 */
public class CheckInActivity  extends Activity{
	private date_select_control detate = null;
	private time_select_control detime = null;
	private Spinner spin_checkergroup = null;
	private Button btn_submit = null;
	private EditText et_sheetNo = null;
	private Bundle Ibundle = null;
	private TextView tv_Title = null;
	private CommonDataAccess commondata = null;
	private AppContext con = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.checkin_activity);
		prepareView();
		//修改title名称
		
		String title=Ibundle.getString("Title");
		tv_Title.setText(title);

		btn_submit.setOnClickListener(new OnClickListener(){
			public void onClick(View v){

				//submit
				insertSheetInfo();
				
			}
		});	
	}
	/*
	 * 获取控件
	 */
	private void prepareView()
	{
		tv_Title = (TextView)findViewById(R.id.txtTitle);
		et_sheetNo = (EditText)findViewById(R.id.et_sheetNo);
		btn_submit = (Button)findViewById(R.id.btn_submit);
		detate = (date_select_control)findViewById(R.id.de_date);
		detime = (time_select_control)findViewById(R.id.de_time);
		spin_checkergroup = (Spinner) findViewById(R.id.spin_checkergroup);
        Ibundle=getIntent().getExtras();
        //加载稽查班组
        commondata = new CommonDataAccess(CheckInActivity.this);
        con= (AppContext) getApplication();
        ArrayList<DDLItem> checkerGroups_items=  null;
        checkerGroups_items = commondata.GetWorkerGroups(con.POSTTYPE_CHECKER);
		ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(this,android.R.layout.simple_spinner_item,checkerGroups_items); //第二个参数表示spinner没有展开前的UI类型 
		spin_checkergroup.setAdapter(aa); //之前已经通过来获取spin对象 
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	}
	
	private void insertSheetInfo(){
		
		CheckSheetInfo sinfo = new CheckSheetInfo();
		//UUID newSheetNo = UUID.randomUUID();
		UUID newSheetNo = sinfo.getCheckSheetNo();
		//CategoryInfo checkMethod = (CategoryInfo)Ibundle.getSerializable("checkMethod");				
		
		sinfo.setCheckMethod(new CategoryInfo(Ibundle.getInt("checkMethodID"),Ibundle.getString("checkMethod")));
		sinfo.setCheckClass(new CategoryInfo( Integer.parseInt(con.POSTTYPE_CHARGER),"收费员"));
		//sinfo.setCheckStartTime(new Date());
		sinfo.setCheckEndTime(new Date());
		sinfo.setComment("");
		//sinfo.setCheckSheetNo(newSheetNo);
		sinfo.setRecordStatus(RecordStatus.New);
		sinfo.setFirstNo(et_sheetNo.getText().toString().trim());
		sinfo.setEndNo(et_sheetNo.getText().toString().trim());
		int checkerGroup = new Long(spin_checkergroup.getSelectedItemId()).intValue();//
		sinfo.setCheckerGroup(checkerGroup);//? lily
		sinfo.setCheckers(con.getLoginUsers());//稽查员信息
		//sinfo.setCreatedRecordTime(new Date());
		
		CheckManager cm = new CheckManager(CheckInActivity.this);
		boolean result = cm.AddCheckSheet(sinfo);
		if(result)
		{
			Toast.makeText(CheckInActivity.this, "操作成功",Toast.LENGTH_SHORT).show();
			//跳转到稽查录入界面
			Intent intent = new Intent (CheckInActivity.this,SpotCheckActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Title", "现场稽查录入"); 
			bundle.putInt("checkMethodID", 3); //现场稽查ID
			bundle.putString("checkMethod", "现场稽查"); //现场稽查ID
			bundle.putSerializable("SheetNo", newSheetNo);
			intent.putExtras(bundle);
			startActivity(intent);
			
		}
		else
		{
			Toast.makeText(CheckInActivity.this, "操作失败",Toast.LENGTH_SHORT).show();
		}
	}

}
