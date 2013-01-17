/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.example.androidtest;

import com.example.androidtest.newsreader.ArticleActivity;
import com.example.androidtest.twowaygrid.TwowaygridActivity;
import com.habibm.customactivitytransition.CustomActivityTransitionActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LauncherActivity extends ListActivity {

	public static final String[] options = { "HorizontalView", "TwoScroll01", "TwoScroll02", "ScrollableImageActivity", "TableActivity",
			"TwowaygridActivity", "Scrolltest01", "ImageTest01", "ImageTest02", "SurefaceViewTest01", "MomoryActivity", "termsTest01", "UUIDMakeActivity", "VoiceRecognitionActivity", "AndroidButtonStateActivity",
			"CustomActivityTransitionActivity", "SpeakingAndroid"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent;

		switch (position) {
			default:
			case 0:
				intent = new Intent(this, MainActivity.class);
				break;
			case 1:
				intent = new Intent(this, TwoScroll01.class);
				break;
			case 2:
				intent = new Intent(this, TwoScroll02.class);
				break;
			case 3:
				intent = new Intent(this, ScrollableImageActivity.class);
				break;
			case 4:
				intent = new Intent(this, TableActivity.class);
				break;
			case 5:
				intent = new Intent(this, TwowaygridActivity.class);
				break;
			case 6:
				intent = new Intent(this, Scrolltest01.class);
				break;
			case 7:
				intent = new Intent(this, ImageTest01.class);
				break;
			case 8:
				intent = new Intent(this, ImageTest02.class);
				break;
			case 9:
				intent = new Intent(this, SurefaceViewTest01.class);
				break;				
			case 10:
				intent = new Intent(this, MomoryActivity.class);
				break;					
			case 11:
				intent = new Intent(this, TermsTest01.class);
				break;		
			case 12:
				intent = new Intent(this, UUIDMakeActivity.class);
				break;					
			case 13:
				intent = new Intent(this, VoiceRecognitionActivity.class);
				break;					
			case 14:
				intent = new Intent(this, AndroidButtonStateActivity.class);
				break;	
			case 15:
				intent = new Intent(this, CustomActivityTransitionActivity.class);
				break;	
			case 16:
				intent = new Intent(this, SpeakingAndroid.class);
				break;	
				
		}

		startActivity(intent);
	}

}
