package com.example.projectstyle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapLoadHelper {
	Bitmap enemyBitmap;
	
	public BitmapLoadHelper(Context context)
	{
		enemyBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.droid);
	}
	
	public Bitmap getEnemyTexture()
	{
		return enemyBitmap;
	}
}
