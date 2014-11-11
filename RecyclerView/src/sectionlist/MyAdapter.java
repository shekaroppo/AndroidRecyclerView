
package sectionlist;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.ItemData;
import com.example.recyclerview.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<PinnedItem> itemsData;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public MyAdapter(List<PinnedItem> mListData) {
        this.itemsData = mListData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        android.util.Log.d("createViewHolder========", "====="+viewType);

        return createHolder(parent,viewType);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        android.util.Log.d("onBindViewHolder========", "=====");
        bindData(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        android.util.Log.d("getItemCount========", "=====");
        return itemsData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemsData.get(position).type;
    }

    private MyAdapter.ViewHolder createHolder(ViewGroup parent,int viewType) {
        View itemLayoutView = null;

        if(viewType==PinnedItem.SECTION){
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_header, null);
            HeaderViewHolder viewHolder = new HeaderViewHolder(itemLayoutView, this);
            return viewHolder;
        }
        else if(viewType==PinnedItem.ITEM){
            itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_layout, null);

            ItemViewHolder viewHolder = new ItemViewHolder(itemLayoutView, this);
            return viewHolder;
        }

        return null;


    }

    private void bindData(ViewHolder viewHolder, int position) {
        if(itemsData.get(position).type==PinnedItem.SECTION){
            //viewHolder.txtViewTitle.setText("SECTION="+position);
            TextView textView = (TextView) viewHolder.itemView;
            textView.setText("SECTION="+position);
        }
        else if(itemsData.get(position).type==PinnedItem.ITEM){
            ItemData iData=(ItemData) itemsData.get(position).tag;
            ItemViewHolder iVH=(ItemViewHolder) viewHolder;
            iVH.txtViewTitle.setText(iData.getTitle());
            iVH.imgViewIcon.setImageResource(iData
                    .getImageUrl());
        }

    }

    public void setOnItemClickListener(
            AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(ViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getPosition(), itemHolder.getItemId());
        }
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder
    implements
    View.OnClickListener {

        private MyAdapter mAdapter;

        public ViewHolder(View itemLayoutView, MyAdapter adapter) {
            super(itemLayoutView);
            mAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }
    }

    public static class HeaderViewHolder extends ViewHolder
    implements
    View.OnClickListener {


        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        private MyAdapter mAdapter;

        public HeaderViewHolder(View itemLayoutView, MyAdapter adapter) {
            super(itemLayoutView,adapter);
            mAdapter = adapter;
            itemLayoutView.setOnClickListener(this);
            txtViewTitle = (TextView) itemLayoutView
                    .findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView
                    .findViewById(R.id.item_icon);
        }

        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }
    }

    public static class ItemViewHolder extends ViewHolder
    implements
    View.OnClickListener {


        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        private MyAdapter mAdapter;

        public ItemViewHolder(View itemLayoutView, MyAdapter adapter) {
            super(itemLayoutView,adapter);
            mAdapter = adapter;
            itemLayoutView.setOnClickListener(this);
            txtViewTitle = (TextView) itemLayoutView
                    .findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView
                    .findViewById(R.id.item_icon);
        }

        @Override
        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }
    }



}
