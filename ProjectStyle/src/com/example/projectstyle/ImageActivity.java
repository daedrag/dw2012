package com.example.projectstyle;

import android.app.Activity;
import android.os.Bundle;
//import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity {
	public static ImageView imageView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		//this.imageView = (ImageView) this.findViewById(R.id.imageView1);
		//Button photoButton = (Button) this.findViewById(R.id.button1);
		//photoButton.setOnClickListener(this);
	}
}
