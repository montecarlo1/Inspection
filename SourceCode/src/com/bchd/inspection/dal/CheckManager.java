package com.bchd.inspection.dal;

import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import com.bchd.inspection.bean.*;


public class CheckManager {
	private CheckDataAccess _checkdata = null;
	
	public CheckManager(Context context)
	{
		_checkdata = new CheckDataAccess(context);
	}
	public boolean AddCheckSheet(CheckSheetInfo info)
    {
        boolean result = false;
        
        if(_checkdata != null)
        {
            try
            {
            	_checkdata.BeginTransaction();
            	_checkdata.InsertCheckSheet(info);
            	//插入稽查员信息 
            	for(int i=0;i<info.getCheckers().size();i++)
            	{
            		_checkdata.InsertRecordChecker(Integer.parseInt(info.getCheckers().get(i).getStaffID()),info.getCheckSheetNo(),info.getCreatedRecordTime());
            	}
            		
            	_checkdata.SetTransactionSuccess();
            	result = true;
            }
            catch (Exception ex)
            {
            	ex = null;
            }
            finally
            {
            	
            	_checkdata.CommitTransaction();
            }
        }

/*
        if (result)
        {
            try
            {
                SyncMgr.BeginSyncCheckSheet(info.CheckSheetNo);
            }
            catch(Exception ee) 
            {
                TraceHelper.TraceError(ee);
            }
        }
        */
        return result;
	}
	
	/*
	 * 添加Main表和Sub表记录
	 */
	public boolean AddCheckItem(CheckItemInfo MInfo, ArrayList<CheckExtensionItemInfo> Sinfo)
    {
        boolean result = false;
        
        if(_checkdata != null)
        {
            try
            {
            	_checkdata.BeginTransaction();
            	_checkdata.InsertCheckRecordMain(MInfo);
            	for(int i = 0; i<Sinfo.size(); i++)
            		_checkdata.InsertCheckRecordSub(Sinfo.get(i));
            	_checkdata.SetTransactionSuccess();
            	result = true;
            }
            catch (Exception ex)
            {
            	ex = null;
            }
            finally
            {
            	
            	_checkdata.CommitTransaction();
            }
        }

/*
        if (result)
        {
            try
            {
                SyncMgr.BeginSyncCheckSheet(info.CheckSheetNo);
            }
            catch(Exception ee) 
            {
                TraceHelper.TraceError(ee);
            }
        }
        */
        return result;
	}

}
