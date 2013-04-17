package com.bchd.inspection.dal;

import java.util.ArrayList;

import com.bchd.inspection.bean.CheckItemTypeInfo;
import com.bchd.inspection.bean.ConfigData;
import com.bchd.inspection.bean.FieldDataTypeInfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



//常用数据查询结构
public class CommonDataAccess {
	
	private DataBaseHelper helper;
	
	/*
	 * 通过传递应用程序的上下文来创建数据访问类，以便于能访问应用程序的资源
	 */
	public CommonDataAccess(Context context)
	{
		helper=new DataBaseHelper(context);		
	}
	/*
	 * 根据广场编码获取广场编号
	 */
	public ArrayList<DDLItem> GetAllPlaza(String plazaNO)
    {
		ArrayList<DDLItem> result = new ArrayList<DDLItem>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "select AliasName,PlazaNo FROM View_mobile_laneInfo "
        			+ "where companyId =5 AND TVirtualFlag = 0 AND SVirtualFlag= 0 ANd PVirtualFlag = 0 ";
        			
        if(plazaNO == "")
        {
        	sql +=  "Order by HDisplayOrder,TDisplayOrder,SDisaplyOrder,LDisplayOrder"; 
	        // 执行原始查询, 得到一个Cursor(类似ResultSet)  
	        c = db.rawQuery(sql, null);  
        }
        else
        {
        	sql +=  " AND PlazaNo = ? Order by HDisplayOrder,TDisplayOrder,SDisaplyOrder,LDisplayOrder"; 
	        // 执行原始查询, 得到一个Cursor(类似ResultSet)  
	        c = db.rawQuery(sql, new String[]{plazaNO});  
        	
        }
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	DDLItem item = new DDLItem(c.getString(c.getColumnIndex("PlazaNo")),c.getString(c.getColumnIndex("AliasName")) +"(" + c.getString(c.getColumnIndex("PlazaNo")) +")");
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 
        
        return result; 
    }
	
	/*
	 * 根据广场编码获取广场编号
	 */
	public ArrayList<DDLItem> GetAllLane(String plazaNO)
	{
		ArrayList<DDLItem> result = new ArrayList<DDLItem>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT LaneID,LaneName FROM View_Mobile_LaneInfo "
        			+ "WHERE companyId =5 AND TVirtualFlag = 0 AND SVirtualFlag= 0 ANd PVirtualFlag = 0 AND PlazaNo = ?"
        			+" Order by HDisplayOrder,TDisplayOrder,SDisaplyOrder,LDisplayOrder";
		// 执行原始查询, 得到一个Cursor(类似ResultSet)  
		c = db.rawQuery(sql, new String[]{plazaNO});  
        	
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	DDLItem item = new DDLItem(c.getString(c.getColumnIndex("LaneID")),c.getString(c.getColumnIndex("LaneName")));
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 
        
        return result; 
    }
	/*
	 * 根据workID获取姓名，班组
	 * 返回结果：workID，姓名,班组ID，班组名称，岗位类型
	 */
	public ArrayList<String> GetWorkerInfo(String workID)
	{
		ArrayList<String> result = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT WorkID,Name,WorkGroupID,WorkGroupName,PostTypeID, WorkNo FROM View_Mobile_WorkIDInfo WHERE workID =  ? ";
        			
		 c = db.rawQuery(sql, new String[]{ workID });  
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        if(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	result.add(c.getString(c.getColumnIndex("WorkID")));  
        	result.add(c.getString(c.getColumnIndex("Name")));  
        	result.add(c.getString(c.getColumnIndex("WorkGroupID")));  
        	result.add(c.getString(c.getColumnIndex("WorkGroupName"))); 
        	result.add(c.getString(c.getColumnIndex("PostTypeID"))); 
        	result.add(c.getString(c.getColumnIndex("WorkNo")));  
        }

        // 释放资源  
        c.close();  
        db.close(); 

        return result; 
	}
	
	/*
	 * 根据workID获取姓名，班组
	 * 返回结果：workID，姓名,班组ID，班组名称，岗位类型
	 */
	public ArrayList<DDLItem> GetWorkerGroups(String postTypeID)
	{
		ArrayList<DDLItem> result = new ArrayList<DDLItem>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT DISTINCT WorkGroupID,WorkGroupName FROM View_Mobile_StaffInfo WHERE PostTypeID  = ? ORDER BY GDisplayOrder";
        			
		 c = db.rawQuery(sql, new String[]{ postTypeID });  
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	DDLItem item = new DDLItem(c.getString(c.getColumnIndex("WorkGroupID")),c.getString(c.getColumnIndex("WorkGroupName")));
        	
        	result.add(item); 
        }

        // 释放资源  
        c.close();  
        db.close(); 

        return result; 
	}
	public ArrayList<String> GetCheckItems(String PostTypeID)
	{
		ArrayList<String> result = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT CheckItemTypeName FROM CheckItemType WHERE CheckClassID = ? AND CURRENT_TIMESTAMP BETWEEN StartTime AND EndTime ORDER BY DisplayOrder";
        			
		 c = db.rawQuery(sql, new String[]{ PostTypeID });  
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
		 while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
			String item = c.getString(c.getColumnIndex("CheckItemTypeName"));
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 

        return result; 
	}
	
	/*
	 * 根据岗位类别posttypeID 返回 违纪类型
	 */
	public ArrayList<DDLItem> GetAntiDisciplineTypes(int posttypeID)
    {
		ArrayList<DDLItem> result = new ArrayList<DDLItem>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT AntiDisciplineTypeID,CheckClassID,AntiDisciplineTypeName,DisplayOrder,StartTime,EndTime,Flag,AssessTypeID,Comment,CreatedRecordTime "
        			+ "FROM AntiDisciplineTypeConfig where  CheckClassID=? and datetime('now', '+8 hours') between StartTime and EndTime";
        String strPostTypeID=String.valueOf(posttypeID); ;
		c = db.rawQuery(sql, new String[]{ strPostTypeID });  
        
        //Log.e("GetAntiDisciplineTypes",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	DDLItem item = new DDLItem(c.getString(c.getColumnIndex("AntiDisciplineTypeID")),c.getString(c.getColumnIndex("AntiDisciplineTypeName")));
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 
        
        return result; 
    }
	
	/*
	 * 根据违纪类型编号 返回 常见违纪类型
	 */
	public ArrayList<DDLItem> GetCommonAntiDisciplineTypes(String antiDisciplineTypeID)
    {
		ArrayList<DDLItem> result = new ArrayList<DDLItem>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT  CommonAntiDisciplineID,CommonAntiDisciplineName FROM CommonAntiDisciplineConfig "
        			+ "where AntiDisciplineTypeID=? and datetime('now', '+8 hours') between StartTime and EndTime order by DisplayOrder ";
      
		c = db.rawQuery(sql, new String[]{ antiDisciplineTypeID });  
        
        //Log.e("GetCommonAntiDisciplineTypes",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
        while(c.moveToNext())  
        {
        	//Log.e("LEILEI",c.getString(c.getColumnIndex("PlazaNo")));
        	DDLItem item = new DDLItem(c.getString(c.getColumnIndex("CommonAntiDisciplineID")),c.getString(c.getColumnIndex("CommonAntiDisciplineName")));
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 
        
        return result; 
    }
	
	/*
	 * 返回待检查项目的元数据
	 */
	public ArrayList<CheckItemTypeInfo> GetCheckItemType(int chekmethod, int posttype)
	{
		ArrayList<CheckItemTypeInfo> result = new ArrayList<CheckItemTypeInfo>();
        SQLiteDatabase db = helper.getReadableDatabase(); 
        Cursor c = null;
        
		String sql = "SELECT [CheckItemTypeID],[CheckMethodID],[CheckClassID],[CheckItemTypeName],[ItemDataType],[DisplayOrder],[StartTime],[EndTime],[DefaultValue],[Comment],[CreatedRecordTime] FROM [CheckItemType] where CheckMethodID=? and CheckClassID=? and datetime('now', '+8 hours') between StartTime and EndTime order by DisplayOrder";
        			
		 c = db.rawQuery(sql, new String[]{ String.valueOf(chekmethod),String.valueOf(posttype) });  
        //Log.e("LEILEI",String.valueOf(c.getCount()));
        // 判断Cursor是否有下一条记录  
		 while(c.moveToNext())  
        {
			CheckItemTypeInfo item=createCheckItemTypeInfo(c);
        	result.add(item);  
        }

        // 释放资源  
        c.close();  
        db.close(); 

        return result; 
	}
	
	//读取数据库中的行，创建待稽查项
	private CheckItemTypeInfo createCheckItemTypeInfo(Cursor c)
	{
		int id = c.getInt(c.getColumnIndex("CheckItemTypeID")); 
        String title =c.getString(c.getColumnIndex("CheckItemTypeName")); 
        String code = null;

        CheckItemTypeInfo temp = new CheckItemTypeInfo(id, title, code);
        int displayOrder=c.getInt(c.getColumnIndex("DisplayOrder"));
        temp.setDisplayOrder(displayOrder);
        
        
        //temp.StartTime = reader["StartTime"].ToDateTime();
        //temp.EndTime = reader["EndTime"].ToDateTime();
        //temp.Comment = reader["Comment"].ToText();
        //temp.CreatedRecordTime = reader["CreatedRecordTime"].ToDateTime();
        int checkMethodID=c.getInt(c.getColumnIndex("CheckMethodID"));
        temp.setCheckMethodID(checkMethodID);
        int checkClassID=c.getInt(c.getColumnIndex("CheckClassID"));
        temp.setCheckClassID(checkClassID);

        int itemDataType=c.getInt(c.getColumnIndex("ItemDataType"));        
        FieldDataTypeInfo dataType = ConfigData.GetFieldDataType(itemDataType);
        
        //int defaultValue=c.getInt(c.getColumnIndex("DefaultValue"));  
        
        //dataType.CreateDefaultValue(defaultValue);

        temp.setDataType(dataType);

        return temp;		
	}
}
