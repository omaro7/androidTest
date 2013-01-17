package com.example.androidtest.handler;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class AnimThread extends Thread {

    private SurfaceHolder holder;
    private boolean running = true;
    int i = 0;

    public AnimThread(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        while(running ) {
            Canvas canvas = null;

            try {
                canvas = holder.lockCanvas();
                 synchronized (holder) {
                    // draw
                    canvas.drawColor(Color.BLACK);
                    Paint paint = new Paint();
                    paint.setColor(Color.WHITE);
                    canvas.drawCircle(i++, 100, 50, paint);

			/*
			Paint myPaint = new Paint();
			myPaint.setColor(Color.parseColor("#" + colorAlpha + "3AA6D0"));// initially colorAlpha is ff
			Rect r = new Rect();
			char[] a = "Hello World".toCharArray();
			datePaint.getTextBounds(a, 0, a.length, r);// get the bound of the text, I was not calculating this correctly
			canvas.drawText("Hello World", 0, 0, myPaint);// draw the text

			int colorValue = Integer.parseInt(colorAlpha, 16);
			    colorValue -= 20;// decrease alpha value for next call to onDraw method by postInvalidateDelayed
			if (colorValue > 40) {
				colorAlpha = Integer.toHexString(colorValue);
				postInvalidateDelayed(50, r.left, r.top, r.right, r.bottom);// this will create the effect of fade out animation
			 //because each call to onDraw method is at the difference of 50 millisecond delay and in each call we are decreasing alpha value by 20.
			    }
			*/
                }
            }
            finally {
                    if (canvas != null) {
                            holder.unlockCanvasAndPost(canvas);
                        }
            }
        }
    }

    public void setRunning(boolean b) {
        running = b;
    }
}