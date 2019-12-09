package com.example.prism.domain;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HourDataSummary {

    public ArrayList<DataSummary> hourSummary;


    public HourDataSummary(){

    }

    public ArrayList<DataSummary> createHourlySummary(ArrayList<TimeEvent> rawData) {

        if (hourSummary != null) {
            return hourSummary;

        } else {
            hourSummary = new ArrayList<>();
            // Get current time and round to hour
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(rawData.get(0).eventTime));

            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.add(Calendar.HOUR, 1);

            long lastHourBlockEnd = calendar.getTime().getTime();
            long lastHourBlockStart = lastHourBlockEnd - 3600 * 1000;

            float tempTotal = 0;
            int countAvgItems = 0;
            int rawIndex = 0;

            // rawData has to be decreasing
            DataSummary dtSumm = new DataSummary();
            dtSumm.startDate = lastHourBlockStart;
            dtSumm.endDate = lastHourBlockEnd;

            while (rawIndex < rawData.size()) {

                long time = rawData.get(rawIndex).eventTime;

                if (lastHourBlockEnd >= time && lastHourBlockStart < time) {
                    dtSumm.addRawPoints(rawData.get(rawIndex));
                    tempTotal += rawData.get(rawIndex).value;
                    rawIndex++;
                    countAvgItems++;
                } else {
                    //Setting last item
                    setDataSumm(tempTotal, countAvgItems, dtSumm, hourSummary);

                    dtSumm = new DataSummary();

                    countAvgItems = 0;
                    tempTotal = 0;
                    lastHourBlockEnd -= 3600 * 1000;
                    lastHourBlockStart -= 3600 * 1000;
                    dtSumm.startDate = lastHourBlockStart;
                    dtSumm.endDate = lastHourBlockEnd;
                }

            }
            //Setting last item
            setDataSumm(tempTotal, countAvgItems, dtSumm, hourSummary);
        }

        return hourSummary;
    }

    private void setDataSumm(float tempTotal, int countAvgItems, DataSummary dtSumm, ArrayList<DataSummary> summList) {
        if (countAvgItems != 0)
            dtSumm.setAvg(tempTotal / (float) countAvgItems);
        else
            dtSumm.setAvg(0f);

        summList.add(dtSumm);
    }
}
