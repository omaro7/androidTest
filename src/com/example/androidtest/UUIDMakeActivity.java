package com.example.androidtest;

import java.util.UUID;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class UUIDMakeActivity extends Activity {
	public static String TAG = "UUIDMakeActivity";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uuid_main);
        
        TextView tvUUID = (TextView)findViewById(R.id.tvUUID);
        String myUUID = GetDevicesUUID(this);
        tvUUID.setText("UUID: "+myUUID);
        Log.i(TAG,"UUID :"+myUUID+", Len:"+myUUID.length());
        
        String PhoneNumber = GetDevicesPhoneNumber(this);
    }
    
    private String GetDevicesUUID(Context mContext){
    	
	   final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
	
	   final String tmDevice, tmSerial, androidId;
	   tmDevice = "" + tm.getDeviceId();
	   tmSerial = "" + tm.getSimSerialNumber();
	   androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
	
	   UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
	   String deviceId = deviceUuid.toString();
	
	   return deviceId;
    }
    
	private String GetDevicesPhoneNumber(Context mContext){
    	
		   final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
		
		   final String tmPhoneNumber, tmNetworkOperator, tmNetworkOperatorName;
		   tmPhoneNumber = tm.getLine1Number();
		   tmNetworkOperator = tm.getNetworkOperator();
		   tmNetworkOperatorName = tm.getNetworkOperatorName();
		
		   Log.i(TAG,"tmPhoneNumber : "+tmPhoneNumber);
		   Log.i(TAG,"tmNetworkOperator : "+tmNetworkOperator);
		   Log.i(TAG,"tmNetworkOperatorName : "+tmNetworkOperatorName);
		   
		   return tmPhoneNumber;
	}
	
	private String GetDevicesNetworkOperator(Context mContext){
    	
		   final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
		
		   final String tmNetworkOperator;
		   tmNetworkOperator = tm.getNetworkOperator();
		
		   Log.i(TAG,"tmNetworkOperator : "+tmNetworkOperator);
		   
		   return tmNetworkOperator;
	}
	
	private String GetDevicesNetworkOperatorName(Context mContext){
    	
		   final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
		
		   final String tmNetworkOperatorName;
		   tmNetworkOperatorName = tm.getNetworkOperatorName();
		
		   Log.i(TAG,"tmNetworkOperatorName : "+tmNetworkOperatorName);
		   
		   return tmNetworkOperatorName;
	}
 
}