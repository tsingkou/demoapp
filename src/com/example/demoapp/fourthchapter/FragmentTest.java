package com.example.demoapp.fourthchapter;

import com.example.demoapp.R;
import com.example.demoapp.fourthchapter.BookListFragment.Callbacks;
import android.app.Activity;
import android.os.Bundle;

public class FragmentTest extends Activity implements Callbacks {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_twopane);
	}
	
	// 实现Callbacks接口必须实现的方法
	@Override
	public void onItemSelected(Integer id) {
		Bundle argument = new Bundle();
		argument.putInt(BookDetailFragment.ITEM_ID, id);
		BookDetailFragment frgment = new BookDetailFragment();
		frgment.setArguments(argument);
		getFragmentManager().beginTransaction()
			.replace(R.id.book_detail_container, frgment)
			.commit();
	}
}
