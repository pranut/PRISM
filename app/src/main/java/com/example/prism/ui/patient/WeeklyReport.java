package com.example.prism.ui.patient;

import android.os.Bundle;
import com.example.prism.databinding.ContentWeeklyReportBinding;
import com.example.prism.model.Routine;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.prism.R;

import java.util.ArrayList;
import java.util.List;

public class WeeklyReport extends AppCompatActivity  {

    ContentWeeklyReportBinding bi;
    ExpendableRecyclerViewAdapter adapter;
    List<Routine> routineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.content_weekly_report);
        init();
    }

    private void init() {
        setSupportActionBar(bi.tlbWeeklyReport);
        getSupportActionBar().setTitle("Weekly Report");

        routineList = new ArrayList<>();
        //routineList = getRoutinesData();

        routineList.addAll(Routine.createRoutinesList(0));

        adapter = new ExpendableRecyclerViewAdapter(this, routineList);

        bi.rcvItemsList.setLayoutManager(new LinearLayoutManager(this));
        bi.rcvItemsList.setHasFixedSize(true);
        bi.rcvItemsList.setAdapter(adapter);

    }

//    public List<Routine> getRoutinesData() {
//        List<Routine> routineList = new ArrayList<>();
//        String[] routines = getResources().getStringArray(R.array.routine);
//        //TypedArray images = getResources().obtainTypedArray(R.array.images);
//
//        for (int i = 0; i < routines.length; i++) {
//            Routine routine = new Routine();
//            routine.setName(routines[i]);
//            //routine.setImage(images.getResourceId(i, -1));
//            routineList.add(routine);
//        }
//        return routineList;
//    }

}
