package com.example.androidtest.view;

import java.util.Random;

import com.example.androidtest.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;

public class MySurfaceView extends SurfaceView implements Runnable{

	Thread thread = null;   
	SurfaceHolder surfaceHolder;    
	volatile boolean running = false;        
	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);    
	Random random;         
	volatile boolean touched = false;    
	volatile float touched_x, touched_y;
	private Bitmap bmp;

	public MySurfaceView(Context context) {   
		super(context);
		   // TODO Auto-generated constructor stub   
		setZOrderOnTop(true);

		   surfaceHolder = getHolder();
		   //surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);

		   random = new Random();
		   bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image);
		  }     
		  public void onResumeMySurfaceView(){  
			  running = true;
			  thread = new Thread(this);
			  thread.start();
		  }     
		  public void onPauseMySurfaceView(){  
		  boolean retry = true;
		   running = false;
		   while(retry){   
		   try {    
		   thread.join();
		     retry = false;
		    } catch (InterruptedException e) {     
		    // TODO Auto-generated catch block    
		    e.printStackTrace();
		    }   }  }   
		    @Override  
		    public void run() {  
		    // TODO Auto-generated method stub  
		    while(running){   
		    if(surfaceHolder.getSurface().isValid()){     
		    Canvas canvas = surfaceHolder.lockCanvas();
		    
		    canvas.drawBitmap(bmp, 320, 480, null);
		    
		     //... actual drawing on canvas      
		     paint.setStyle(Paint.Style.STROKE);
		        paint.setStrokeWidth(20);
		           int w = canvas.getWidth();
		     int h = canvas.getHeight();
		     int x = random.nextInt(w-1);
		      int y = random.nextInt(h-1);
		     int r = random.nextInt(255);
		     int g = random.nextInt(255);
		     int b = random.nextInt(255);
		     paint.setColor(0xff000000 + (r << 16) + (g << 8) + b);
		     canvas.drawPoint(x, y, paint);
		      if(touched){      
		    	  paint.setStrokeWidth(50);
		    	  paint.setColor(Color.BLACK);
		    	  canvas.drawPoint(touched_x, touched_y, paint);
		     }          
		     
		     surfaceHolder.unlockCanvasAndPost(canvas);
		    }   }  }   
		    @Override  
		    public boolean onTouchEvent(MotionEvent event) {   
		    // TODO Auto-generated method stub      
		    touched_x = event.getX();
		   touched_y = event.getY();
		       int action = event.getAction();
		   switch(action){   
		   case MotionEvent.ACTION_DOWN:   
			   touched = true;
		    break;
		   case MotionEvent.ACTION_MOVE:   
			   touched = true;
		    break;
		   case MotionEvent.ACTION_UP:    
			   touched = false;
		    break;
		   case MotionEvent.ACTION_CANCEL:    
			   touched = false;
		    break;
		   case MotionEvent.ACTION_OUTSIDE:   
			   touched = false;
		    break;
		   default:   }  
		   return true; //processed 
		   }       
		    
		    /* 상태바, 타이틀바를 제외한 클라이언트 영역의 높이를 구한다 
			private int getClientHeight() {
			    Rect rect= new Rect();    
			    Window window = ((Activity)context.getWindow();     
			    window.getDecorView().getWindowVisibleDisplayFrame(rect);     
			    int statusBarHeight= rect.top;    
			    int contentViewTop= window.findViewById(Window.ID_ANDROID_CONTENT).getTop();     
			    int titleBarHeight= contentViewTop - statusBarHeight;
			    return ((Activity)context).getWindowManager().getDefaultDisplay().
			    		getHeight() - statusBarHeight - titleBarHeight;
			}
			*/


}
