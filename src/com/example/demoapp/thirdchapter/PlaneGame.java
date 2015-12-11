package com.example.demoapp.thirdchapter;

import com.example.demoapp.R;
import com.example.demoapp.service.PlaneView;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class PlaneGame extends Activity {
	
	//定义飞机移动速度
	private int speed = 10;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//去掉窗口标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏显示
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		final PlaneView planeView = new PlaneView(this);
		setContentView(planeView);
		planeView.setBackgroundResource(R.drawable.back);
		
		//窗口管理器
		WindowManager windowmanager = getWindowManager();
		Display display = windowmanager.getDefaultDisplay();
		DisplayMetrics mertrics = new DisplayMetrics();
		//获取屏幕高*宽
		display.getMetrics(mertrics);
		
		planeView.currentX = mertrics.widthPixels/2;
		planeView.currentY = mertrics.heightPixels-40;
		
		//为draw组件键盘事件绑定监听事件
		planeView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				//
				switch(event.getKeyCode()){
				case KeyEvent.KEYCODE_S:
					planeView.currentX += speed;
					break;
				case KeyEvent.KEYCODE_W:
					planeView.currentY -= speed;
					break;
				case KeyEvent.KEYCODE_A:
					planeView.currentY += speed;
					break;
				case KeyEvent.KEYCODE_D:
					planeView.currentY -= speed;
					break;
				}
				planeView.invalidate();
				return true;
			}
		});
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
