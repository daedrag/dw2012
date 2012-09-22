package com.example.projectstyle;

import android.hardware.Camera;

public class TestCamera {
	Camera mCamera;

	public TestCamera() {

	}

	public void OpenCamera() {
		releaseCamera();
		mCamera = Camera.open();
	}

	private void releaseCamera() {
		if (mCamera != null) {
			mCamera.release();
			mCamera = null;
		}
	}
}
