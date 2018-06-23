package com.aig.drprasantapp.activity;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.aig.drprasantapp.R;

import model.ImageModel;

import com.aig.drprasantapp.adapter.HorizoBookAdapter;
import com.aig.drprasantapp.adapter.RecyclerHoriAdapter;
import com.aig.drprasantapp.adapter.SoldBookAdapter;
import com.aig.drprasantapp.utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import model.HorizotalitemsMenu;
import model.SoldBookModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView, recycler_bookclass, recyclerbook;
    RecyclerHoriAdapter recycler_adapter;
    HorizoBookAdapter horizoBookAdapter;
    SoldBookAdapter soldBookAdapter;
    LinearLayout lI_prepare, lI_notific, lI_profile, lI_topprepare, lI_topprestore, lI_topcontactus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy_view);
        recycler_bookclass = findViewById(R.id.recy_bookclass);
        recyclerbook = findViewById(R.id.rL_recyclersbook);
        lI_prepare = findViewById(R.id.li_prepare);
        lI_notific = findViewById(R.id.li_notifi);
        lI_profile = findViewById(R.id.li_profile);
        lI_topprepare = findViewById(R.id.lI_topprepare);
        lI_topprestore = findViewById(R.id.lI_topprestore);
        lI_topcontactus = findViewById(R.id.lI_topcontactus);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler_bookclass.setLayoutManager(horizontalLayout);
        LinearLayoutManager horizontalLayou1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerbook.setLayoutManager(horizontalLayou1);

        List<HorizotalitemsMenu> product = horizontaldata();
        List<ImageModel> images = imagesdata();
        List<SoldBookModel> soldBookModels = boolmodeldata();
        soldBookAdapter = new SoldBookAdapter(soldBookModels, this);
        recyclerbook.setAdapter(soldBookAdapter);
        recyclerbook.setNestedScrollingEnabled(false);

        recycler_adapter = new RecyclerHoriAdapter(product, this);
        recyclerView.setAdapter(recycler_adapter);
        recyclerView.setNestedScrollingEnabled(false);
        horizoBookAdapter = new HorizoBookAdapter(images, this);
        recycler_bookclass.setAdapter(horizoBookAdapter);
        recycler_bookclass.setNestedScrollingEnabled(false);
        lI_prepare.setOnClickListener(this);
        lI_notific.setOnClickListener(this);
        lI_profile.setOnClickListener(this);
        lI_topcontactus.setOnClickListener(this);
        lI_topprepare.setOnClickListener(this);
        lI_topprestore.setOnClickListener(this);

       /* recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, PrepareActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, ContactUsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, PreStoreActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));*/
    }

    private List<SoldBookModel> boolmodeldata() {
        List<SoldBookModel> soldBookModels = new ArrayList<>();
        soldBookModels.add(new SoldBookModel(R.drawable.images2_180, "Eamination Review", "by Gobind Rai Garg", "Rs.300", "Rs.200", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images3_180, "Eamination Review", "by Gobind Rai Garg", "Rs.500", "Rs.300", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images2_180, "Eamination Review", "by Gobind Rai Garg", "Rs.300", "Rs.200", "Saved 60%", 5f));
        soldBookModels.add(new SoldBookModel(R.drawable.images3_180, "Eamination Review", "by Gobind Rai Garg", "Rs.400", "Rs.200", "Saved 50%", 5f));
        return soldBookModels;
    }

    private List<ImageModel> imagesdata() {
        List<ImageModel> images = new ArrayList<>();
        images.add(new ImageModel(R.drawable.images3_180, "DNB CET Jan 2018: Schedule for..."));
        images.add(new ImageModel(R.drawable.images2_180, "My exam score closely matches th.."));
        images.add(new ImageModel(R.drawable.images3_180, "From rank 4,184 to rank 4 in year.."));
        return images;
    }

    private List<HorizotalitemsMenu> horizontaldata() {
        List<HorizotalitemsMenu> dtop = new ArrayList<>();
        dtop.add(new HorizotalitemsMenu(R.drawable.read_top, "Prepare"));
        dtop.add(new HorizotalitemsMenu(R.drawable.prese_top, "PrepClass"));
        dtop.add(new HorizotalitemsMenu(R.drawable.cart_top, "PrepStore"));
        dtop.add(new HorizotalitemsMenu(R.drawable.contact_us, "Contact Us"));
        return dtop;
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

            case R.id.li_profile:
                Intent intent2 = new Intent(this, ProfileActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
            case R.id.lI_topprepare:
                Intent intent3 = new Intent(MainActivity.this, PrepareActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                break;
            case R.id.lI_topprestore:
                Intent intent4 = new Intent(MainActivity.this, PreStoreActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                break;

            case R.id.lI_topcontactus:
                Intent intent5 = new Intent(MainActivity.this, ContactUsActivity.class);
                intent5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
