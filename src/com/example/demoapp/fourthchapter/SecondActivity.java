package com.example.demoapp.fourthchapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	@Override
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		TextView tv = new TextView(this);
		tv.setText("duihauhusashudsau");
		setContentView(tv);
		Button button = new Button(this);
		button.setText("返回");
		setContentView(button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SecondActivity.this.finish();
			}
		});
		
		
		
	}
}
