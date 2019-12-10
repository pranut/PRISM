package com.example.prism.ui.patient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.prism.R;
import com.example.prism.databinding.FragmentBarChartBinding;
import com.example.prism.model.DataSummary;
import com.example.prism.model.DayDataSummary;
import com.example.prism.model.EDataResolution;
import com.example.prism.model.HourDataSummary;
import com.example.prism.model.TimeEvent;
import com.example.prism.model.TimeSeriesPrivatizer;
import com.example.prism.model.WeekDataSummary;
import com.example.prism.ui.custom.DayAxisValueFormatter;
import com.example.prism.ui.custom.MyValueFormatter;
import com.example.prism.ui.custom.XYMarkerView;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;
import java.util.List;

public class BarChartFragment extends Fragment implements OnChartValueSelectedListener {

    private BarChart chart;
    private FragmentBarChartBinding bi;
    private WeekDataSummary weekDataSummary;
    private DayDataSummary dayDataSummary;
    private HourDataSummary hourDataSummary;
    public ArrayList<TimeEvent> rawData;

    private Entry lastEntrySelected;

    // 0 = raw, 1 = hourly, 2=daily, 3=weekly, 4=monthly, 5=yearly
    private int dataViewResolution = 0;

    private Context context;

    private int timeOffSet = 0;

    public OnFragmentInteractionListener mListener;

    public BarChartFragment() {
        // Required empty public constructor
    }

    public static BarChartFragment newInstance() {
        BarChartFragment fragment = new BarChartFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        TimeSeriesPrivatizer priv = new TimeSeriesPrivatizer();
        weekDataSummary = priv.getWeekAvgDataPoints(this.rawData);
        dayDataSummary = weekDataSummary.dailySummary;
        hourDataSummary = dayDataSummary.hourlySummary;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_bar_chart, null);
        bi = DataBindingUtil.bind(view);

        // Inflate the layout for this fragment
        //View root = inflater.inflate(R.layout.fragment_bar_chart, container, false);

        //chart = root.findViewById(R.id.barChart);
        chart = bi.barChart;
        chart.setOnChartValueSelectedListener(this);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);


        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(chart);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        //xAxis.setTypeface(tfLight);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        ValueFormatter custom = new MyValueFormatter("");

        YAxis leftAxis = chart.getAxisLeft();
        //leftAxis.setTypeface(tfLight);
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        chart.getAxisRight().setEnabled(false);
//        YAxis rightAxis = chart.getAxisRight();
//        rightAxis.setDrawGridLines(false);
//        //rightAxis.setTypeface(tfLight);
//        rightAxis.setLabelCount(8, false);
//        rightAxis.setValueFormatter(custom);
//        rightAxis.setSpaceTop(15f);
//        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        XYMarkerView mv = new XYMarkerView(container.getContext(), xAxisFormatter);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart

        setInitialData();

        // draw points over time
        chart.animateX(1500);

        // draw legend entries as lines
        //l.setForm(Legend.LegendForm.LINE);
        //chart.setDrawLegend(false);
        return view;
    }

    private void updateData(int chartX, int viewResolution) {
        //chartX is x+1
        ArrayList<BarEntry> values = new ArrayList<>();

        switch (viewResolution){
            case 0:{
                break;
            }
            case 1:{
                ArrayList<DataSummary> hoursWithinDay  = dayDataSummary.getHoursWithinDay(chartX-1);
                setBarEntry(values, hoursWithinDay);
                break;
            }
            case 2:{
                ArrayList<DataSummary> daysWithinWeek  = weekDataSummary.getDaysWithinWeek(chartX-1);
                setBarEntry(values, daysWithinWeek);

                break;
            }
        }
        setChartData(values, context);
    }

    private void setBarEntry(ArrayList<BarEntry> values, ArrayList<DataSummary> dataList) {
        for (int i = 1; i < dataList.size() + 1; i++) {
            float val = dataList.get(i - 1).getAvg();
            //values.add(new BarEntry(i, val, getResources().getDrawable(R.drawable.star)));
            values.add(new BarEntry(i, val));
        }
    }

    private void setInitialData() {

        ArrayList<DataSummary> dataPoints = weekDataSummary.dataPoints;
        ArrayList<BarEntry> values = new ArrayList<>();
        setBarEntry(values, dataPoints);
        setChartData(values, context);
    }

    private void setChartData(ArrayList<BarEntry> values, Context context) {
        BarDataSet set1;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(values, "Collected Steps");
            set1.setDrawIcons(false);

            int colorGreen = ContextCompat.getColor(context, android.R.color.holo_green_light);
            //int coloRed = ContextCompat.getColor(context, android.R.color.holo_red_light);

            List<GradientColor> gradientColors = new ArrayList<>();
            gradientColors.add(new GradientColor(colorGreen, colorGreen));

            set1.setGradientColors(gradientColors);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            //data.setValueTypeface(tfLight);
            data.setBarWidth(0.9f);

            chart.setData(data);
        }
        chart.resetZoom();
        chart.fitScreen();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bar, menu);
//        return true;
//    }

    //Not being used. Kept for reference
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.viewGithub: {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/com/xxmassdeveloper/mpchartexample/BarChartActivity.java"));
                startActivity(i);
                break;
            }
            case R.id.actionToggleValues: {
                for (IDataSet set : chart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                chart.invalidate();
                break;
            }
            case R.id.actionToggleIcons: {
                for (IDataSet set : chart.getData().getDataSets())
                    set.setDrawIcons(!set.isDrawIconsEnabled());

                chart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {
                if (chart.getData() != null) {
                    chart.getData().setHighlightEnabled(!chart.getData().isHighlightEnabled());
                    chart.invalidate();
                }
                break;
            }
            case R.id.actionTogglePinch: {
                if (chart.isPinchZoomEnabled())
                    chart.setPinchZoom(false);
                else
                    chart.setPinchZoom(true);

                chart.invalidate();
                break;
            }
            case R.id.actionToggleAutoScaleMinMax: {
                chart.setAutoScaleMinMaxEnabled(!chart.isAutoScaleMinMaxEnabled());
                chart.notifyDataSetChanged();
                break;
            }
            case R.id.actionToggleBarBorders: {
                for (IBarDataSet set : chart.getData().getDataSets())
                    ((BarDataSet) set).setBarBorderWidth(set.getBarBorderWidth() == 1.f ? 0.f : 1.f);

                chart.invalidate();
                break;
            }
            case R.id.animateX: {
                chart.animateX(2000);
                break;
            }
            case R.id.animateY: {
                chart.animateY(2000);
                break;
            }
            case R.id.animateXY: {
                chart.animateXY(2000, 2000);
                break;
            }
//            case R.id.actionSave: {
//                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                    saveToGallery();
//                } else {
//                    requestStoragePermission(chart);
//                }
//                break;
//            }
        }
        return true;
    }

    private final RectF onValueSelectedRectF = new RectF();

    public void setDataViewResolution(String viewResolution){
        ArrayList<BarEntry> values = new ArrayList<>();
        switch (viewResolution){
            case "All":{
                this.dataViewResolution = 0;
                ArrayList<TimeEvent> rawDataWithinHour  = hourDataSummary.rawDataPoints;
                for (int i = 1; i < rawDataWithinHour.size() + 1; i++) {
                    float val = (float)rawDataWithinHour.get(i-1).value;
                    float index = rawDataWithinHour.get(i-1).eventTime;
                    //values.add(new BarEntry(i, val, getResources().getDrawable(R.drawable.star)));
                    values.add(new BarEntry(i, val));
                }
                break;
            }
            case "Hourly":{
                this.dataViewResolution = 1;
                ArrayList<DataSummary> allDataAsHours  = hourDataSummary.dataPoints;
                setBarEntry(values, allDataAsHours);
                break;
            }
            case "Daily":{
                this.dataViewResolution = 2;
                ArrayList<DataSummary> allDataAsDays  = dayDataSummary.dataPoints;
                setBarEntry(values, allDataAsDays);
                break;
            }
            case "Weekly":{
                ArrayList<DataSummary> allDataAsWeeks  = weekDataSummary.dataPoints;
                setBarEntry(values, allDataAsWeeks);
                this.dataViewResolution = 3;
                break;
            }
            default:{
                break;
            }
        }
        setChartData(values, this.context);
        chart.animateX(1000);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

        if (e == null)
            return;
        //Saving last item selected
        lastEntrySelected = e;

        //Kept for reference
        RectF bounds = onValueSelectedRectF;
        chart.getBarBounds((BarEntry) e, bounds);
        MPPointF position = chart.getPosition(e, AxisDependency.LEFT);

        Log.i("bounds", bounds.toString());
        Log.i("position", position.toString());

        Log.i("x-index",
                "low: " + chart.getLowestVisibleX() + ", high: "+ chart.getHighestVisibleX());

        MPPointF.recycleInstance(position);
    }

    @Override
    public void onNothingSelected() {

        if(this.dataViewResolution > 1) {
            //Going one level into
            EDataResolution eDataResPrevious = EDataResolution.toEnum(this.dataViewResolution);
            this.dataViewResolution = this.dataViewResolution - 1;
            EDataResolution eDataResNext = EDataResolution.toEnum(this.dataViewResolution);

            String message = "Expanding " + eDataResPrevious.toString() + " data point into " + eDataResNext.toString();

            Snackbar.make(bi.linearChartFrame, message, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            //This c
            mListener.onFragmentInteraction(this.dataViewResolution);

            //this.updateData((int) lastEntrySelected.getX(), this.dataViewResolution);

            // draw points over time

            //chart.animateX(1000);

        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int dataResolutionView);
    }
}
