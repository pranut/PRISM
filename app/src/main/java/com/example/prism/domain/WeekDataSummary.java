package com.example.prism.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeekDataSummary {

    public ArrayList<DataSummary> weekSummary;

    public DayDataSummary daySumm;

    public WeekDataSummary(){

    }

    public ArrayList<DataSummary> createWeekSummary(ArrayList<TimeEvent> rawData) {

        if (weekSummary != null) {
            return weekSummary;

        } else {
            weekSummary = new ArrayList<>();
            daySumm = new DayDataSummary();
            ArrayList<DataSummary> daySummary = daySumm.createDaySummary(rawData);

            // Get current time and round to hour
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(daySummary.get(0).endDate));

            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.DAY_OF_WEEK, 0);

            long weekBlockEnd = calendar.getTime().getTime();
            //Day end - 24 hours
            long weekBlockStart = weekBlockEnd - 3600 * 1000 * 24 * 7;

            float tempTotal = 0;
            int countAvgItems = 0;
            int rawIndex = 0;

            // rawData has to be decreasing
            DataSummary dtSumm = new DataSummary();
            dtSumm.startDate = weekBlockStart;
            dtSumm.endDate = weekBlockEnd;

            while (rawIndex < daySummary.size()) {

                long time = daySummary.get(rawIndex).endDate;
                float avg = daySummary.get(rawIndex).getAvg();

                if (weekBlockEnd >= time && weekBlockStart < time) {
                    dtSumm.addSummaryData(avg);
                    tempTotal += avg;
                    rawIndex++;
                    countAvgItems++;
                } else {

                    setDataSumm(tempTotal, countAvgItems, dtSumm,weekSummary);

                    dtSumm = new DataSummary();

                    countAvgItems = 0;
                    tempTotal = 0;

                    weekBlockEnd -= 3600 * 1000 * 24 * 7;
                    weekBlockStart -= 3600 * 1000 * 24 * 7;
                    dtSumm.startDate = weekBlockEnd;
                    dtSumm.endDate = weekBlockStart;
                }

            }

            //Setting last item
            setDataSumm(tempTotal, countAvgItems, dtSumm, weekSummary);


        }


        return weekSummary;
    }

    private void setDataSumm(float tempTotal, int countAvgItems, DataSummary dtSumm, ArrayList<DataSummary> summList) {
        if (countAvgItems != 0)
            dtSumm.setAvg(tempTotal / (float) countAvgItems);
        else
            dtSumm.setAvg(0f);

        summList.add(dtSumm);
    }

}
