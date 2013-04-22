package com.bchd.inspection.ui;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bchd.inspection.AppContext;
import com.bchd.inspection.R;
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class RealTimeActivity extends BaseActivity {
	
	TextView mTitleView;
	ImageView btn_realtime;
	private ImageButton ib_spotCheck = null;	
	private static final int msgKey = 1;
    private TextView mTime;
    private TextView mName;
    private TextView mTime2;
    private TextView mTime3;
    private AppContext con = null;
  //当前时间--月日
    public String setTime(){
            long longtime=System.currentTimeMillis();
            Calendar c=Calendar.getInstance();
            c.setTimeInMillis(longtime);            
            int mMonth=c.get(Calendar.MONTH);
            int mDay=c.get(Calendar.DAY_OF_MONTH);
            int Month=mMonth+1;
            return new String(Month+"月"+mDay+"日"); 
        }   
    //当前时间--星期
    public static String getWeekOfDate() {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date curDate = new Date(System.currentTimeMillis());
        cal.setTime(curDate);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }   
    
    public class TimeThread extends Thread {
        @Override
        public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey;
                    mHandler.sendMessage(msg);                  
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }
    
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
               case msgKey:            	     
            	    SimpleDateFormat sdf=new SimpleDateFormat("kk:mm:ss");
            	    //sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));                     
                    mTime.setText(sdf.format(new Date()));
                    break;
               default:                	 
                    break;
            }
        }
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.realtime_activity);
		 //显示系统时间--月日
        mTime2 = (TextView) findViewById(R.id.sys_time2);
        mTime2.setText(new RealTimeActivity().setTime());
        //显示系统时间--星期
        mTime3 = (TextView) findViewById(R.id.sys_time3);        
        mTime3.setText(new RealTimeActivity().getWeekOfDate());
        //显示系统时间--时分秒
        mTime=(TextView)findViewById(R.id.sys_time);
        new TimeThread().start();  
        mName = (TextView)this.findViewById(R.id.user_name);
		con= (AppContext) getApplication();
		
		mName.setText(con.getLoginUsersString(true));
		prepareView();
	 
		//mTitleView.setText(R.string.category_realtime);
		//现场稽查	
		//ib_spocCheck.setFocusable(true);   
		//ib_spocCheck.setFocusableInTouchMode(true);   

		ib_spotCheck.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				spotCheck();
				
			}
		});	
		
		
	}

	private void prepareView() {
		//mTitleView = (TextView) findViewById(R.id.title_text);
		ib_spotCheck = (ImageButton)findViewById(R.id.ib_spotcheck);
		
		//绑定照相及摄像事件
		this.takePicureButton=(ImageButton)findViewById(R.id.ib_picture);
		this.recordVideoButton=(ImageButton)findViewById(R.id.ib_video);
		takePicureButton.setOnClickListener(cameraButtonListenser);
	    recordVideoButton.setOnClickListener(cameraButtonListenser);
	}
	
	private void spotCheck()
	{
		Toast.makeText(RealTimeActivity.this,"进入现场稽查",Toast.LENGTH_SHORT).show();
		//Intent intent = new Intent (RealTimeActivity.this,CheckInActivity.class);			
		Intent intent = new Intent (RealTimeActivity.this,CheckInActivity.class);				
		Bundle bundle = new Bundle();
		//保存输入的信息
		
		bundle.putString("Title", "现场稽查上岗注册"); //现场稽查ID
		bundle.putInt("checkMethodID", 3); //现场稽查ID
		bundle.putString("checkMethod", "现场稽查"); //现场稽查ID
		//bundle.putSerializable("checkMethod", new CategoryInfo(3,"现场稽查"));
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	/* 拍照及摄像相关 */ 
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
	private Uri fileUri; //保存文件的路径,当前的路径为:SD\pcitures\inspection
	
	ImageButton takePicureButton;
	ImageButton recordVideoButton;
	
	OnClickListener cameraButtonListenser =  new OnClickListener(){

		public void onClick(View view) {
			// TODO Auto-generated method stub
			
			Intent intent = null;
			
			if(((ImageButton)view).equals(takePicureButton)){
				
			    // create Intent to take a picture and return control to the calling application
			    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

			    fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
			    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
			    
			   // start the video record Intent
			    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
				
			}else if(((ImageButton)view).equals(recordVideoButton)){
				
			    intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

			    fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO); // create a file to save the video
			    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the video file name
			    
			    
			    startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
			}
		}
		
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Image captured and saved to fileUri specified in the Intent
	        	
	        	
	        	if(data!=null){
	        		
		            Toast.makeText(this, "Image saved to:\n" +
		            		data.getData().toString(), Toast.LENGTH_LONG).show();	        		
	        	}else{	        		
	        		System.out.println("can't get any data!!!");
	        	}
	        
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the image capture
	        } else {
	            // Image capture failed, advise user
	        }
	    }

	    if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Video captured and saved to fileUri specified in the Intent
	        	if(data!=null){
	        		
		            Toast.makeText(this, "照片已经保存到:\n" +
		            		data.getData().toString(), Toast.LENGTH_LONG).show();
	        		
	        	}else{
	        		
	        		Log.i("com.bchd.inspection", "读取不到任何数据!!!");

	        	}
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the video capture
	        } else {
	            // Video capture failed, advise user
	        }
	    }
	}
	
	
	/** Create a file Uri for saving an image or video */
	private static Uri getOutputMediaFileUri(int type){
	      return Uri.fromFile(getOutputMediaFile(type));
	}

	/** Create a File for saving an image or video */
	private static File getOutputMediaFile(int type){
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "inspection");//保存图片的文件夹为：sd\pictures\inspection
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("com.bchd.inspection", "failed to create directory");
	            return null;
	        }
	    }

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	    } else if(type == MEDIA_TYPE_VIDEO) {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "VID_"+ timeStamp + ".mp4");
	    } else {
	        return null;
	    }

	    return mediaFile;
	}
	
	/**/
}
