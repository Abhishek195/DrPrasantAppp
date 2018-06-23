package com.aig.drprasantapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aig.drprasantapp.R;

import java.util.Collections;
import java.util.List;

import model.NotificationModel;

/**
 * Created by admin on 6/20/2018.
 */

public class NotifiAdapter extends RecyclerView.Adapter<NotifiAdapter.ViewHolder> {
    List<NotificationModel> list = Collections.emptyList();
    Context context;
    private NotifiAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public NotifiAdapter(List<NotificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public NotifiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_single, parent, false);
        NotifiAdapter.ViewHolder viewHolder = new NotifiAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(NotifiAdapter.ViewHolder holder, int position) {
        //holder.imageView.setImageResource(list.get(position).getBookimage());
        holder.textName.setText(list.get(position).getName());
        holder.textSubject.setText(list.get(position).getSubject());
        holder.textDate.setText(list.get(position).getDate());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textName, textSubject, textDate;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.tv_name);
            textSubject = (TextView) itemView.findViewById(R.id.tv_subject);
            textDate = (TextView) itemView.findViewById(R.id.tv_date);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public NotificationModel getItem(int id) {
        return list.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(NotifiAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}