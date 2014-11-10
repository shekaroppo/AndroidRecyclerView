package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.addItemDecoration(getItemDecoration());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyAdapter mAdapter = new MyAdapter(itemsData);
        mAdapter.setOnItemClickListener(this);
        StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(mAdapter);
        recyclerView.addItemDecoration(headersDecor);
        recyclerView.setAdapter(mAdapter);


    }

    private RecyclerView.ItemDecoration getItemDecoration() {
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL_LIST);
        return itemDecoration;
    }

    private LinearLayoutManager getLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,
                "Clicked: " + position + ", index " + recyclerView.indexOfChild(view),
                Toast.LENGTH_SHORT).show();

    }


}