package com.aig.drprasantapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.aig.drprasantapp.R;

import java.util.Collections;
import java.util.List;

import model.TestModel;

/**
 * Created by admin on 6/20/2018.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    List<TestModel> list = Collections.emptyList();
    Context context;
    private TestAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public TestAdapter(List<TestModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_single, parent, false);
        TestAdapter.ViewHolder viewHolder = new TestAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(TestAdapter.ViewHolder holder, int position) {
        //holder.imageView.setImageResource(list.get(position).getBookimage());
        holder.textName.setText(list.get(position).getTestname());
        holder.textSylubus.setText(list.get(position).getSylabus());
        holder.textCover.setText(list.get(position).getCover());
        holder.textQuest.setText(list.get(position).getQuestion());
        holder.textMinute.setText(list.get(position).getMinute());
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
        public TextView textName, textSylubus, textCover, textQuest,textMinute;
        public LinearLayout li_Share;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.tv_textname);
            textSylubus = (TextView) itemView.findViewById(R.id.tv_sylibus);
            textCover = (TextView) itemView.findViewById(R.id.tv_cover);
            textQuest = (TextView) itemView.findViewById(R.id.tv_quest);
            textMinute = (TextView) itemView.findViewById(R.id.tv_minute);
            li_Share = itemView.findViewById(R.id.share);
            imageView = itemView.findViewById(R.id.image_write);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public TestModel getItem(int id) {
        return list.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(TestAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}