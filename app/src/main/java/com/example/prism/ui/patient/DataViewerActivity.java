package com.example.prism.ui.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.prism.DatePickerFragment;
import com.example.prism.R;
import com.github.mikephil.charting.charts.BarChart;

import java.util.Calendar;

public class DataViewerActivity extends AppCompatActivity implements BarChartFragment.OnFragmentInteractionListener, AdapterView.OnItemSelectedListener{

    DialogFragment newFragment = new DatePickerFragment();
    BarChartFragment fragment;
    BarChart chart;
    private Spinner spnDataResolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_viewer_activity);

        if (savedInstanceState == null) {
            fragment = BarChartFragment.newInstance();
            fragment.mListener = this;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow();
        }

        chart = findViewById(R.id.barChart);

        final TextView startDate = findViewById(R.id.txtStartDate);
        final TextView endDate = findViewById(R.id.txtEndDate);

        startDate.setOnClickListener(createClickEvent(startDate));
        endDate.setOnClickListener(createClickEvent(endDate));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        startDate.setText(sdf.format(cal.getTime()));
        endDate.setText(sdf.format(cal.getTime()));

        spnDataResolution = findViewById(R.id.spnPresetDates);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.date_presets, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnDataResolution.setAdapter(adapter);

        spnDataResolution.setOnItemSelectedListener(this);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        Object item = parent.getItemAtPosition(pos);
        fragment.setDataViewResolution((String) item);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private View.OnClickListener createClickEvent(final TextView date){

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
    public void onFragmentInteraction(int dataResolutionView) {

        spnDataResolution.setSelection(dataResolutionView);

    }
}
