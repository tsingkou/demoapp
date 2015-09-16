package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteViewText extends Activity {
	
	AutoCompleteTextView actv;
	MultiAutoCompleteTextView mactv;
	
	String[] books = new String[]{"红楼梦","金瓶梅","水浒传"};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocompletetextview);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.main, books);
		actv = (AutoCompleteTextView) findViewById(R.id.auto);
		actv.setAdapter(adapter);
		
		
		
	}
	
}
