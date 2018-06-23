package com.aig.drprasantapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aig.drprasantapp.R;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import model.ImageModel;

/**
 * Created by admin on 6/16/2018.
 */

public class HorizoBookAdapter extends RecyclerView.Adapter<HorizoBookAdapter.ViewHolder> {


    List<ImageModel> list = Collections.emptyList();
    Context context;
    private HorizoBookAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public HorizoBookAdapter(List<ImageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public HorizoBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sing_book, parent, false);
        HorizoBookAdapter.ViewHolder viewHolder = new HorizoBookAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(HorizoBookAdapter.ViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.tv_name.setText(list.get(position).getName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            tv_name = itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public ImageModel getItem(int id) {
        return list.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(HorizoBookAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}