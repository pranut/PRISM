package com.example.prism.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeekDataSummary {

    public ArrayList<DataSummary> weekDataPoints;

    public DayDataSummary daySumm;

    public WeekDataSummary(){

    }

    public ArrayList<DataSummary> getDaysWithinWeek(int weekIndex){

        //TODO this code can be simplified
        ArrayList<DataSummary> daySummary = daySumm.daySummary;

        ArrayList<DataSummary> daysWithinWeek = new ArrayList<>();

        int dayIndexEnd;
        if(weekIndex == 0)
            dayIndexEnd = 7;
        else
            dayIndexEnd = (weekIndex+1) * 7;

        int dayIndexStart = dayIndexEnd - 7;

        int index = dayIndexStart;

        while (index < daySummary.size() && index < dayIndexEnd){
            daysWithinWeek.add(daySummary.get(index));
            index++;
        }

        return daysWithinWeek;

    }

    public ArrayList<DataSummary> createWeekSummary(ArrayList<TimeEvent> rawData) {

        if (weekDataPoints != null) {
            return weekDataPoints;

        } else {
            weekDataPoints = new ArrayList<>();
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

                    setDataSumm(tempTotal, countAvgItems, dtSumm, weekDataPoints);

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
            setDataSumm(tempTotal, countAvgItems, dtSumm, weekDataPoints);


        }


        return weekDataPoints;
    }

    private void setDataSumm(float tempTotal, int countAvgItems, DataSummary dtSumm, ArrayList<DataSummary> summList) {
        if (countAvgItems != 0)
            dtSumm.setAvg(tempTotal / (float) countAvgItems);
        else
            dtSumm.setAvg(0f);

        summList.add(dtSumm);
    }

}
