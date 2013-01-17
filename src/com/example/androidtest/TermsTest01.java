package com.example.androidtest;

import com.example.androidtest.view.CChatPopup;
import com.example.androidtest.view.CChatPopupScroll;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TermsTest01 extends Activity {
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //set up main content view
	        setContentView(R.layout.terms_main);
	        //this button will show the dialog
	        Button button1main = (Button) findViewById(R.id.Button01main);
	        button1main.setOnClickListener(new OnClickListener() {
	        @Override
	            public void onClick(View v) {
	                //set up dialog
	                final Dialog dialog = new Dialog(TermsTest01.this);
	                dialog.setContentView(R.layout.terms_main_dialog);
	                dialog.setTitle("This is my custom dialog box");
	                dialog.setCancelable(true);
	                //there are a lot of settings, for dialog, check them all out!
	 
	                //set up text
	                TextView text = (TextView) dialog.findViewById(R.id.TextView01);
	                text.setText(R.string.terms_text); 

	                //set up image view
	                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
	                img.setImageResource(R.drawable.image);
	 
	                //set up button
	                Button button = (Button) dialog.findViewById(R.id.Button01);
	                button.setOnClickListener(new OnClickListener() {
	                @Override
	                    public void onClick(View v) {
	                        //finish();
	                        //dialog.cancel();
	                        dialog.dismiss();
	                    }
	                });
	                //now that the dialog is set up, it's time to show it    
	                dialog.show();
	            }
	        });
	        
	        //mydialog
	        //this button will show the dialog
	        Button button2main = (Button) findViewById(R.id.Button02main);
	        button2main.setOnClickListener(new OnClickListener() {
	        @Override
	            public void onClick(View v) {
	                //set up dialog
	                final Dialog dialog = new Dialog(TermsTest01.this);
	                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	                dialog.setContentView(R.layout.terms_main_dialog_shape);
	                //dialog.setTitle("This is my custom dialog box");
	                dialog.setCancelable(true);
	                //there are a lot of settings, for dialog, check them all out!
	 
	                //set up text
	                TextView text = (TextView) dialog.findViewById(R.id.TextView01);
	                text.setText(R.string.terms_text); 

	                //set up image view
	                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
	                img.setImageResource(R.drawable.image);
	 
	                //set up button
	                Button button = (Button) dialog.findViewById(R.id.Button01);
	                button.setOnClickListener(new OnClickListener() {
	                @Override
	                    public void onClick(View v) {
	                        //finish();
	                        //dialog.cancel();
	                        dialog.dismiss();
	                    }
	                });
	                //now that the dialog is set up, it's time to show it    
	                dialog.show();
	            }
	        });
	        
	        //custom view
	        //this button will show the dialog
	        Button button3main = (Button) findViewById(R.id.Button03main);
	        button3main.setOnClickListener(new OnClickListener() {
	        @Override
	            public void onClick(View v) {
	                //set up view
	        	

	        		View popupView = View.inflate(TermsTest01.this, R.layout.cchatpopup, null);
	        		CChatPopup cchatPopup = new CChatPopup(popupView, 50, 50, true, 0);
	        		cchatPopup.show(TermsTest01.this, popupView, 0);

	        		/*
	        		View popupView = View.inflate(TermsTest01.this, R.layout.cchatpopup, null);
	        		AlertDialog _ab = new AlertDialog.Builder(TermsTest01.this)
	                .setTitle("대화지원")   //타이틀 제목
	                .setView(popupView) //읽여들여온 레이아웃 부찻
	                .setPositiveButton("확인", new DialogInterface.OnClickListener()  //확인버튼추가
	                {
	                    public void onClick(DialogInterface dialog, int which) 
	                    {
	                        // TODO Auto-generated method stub
	                        //onMsgBox("qwe", 1);
	                        dialog.dismiss();
	                    }
	                })
	                .show();
	         

	               // AlertDialog 에서 위치 크기 수정       
	                LayoutParams params = _ab.getWindow().getAttributes(); 
	                params.x = 300;
	                params.y = 50;
	                params.width = 300;
	                _ab.getWindow().setAttributes(params);
				*/
	        
	        }
	        });
	        
	        //custom scroll view
	        //this button will show the dialog
	        Button button4main = (Button) findViewById(R.id.Button04main);
	        button4main.setOnClickListener(new OnClickListener() {
	        @Override
	            public void onClick(View v) {
	                //set up view
	        	

	        		View popupView = View.inflate(TermsTest01.this, R.layout.cchatpopup_scroll, null);
	        		//CChatPopupScroll cchatPopup = new CChatPopupScroll(popupView, 50, 50, true, 0, "this Text");
	        		CChatPopupScroll.show(TermsTest01.this, popupView, 0, "this Text this Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Textthis Text");

	        		/*
	        		View popupView = View.inflate(TermsTest01.this, R.layout.cchatpopup, null);
	        		AlertDialog _ab = new AlertDialog.Builder(TermsTest01.this)
	                .setTitle("대화지원")   //타이틀 제목
	                .setView(popupView) //읽여들여온 레이아웃 부찻
	                .setPositiveButton("확인", new DialogInterface.OnClickListener()  //확인버튼추가
	                {
	                    public void onClick(DialogInterface dialog, int which) 
	                    {
	                        // TODO Auto-generated method stub
	                        //onMsgBox("qwe", 1);
	                        dialog.dismiss();
	                    }
	                })
	                .show();
	         

	               // AlertDialog 에서 위치 크기 수정       
	                LayoutParams params = _ab.getWindow().getAttributes(); 
	                params.x = 300;
	                params.y = 50;
	                params.width = 300;
	                _ab.getWindow().setAttributes(params);
				*/
	        
	        }
	        });
	    } 
	 }