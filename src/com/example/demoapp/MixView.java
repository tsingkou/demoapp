package com.example.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MixView extends Activity {
	
	int[] images = new int[]{
			R.drawable.b1,
			R.drawable.b2,
			R.drawable.b3,
			R.drawable.b4,
			R.drawable.b5
	};
	int currentImg = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LinearLayout main = (LinearLayout)findViewById(R.id.root);
		final ImageView image = new ImageView(this);
		main.addView(image);
		image.setImageResource(images[0]);
		image.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (currentImg >= 4)
				{
					currentImg = -1;
				}
				//改变ImageView里显示的图片
				image.setImageResource(images[++currentImg%images.length]);
			}
		});
		
	}
	
	

}
