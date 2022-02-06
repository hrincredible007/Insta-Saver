package com.example.instagramcontentsaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem photo, video, reel, igtv, pic;
    Toolbar toolbar;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        photo = (TabItem) findViewById(R.id.Photo);
        video = (TabItem) findViewById(R.id.Video);
        reel = (TabItem) findViewById(R.id.Reel);
        igtv = (TabItem) findViewById(R.id.IGTV);
        pic = (TabItem) findViewById(R.id.PIC);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 5);
        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() ==3 || tab.getPosition() == 4){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}