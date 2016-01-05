package com.example.demoapp.tenthchapter;

import com.example.demoapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstServiceTest extends Activity {
	Button start,stop;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstservice);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		final Intent intent = new Intent();
		intent.setAction("com.example.demoapp.tenthchapter.FIRST_SERVICE");
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(intent);
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService(intent);
			}
		});
	}
}
