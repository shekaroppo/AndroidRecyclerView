
package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder>{

    private ItemData[] itemsData;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public MyAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.util.Log.d("createViewHolder========", "=====");
        return createViewHolder(parent);
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
        return itemsData.length;
    }

    private MyAdapter.ViewHolder createViewHolder(ViewGroup parent) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_layout, null);
     
        ViewHolder viewHolder = new ViewHolder(itemLayoutView, this);
        return viewHolder;
    }

    private void bindData(ViewHolder viewHolder, int position) {
        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
        viewHolder.imgViewIcon.setImageResource(itemsData[position]
                .getImageUrl());
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
        

        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        private MyAdapter mAdapter;

        public ViewHolder(View itemLayoutView, MyAdapter adapter) {
            super(itemLayoutView);
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

    @Override
    public long getHeaderId(int position) {
        return itemsData[position].getTitle().charAt(0);
    }

    @Override
    public android.support.v7.widget.RecyclerView.ViewHolder onCreateHeaderViewHolder(
            ViewGroup parent) {
        android.util.Log.d("onCreateHeaderViewHolder========", "=====");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_header, parent, false);
            return new RecyclerView.ViewHolder(view) { };
    }

    @Override
    public void onBindHeaderViewHolder(android.support.v7.widget.RecyclerView.ViewHolder holder,
            int position) {
        android.util.Log.d("onBindHeaderViewHolder========", "=====");
        TextView textView = (TextView) holder.itemView.findViewById(R.id.header_view);
        textView.setText(String.valueOf(itemsData[position].getTitle().charAt(0)));

        
    }
}
