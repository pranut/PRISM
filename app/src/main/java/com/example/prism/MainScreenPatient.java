package com.example.prism;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.prism.ui.patient.WeeklyReport;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.example.prism.ui.patient.SectionsPagerAdapter;

public class MainScreenPatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_patient);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.vpContentItems);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabPatient);
        tabs.setupWithViewPager(viewPager);

        // Setting floating button behavior
        FloatingActionButton fab = findViewById(R.id.fab);

        final View.OnClickListener listener = createClickEvent(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Preparing weekly report...", Snackbar.LENGTH_LONG)
                        .setAction("Action", listener).show();
            }
        });
    }

    private View.OnClickListener createClickEvent(final Context context){

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, WeeklyReport.class);
                startActivity(myIntent);
            }
        };

        return clickListener;
    }

}