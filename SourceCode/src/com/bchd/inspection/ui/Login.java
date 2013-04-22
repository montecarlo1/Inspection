package com.bchd.inspection.ui;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bchd.inspection.AppContext;
import com.bchd.inspection.R;
import com.bchd.inspection.bean.EmployeeInfo;

public class Login extends BaseActivity {
	private EditText mUser = null; // 帐号编辑框
	private EditText mPassword  = null; // 密码编辑框
	private ImageButton mbtnLogin  = null; // 登录按钮
	private ImageButton mbtnEnter  = null; //进入系统按钮
	private TextView mtvWelcome = null;
	private AppContext con = null;
	private Toast mToast;
	private static int m_ClickNum=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		prepareView();
		
		// 设置登录按钮的事件监听器(匿名内部类作为事件监听器类)
		mbtnLogin.setOnClickListener(new ImageButton.OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				login_one();
				 m_ClickNum ++ ;
				 if(m_ClickNum>4){
					 Dialog alertDialog = new AlertDialog.Builder(Login.this)
						.setIcon(R.drawable.ic_launcher)
						.setTitle("登录失败")
						.setMessage("您的登录次数过多，\n请重新输入！")
						.create();
						alertDialog.show();					 
				 }
				 return;
			}
		});
		// 设置进入系统按钮的事件监听器(匿名内部类作为事件监听器类)
		mbtnEnter.setOnClickListener(new ImageButton.OnClickListener() 
		{
			int i=0;
			@Override
			public void onClick(View v) {
				//跳转到主界面
				if(con.getLoginUsers().size() == 0)
				{
					new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录错误")
					.setMessage("请先登录系统。").create()
					.show();
				}
				else
				{											 			
						   Intent intent = new Intent();
						   intent.setClass(Login.this, MainActivity.class);
						   startActivity(intent);			  
					 
				}
			}
		});
	}
	
	private void prepareView(){
		mUser = (EditText) findViewById(R.id.login_user_edit);
		mPassword = (EditText) findViewById(R.id.login_passwd_edit);
		mbtnLogin = (ImageButton) this.findViewById(R.id.btn_login);
		mbtnEnter = (ImageButton) this.findViewById(R.id.btn_enter);
		mtvWelcome = (TextView)this.findViewById(R.id.tv_welcome);
		con= (AppContext) getApplication();
		
		mtvWelcome.setText("欢迎登录： "+ con.getLoginUsersString(false));
	}
	// 直接绑定到标签
	public void login_back(View v) { // 标题栏 返回按钮
		this.finish();
	}
	/*
	 * 单人登录
	 */
	private void login_one()
	{
		//Log.e("leilei",mPassword.getText().toString());
		String userID = mUser.getText().toString();
		String password = mPassword.getText().toString();
		
		if ("".equals(userID)|| "".equals(password))// 判断帐号和密码是否为空
		{
			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录错误")
					.setMessage("员工号或者密码不能为空，\n请输入后再登录！").create()
					.show();
		}
		else 
		{
			try 
			{				 
				    //更新欢迎内容
					if(con.Login(userID, password)){
						Toast.makeText(Login.this, "欢迎登录： "+ con.getLoginUsersString(true),Toast.LENGTH_SHORT).show();
						mtvWelcome.setText("欢迎登录： "+ con.getLoginUsersString(false));
						 
					}
					else if(con.checkIfRepeatLogin(userID)){
						Dialog alertDialog = new AlertDialog.Builder(this)
						.setIcon(R.drawable.ic_launcher)
						.setTitle("温馨提示")
						.setMessage("您已成功登录！")
						.create();
						alertDialog.show();		
					}				 							
					else{
			                new AlertDialog.Builder(Login.this)
										.setIcon(getResources()
												.getDrawable(
												R.drawable.login_error_icon))
										.setTitle("登录失败")
										.setMessage("员工号或者密码不正确，\n请检查后重新输入！")
										.create().show();
					}	
				 
			}
			catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(Login.this, e.getMessage(),Toast.LENGTH_LONG).show();				
			}
		}
	}
	
    
}
