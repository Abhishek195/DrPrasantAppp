package com.aig.drprasantapp.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.aig.drprasantapp.R;
import com.aig.drprasantapp.fragment.FreeVideosFragment;
import com.aig.drprasantapp.fragment.PremiumVideoFragment;
import com.aig.drprasantapp.fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class PrepareActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView imageView;
    LinearLayout linear_prepare, linear_home,linear_noti,lI_profile;
    Toolbar toolbar;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolbar = findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.title);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle.setText("Prepare");
        imageView = findViewById(R.id.image);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        linear_prepare = findViewById(R.id.li_prepare);
        linear_home = findViewById(R.id.li_home);
        linear_noti = findViewById(R.id.li_notifi);
        lI_profile = findViewById(R.id.li_profile);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        imageView.setOnClickListener(this);
        linear_home.setOnClickListener(this);
        linear_noti.setOnClickListener(this);
        lI_profile.setOnClickListener(this);
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.video_image,
                R.drawable.video_image1,
                R.drawable.icons8_help_60,

        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#f0565f"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#f0565f"), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        // MainActivity.toolbar.setTitle("Free Videos");
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        //MainActivity.toolbar.setTitle("Premium Videos");
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        //  MainActivity.toolbar.setTitle("Tests");
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#808080"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FreeVideosFragment(), "Free Videos");
        adapter.addFrag(new PremiumVideoFragment(), "Premium Videos");
        adapter.addFrag(new TestFragment(), "Tests");

        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                Intent intent = new Intent(this, MainActivity.class);
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
            case R.id.li_notifi:
                Intent intent2 = new Intent(this, NotificationActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;
            case R.id.li_profile:
                Intent intent3 = new Intent(this, ProfileActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                break;
        }

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
