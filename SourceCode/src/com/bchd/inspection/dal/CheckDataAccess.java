package com.bchd.inspection.dal;

import java.util.Date;
import java.util.UUID;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bchd.inspection.bean.CheckExtensionItemInfo;
import com.bchd.inspection.bean.CheckItemInfo;
import com.bchd.inspection.bean.CheckSheetInfo;
import com.bchd.inspection.bean.RecordStatus;

	/*
	 * 稽查数据库操作
	 */
	public class CheckDataAccess {
	private DataBaseHelper _dbHelper = null;
	private SQLiteDatabase _db = null;
	private boolean _InTransaction = false;	
	/*
	 * 通过传递应用程序的上下文来创建数据访问类，以便于能访问应用程序的资源
	 */
	public CheckDataAccess(Context context)
	{
		_dbHelper=new DataBaseHelper(context);	
		if (_dbHelper != null)
			_db = _dbHelper.getReadableDatabase();  
	}
	
	public void BeginTransaction()
    {
        _InTransaction = true;

        if (_db == null)
        {
        	_db = _dbHelper.getReadableDatabase();  
        }

        _db.beginTransaction();
    }

    public void CommitTransaction()
    {

        _db.endTransaction();
        _InTransaction = false ;

        _db.close();
        _dbHelper = null;
          
    }

    public void EndTransaction()
    {}
    public void SetTransactionSuccess()
    {
        _db.setTransactionSuccessful();
    }
    /*
     * 添加checksheet
     */
    public void InsertCheckSheet(CheckSheetInfo info)
    {
    	String sql = "INSERT INTO [CheckSheet]"
                           +"([CheckSheetAssistanceID]"
                           +",[CheckMethodID]"
                           +",[CheckClassID]"
                           +",[CheckStartTime]"
                           +",[CheckEndTime]"
                           +",[AuditorID]"
                           +",[Comment]"                              
                           +",[CheckSheetNo]"
                           +",[RecordStatus]"
                           +",[FirstNo]"
                           +",[EndNo]"
                           +",[CheckerGroupID]"
                           +",[CreatedRecordTime])"
                      +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                           
        //检查岗位默认为收费员
         _db.execSQL(sql, new Object[]{ 0
        		 						,info.getCheckMethod()
        		 						,info.getCheckClass()
        		 						,info.getCheckStartTime()
        		 						,info.getCheckEndTime()
        		 						,0
        		 						,""
        		 						,info.getCheckSheetNo()
        		 						,info.getRecordStatus()
        		 						,info.getFirstNo()
        		 						,info.getEndNo()
        		 						,info.getCheckerGroup()
        		 						,info.getCreatedRecordTime()
        		 						});

        return;
    }
    /*
     * 添加稽查人员
     * checkerId:staffIID
     */
    public void InsertRecordChecker(int checkerId, UUID checkSheetNo, Date createdtime)
    {
        String sql = "INSERT INTO [RecordChecker]"
                       +" ([CheckerID]"
                       +" ,[CheckSheetNo]"
                       +" ,[RecordCheckerID]"
                       +" ,[RecordStatus]"
                       +" ,[CreatedRecordTime])"
                       +" VALUES (?,?,?,?,?)";
      //检查岗位默认为收费员
        _db.execSQL(sql, new Object[]{ checkerId
       		 						,checkSheetNo
       		 						,UUID.randomUUID()
       		 						,RecordStatus.New
       		 						,createdtime	
       		 						});

       return;
      
    }
    /*
     * 添加checkRecordMain
     */
    public void InsertCheckRecordMain(CheckItemInfo info)
    {
        String sql = "INSERT INTO [CheckRecordMain]"
                      +" ([WorkNo]"
                      +" ,[WorkGroupID]"
                      +" ,[StationID]"
                      +" ,[LaneID]"
                      +" ,[CheckedTime]"
                      +" ,[Comment]"
                      +" ,[CheckSheetNo]"
                      +" ,[CheckRecordID]"
                      +" ,[RecordStatus]"
                      +" ,[LaneRecordID]"
                      +" ,[StaffID]"
                      +" ,[WorkGroupRecordID]"
                      +" ,[CreatedRecordTime]"
                      +" ,[ShiftID])"
                 +" VALUES"
                       +"(?"//@WorkNo
                       +",?"//@WorkGroupID
                       +",?"//@StationID
                       +",?"//@LaneID
                       +",?"//@CheckedTime
                       +",?"//@Comment
                       +",?"//@CheckSheetNo
                       +",?"//@CheckRecordID
                       +",?"//@RecordStatus
                       +",?"//@LaneRecordID
                       +",?"//@StaffID
                       +",?"//@WorkGroupRecordID
                       +",?"//@CreatedRecordTime
                       +",?"//@ShiftID
                    +")";

      /*  _db.execSQL(sql, new Object[]{ 0
					,info.getCheckMethod()
					,info.getCheckClass()
					,info.getCheckStartTime()
					,info.getCheckEndTime()
					,0
					,""
					,info.getCheckSheetNo()
					,info.getRecordStatus()
					,info.getFirstNo()
					,info.getEndNo()
					,info.getCheckerGroup()
					,info.getCreatedRecordTime()
					});
					*/

        return;
    }

    public void InsertCheckRecordSub(CheckExtensionItemInfo info)
    {
        String sql = "INSERT INTO [CheckRecordSub](CheckItemTypeID,ResultNumber,ResultText,ResultDatetime,Comment,CheckRecordID,CheckRecordSubID)"
                     +"VALUES"
                           +"(?" //@CheckItemTypeID
                           +",?" //@ResultNumber
                           +",?" //@ResultText
                           +",?" //@ResultDatetime
                           +",?" //@Comment
                           +",?" //@CheckRecordID
                           +",?)";//@CheckRecordSubID)";

       /* _db.execSQL(sql, new Object[]{ 0
				,info.getCheckMethod()
				,info.getCheckClass()
				,info.getCheckStartTime()
				,info.getCheckEndTime()
				,0
				,""
				,info.getCheckSheetNo()
				,info.getRecordStatus()
				,info.getFirstNo()
				,info.getEndNo()
				,info.getCheckerGroup()
				,info.getCreatedRecordTime()
				}); 
*/
        return;
    }

}
