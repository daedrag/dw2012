package com.example.projectstyle;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	
	private boolean running;
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void run() {
		Canvas canvas;
		
		while (running) {
			canvas = null;
			// try locking the canvas for exclusive pixel editing
			// in the surface
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					// update game state 
					this.gamePanel.update();
					// render state to the screen
					// draws the canvas on the panel
					this.gamePanel.render(canvas);				
					// calculate how long did the cycle take
				}
			} finally {
				// in case of an exception the surface is not left in 
				// an inconsistent state
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}	// end finally
		}
	}

}
