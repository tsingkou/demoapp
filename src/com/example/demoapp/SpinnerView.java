package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerView extends Activity {
	Spinner spinner;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);
		
		spinner = (Spinner) findViewById(R.id.spinner);
		
		String[] arr = {"zhubajie","sunwukong","shawujin"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
				, android.R.layout.activity_list_item, arr);
		
		spinner.setAdapter(adapter);
		
	}
	
	
}
