package com.example.demoapp.thirdchapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.demoapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalPrime extends Activity {
	
	static final String UPPER_NUM = "upper";
	EditText etNum;
	CalThread calThread;
	
	class CalThread extends Thread {
		public Handler mHandler;
		public void run(){
			Looper.prepare();
			mHandler = new Handler(){
				@Override
				public void handleMessage(Message msg){
					if(msg.what == 0x123)
					{
						int upper = msg.getData().getInt(UPPER_NUM);
						List<Integer> nums = new ArrayList<Integer>();
						// 计算从2开始、到upper的所有质数
						outer:
						for (int i = 2 ; i <= upper ; i++)
						{
							// 用i除以从2开始、到i的平方根的所有数
							for (int j = 2 ; j <= Math.sqrt(i) ; j++)
							{
								// 如果可以整除，则表明这个数不是质数
								if(i != 2 && i % j == 0)
								{
									continue outer;
								}
							}
							nums.add(i);
						}
						// 使用Toast显示统计出来的所有质数
						Toast.makeText(CalPrime.this, nums.toString()
							, Toast.LENGTH_LONG).show();
					}					
				}
			};
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
			}, 0, 12000);
			Looper.loop();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calprime);
		etNum = (EditText)findViewById(R.id.etNum);
		calThread = new CalThread();
		// 启动新线程
		calThread.start();
	}
	
	public void cal(View source){
		Message msg = new Message();
		msg.what = 0x123;
		Bundle  bundle = new Bundle();
		bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
		msg.setData(bundle);
		calThread.mHandler.sendMessage(msg);
	}
}
