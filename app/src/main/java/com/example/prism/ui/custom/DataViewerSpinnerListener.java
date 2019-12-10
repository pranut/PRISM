package com.example.prism.ui.custom;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.prism.ui.patient.BarChartFragment;

public class DataViewerSpinnerListener implements OnItemSelectedListener {

    private BarChartFragment fragment;

    public DataViewerSpinnerListener (){}

    public DataViewerSpinnerListener (BarChartFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // An item was selected. You can retrieve the selected item using
        Object item = adapterView.getItemAtPosition(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
