package com.example.demoapp.thirdchapter;

import com.example.demoapp.R;
import com.example.demoapp.thirdchapter.domain.Person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BundlerTest extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bundletest);
		Button bn = (Button) findViewById(R.id.bn);
		bn.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				EditText name = (EditText)findViewById(R.id.name);
				EditText passwd = (EditText)findViewById(R.id.passwd);
				RadioButton male = (RadioButton) findViewById(R.id.male);
				String gender = male.isChecked() ? "男 " : "女";
				Person p = new Person(name.getText().toString(), passwd
						.getText().toString(), gender);
				// 创建一个Bundle对象
				Bundle dataBundler = new Bundle();
				dataBundler.putSerializable("person", p);
				// 创建一个Intent
				Intent intent = new Intent(BundlerTest.this,
						ResultActivity.class);
				intent.putExtras(dataBundler);
				// 启动intent对应的Activity
				startActivity(intent);
			}
		});
	}

}
