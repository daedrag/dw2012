package com.example.projectstyle;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
//import com.qualcomm.QCAR.QCAR;

public class ImageTarget {
	public ImageTarget(Bitmap photo)
	{
		for (int i = 0; i < photo.getWidth(); i++)
		{
			for (int j = 0; j < photo.getHeight(); j++)
			{
				photo.setPixel(i, j, Color.BLACK);
			}
			//System.out.print("\n");
		}
	}

}
