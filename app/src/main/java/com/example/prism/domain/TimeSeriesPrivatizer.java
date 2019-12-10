package com.example.prism.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TimeSeriesPrivatizer {

    public ArrayList<long[]> rawEventData = new ArrayList<>();
    public ArrayList<int[]> intEventData = new ArrayList<>();

    public TimeSeriesPrivatizer(){}

    public ArrayList<TimeEvent> generateDummyData(int count, float range){

        ArrayList<TimeEvent> rawData = new ArrayList<>();
        Date currentTime = Calendar.getInstance().getTime();
        long randomTimeEvent = currentTime.getTime();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * (range + 1));
            randomTimeEvent = randomTimeEvent - (long)(Math.random() * 1000 * 60 * 60 * 10);
            rawData.add(new TimeEvent(randomTimeEvent, val));
        }

        //Collections.sort(rawData, new SortbyEventTime());
        return rawData;
    }

    public WeekDataSummary  getWeekAvgDataPoints(ArrayList<TimeEvent> rawData){
        WeekDataSummary wSumm = new WeekDataSummary();
        wSumm.createWeekSummary(rawData);
        return wSumm;
    }

}
