package com.example.prism.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DayDataSummary {

    public ArrayList<DataSummary> daySummary;

    public HourDataSummary hdSumm;

    public DayDataSummary(){

    }

    public ArrayList<DataSummary> createDaySummary(ArrayList<TimeEvent> rawData) {

        if (daySummary != null) {
            return daySummary;

        } else {
            daySummary = new ArrayList<>();
            hdSumm = new HourDataSummary();
            ArrayList<DataSummary> hourSummary = hdSumm.createHourlySummary(rawData);

            // Get current time and round to hour
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(hourSummary.get(0).endDate));

            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.HOUR, 0);
            calendar.add(Calendar.DAY_OF_MONTH,1);

            long dayBlockEnd = calendar.getTime().getTime();
            //Day end - 24 hours
            long dayBlockStart = dayBlockEnd - 3600 * 1000 * 24;

            float tempTotal = 0;
            int countAvgItems = 0;
            int rawIndex = 0;

            // rawData has to be decreasing
            DataSummary dtSumm = new DataSummary();
            dtSumm.startDate = dayBlockStart;
            dtSumm.endDate = dayBlockEnd;

            while (rawIndex < hourSummary.size()) {

                long time = hourSummary.get(rawIndex).endDate;
                float avg = hourSummary.get(rawIndex).getAvg();

                if (dayBlockEnd >= time && dayBlockStart < time) {
                    dtSumm.addSummaryData(avg);
                    tempTotal += avg;
                    rawIndex++;
                    countAvgItems++;
                } else {

                    //Setting last item
                    setDataSumm(tempTotal, countAvgItems, dtSumm, daySummary);

                    dtSumm = new DataSummary();

                    countAvgItems = 0;
                    tempTotal = 0;
                    dayBlockEnd -= 3600 * 1000 * 24;
                    dayBlockStart -= 3600 * 1000 * 24;
                    dtSumm.startDate = dayBlockEnd;
                    dtSumm.endDate = dayBlockStart;
                }

            }
            //Setting last item
            setDataSumm(tempTotal, countAvgItems, dtSumm, daySummary);
        }


        return daySummary;
    }

    private void setDataSumm(float tempTotal, int countAvgItems, DataSummary dtSumm, ArrayList<DataSummary> summList) {
        if (countAvgItems != 0)
            dtSumm.setAvg(tempTotal / (float) countAvgItems);
        else
            dtSumm.setAvg(0f);

        summList.add(dtSumm);
    }
}
