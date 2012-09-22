package com.example.projectstyle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	

	public final int PICTURE_RESULT = 1;
	public ImageView pictureHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //Call Image capture
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);   
        this.startActivityForResult(camera, PICTURE_RESULT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public void onActivityResult(int mRequestCode, int mResultCode,
			Intent mDataIntent) {
		super.onActivityResult(mRequestCode, mResultCode, mDataIntent);

		switch (mRequestCode) {
		case PICTURE_RESULT:
			if (mResultCode == Activity.RESULT_OK) {
                // Display image received on the view
                 Bundle b = mDataIntent.getExtras(); // Kept as a Bundle to check for other things in my actual code
                 Bitmap pic = (Bitmap) b.get("data");

                 if (pic != null) { // Display your image in an ImageView in your layout (if you want to test it)
                     pictureHolder = (ImageView) this.findViewById(R.id.image);
                     pictureHolder.setImageBitmap(pic);
                     pictureHolder.invalidate();
                 }
             }
             else if (mResultCode == Activity.RESULT_CANCELED) {}
		}
    }	
}

