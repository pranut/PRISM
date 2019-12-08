package com.example.prism.ui.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.prism.DatePickerFragment;
import com.example.prism.R;
import com.github.mikephil.charting.charts.BarChart;

public class DataViewerActivity extends AppCompatActivity implements BarChartFragment.OnFragmentInteractionListener, AdapterView.OnItemSelectedListener {

    DialogFragment newFragment = new DatePickerFragment();
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_viewer_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BarChartFragment.newInstance())
                    .commitNow();
        }

        chart = findViewById(R.id.barChart);


        final TextView startDate = findViewById(R.id.txtStartDate);
        final TextView endDate = findViewById(R.id.txtEndDate);

        startDate.setOnClickListener(setOnClickListener(startDate));
        endDate.setOnClickListener(setOnClickListener(endDate));

        Spinner spinner = findViewById(R.id.spnPresetDates);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.date_presets, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);



    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    private View.OnClickListener setOnClickListener(final TextView date){

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
