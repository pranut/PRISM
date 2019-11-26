package com.example.prism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.prism.ui.physician.SectionsPhyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainScreenPhysician extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_physician);

        SectionsPhyPagerAdapter sectionsPagerAdapter = new SectionsPhyPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.phy_view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.phy_tabs);
        tabs.setupWithViewPager(viewPager);
    }


}
