package com.bchd.inspection.ui;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bchd.inspection.AppContext;
import com.bchd.inspection.R;
import com.bchd.inspection.bean.CheckExtensionItemInfo;
import com.bchd.inspection.bean.CheckItemInfo;
import com.bchd.inspection.bean.RecordStatus;
import com.bchd.inspection.dal.CheckManager;
import com.bchd.inspection.dal.CommonDataAccess;
import com.bchd.inspection.dal.DDLItem;
import com.bchd.inspection.ui.Control.CheckItemControl;
import com.bchd.inspection.ui.Control.SelectCheckItemControl;

public class SpotCheckActivity  extends BaseActivity{
	private Spinner spin_plaza=null;  
	private Spinner spin_lane = null;

	private ArrayList<String> workerInfo = null;
	private EditText et_workID = null;
	private EditText et_name = null;
	private EditText et_workgroup = null;
	private EditText et_plazaNo = null;
	private Bundle Ibundle = null;
	private TextView tv_Title = null;
	private AppContext con = null; 
	Button btn_NoInfo = null;
	Button btn_submit = null;
	
	//稽查项目控件列表
	private ArrayList<CheckItemControl> checkItems=new ArrayList<CheckItemControl>();
	
	private CommonDataAccess commondata = new CommonDataAccess(SpotCheckActivity.this);
	@Override
	public void onCreate(Bundle savedInstanceState) {		
		
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.spotcheck_activity);
		
		prepareView();
		
		//修改title名称
		Ibundle=getIntent().getExtras();
		String title=Ibundle.getString("Title");		
		tv_Title.setText(title);
		
		//注册信息加载事件
		
		//et_workID.addTextChangedListener(workID_textWatcher);
		et_workID.setOnFocusChangeListener(new OnFocusChangeListener(){
		        public void onFocusChange(View v, boolean hasFocus) {
		        		if(!hasFocus){
		        			//根据员工号加载员工信息
		        			//Log.e("Leilei",et_workID.getText().toString());
		        			workerInfo  = commondata.GetWorkerInfo(et_workID.getText().toString());
		        			if(workerInfo.equals(null))
		        				Toast.makeText(SpotCheckActivity.this, "无此员工信息", Toast.LENGTH_SHORT).show();
		        			else{
		        				et_name.setText(workerInfo.get(1));
		        				et_workgroup.setText(workerInfo.get(3));
		        				//加载检查子项
		        				CreateCheckItems(workerInfo.get(4));
		        				
		        			}
		        		}
		        }
		});
		btn_NoInfo.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//根据姓名查找
				Intent intent = new Intent (SpotCheckActivity.this,FindWorkerInfo.class);			
				startActivity(intent);	
			}
		});	
		btn_submit.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
					insertCheckRecordMain();
				
			}
		});	
		//注册广场编码事件
		et_plazaNo.addTextChangedListener(plaza_textWatcher);

		//加载广场下拉菜单
		ArrayList<DDLItem> plaza_items=  null;
		plaza_items = commondata.GetAllPlaza("");
		ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(this,android.R.layout.simple_spinner_item,plaza_items); //第二个参数表示spinner没有展开前的UI类型 
		spin_plaza.setAdapter(aa); //之前已经通过来获取spin对象 
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin_plaza.setOnItemSelectedListener(new SpinnerOnItemSelectListener());  
		
   }
	private void prepareView()
	{
		tv_Title = (TextView)findViewById(R.id.txtTitle);
		et_workID = (EditText)findViewById(R.id.et_workID);
		et_name = (EditText)findViewById(R.id.et_name);
		et_workgroup = (EditText)findViewById(R.id.et_workgroup);
		btn_NoInfo = (Button)findViewById(R.id.btn_NoInfo);
		btn_submit = (Button)findViewById(R.id.btn_submit);
		et_plazaNo = (EditText)findViewById(R.id.et_plazaNo);
		spin_plaza = (Spinner) findViewById(R.id.spin_plaza);
		spin_lane = (Spinner) findViewById(R.id.spin_lane);
		con= (AppContext) getApplication();
	}
	/*
	 * 根据workID加载检查子项
	 */
	private void CreateCheckItems(String PostTypeID)
	{
		LinearLayout layout=(LinearLayout)this.findViewById(R.id.ll_SpotCheck);
		LayoutInflater inflater = LayoutInflater.from(this);
		SelectCheckItemControl c= null;
		ArrayList<String> items = null;
		
		items = commondata.GetCheckItems(PostTypeID);
		for(int i = 0; i< items.size();i++)
		{
			c=(SelectCheckItemControl) inflater.inflate(R.layout.selectcheckitemcontrol_view,layout,false);  
			c.setTitle(items.get(i));
			layout.addView(c); 
			checkItems.add(c);
		}
	
	}
	private TextWatcher plaza_textWatcher = new TextWatcher() {             
		@Override        
		public void beforeTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
		{            
			       
		}               
		@Override        
		public void onTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
		{
			     
		}               
		@Override        
		public void afterTextChanged(Editable s) 
		{            
			ArrayList<DDLItem> plaza_items=  null;
			plaza_items = commondata.GetAllPlaza(et_plazaNo.getText().toString().trim());
			ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(SpotCheckActivity.this,android.R.layout.simple_spinner_item,plaza_items); //第二个参数表示spinner没有展开前的UI类型 
			spin_plaza.setAdapter(aa); //之前已经通过来获取spin对象 
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		}    
	};
	private TextWatcher workID_textWatcher = new TextWatcher() {             
		@Override        
		public void beforeTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
		{            
			       
		}               
		@Override        
		public void onTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
		{
			     
		}               
		@Override        
		public void afterTextChanged(Editable s) 
		{            
			//根据员工号加载员工信息
			workerInfo  = commondata.GetWorkerInfo(et_workID.getText().toString());
			System.out.print(workerInfo);
			if(workerInfo.equals(null))
				Toast.makeText(SpotCheckActivity.this, "无此员工信息", Toast.LENGTH_SHORT).show();
			else{
				et_name.setText(workerInfo.get(1));
				et_workgroup.setText(workerInfo.get(3));
			}
		}    
	};
	class SpinnerOnItemSelectListener implements OnItemSelectedListener{  
	    @Override  
	    public void onItemSelected(AdapterView<?> AdapterView, View view, int position,  long arg3) 
	    {  
	        // TODO Auto-generated method stub   
	    	//如果取TEXT值则可以直接取:Sp.getSelectedItem.ToString()或者:((CItem)Sp.getSelectedItem). GetValue() ;
	    	//如果取Value值则可以这样取:((CItem)Sp.getSelectedItem).GetID();

	    	//String selected = AdapterView.getItemAtPosition(position).toString();  
	    	String plazaNo = ((DDLItem)spin_plaza.getSelectedItem()).GetID();
	    	//et_plazaNo.setText(plazaNo);
	    	//加载道次下拉框
	    	ArrayList<DDLItem> Lane_items=  null;
	    	Lane_items = commondata.GetAllLane(plazaNo);
			ArrayAdapter<DDLItem> aa = new ArrayAdapter<DDLItem>(SpotCheckActivity.this,android.R.layout.simple_spinner_item,Lane_items); //第二个参数表示spinner没有展开前的UI类型 
			spin_lane.setAdapter(aa); //之前已经通过来获取spin对象 
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    	
	    }    
	    @Override  
	    public void onNothingSelected(AdapterView<?> arg0) {  
	        // TODO Auto-generated method stub   
	        System.out.println("NothingSelected");  
	    }  
      
}  
	
	private boolean insertCheckRecordMain()
	{
		
		CheckItemInfo itemInfo = new CheckItemInfo();
		UUID newMainID=  UUID.randomUUID();
		//CheckExtensionItemInfo subInfo = new CheckExtensionItemInfo();
		itemInfo.setWorkNo(workerInfo.get(5).toString());
		//itemInfo.setWorkGroup( new CategoryInfo(Integer.parseInt(workerInfo.get(2)),workerInfo.get(3)));
		itemInfo.setStation(spin_plaza.getId());
		//itemInfo.setLane(new CategoryInfo(((DDLItem)spin_lane.getSelectedItem()).GetID(),(DDLItem)spin_lane.getSelectedItem()).GetValue());
        itemInfo.setCheckedTime(new java.util.Date());//lily ?
        itemInfo.setComment("");//lily??
        itemInfo.setCheckSheetNO(con.getSheetInfos(con.METHORD_SPOT).getCheckSheetNo());
        itemInfo.setCheckRecordID(newMainID);
        itemInfo.setStatus(RecordStatus.New);
        itemInfo.setLaneRecordID(0);//lily ?
        itemInfo.setWorker(0);//@StaffID lily ?
        //itemInfo.setWorkGroupRecordID(value)//@WorkGroupRecordID lily ?
        itemInfo.setCheckedTime(new java.util.Date());//@CreatedRecordTime lily ?
        //itemInfo.setShift(value) //@ShiftID lily ?
        
        ArrayList<CheckExtensionItemInfo> subInfo = null;
		
        CheckManager cm = new CheckManager(SpotCheckActivity.this);
		boolean result = cm.AddCheckItem(itemInfo, subInfo);
		if(result)
		{
			Toast.makeText(SpotCheckActivity.this, "操作成功",Toast.LENGTH_SHORT).show();
			
		}
		else
		{
			Toast.makeText(SpotCheckActivity.this, "操作失败",Toast.LENGTH_SHORT).show();
		}
		return true;
	}
}
;