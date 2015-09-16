package com.example.demoapp;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MenuTest extends Activity {
	
	// 定义字体大小菜单项的标识
	final int FONT_10 = 0x111;
	final int FONT_12 = 0x112;
	final int FONT_14 = 0x113;
	final int FONT_16 = 0x114;
	final int FONT_18 = 0x115;
	// 定义普通菜单项的标识
	final int PLAIN_ITEM = 0x11b;
	// 定义字体颜色菜单项的标识
	final int FONT_RED = 0x116;
	final int FONT_BLUE = 0x117;
	final int FONT_GREEN = 0x118;
	
	private EditText edit;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuview);
		edit = (EditText) findViewById(R.id.txt);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// -------------向menu中添加字体大小的子菜单-------------
		SubMenu fontMenu = menu.addSubMenu("字体大小");
		//fontMenu.setGroupCheckable(0, true, true);
		// 设置菜单的图标
		fontMenu.setIcon(R.drawable.font);
		// 设置菜单头的图标
		fontMenu.setHeaderIcon(R.drawable.font);
		// 设置菜单头的标题
		fontMenu.setHeaderTitle("选择字体大小");
		fontMenu.add(0, FONT_10, 0, "10号字体");
		fontMenu.add(0, FONT_12, 0, "12号字体");
		fontMenu.add(0, FONT_14, 0, "14号字体");
		fontMenu.add(0, FONT_16, 0, "16号字体");
		fontMenu.add(0, FONT_18, 0, "18号字体");
		// -------------向menu中添加普通菜单项-------------
		menu.add(0, PLAIN_ITEM, 0, "还原菜单项");
		//SubMenu normMenu = menu.addSubMenu("普通菜单项");
		
		
		// -------------向menu中添加文字颜色的子菜单-------------
		SubMenu colorMenu = menu.addSubMenu("字体颜色");
		colorMenu.setIcon(R.drawable.color);
		// 设置菜单头的图标
		colorMenu.setHeaderIcon(R.drawable.color);
		// 设置菜单头的标题
		colorMenu.setHeaderTitle("选择文字颜色");
		colorMenu.add(0, FONT_RED, 0, "红色");
		colorMenu.add(0, FONT_GREEN, 0, "绿色");
		colorMenu.add(0, FONT_BLUE, 0, "蓝色");
		MenuItem mi = colorMenu.add("其他颜色");
		mi.setIntent(new Intent(this, MixView.class));
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	// 菜单项被单击后的回调方法
	public boolean onOptionsItemSelected(MenuItem mi)
	{
		//判断单击的是哪个菜单项，并针对性的作出响应。
		switch (mi.getItemId())
		{
			case FONT_10:
				//mi.setCheckable(true);
				edit.setTextSize(10 * 2);
				break;
			case FONT_12:
				edit.setTextSize(12 * 2);
				break;
			case FONT_14:
				edit.setTextSize(14 * 2);
				break;
			case FONT_16:
				edit.setTextSize(16 * 2);
				break;
			case FONT_18:
				edit.setTextSize(18 * 2);
				break;
			case FONT_RED:
				edit.setTextColor(Color.RED);
				break;
			case FONT_GREEN:
				edit.setTextColor(Color.GREEN);
				break;
			case FONT_BLUE:
				edit.setTextColor(Color.BLUE);
				break;
			case PLAIN_ITEM:
				edit.setTextSize(10 * 2);
				edit.setTextColor(Color.BLACK);
				Toast toast = Toast.makeText(MenuTest.this
						, "已将内容还原！" , Toast.LENGTH_SHORT);
					toast.show();
				break;
		}
		return true;
	}
}