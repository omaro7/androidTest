package com.example.androidtest;

import com.example.androidtest.view.AnimView;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ImageTest02 extends Activity {
    private AnimView view;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new AnimView(this);
        
        //ImageView sprite = (ImageView) findViewById(R.id.sprite);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        view.startAnimation(animation);
        
        setContentView(view);
    }
}
