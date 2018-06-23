package com.aig.drprasantapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aig.drprasantapp.R;

import java.util.Collections;
import java.util.List;

import model.SoldBookModel;

/**
 * Created by admin on 6/18/2018.
 */

public class SoldBookAdapter extends RecyclerView.Adapter<SoldBookAdapter.ViewHolder> {


    List<SoldBookModel> list = Collections.emptyList();
    Context context;
    private SoldBookAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public SoldBookAdapter(List<SoldBookModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public SoldBookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsoled_books, parent, false);
        SoldBookAdapter.ViewHolder viewHolder = new SoldBookAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(SoldBookAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getBookimage());
        holder.textName.setText(list.get(position).getBookname());
        holder.textWrite.setText(list.get(position).getWriter());
        holder.textreduces.setText(list.get(position).getDeductprice());
        holder.textactualprice.setText(list.get(position).getActualprice());
      //  holder.ratingBar.setRating(Float.parseFloat(list.get(position).getActualprice()));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textName, textWrite, textreduces, textactualprice;
        public RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.tv_name);
            textWrite = (TextView) itemView.findViewById(R.id.tv_writtenby);
            textreduces = (TextView) itemView.findViewById(R.id.tv_price);
            textactualprice = (TextView) itemView.findViewById(R.id.tv_actual);
            imageView = itemView.findViewById(R.id.iM_image);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public SoldBookModel getItem(int id) {
        return list.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(SoldBookAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}