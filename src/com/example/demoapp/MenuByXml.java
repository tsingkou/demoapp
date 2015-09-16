package com.example.demoapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuByXml extends Activity {
	private TextView tv;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuview);
		tv = (TextView) findViewById(R.id.txt);
		registerForContextMenu(tv);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.mymenu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View source, ContextMenu.ContextMenuInfo menuInfo){
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.context, menu);
		menu.setHeaderIcon(R.drawable.aaa);
		menu.setHeaderTitle("choose bg color");
	}
	
	@Override
	//上下文菜单中菜单项被单击时触发该方法
	public boolean onContextItemSelected(MenuItem mi){
		mi.setChecked(true);
		switch (mi.getItemId()) {
		case R.id.red:
			mi.setChecked(true);
			tv.setBackgroundColor(Color.RED);
			break;
		case R.id.green:
			mi.setChecked(true);
			tv.setBackgroundColor(Color.GREEN);
			break;
		case R.id.blue:
			mi.setChecked(true);
			tv.setBackgroundColor(Color.BLUE);
			break;
		}
		return true;
	}
	
	@Override
	//菜单项被单击后的回调方法
	public boolean onOptionsItemSelected(MenuItem mi){
		if(mi.isCheckable()){
			mi.setChecked(true);
		}
		//mi.setChecked(true);
		switch (mi.getItemId()) {
			case R.id.menu1:
				tv.setTextSize(10*2);
				break;
			case R.id.menu2:
				tv.setTextSize(10*3);
				break;
			case R.id.menu3:
				Toast toast = Toast.makeText(MenuByXml.this, "你点击了普通菜单项", Toast.LENGTH_SHORT);
				toast.show();
				break;
		}
		return true;
	}
}
