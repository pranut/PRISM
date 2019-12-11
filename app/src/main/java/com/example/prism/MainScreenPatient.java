package com.example.prism;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.prism.databinding.ActivityMainScreenPatientBinding;
import com.example.prism.model.Routine;
import com.example.prism.model.Routines;
import com.example.prism.ui.patient.WeeklyReport;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import com.example.prism.ui.patient.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainScreenPatient extends AppCompatActivity {

    Routines routines;

    ActivityMainScreenPatientBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main_screen_patient);

        Bundle extras = getIntent().getExtras();
        Intent intentIncoming = getIntent();
        if(extras != null) {
            routines = intentIncoming.getParcelableExtra("ROUTINES");// OK
        }

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),routines);

        ViewPager viewPager = bi.vpContentItems;
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabPatient);
        tabs.setupWithViewPager(viewPager);

        // Setting floating button behavior
        FloatingActionButton fab = findViewById(R.id.fab);

        final View.OnClickListener listener = createClickEvent(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,
                        "Preparing weekly report...",
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", listener).show();
            }
        });

        // Change listener code.
        FloatingActionButton fab2 = bi.fab2;
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplication(), TestActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                view.getContext().startActivity(myIntent);
            }
        });

    }

    private View.OnClickListener createClickEvent(final Context context){
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, WeeklyReport.class);

                myIntent.putExtra("ROUTINES", routines);

                startActivity(myIntent);
            }
        };
        return clickListener;
    }
}