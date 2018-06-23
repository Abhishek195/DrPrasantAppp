package com.aig.drprasantapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.aig.drprasantapp.R;

import java.util.Collections;
import java.util.List;

import model.HorizotalitemsMenu;

/**
 * Created by aone on 31-10-2017.
 */

public class RecyclerHoriAdapter extends RecyclerView.Adapter<RecyclerHoriAdapter.ViewHolder> {


    List<HorizotalitemsMenu> list = Collections.emptyList();
    Context context;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public RecyclerHoriAdapter(List<HorizotalitemsMenu> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_main_horitop, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView.setText(list.get(position).getCatname());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv_Catname);
            imageView = (ImageView)itemView.findViewById(R.id.im_category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // convenience method for getting data at click position
    public HorizotalitemsMenu getItem(int id) {
        return list.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}