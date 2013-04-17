package com.bchd.inspection.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bchd.inspection.bean.EmployeeInfo;

public class UserDataAccess {
	
	private DataBaseHelper helper;
	
	/*
	 * 通过传递应用程序的上下文来创建数据访问类，以便于能访问应用程序的资源
	 */
	public UserDataAccess(Context context)
	{
		helper=new DataBaseHelper(context);		
	}
	
	public EmployeeInfo GetUserByIDAndPwd(String loginName, String Pwd)
    {

        String sql = "SELECT StaffID,[RealName] FROM [UserConfig] where LoginName=? and Password=?";

        SQLiteDatabase db = helper.getReadableDatabase();  
        
        // 执行原始查询, 得到一个Cursor(类似ResultSet)  
        Cursor curor = db.rawQuery(sql, new String[] { loginName, Pwd });   
        EmployeeInfo p = null;  
          
        // 判断Cursor是否有第一条记录            
        if (curor.moveToFirst())    
        {  
        	// 从Cursor中获取数据, 创建用户对象    
        	int staffID;  
        	String name;  
        	
        	staffID=curor.getInt(curor.getColumnIndex("StaffID"));  
        	name=curor.getString(curor.getColumnIndex("RealName"));  
        	p=new EmployeeInfo(staffID,name,loginName);  
        	p.setPassword(Pwd);      
        }  
	    // 释放资源       
        curor.close(); 
        db.close();  
        return p; 
    }
	
}
