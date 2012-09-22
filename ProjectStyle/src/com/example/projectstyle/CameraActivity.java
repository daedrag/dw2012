package com.example.projectstyle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity implements OnClickListener{
	private static final int CAMERA_REQUEST = 1888;
	private ImageView imageView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		this.imageView = (ImageView) this.findViewById(R.id.imageView1);
		Button photoButton = (Button) this.findViewById(R.id.button1);
		photoButton.setOnClickListener(this);
	}
	
	
	public void onClick(View v)
	{
		switch (v.getId()){
		case R.id.button1:
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, CAMERA_REQUEST);
			break;
		default:
			break;
		}
		
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    } 

}
