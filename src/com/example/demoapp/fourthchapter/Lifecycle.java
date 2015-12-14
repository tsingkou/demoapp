package com.example.demoapp.fourthchapter;

import com.example.demoapp.MainActivity;
import com.example.demoapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lifecycle extends Activity {
	
	final String TAG = "---ACTIVITY TAG---";
	Button finish,startActivity;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycle);
		Log.d(TAG, "---oncreate---");
		finish = (Button) findViewById(R.id.finish);
		startActivity = (Button) findViewById(R.id.startActivity);
		startActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Lifecycle.this, SecondActivity.class);
				startActivity(intent);	
			}
		});
		
		finish.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Lifecycle.this.finish();
			}
		});
	}
	@Override
	public void onStart()
	{
		super.onStart();
		// 输出日志
		Log.d(TAG, "-------onStart------");
	}
	@Override
	public void onRestart()
	{
		super.onRestart();
		// 输出日志
		Log.d(TAG, "-------onRestart------");
	}
	@Override
	public void onResume()
	{
		super.onResume();
		// 输出日志
		Log.d(TAG, "-------onResume------");
	}
	@Override
	public void onPause()
	{
		super.onPause();
		// 输出日志
		Log.d(TAG, "-------onPause------");
	}
	@Override
	public void onStop()
	{
		super.onStop();
		// 输出日志
		Log.d(TAG, "-------onStop------");
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		// 输出日志
		Log.d(TAG, "-------onDestroy------");
	}
}
