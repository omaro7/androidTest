package com.example.androidtest.view;

import com.example.androidtest.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class CChatPopupScroll extends PopupWindow{
    
    int _type = 0;
    static String _scollTxt = null;
        
    public static CChatPopupScroll show(Activity act, View view, int type, String scollTxt)
    {
        //
        ////////////////////////////////////////////////////////
        Resources res = act.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
    
        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, dm);
        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, dm);
        
        
        int dlgX = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, dm);
        int dlgY = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, dm);
       
        View popupView = View.inflate(act, R.layout.cchatpopup_scroll, null);
        CChatPopupScroll pop = new CChatPopupScroll(popupView,width,height,true, type, scollTxt);
        pop.showAtLocation(view, Gravity.CENTER, 0, 0);
        
        Drawable shape = res.getDrawable(R.drawable.image); 
        popupView.setBackgroundDrawable(shape);
        
        return pop;
    }
    
    public CChatPopupScroll(View contentView,int width,int height,boolean focusable, int type, String scollTxt)
    {
        super(contentView, width, height, focusable);
        
        _type = type;
        _scollTxt = scollTxt;
        
        initGUI();
    }

    void initGUI()
    {
        String closeStr = "close";        
        //close
        Button btn = (Button)getContentView().findViewById(R.id.close);
        btn.setText(closeStr);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });
        
         TextView title = (TextView)getContentView().findViewById(R.id.title);
         String titleStr = "title";
         title.setText(titleStr);
         
         TextView popupScrollTv = (TextView)getContentView().findViewById(R.id.PopupTextView01);
         popupScrollTv.setText(_scollTxt);

    }

}

