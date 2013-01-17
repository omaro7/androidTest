package com.example.androidtest.view;

import com.example.androidtest.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class CChatPopup2 extends AlertDialog{
    
    int _type = 0;
 
    public static void show(Activity act, View view, int type)
    {
        Resources res = act.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
    
        int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 380, dm);
        int height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, dm);
        
        int dlgX = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 410, dm);
        int dlgY = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, dm);
    
     
        CChatPopup2 pop = new CChatPopup2(act, type); 
        pop.show();
        
    
        LayoutParams params = pop.getWindow().getAttributes();
        params.x = dlgX;
        params.y = dlgY;
        params.width = width;
        params.height = height;
        pop.getWindow().setAttributes(params);
    }
    
    protected CChatPopup2(Context context, int type) {
        super(context);
        // TODO Auto-generated constructor stub
        _type = type;
        initGUI();
    }
    
    protected CChatPopup2(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        initGUI();
    }

    void initGUI()
    {
        View popupView = View.inflate(getContext(), R.layout.cchatpopup, null);
        setView(popupView, 0, 0, 0, 0);
        
        //close
        String closeStr = "close";
        Button btn = (Button)popupView.findViewById(R.id.close);
        btn.setText(closeStr);
        
        btn.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });
        
        
        TextView title = (TextView)popupView.findViewById(R.id.title);
        String titleStr = "title";
     
        title.setText(titleStr);
        
    }
}