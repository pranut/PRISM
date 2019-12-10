package com.example.prism.model;

import java.util.ArrayList;

public class DataSummary {

    private ArrayList<TimeEvent> rawPoints;
    private ArrayList<Float> summaryData;

    public long startDate;
    public long endDate;

    private float avg;

    public DataSummary(){
    }

    public ArrayList<TimeEvent> getRawPoints() {
        return rawPoints;
    }

    public void setRawPoints(ArrayList<TimeEvent> rawPoints) {
        this.rawPoints = rawPoints;
    }

    public void addRawPoints(TimeEvent tEvent) {

        if (rawPoints != null){
            rawPoints.add(tEvent);
        }else{
            rawPoints = new ArrayList<>();
            rawPoints.add(tEvent);
        }
    }

    public ArrayList<Float> getSummaryData() {
        return summaryData;
    }

    public void addSummaryData(Float sumData) {

        if (summaryData != null){
            summaryData.add(sumData);
        }else{
            summaryData = new ArrayList<>();
            summaryData.add(sumData);
        }
    }

    public void setSummaryData(ArrayList<Float> summaryData) {
        this.summaryData = summaryData;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
