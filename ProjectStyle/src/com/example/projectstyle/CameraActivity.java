package com.example.projectstyle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity implements OnClickListener {
	private static final int CAMERA_REQUEST = 1888;
	private ImageView imageView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new MainGamePanel(this));
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(cameraIntent, CAMERA_REQUEST);
			break;
		//case R.id.button2:
			//Intent imageIntent = new Intent(CameraActivity.this, ImageActivity.class);
		default:
			
		}

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAMERA_REQUEST) {
			//if (resultCode == Activity.RESULT_OK) {
				Bitmap photo = (Bitmap) data.getExtras().get("data");
				Bitmap copyPhoto = photo.copy(photo.getConfig(), true);
				int[][] pixelColors = new int[photo.getWidth()][photo.getHeight()];
				for (int i = 0; i < copyPhoto.getWidth(); i++)
					for (int j = 0; j < copyPhoto.getHeight(); j++)
					{	
						int color = ((photo.getPixel(i,  j)) <= Color.BLACK + 0x000001a0) ? Color.BLACK : Color.YELLOW;
						
						
						if (color != Color.BLACK)
						{
							double random = Math.random();
							if (random >= 0.7)
								color = Color.BLUE;
							else if (random >= 0.4)
								color = Color.GREEN;
							else
								color = Color.CYAN;
						}
						
						
						copyPhoto.setPixel(i, j, color);
					}
				
				imageView.setImageBitmap(copyPhoto);
				//ImageActivity.imageView.setImageBitmap(photo);
				//ImageTarget imageTarget = new ImageTarget(photo);
				
			//}
			//else if (resultCode == Activity.RESULT_CANCELED){}
		}
	}

}
