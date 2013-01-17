package com.example.androidtest;

import com.example.androidtest.view.MySurfaceView;

import android.app.Activity;
import android.os.Bundle;

public class SurefaceViewTest01 extends Activity {   
	MySurfaceView mySurfaceView;    
	/** Called when the activity is first created. */   
	@Override   
	public void onCreate(Bundle savedInstanceState) {      
		super.onCreate(savedInstanceState);     
		mySurfaceView = new MySurfaceView(this);    
		setContentView(mySurfaceView); 
		}     
	@Override 
	protected void onResume() {  
		// TODO Auto-generated method stub  
		super.onResume();  
		mySurfaceView.onResumeMySurfaceView();
	}  
	@Override 
	protected void onPause() {  
		// TODO Auto-generated method stub  
		super.onPause();  
		mySurfaceView.onPauseMySurfaceView(); 
	}
}