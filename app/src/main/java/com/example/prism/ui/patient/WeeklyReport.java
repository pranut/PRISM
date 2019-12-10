package com.example.prism.ui.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prism.MainScreenPatient;
import com.example.prism.databinding.ContentWeeklyReportBinding;
import com.example.prism.model.Routine;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.prism.R;
import com.example.prism.model.Routines;

import java.util.ArrayList;
import java.util.List;

public class WeeklyReport extends AppCompatActivity  {

    ContentWeeklyReportBinding bi;
    ExpendableRecyclerViewAdapter adapter;

    Routines routines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.content_weekly_report);
        init();
    }

    private void init() {
        setSupportActionBar(bi.tlbWeeklyReport);
        getSupportActionBar().setTitle("Weekly Report");

        Bundle extras = getIntent().getExtras();
        Intent intentIncoming = getIntent();
        if(extras != null) {
            routines = intentIncoming.getParcelableExtra("ROUTINES");// OK
        }

        adapter = new ExpendableRecyclerViewAdapter(this, routines.rList);

        bi.rcvItemsList.setLayoutManager(new LinearLayoutManager(this));
        bi.rcvItemsList.setHasFixedSize(true);
        bi.rcvItemsList.setAdapter(adapter);

    }

    public void sendReport(View view) {


        this.finish();
//        Intent myIntent = new Intent(this, MainScreenPatient.class);
//        startActivity(myIntent);

    }

//    public List<Routine> getRoutinesData() {
//        List<Routine> routineList = new ArrayList<>();
//        String[] routines = getResources().getStringArray(R.array.rList);
//        //TypedArray images = getResources().obtainTypedArray(R.array.images);
//
//        for (int i = 0; i < routines.length; i++) {
//            Routine rList = new Routine();
//            rList.setName(routines[i]);
//            //rList.setImage(images.getResourceId(i, -1));
//            routineList.add(rList);
//        }
//        return routineList;
//    }

}
