package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity
		implements
			RecyclerView.OnItemTouchListener {

	private RecyclerView recyclerView;
	GestureDetectorCompat gestureDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

		ItemData itemsData[] = {new ItemData("Help", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Delete", R.drawable.ic_launcher),
				new ItemData("Cloud", R.drawable.ic_launcher),
				new ItemData("Favorite", R.drawable.ic_launcher),
				new ItemData("Like", R.drawable.ic_launcher),
				new ItemData("Rating", R.drawable.ic_launcher)};

		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		layoutManager.scrollToPosition(5);
		recyclerView.setLayoutManager(layoutManager);

		RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
				this, DividerItemDecoration.VERTICAL_LIST);
		recyclerView.addItemDecoration(itemDecoration);

		MyAdapter mAdapter = new MyAdapter(itemsData);
		recyclerView.setAdapter(mAdapter);
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		recyclerView.addOnItemTouchListener(this);
		gestureDetector = new GestureDetectorCompat(this,
				new RecyclerViewDemoOnGestureListener());

	}

	@Override
	public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
		gestureDetector.onTouchEvent(e);
		return false;
	}

	private class RecyclerViewDemoOnGestureListener
			extends
				SimpleOnGestureListener {
		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
			Log.d("Clicked", "======");
			return super.onSingleTapConfirmed(e);
		}

		public void onLongPress(MotionEvent e) {
			View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
			super.onLongPress(e);
		}
	}

	@Override
	public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub

	}
}