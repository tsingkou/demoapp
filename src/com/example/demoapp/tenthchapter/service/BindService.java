package com.example.demoapp.tenthchapter.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {

	private int count;
	private boolean quit;
	private MyBind binder = new MyBind();

	public class MyBind extends Binder{
		public int getCount(){
			return count;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("Service is Binded!");
		//返回IBinder对象
		return binder;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		System.out.println("service is oncreate！");
		new Thread(){
			@Override
			public void run(){
				while(!quit){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
				}
			}
		};
	}
	
	@Override
	public boolean onUnbind(Intent intent){
		System.out.println("service is unbind");
		return true;
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		this.quit = true;
		System.out.println("service is destroy");
	}
}
