package com.aig.drprasantapp.activity;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.aig.drprasantapp.R;
import com.aig.drprasantapp.adapter.NotifiAdapter;
import com.aig.drprasantapp.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import model.NotificationModel;
import model.TestModel;


public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    NotifiAdapter notifiAdapter;
    Toolbar toolbar;
    TextView mTitle;
    LinearLayout lI_home, lI_prepare,lI_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        toolbar = findViewById(R.id.toolbar);
        lI_home = findViewById(R.id.li_home);
        lI_prepare = findViewById(R.id.li_prepare);
        lI_profile = findViewById(R.id.li_profile);
        mTitle = (TextView) toolbar.findViewById(R.id.title);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle.setText("Notification");
        recyclerView = findViewById(R.id.tecy_notifi);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<NotificationModel> listarray = notidata();
        notifiAdapter = new NotifiAdapter(listarray, NotificationActivity.this);
        recyclerView.setAdapter(notifiAdapter);
        lI_home.setOnClickListener(this);
        lI_prepare.setOnClickListener(this);
        lI_profile.setOnClickListener(this);
    }

    private List<NotificationModel> notidata() {
        List<NotificationModel> notidata = new ArrayList<>();
        notidata.add(new NotificationModel("Attemp this High Yield Image Based MCQ", "Subject : Medicine", "20 June 2018"));
        notidata.add(new NotificationModel("Attemp this High Yield Image Based MCQ", "Subject : Radiology", "19 June 2018"));
        notidata.add(new NotificationModel("Attemp this High Yield Image Based MCQ", "Subject : Radiology", "19 June 2018"));
        return notidata;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.li_prepare:
                Intent intent = new Intent(this, PrepareActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.li_home:
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                break;
            case R.id.li_profile:
                Intent intent2 = new Intent(this, ProfileActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
        }

    }
}
