package sectionlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.recyclerview.DividerItemDecoration;
import com.example.recyclerview.ItemData;
import com.example.recyclerview.R;

public class MainActivity extends Activity implements OnItemClickListener{
    private RecyclerView recyclerView;
    public List<ItemData> nearByGames=new ArrayList<ItemData>();
    public List<ItemData> myGames=new ArrayList<ItemData>();;
    private List<PinnedItem> mListData;
    private final int myGamesString = R.string.my_games;
    private final int nearByGamesStrings = R.string.nearby_games;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nearByGames.add( new ItemData("Delete", R.drawable.ic_launcher));
        nearByGames.add( new ItemData("Delete", R.drawable.ic_launcher));
        nearByGames.add( new ItemData("Delete", R.drawable.ic_launcher));
        nearByGames.add(   new ItemData("Rating", R.drawable.ic_launcher));
        nearByGames.add(   new ItemData("Like", R.drawable.ic_launcher));
        nearByGames.add(   new ItemData("Favorite", R.drawable.ic_launcher));
        nearByGames.add(   new ItemData("Cloud", R.drawable.ic_launcher));


        myGames.add( new ItemData("1", R.drawable.ic_launcher));
        myGames.add( new ItemData("2", R.drawable.ic_launcher));
        myGames.add( new ItemData("3", R.drawable.ic_launcher));
        myGames.add(   new ItemData("4", R.drawable.ic_launcher));
        myGames.add(   new ItemData("5", R.drawable.ic_launcher));
        myGames.add(   new ItemData("6", R.drawable.ic_launcher));
        myGames.add(   new ItemData("7", R.drawable.ic_launcher));







        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.addItemDecoration(getItemDecoration());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        updateListData();


    }

    public void updateListData() {
        //        if (paymentSet == null) {
        //            showList(false);
        //        } else {
        LinkedHashMap<Integer, ArrayList<ItemData>> transferData = new LinkedHashMap<Integer, ArrayList<ItemData>>();
        if (nearByGames != null && !nearByGames.isEmpty()) {
            transferData.put(nearByGamesStrings,
                    (ArrayList<ItemData>) nearByGames);
        }
        if (myGames != null && !myGames.isEmpty()) {
            transferData.put(myGamesString,
                    (ArrayList<ItemData>) myGames);
        }

        mListData = new ArrayList<PinnedItem>();
        Set<Integer> sections = transferData.keySet();
        Iterator<Integer> iterator = sections.iterator();
        int sectionPosition = 0;
        int listPosition = 0;
        while (iterator.hasNext()) {
            // add section header
            int sectionHeaderId = iterator.next();
            List<ItemData> paymentss = transferData.get(sectionHeaderId);
            PinnedItem section = new PinnedItem(PinnedItem.SECTION,
                    this.getString(sectionHeaderId));
            section.sectionPosition = sectionPosition++;
            section.listPosition = listPosition++;
            mListData.add(section);
            // add list data
            for (ItemData payment : paymentss) {
                PinnedItem item = new PinnedItem(PinnedItem.ITEM,
                        this.getString(sectionHeaderId), payment);
                item.sectionPosition = sectionPosition;
                item.listPosition = listPosition++;
                mListData.add(item);
            }
        }

        MyAdapter mAdapter = new MyAdapter(mListData);
        mAdapter.setOnItemClickListener(this);
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