package com.example.androidtest.twowaygrid;

import com.example.androidtest.R;
import com.example.androidtest.twowaygrid.TwoWayAdapterView.OnItemClickListener;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

public class TwowaygridActivity extends Activity {
	private static final String TAG = "MainActivity";

	private Cursor mImageCursor;
	private ImageThumbnailAdapter mAdapter;
	private TwoWayGridView mImageGrid;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.twowaygrid_main);
		initGrid();
	}


	private void initGrid() {
		mImageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
				ImageThumbnailAdapter.IMAGE_PROJECTION, null, null,
				MediaStore.Images.ImageColumns.DISPLAY_NAME);
		mImageGrid = (TwoWayGridView) findViewById(R.id.gridview);
		mAdapter = new ImageThumbnailAdapter(this, mImageCursor);
		mImageGrid.setAdapter(mAdapter);

		mImageGrid.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(TwoWayAdapterView parent, View v, int position, long id) {
				Log.i(TAG, "showing image: " + mImageCursor.getString(ImageThumbnailAdapter.IMAGE_NAME_COLUMN));
				Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mAdapter.cleanup();
	}

}