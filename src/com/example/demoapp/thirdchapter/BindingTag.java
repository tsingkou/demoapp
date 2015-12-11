package com.example.demoapp.thirdchapter;

import com.example.demoapp.R;
import com.example.demoapp.thirdchapter.EventQs.MyClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BindingTag extends Activity {
	

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onclickview);
	}
	
	public void clickHandler(View source){
		EditText show = (EditText) findViewById(R.id.show);
		show.setText("bn被电击了");
		
		Toast.makeText(BindingTag.this, "click again", Toast.LENGTH_SHORT).show();
		
		
		
	}

}
