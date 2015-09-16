package com.example.demoapp;

import com.example.demoapp.service.DrawView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CustomView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		
		LinearLayout main = (LinearLayout)findViewById(R.id.root);
		
		final DrawView draw = new DrawView(this);
		draw.setMinimumWidth(300);
		draw.setMinimumHeight(500);
		main.addView(draw);
		
		
		
	}

}
