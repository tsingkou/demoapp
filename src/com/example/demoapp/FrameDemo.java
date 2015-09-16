package com.example.demoapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class FrameDemo extends Activity {
	private int currenColor = 0;
	final int[] colors = new int[]{
		R.color.color1,	
		R.color.color2,
		R.color.color3,
		R.color.color4,
		R.color.color5,
		R.color.color6
	};
	final int[] names = new int[]{
		R.id.textView1,
		R.id.textView2,
		R.id.textView3,
		R.id.textView4,
		R.id.textView5,
		R.id.textView6,
	};
	
	TextView[] views = new TextView[6];
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.framedemo);
		for(int i=0;i<6;i++){
			views[i] = (TextView) findViewById(names[i]);
		}
		final Handler hand = new Handler(){
			@Override
			public void handleMessage(Message msg){
				if(msg.what==0x1122){
					for(int i=0;i<6;i++){
						views[i].setBackgroundResource(colors[i+currenColor]);
					}
					for(int i = 7 - currenColor , j = 0 ; i < 6 ; i++ ,j++)
					{
						views[i].setBackgroundResource(colors[j]);
					}
				}
				super.handleMessage(msg);
			}
		};
		//定义一个线程周期性的改变currenColor变量值
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				currenColor++;
				if(currenColor>=6){
					currenColor = 0;
				}
				Message m = new Message();
				m.what = 0x1122;
				hand.sendMessage(m);
			}
		},  0 , 100);
	}
}
