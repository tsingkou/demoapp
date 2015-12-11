package com.example.demoapp.fourthchapter;

import com.example.demoapp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForResult extends Activity {
	Button bn;
	EditText city;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activityforresult);
		bn = (Button) findViewById(R.id.bn);
		city = (EditText) findViewById(R.id.city);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityForResult.this, SelectCityActivity.class); 
				startActivityForResult(intent, 0);
			}
		});
	}
	
	//重写改方法，此方法以回调方式来获取指定的Activity返回的结果
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		if(0==requestCode && 0==resultCode){
			Bundle date = intent.getExtras();
			String resultCity = date.getString("city");
			city.setText(resultCity);
		}
		
		
	}

}
