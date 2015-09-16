package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	
	public void clickHandle(View source){
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(R.string.app_name);
		//tv.setText("what is this？");;
		
		
	}
	
}
