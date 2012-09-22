package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Enemy {
	private Bitmap enemyBitmap;
	private int x;
	private int y;
	
	public Enemy(Bitmap bitmap, int x, int y)
	{
		enemyBitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public void OnUpdate()
	{
		//DO NOthing for now
	}
	
	public void OnDraw(Canvas canvas)
	{
		canvas.drawBitmap(enemyBitmap, x, y, null);
	}
	

}
