package com.aig.drprasantapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


import com.aig.drprasantapp.R;
import com.aig.drprasantapp.adapter.SoldBookAdapter;

import java.util.ArrayList;
import java.util.List;

import model.SoldBookModel;

public class PreStoreActivity extends AppCompatActivity {
    RecyclerView recy_latest, recy_popular;
    SoldBookAdapter soldBookAdapter;
    Toolbar toolbar;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_store);
        toolbar = findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.title);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle.setText("PrepStore");
        recy_latest = findViewById(R.id.recycle_latestboo);
        recy_popular = findViewById(R.id.recycle_mostpapular);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recy_latest.setLayoutManager(horizontalLayout);
        LinearLayoutManager horizontalLayout1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recy_popular.setLayoutManager(horizontalLayout1);
        List<SoldBookModel> latestbook = booklatest();
        soldBookAdapter = new SoldBookAdapter(latestbook, this);
        recy_latest.setAdapter(soldBookAdapter);
        recy_latest.setNestedScrollingEnabled(false);

        List<SoldBookModel> soldbooks = booklatest();
        soldBookAdapter = new SoldBookAdapter(soldbooks, this);
        recy_popular.setAdapter(soldBookAdapter);
        recy_popular.setNestedScrollingEnabled(false);

    }

    private List<SoldBookModel> booklatest() {
        List<SoldBookModel> soldBookModels = new ArrayList<>();
        soldBookModels.add(new SoldBookModel(R.drawable.images2_180, "Eamination Review", "by Gobind Rai Garg", "Rs.300", "Rs.200", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images3_180, "Eamination Review", "by Gobind Rai Garg", "Rs.500", "Rs.300", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images2_180, "Eamination Review", "by Gobind Rai Garg", "Rs.300", "Rs.200", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images3_180, "Eamination Review", "by Gobind Rai Garg", "Rs.400", "Rs.200", "Saved 50%", 5f));
        return soldBookModels;
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
}
