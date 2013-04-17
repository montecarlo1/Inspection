package com.bchd.inspection;

import android.content.Context;

import com.bchd.inspection.bean.EmployeeInfo;
import com.bchd.inspection.dal.UserDataAccess;

public class EmpManager {

	UserDataAccess da;
	
	public EmpManager(Context context)
	{
		da=new UserDataAccess(context);		
	}
	
	public EmployeeInfo Login(String uid, String pwd)
    {
		EmployeeInfo userInfo = da.GetUserByIDAndPwd(uid, pwd);
        return userInfo;
    }
	
}
