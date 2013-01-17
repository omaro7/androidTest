package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TwoScroll01 extends Activity {
	  private RelativeLayout container;
	  private int currentX;
	  private int currentY;

	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.twoscroll_design);

	    container = (RelativeLayout)findViewById(R.id.twoscroll_container);

	    int top = 0;
	    int left = 0;

	    ImageView image1 = (ImageView) findViewById(R.id.image);
	    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	    layoutParams.setMargins(left, top, 0, 0);               
	    container.addView(image1, layoutParams);

	    ImageView image2 =  (ImageView) findViewById(R.id.image);
	    left+= 100;
	    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	    layoutParams.setMargins(left, top, 0, 0);               
	    container.addView(image2, layoutParams2);

	    ImageView image3 =  (ImageView) findViewById(R.id.image);
	    left= 0;
	    top+= 100;
	    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	    layoutParams.setMargins(left, top, 0, 0);               
	    container.addView(image3, layoutParams3);

	    ImageView image4 =  (ImageView) findViewById(R.id.image);
	    left+= 100;     
	    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	    layoutParams.setMargins(left, top, 0, 0);               
	    container.addView(image4, layoutParams4);
	  }     

	  @Override 
	  public boolean onTouchEvent(MotionEvent event) {
	    switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN: {
	            currentX = (int) event.getRawX();
	            currentY = (int) event.getRawY();
	            break;
	        }

	        case MotionEvent.ACTION_MOVE: {
	            int x2 = (int) event.getRawX();
	            int y2 = (int) event.getRawY();
	            container.scrollBy(currentX - x2 , currentY - y2);
	            currentX = x2;
	            currentY = y2;
	            break;
	        }   
	        case MotionEvent.ACTION_UP: {
	            break;
	        }
	    }
	      return true; 
	  }
	}

