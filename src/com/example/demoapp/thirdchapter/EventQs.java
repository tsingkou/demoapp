package com.example.demoapp.thirdchapter;

import com.example.demoapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EventQs extends Activity {
	

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listenerdemo1);
		Button bn = (Button) findViewById(R.id.bn);
		bn.setOnClickListener(new MyClickListener());
		
	}

	
	//单击事件监听器
	class MyClickListener implements View.OnClickListener{

		//监听方法
		@Override
		public void onClick(View v) {
			EditText et = (EditText) findViewById(R.id.txt1);
			et.setText("bn被单击了");
			Toast.makeText(EventQs.this, "单击了一下bn", Toast.LENGTH_LONG).show();
		}
		
	}
	
	
	
	
}
