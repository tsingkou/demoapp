package com.example.demoapp.tenthchapter;

import com.example.demoapp.R;
import com.example.demoapp.tenthchapter.service.BindService.MyBind;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceTest extends Activity {
	
	Button bind, unbind, getServiceState;  
	MyBind binder;
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("service is disconnect");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("service is connect");
			binder = (MyBind) service;
		}
	};

	@Override
	public void onCreate(Bundle savedInstanced){
		super.onCreate(savedInstanced);
		setContentView(R.layout.bindservice);
		bind = (Button) findViewById(R.id.bind);
		unbind = (Button) findViewById(R.id.unbind);
		getServiceState = (Button) findViewById(R.id.getServiceStatus);
		
		final Intent intent = new Intent();
		intent.setAction("com.example.demoapp.tenthchapter.BINDSERVICE");
		bind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//绑定指定的Service
				bindService(intent, conn, BIND_AUTO_CREATE);
			}
		});
		unbind.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unbindService(conn);
			}
		});
		getServiceState.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(BindServiceTest.this, "Service的值为："+binder.getCount(), Toast.LENGTH_LONG).show();
			}
		});
	}
}
