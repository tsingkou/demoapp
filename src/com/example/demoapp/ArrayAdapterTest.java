package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterTest extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		ListView listview = (ListView) findViewById(R.id.list1);
		String[] arr1 = {"孙悟空","猪八戒","沙悟净"};
		ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.array_item, arr1);
		//为ListView设置Adapter
		listview.setAdapter(adapter1);
		
		
		
		
	}
	
	
}
