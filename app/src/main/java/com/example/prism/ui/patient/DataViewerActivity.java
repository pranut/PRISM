package com.example.prism.ui.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.prism.DatePickerFragment;
import com.example.prism.R;

public class DataViewerActivity extends AppCompatActivity implements BarChartFragment.OnFragmentInteractionListener {

    DialogFragment newFragment = new DatePickerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_viewer_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BarChartFragment.newInstance())
                    .commitNow();
        }

        final TextView startDate = findViewById(R.id.txtStartDate);
        final TextView endDate = findViewById(R.id.txtEndDate);

        startDate.setOnClickListener(setOnClickListner(startDate));
        endDate.setOnClickListener(setOnClickListner(endDate));

    }

    private View.OnClickListener setOnClickListner(final TextView date){

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment(date);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        };

        return clickListener;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
