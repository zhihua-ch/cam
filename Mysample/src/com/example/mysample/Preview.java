package com.example.mysample;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;


public class Preview extends ViewGroup implements SurfaceHolder.Callback {
	SurfaceView mSurfaceView;
	SurfaceHolder mHolder;
	Camera mCamera = null;
	
	Preview(Context context){
		super(context);
		
		mSurfaceView = new SurfaceView(context);
		addView(mSurfaceView);
		
		mHolder = mSurfaceView.getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

public void setCamera(Camera camera){
	if(mCamera == camera){return;}
	
	stopPreviewAndFreeCamera();
	
	mCamera = camera;
	
	if(mCamera != null){
		List<Size> localSizes = mCamera.getParameters().getSupportedPreviewSizes();
		mSupportedPreviewSizes = localSizes;
		requestLayout();
		try{
			mCamera.setPreviewDisplay(mHolder);			
		}catch(IOException e){
			e.printStackTrace();
		}
		mCamera.startPreview();
	}
}

public void stopPreviewAndFreeCamera(){
	
}

public void surfaceCreated(SurfaceHolder holder){
	
}
public void surfaceDestroyed(SurfaceHolder holder){
	
}
public void surfaceChanged(SurfaceHolder holder, int i, int m, int n){
	
}
protected void onLayout(boolean changed, int left, int top, int right, int bottom){
	
}
}
