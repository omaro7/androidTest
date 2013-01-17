package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.Gravity;

public class TableActivity extends Activity 
{ 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        HorizontalScrollView HSC = new HorizontalScrollView(this);
        ScrollView VSC = new ScrollView(this);
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setGravity(Gravity.CENTER);
        EditText[][] values = new EditText[20][20];
        for (int i = 0; i < 20; i++) 
        { 
            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER);
            for (int j = 0; j < 20; j++) 
            { 
                values[i][j] = new EditText(this);
                values[i][j].setHint("r " + i + "c" +j);
                values[i][j].setPadding(10, 10, 10, 10);
                tableRow.addView(values[i][j]);
            }
            tableLayout.addView(tableRow);
        }
        VSC.addView(tableLayout);
        HSC.addView(VSC);
        setContentView(HSC);
    }
}