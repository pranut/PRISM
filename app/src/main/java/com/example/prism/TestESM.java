package com.example.prism;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.aware.Aware;
import com.aware.ESM;
import com.aware.Screen;
import com.aware.ui.esms.ESMFactory;
import com.aware.ui.esms.ESM_Checkbox;
import com.aware.ui.esms.ESM_Date;
import com.aware.ui.esms.ESM_DateTime;
import com.aware.ui.esms.ESM_Freetext;
import com.aware.ui.esms.ESM_Likert;
import com.aware.ui.esms.ESM_Number;
import com.aware.ui.esms.ESM_PAM;
import com.aware.ui.esms.ESM_QuickAnswer;
import com.aware.ui.esms.ESM_Radio;
import com.aware.ui.esms.ESM_Scale;
import com.aware.ui.esms.ESM_Web;
import com.aware.utils.Scheduler;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by denzil on 04/03/16.
 */
public class TestESM implements AwareTest {

    BroadcastReceiver batteryInfoReceiverLevel;

    public void test(Context context, int testno) {
//        testESMS(context);
//        trialESMS(context);
//        testFlow(context);
//        testTimeoutQueue(context);
//        testNumeric(context);
//        testDateTime(context);
        //testPAM(context);
//        testOptionsOverflow(context);
//        testNotificationRetries(context);
//        testESMWeb(context);
        //testESMDate(context);
        //sleepESM(context);
        if( testno == 1) {
            painESM(context);
        } else if (testno == 2)
        {
            sleepESM(context);
        } else if(testno == 3) {
            communicationEsm(context);
        }
    }

    private void sleepESM(Context context) {
        try {
            ESMFactory factory = new ESMFactory();

            ESM_Scale rate = new ESM_Scale();
            rate.setTitle("ESM: Sleep");
            rate.setInstructions("How did you sleep?");
            rate.setSubmitButton("OK");

            factory.addESM(rate);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void painChange(Context context) {
        ESMFactory factory = new ESMFactory();
        try {

            ESM_QuickAnswer q0 = new ESM_QuickAnswer();
            q0.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTitle("High change in pain detected. It is advisable to report this to your PT, would you like to report it now?");

            factory.addESM(q0);

            ESM.queueESM(context, factory.build());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void communicationEsm(Context context) {
        ESMFactory factory = new ESMFactory();
        try {

            ESM_Freetext esmFreetext = new ESM_Freetext();
            esmFreetext.setTitle("Everything Alright?")
                    .setTrigger("test")
                    .setReplaceQueue(true)
                    .setSubmitButton("Done")
                    .setInstructions("We detected that you had difficulty sleeping on yesterday.\nIf you want to note the reason, please enter below:");


//            ESM_QuickAnswer q0 = new ESM_QuickAnswer();
//            q0.addQuickAnswer("Yes")
//                    .addQuickAnswer("No")
//                    .setTitle("High change in pain detected. It is advisable to report this to your PT, would you like to report it now?");

            factory.addESM(esmFreetext);

            ESM.queueESM(context, factory.build());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void painESM(Context context) {
        ESMFactory factory = new ESMFactory();
        try {

            ESM_QuickAnswer q0 = new ESM_QuickAnswer();
            q0.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTitle("Is this a good time to answer?");

            factory.addESM(q0);

            ESM.queueESM(context, factory.build());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        batteryInfoReceiverLevel = new BroadcastReceiver() { // init your Receiver

            @Override
            public void onReceive(Context context, Intent intent) {

                String answer = intent.getStringExtra(ESM.EXTRA_ANSWER);
                if (answer.equals("Yes")) {
                    launch(context);
                }
            }
        };
        // register your Receiver after initialization
        context.registerReceiver(batteryInfoReceiverLevel,
                new IntentFilter(ESM.ACTION_AWARE_ESM_ANSWERED));



            /*ESMFactory factory = new ESMFactory();

            ESM_Scale rate = new ESM_Scale();
            rate.setTitle("ESM: Sleep");
            rate.setInstructions("How did you sleep?");
            rate.setSubmitButton("OK");

            factory.addESM(rate);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    private void launch(Context context) {
        if(context != null) {
            Intent myIntent = new Intent(context, DvprsEntry.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //myIntent.putExtra("key", value); //Optional parameters
            context.startActivity(myIntent);
            painChange(context);
        }
    }

    private void testESMDate(Context context) {
        try {
            ESMFactory factory = new ESMFactory();

            ESM_Date date = new ESM_Date();
            date.setTitle("ESM: Date");
            date.setInstructions("On which day did this occur?");
            date.setSubmitButton("OK");
            date.setCalendar(false); //don't use calendar view, use date picker

            factory.addESM(date);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testESMWeb(Context context) {
        try {
            ESMFactory factory = new ESMFactory();

            ESM_Web web = new ESM_Web();
            web.setURL("https://www.google.com");
            web.setTitle("Web survey");
            web.setInstructions("Fill out this survey. Press OK when finished");
            web.setSubmitButton("OK");

            factory.addESM(web);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This tests the notification re-trigger x times after y seconds have elapsed.
     *
     * @param context
     */
    private void testNotificationRetries(Context context) {
        ESMFactory factory = new ESMFactory();
        try {

            ESM_Number number = new ESM_Number();
            number.setNotificationTimeout(5 * 60) //5 minutes
                    .setNotificationRetry(3) //notify the user 3 times, so notification alive for 3 * 5 minutes = 15 minutes
                    .setTitle("Lucky number?")
                    .setInstructions("Pick one.");

            factory.addESM(number);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testOptionsOverflow(Context context) {
        ESMFactory factory = new ESMFactory();
        try {
            ESM_Radio q2 = new ESM_Radio();
            q2.addRadio("1")
                    .addRadio("2")
                    .addRadio("3")
                    .addRadio("4")
                    .addRadio("5")
                    .addRadio("6")
                    .addRadio("7")
                    .addRadio("8")
                    .addRadio("9")
                    .addRadio("10")
                    .addRadio("11")
                    .addRadio("12")
                    .addRadio("13")
                    .addRadio("14")
                    .addRadio("15")
                    .addRadio("16")
                    .addRadio("17")
                    .addRadio("18")
                    .addRadio("19")
                    .setTitle("Too many options!!!")
                    .setSubmitButton("Visible?");

            ESM_Checkbox q3 = new ESM_Checkbox();
            q3.addCheck("1")
                    .addCheck("2")
                    .addCheck("3")
                    .addCheck("4")
                    .addCheck("5")
                    .addCheck("6")
                    .addCheck("7")
                    .addCheck("8")
                    .addCheck("9")
                    .addCheck("10")
                    .addCheck("11")
                    .addCheck("12")
                    .addCheck("13")
                    .addCheck("14")
                    .addCheck("15")
                    .addCheck("16")
                    .addCheck("17")
                    .addCheck("18")
                    .addCheck("19")
                    .setTitle("Too many options!!!")
                    .setSubmitButton("Visible?");

            factory.addESM(q2);
            factory.addESM(q3);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testPAM(Context context) {
        ESMFactory factory = new ESMFactory();

        try {
            ESM_PAM q1 = new ESM_PAM();
            q1.setTitle("PAM")
                    .setInstructions("Pick the closest to how you feel right now.")
                    .setSubmitButton("OK")
                    .setNotificationTimeout(10)
                    .setTrigger("AWARE Test");

            factory.addESM(q1);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testDateTime(Context context) {
        ESMFactory factory = new ESMFactory();

        try {
            ESM_DateTime q1 = new ESM_DateTime();
            q1.setTitle("Date and time")
                    .setInstructions("When did this happen?")
                    .setSubmitButton("OK")
                    .setTrigger("AWARE Test");

            factory.addESM(q1);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testNumeric(Context context) {
        ESMFactory factory = new ESMFactory();

        try {
            ESM_Number q1 = new ESM_Number();
            q1.setTitle("Number")
                    .setInstructions("We only accept a number!")
                    .setSubmitButton("OK")
                    .setTrigger("AWARE Test");

            factory.addESM(q1);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testFlow(Context context) {
        ESMFactory factory = new ESMFactory();

        try {
            ESM_PAM q1 = new ESM_PAM();
            q1.setTitle("Your mood")
                    .setInstructions("Choose the closest to how you feel right now.")
                    .setSubmitButton("Thanks!");

            ESM_Radio q2 = new ESM_Radio();
            q2.addRadio("Eating")
                    .addRadio("Working")
                    .addRadio("Not alone")
                    .setTitle("Why is that?")
                    .setSubmitButton("Thanks!");

            ESM_QuickAnswer q0 = new ESM_QuickAnswer();
            q0.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTitle("Is this a good time to answer?")
                    .addFlow("Yes", q1.build())
                    .addFlow("No", q2.build());

            factory.addESM(q0);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void testESMS(Context context) {
        ESMFactory factory = new ESMFactory();
        try {
            ESM_Freetext esmFreetext = new ESM_Freetext();
            esmFreetext.setTitle("Freetext")
                    .setTrigger("test")
                    .setReplaceQueue(true)
                    .setSubmitButton("OK")
                    .setInstructions("Freetext ESM");

            ESM_Checkbox esmCheckbox = new ESM_Checkbox();
            esmCheckbox.addCheck("Check 1")
                    .addCheck("Check 2")
                    .addCheck("Other")
                    .setTitle("Checkbox")
                    .setTrigger("test")
                    .setSubmitButton("OK")
                    .setInstructions("Checkbox ESM");

            ESM_Likert esmLikert = new ESM_Likert();
            esmLikert.setLikertMax(7)
                    .setLikertMaxLabel("Great")
                    .setLikertMinLabel("Poor")
                    .setLikertStep(1)
                    .setTitle("Likert 3")
                    .setInstructions("Likert ESM")
                    .setTrigger("test")
                    .setSubmitButton("OK");

            ESM_QuickAnswer esmQuickAnswer = new ESM_QuickAnswer();
            esmQuickAnswer.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTrigger("test")
                    .setInstructions("Quick Answers ESM");

            ESM_Radio esmRadio = new ESM_Radio();
            esmRadio.addRadio("Radio 1")
                    .addRadio("Radio 2")
                    .setTitle("Radios")
                    .setInstructions("Radios ESM")
                    .setSubmitButton("OK");

            ESM_Scale esmScale = new ESM_Scale();
            esmScale.setScaleMax(100)
                    .setScaleMin(0)
                    .setScaleStart(50)
                    .setScaleMaxLabel("Perfect")
                    .setScaleMinLabel("Poor")
                    .setScaleStep(10)
                    .setTitle("Scale")
                    .setInstructions("Scale ESM")
                    .setSubmitButton("OK");

            ESM_DateTime esmDate = new ESM_DateTime();
            esmDate.setTitle("Date and Time")
                    .setTrigger("AWARE Test")
                    .setInstructions("Specify date and time")
                    .setSubmitButton("OK");

            ESM_PAM esmPAM = new ESM_PAM();
            esmPAM.setTitle("PAM")
                    .setInstructions("Pick the closest to how you feel right now.")
                    .setSubmitButton("OK")
                    .setTrigger("AWARE Test")
                    .setAppIntegration("fourtwentystudy://");

            factory.addESM(esmFreetext);
            factory.addESM(esmCheckbox);
            factory.addESM(esmLikert);
            factory.addESM(esmQuickAnswer);
            factory.addESM(esmRadio);
            factory.addESM(esmScale);
            factory.addESM(esmPAM);
            factory.addESM(esmDate);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void trialESMS(Context context) {
        ESMFactory factory = new ESMFactory();
        try {
            ESM_Freetext esmFreetext = new ESM_Freetext();
            esmFreetext.setTitle("Freetext")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK")
                    .setInstructions("Freetext ESM");

            ESM_Checkbox esmCheckbox = new ESM_Checkbox();
            esmCheckbox.addCheck("Check 1")
                    .addCheck("Check 2")
                    .addCheck("Other")
                    .setTitle("Checkbox")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK")
                    .setInstructions("Checkbox ESM");

            ESM_Likert esmLikert = new ESM_Likert();
            esmLikert.setLikertMax(5)
                    .setLikertMaxLabel("Great")
                    .setLikertMinLabel("Poor")
                    .setLikertStep(1)
                    .setTitle("Likert")
                    .setInstructions("Likert ESM")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK");

            ESM_QuickAnswer esmQuickAnswer = new ESM_QuickAnswer();
            esmQuickAnswer.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK")
                    .setInstructions("Quick Answers ESM");

            ESM_Radio esmRadio = new ESM_Radio();
            esmRadio.addRadio("Radio 1")
                    .addRadio("Radio 2")
                    .setTitle("Radios")
                    .setInstructions("Radios ESM")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK");

            ESM_Scale esmScale = new ESM_Scale();
            esmScale.setScaleMax(100)
                    .setScaleMin(0)
                    .setScaleStart(50)
                    .setScaleMaxLabel("Perfect")
                    .setScaleMinLabel("Poor")
                    .setScaleStep(10)
                    .setTitle("Scale")
                    .setInstructions("Scale ESM")
                    .setExpirationThreshold(0)
                    .setSubmitButton("OK");

            factory.addESM(esmFreetext);
            factory.addESM(esmCheckbox);
            factory.addESM(esmLikert);
            factory.addESM(esmQuickAnswer);
            factory.addESM(esmRadio);
            factory.addESM(esmScale);

            ESM.queueESM(context, factory.build(), true);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testTimeoutQueue(Context context) {
        ESMFactory factory = new ESMFactory();
        try {
            ESM_Freetext esmFreetext = new ESM_Freetext();
            esmFreetext.setTitle("Freetext")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setSubmitButton("OK")
                    .setInstructions("Freetext ESM");

            ESM_Checkbox esmCheckbox = new ESM_Checkbox();
            esmCheckbox.addCheck("Check 1")
                    .addCheck("Check 2")
                    .addCheck("Other")
                    .setTitle("Checkbox")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setSubmitButton("OK")
                    .setInstructions("Checkbox ESM");

            ESM_Likert esmLikert = new ESM_Likert();
            esmLikert.setLikertMax(5)
                    .setLikertMaxLabel("Great")
                    .setLikertMinLabel("Poor")
                    .setLikertStep(1)
                    .setTitle("Likert")
                    .setInstructions("Likert ESM")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setSubmitButton("OK");

            ESM_QuickAnswer esmQuickAnswer = new ESM_QuickAnswer();
            esmQuickAnswer.addQuickAnswer("Yes")
                    .addQuickAnswer("No")
                    .setTrigger("test")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setInstructions("Quick Answers ESM");

            ESM_Radio esmRadio = new ESM_Radio();
            esmRadio.addRadio("Radio 1")
                    .addRadio("Radio 2")
                    .setTitle("Radios")
                    .setInstructions("Radios ESM")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setSubmitButton("OK");

            ESM_Scale esmScale = new ESM_Scale();
            esmScale.setScaleMax(100)
                    .setScaleMin(0)
                    .setScaleStart(50)
                    .setScaleMaxLabel("Perfect")
                    .setScaleMinLabel("Poor")
                    .setScaleStep(10)
                    .setTitle("Scale")
                    .setInstructions("Scale ESM")
                    .setExpirationThreshold(0)
                    .setNotificationTimeout(10)
                    .setSubmitButton("OK");

            factory.addESM(esmFreetext);
            factory.addESM(esmCheckbox);
            factory.addESM(esmLikert);
            factory.addESM(esmQuickAnswer);
            factory.addESM(esmRadio);
            factory.addESM(esmScale);

            ESM.queueESM(context, factory.build());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void test(Context context) {

    }
}
