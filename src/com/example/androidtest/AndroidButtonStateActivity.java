package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidButtonStateActivity extends Activity {
    private Button lgn_btn;
	private Button sgn_btn;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_main);
        
        lgn_btn=(Button)findViewById(R.id.loginBtn);
        sgn_btn=(Button)findViewById(R.id.signBtn);
        
        lgn_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(AndroidButtonStateActivity.this, 
						"Login button is clicked !",Toast.LENGTH_SHORT ).show();
			}
		});
        
        sgn_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(AndroidButtonStateActivity.this, 
						"SignUp button is clicked !",Toast.LENGTH_SHORT ).show();
			}
		});
    }
}