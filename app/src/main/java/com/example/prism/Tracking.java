package com.example.prism;

import android.content.ContentValues;
import android.content.Context;

import com.aware.Accelerometer;
import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.ESM;
import com.aware.Screen;
import com.aware.providers.Accelerometer_Provider;
import com.aware.ui.esms.ESMFactory;
import com.aware.ui.esms.ESM_PAM;
import com.aware.utils.Scheduler;

import org.json.JSONException;


public class Tracking {

    public Tracking(Context c) {
        Aware.startAWARE(c);
        Aware.setSetting(c, Aware_Preferences.FREQUENCY_ACCELEROMETER, 200000); //20Hz
        Aware.setSetting(c, Aware_Preferences.THRESHOLD_ACCELEROMETER, 0.02f); // [x,y,z] > 0.02 to log

        Aware.startAccelerometer(c);

        Accelerometer.setSensorObserver(new Accelerometer.AWARESensorObserver() {
            @Override
            public void onAccelerometerChanged(ContentValues contentValues) {
                gotValues(contentValues);
            }
        });


        try{
            String esm_goodmorning = "[{'esm': {" +
                    "'esm_type': "+ ESM.TYPE_ESM_QUICK_ANSWERS+"," +
                    "'esm_title': 'Sleep quality'," +
                    "'esm_instructions': 'Slept well?'," +
                    "'esm_quick_answers': ['Yes','No']," +
                    "'esm_expiration_threshold': 0," +
                    "'esm_trigger': 'goodmorning_check'" +
                    "}}]";

            Scheduler.Schedule schedule = new Scheduler.Schedule("PRISM");
            schedule.addMinute(5)
                    .addHour(3)//0-23
                    .addContext(Screen.ACTION_AWARE_SCREEN_ON)
                    .setActionType(Scheduler.ACTION_TYPE_BROADCAST)
                    .setActionIntentAction(ESM.ACTION_AWARE_QUEUE_ESM)
                    .addActionExtra(ESM.EXTRA_ESM, esm_goodmorning);

            Scheduler.saveSchedule(c, schedule);

            Aware.startScheduler(c);

            //to remove
            //Scheduler.removeSchedule(getApplicationContext(), "schedule_id");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //testESMTrigger(c);
        Aware.startScheduler(c);

    }

    /*private void testESMTrigger(Context c) {
        try {

            ESM_PAM esmPAM = new ESM_PAM();
            esmPAM.setTitle("PAM")
                    .setInstructions("Pick the closest to how you feel right now.")
                    .setSubmitButton("OK")
                    .setNotificationTimeout(10)
                    .setTrigger("AWARE Test");

            ESMFactory factory = new ESMFactory();
            factory.addESM(esmPAM);

            Scheduler.Schedule contextual = new Scheduler.Schedule("test_contextual");
            contextual.addContext(Screen.ACTION_AWARE_SCREEN_ON);
            contextual.addMinute(5);
            contextual.setActionType(Scheduler.ACTION_TYPE_BROADCAST);
            contextual.setActionIntentAction(ESM.ACTION_AWARE_QUEUE_ESM);
            contextual.addActionExtra(ESM.EXTRA_ESM, factory.build());

            Scheduler.saveSchedule(c, contextual);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/

    public void gotValues(ContentValues contentValues){
        String x = String.valueOf(contentValues.get(Accelerometer_Provider.Accelerometer_Data.VALUES_0));
        String y = String.valueOf(contentValues.get(Accelerometer_Provider.Accelerometer_Data.VALUES_1));
        String z = String.valueOf(contentValues.get(Accelerometer_Provider.Accelerometer_Data.VALUES_2));
        System.out.println(x+" "+y+" "+z);
    }

}
