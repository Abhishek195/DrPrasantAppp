package com.aig.drprasantapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aig.drprasantapp.R;

public class ProfileActivity extends AppCompatActivity  implements View.OnClickListener{
    Toolbar toolbar;
    TextView mTitle,mContact;
    LinearLayout lI_home,lI_prepare,lI_notifi,lI_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = findViewById(R.id.toolbar);
        lI_home = findViewById(R.id.li_home);
        lI_prepare = findViewById(R.id.li_prepare);
        lI_notifi = findViewById(R.id.li_notifi);
        lI_profile = findViewById(R.id.li_profile);
        mTitle = (TextView) toolbar.findViewById(R.id.title);
        mContact = (TextView) toolbar.findViewById(R.id.contact);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle.setText("My Profile");
        lI_home.setOnClickListener(this);
        lI_prepare.setOnClickListener(this);
        lI_notifi.setOnClickListener(this);
        lI_profile.setOnClickListener(this);
        mContact.setOnClickListener(this);
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
            case R.id.li_notifi:
                Intent intent1 = new Intent(this, NotificationActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                break;
            case R.id.li_home:
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
            case R.id.contact:
                Intent intent3 = new Intent(this,ContactUsProfActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                break;
        }
    }
}
