package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class PopupMenuTest extends Activity {
	PopupMenu pm = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuview);
	}

	public void onPopupButtonClick(View button){
		pm = new PopupMenu(this, button);
		getMenuInflater().inflate(R.menu.context, pm.getMenu());
		pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				switch (item.getItemId()) {
				case R.id.txt:
					pm.dismiss();
					break;
				default:
					Toast.makeText(PopupMenuTest.this, "你单击了【"+item.getTitle()+"】菜单项", Toast.LENGTH_SHORT).show();
					break;
				}
				return true;
			}
		});
		pm.show();
	}
}
