package com.bchd.inspection;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.widget.Toast;

import com.bchd.inspection.bean.*;
import com.bchd.inspection.dal.DataBaseHelper;

/*
 * 全局应用程序类：用于保存和调用全局应用配置
 */
public class AppContext extends Application {

	public static Context context;
	private static Handler handler;
	
	//全局变量
	public static final String POSTTYPE_CHECKER = "120";
	public static final String POSTTYPE_CHARGER= "112";
	
	public static final String METHORD_SPOT = "现场稽查";
	public static final String METHORD_ALL= "集中暗查";
	
	//已经登录的用户列表
	private ArrayList<EmployeeInfo> loginUsers;
	private String usersStr = "";
	private ArrayList<CheckSheetInfo> sheetInfos; //各种稽查方法的sheet基本信息
	
	@Override
	public void onCreate() {		
		super.onCreate();
		
		context= this.getBaseContext();
		handler = new Handler();
		loginUsers=new ArrayList<EmployeeInfo>();
		sheetInfos = new ArrayList<CheckSheetInfo>();
		//初始化数据库，将数据库拷贝到系统目录
		initDatabase();		
	}
	
	/*
	 * 初始化数据库
	 */
	private void initDatabase(){		
		DataBaseHelper dbHelper;		
		try {
			dbHelper = new DataBaseHelper(this);
			dbHelper.createDataBase();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	
	public static void showToast(final int resId) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
			}
		});
	}

	public static void showToast(final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
			}
		});
	}

	/**
	 * 获取App安装包信息
	 * @return
	 */
	public PackageInfo getPackageInfo() {
		PackageInfo info = null;
		try { 
			info = getPackageManager().getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e) {    
			e.printStackTrace(System.err);
		} 
		if(info == null) info = new PackageInfo();
		return info;
	}
	
	public Boolean Login(String uid,String pwd)
	{
		EmpManager empMgr=new EmpManager(context);
		EmployeeInfo userInfo= empMgr.Login(uid, pwd);
		if(userInfo!=null)
		{
			this.loginUsers.add(userInfo);
			return true;
		}
		else
			return false;
	}
	
	/*
	 * 返回当前登录用户列表
	 */
	public ArrayList<EmployeeInfo> getLoginUsers()
	{
		return this.loginUsers;		
	}
	/*
	 * 返回登录用户字串，用“，”间隔
	 * IsLogin 为true时，表示登陆人信息有修改，需要重新查询
	 */
	public String getLoginUsersString(boolean IsLogin)
	{
		if(IsLogin)
		{
			usersStr = "";
			for(int i = 0;i<loginUsers.size();i++)
				usersStr += loginUsers.get(i).getName() + " ";
		}
		return usersStr;		
	}
	
	/*
	 * 设置sheet信息
	 */
	public void setSheetInfos(CheckSheetInfo sheetInfo)
	{
		sheetInfos.add(sheetInfo);
	}
	/*
	 * 获取各个稽查方法的sheet信息
	 */
	public CheckSheetInfo getSheetInfos(String checkMethod)
	{
		for(int i = 0; i<sheetInfos.size();i++)
		{
			if(sheetInfos.get(i).getCheckMethod().getText().equals(checkMethod))
				return sheetInfos.get(i);	
		}
		return null;
	}
}
