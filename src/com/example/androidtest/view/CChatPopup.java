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

public class CChatPopup extends PopupWindow{
    
    int _type = 0;
        
    public static CChatPopup show(Activity act, View view, int type)
    {
        //
        ////////////////////////////////////////////////////////
        Resources res = act.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
    
        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, dm);
        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, dm);
        
        
        int dlgX = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, dm);
        int dlgY = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, dm);
       
        View popupView = View.inflate(act, R.layout.cchatpopup, null);
        CChatPopup pop = new CChatPopup(popupView,width,height,true, type);
        pop.showAtLocation(view, Gravity.CENTER, 0, 0);
        
        Drawable shape = res.getDrawable(R.drawable.image); 
        popupView.setBackgroundDrawable(shape);
        
        return pop;
    }
    
    public CChatPopup(View contentView,int width,int height,boolean focusable, int type)
    {
        super(contentView, width, height, focusable);
        
        _type = type;
        
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

    }

}

