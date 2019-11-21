package com.example.prism;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.common.api.GoogleApiClient;

public class DvprsEntry extends AppCompatActivity {

    private static final String LOG_TAG = "Log: ";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private int count = 0;
    private long startMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();

        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(intent.getAction())) {
                Log.w(LOG_TAG, "Main Activity is not the root.  Finishing Main Activity instead of launching.");
                finish();
                return;
            }
        }

        dvprsFirstScreen();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    Integer currentScreen = -99, dvprs = -99, Activity = -99, Sleep = -99, Mood = -99, Stress = -99, qa1 = -99, qa2 = -99, qa3 = -99,
            dvprsLanguageId = 11, dvprsImageId = 12, dvprsGroupId = 13, submitButtonId = 14, dvprsRadio0Id = 0, dvprsRadio1Id = 1,
            dvprsRadio2Id = 2, dvprsRadio3Id = 3, dvprsRadio4Id = 4, dvprsRadio5Id = 5, dvprsRadio6Id = 6, dvprsRadio7Id = 7,
            dvprsRadio8Id = 8, dvprsRadio9Id = 9, dvprsRadio10Id = 10;

    DBHandler DBHandler;

    private void dvprsFirstScreen() {
        currentScreen = 0;

        final RelativeLayout dvprsFirstLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsImageLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Widgets to be displayed
        TouchImageView dvprsImage = new TouchImageView(this);
        TextView dvprsLanguage = new TextView(this);
        final RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        final RadioButton dvprsRadio0 = new RadioButton(this);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);



        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);
        RadioButton dvprsRadio5 = new RadioButton(this);
        RadioButton dvprsRadio6 = new RadioButton(this);
        RadioButton dvprsRadio7 = new RadioButton(this);
        RadioButton dvprsRadio8 = new RadioButton(this);
        RadioButton dvprsRadio9 = new RadioButton(this);
        RadioButton dvprsRadio10 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsImageLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsImageLayout.addRule(RelativeLayout.BELOW, dvprsLanguageId);
        dvprsGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsSubmitLayout.addRule(RelativeLayout.CENTER_VERTICAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_END);
        Uri imgUri = Uri.parse("android.resource://com.example.prism/" + R.drawable.scale_dvprs);
        dvprsImage.setImageURI(null);
        dvprsImage.setImageURI(imgUri);
        dvprsLanguage.setText(R.string.dvprsIntroText);
        dvprsRadio0.setButtonDrawable(R.drawable.dvprs0_shading);
        dvprsRadio1.setButtonDrawable(R.drawable.dvprs1_shading);
        dvprsRadio2.setButtonDrawable(R.drawable.dvprs2_shading);
        dvprsRadio3.setButtonDrawable(R.drawable.dvprs3_shading);
        dvprsRadio4.setButtonDrawable(R.drawable.dvprs4_shading);
        dvprsRadio5.setButtonDrawable(R.drawable.dvprs5_shading);
        dvprsRadio6.setButtonDrawable(R.drawable.dvprs6_shading);
        dvprsRadio7.setButtonDrawable(R.drawable.dvprs7_shading);
        dvprsRadio8.setButtonDrawable(R.drawable.dvprs8_shading);
        dvprsRadio9.setButtonDrawable(R.drawable.dvprs9_shading);
        dvprsRadio10.setButtonDrawable(R.drawable.dvprs10_shading);

//        dvprsRadio0.setText(R.string._0);
//        dvprsRadio1.setText(R.string._1);
//        dvprsRadio2.setText(R.string._2);
//        dvprsRadio3.setText(R.string._3);
//        dvprsRadio4.setText(R.string._4);
//        dvprsRadio5.setText(R.string._5);
//        dvprsRadio6.setText(R.string._6);
//        dvprsRadio7.setText(R.string._7);
//        dvprsRadio8.setText(R.string._8);
//        dvprsRadio9.setText(R.string._9);
//        dvprsRadio10.setText(R.string._10);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio10.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio0.setPadding(0, 100, 0, 0);
        dvprsRadio1.setPadding(0, 100, 0, 0);
        dvprsRadio2.setPadding(0, 100, 0, 0);
        dvprsRadio3.setPadding(0, 100, 0, 0);
        dvprsRadio4.setPadding(0, 100, 0, 0);
        dvprsRadio5.setPadding(0, 100, 0, 0);
        dvprsRadio6.setPadding(0, 100, 0, 0);
        dvprsRadio7.setPadding(0, 100, 0, 0);
        dvprsRadio8.setPadding(0, 100, 0, 0);
        dvprsRadio9.setPadding(0, 100, 0, 0);
        dvprsRadio10.setPadding(0, 100, 0, 0);
        submitButton.setPadding(5, 5, 5, 5);
        dvprsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dvprsImageLayout.setMargins(0, 10, 0, 80);
        dvprsGroup.setLayoutParams(dvprsGroupLayout);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        dvprsGroup.setPadding(0, 0, 0, 15);

        //Widget IDs
        dvprsLanguage.setId(dvprsLanguageId);
        dvprsImage.setId(dvprsImageId);
        dvprsGroup.setId(dvprsGroupId);
        submitButton.setId(submitButtonId);
        dvprsRadio0.setId(dvprsRadio0Id);
        dvprsRadio1.setId(dvprsRadio1Id);
        dvprsRadio2.setId(dvprsRadio2Id);
        dvprsRadio3.setId(dvprsRadio3Id);
        dvprsRadio4.setId(dvprsRadio4Id);
        dvprsRadio5.setId(dvprsRadio5Id);
        dvprsRadio6.setId(dvprsRadio6Id);
        dvprsRadio7.setId(dvprsRadio7Id);
        dvprsRadio8.setId(dvprsRadio8Id);
        dvprsRadio9.setId(dvprsRadio9Id);
        dvprsRadio10.setId(dvprsRadio10Id);


        //Add Widgets and Params to layout
        dvprsFirstLayout.addView(dvprsLanguage, dvprsTextLayout);
        dvprsFirstLayout.addView(dvprsImage, dvprsImageLayout);
        dvprsFirstLayout.addView(dvprsGroup, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio5, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio6, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio7, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio8, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio9, dvprsGroupLayout);
        dvprsGroup.addView(dvprsRadio10, dvprsGroupLayout);

        //Start the layout
        setContentView(dvprsFirstLayout);

        //Listeners for First View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_END);
                    dvprsSubmitLayout.addRule(RelativeLayout.CENTER_VERTICAL);
                    dvprsFirstLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsFirstLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Log.d("Checked", " : " + selectedDvprs);
                        dvprs = selectedDvprs;
                        // Perform action on click
                        if (selectedDvprs == 0) {
                            ((ViewGroup) dvprsFirstLayout.getParent()).removeView(dvprsFirstLayout);
                            //dvprsQA1Question();
                        } else {
                            ((ViewGroup) dvprsFirstLayout.getParent()).removeView(dvprsFirstLayout);
                            dvprsActivityScreen();
                        }
                    }
                });
            }
        });
    }

    private void dvprsActivityScreen() {
        currentScreen = 1;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupImageLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TouchImageView dvprsImage = new TouchImageView(this);
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);
        RadioButton dvprsRadio5 = new RadioButton(this);
        RadioButton dvprsRadio6 = new RadioButton(this);
        RadioButton dvprsRadio7 = new RadioButton(this);
        RadioButton dvprsRadio8 = new RadioButton(this);
        RadioButton dvprsRadio9 = new RadioButton(this);
        RadioButton dvprsRadio10 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.BELOW, dvprsLanguageId);
        dvprsSupImageLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsSupImageLayout.setMargins(0, 140, 0, 80);
        Uri imgUri = Uri.parse("android.resource://com.example.prism/" + R.drawable.activity);
        dvprsImage.setImageURI(null);
        dvprsImage.setImageURI(imgUri);
        dvprsLanguage.setText(R.string.dvprsActivityText);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsImage.getId());
//        dvprsRadio0.setText(R.string._0);
//        dvprsRadio1.setText(R.string._1);
//        dvprsRadio2.setText(R.string._2);
//        dvprsRadio3.setText(R.string._3);
//        dvprsRadio4.setText(R.string._4);
//        dvprsRadio5.setText(R.string._5);
//        dvprsRadio6.setText(R.string._6);
//        dvprsRadio7.setText(R.string._7);
//        dvprsRadio8.setText(R.string._8);
//        dvprsRadio9.setText(R.string._9);
//        dvprsRadio10.setText(R.string._10);
        dvprsRadio0.setButtonDrawable(R.drawable.dvprs0_shading);
        dvprsRadio1.setButtonDrawable(R.drawable.dvprs1_shading);
        dvprsRadio2.setButtonDrawable(R.drawable.dvprs2_shading);
        dvprsRadio3.setButtonDrawable(R.drawable.dvprs3_shading);
        dvprsRadio4.setButtonDrawable(R.drawable.dvprs4_shading);
        dvprsRadio5.setButtonDrawable(R.drawable.dvprs5_shading);
        dvprsRadio6.setButtonDrawable(R.drawable.dvprs6_shading);
        dvprsRadio7.setButtonDrawable(R.drawable.dvprs7_shading);
        dvprsRadio8.setButtonDrawable(R.drawable.dvprs8_shading);
        dvprsRadio9.setButtonDrawable(R.drawable.dvprs9_shading);
        dvprsRadio10.setButtonDrawable(R.drawable.dvprs10_shading);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio10.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio0.setPadding(0, 100, 0, 0);
        dvprsRadio1.setPadding(0, 100, 0, 0);
        dvprsRadio2.setPadding(0, 100, 0, 0);
        dvprsRadio3.setPadding(0, 100, 0, 0);
        dvprsRadio4.setPadding(0, 100, 0, 0);
        dvprsRadio5.setPadding(0, 100, 0, 0);
        dvprsRadio6.setPadding(0, 100, 0, 0);
        dvprsRadio7.setPadding(0, 100, 0, 0);
        dvprsRadio8.setPadding(0, 100, 0, 0);
        dvprsRadio9.setPadding(0, 100, 0, 0);
        dvprsRadio10.setPadding(0, 100, 0, 0);
        dvprsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dvprsSupTextLayout.setMargins(100, 20, 100, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        dvprsGroup.setPadding(0, 0, 0, 15);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsImage.setId(12);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);
        dvprsRadio5.setId(5);
        dvprsRadio6.setId(6);
        dvprsRadio7.setId(7);
        dvprsRadio8.setId(8);
        dvprsRadio9.setId(9);
        dvprsRadio10.setId(10);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsSecondLayout.addView(dvprsImage, dvprsSupImageLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio5, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio6, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio7, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio8, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio9, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio10, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);

        //Listeners for First View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Activity = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        dvprsSleepScreen();
                    }
                });
            }
        });
    }


    private void dvprsSleepScreen() {
        currentScreen = 2;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupImageLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TouchImageView dvprsImage = new TouchImageView(this);
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);
        RadioButton dvprsRadio5 = new RadioButton(this);
        RadioButton dvprsRadio6 = new RadioButton(this);
        RadioButton dvprsRadio7 = new RadioButton(this);
        RadioButton dvprsRadio8 = new RadioButton(this);
        RadioButton dvprsRadio9 = new RadioButton(this);
        RadioButton dvprsRadio10 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.BELOW, dvprsLanguageId);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsSupImageLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSupImageLayout.setMargins(0, 140, 0, 80);
        Uri imgUri = Uri.parse("android.resource://com.example.prism/" + R.drawable.sleep);
        dvprsImage.setImageURI(null);
        dvprsImage.setImageURI(imgUri);
        dvprsLanguage.setText(R.string.dvprsSleepText);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsImage.getId());
//        dvprsRadio0.setText(R.string._0);
//        dvprsRadio1.setText(R.string._1);
//        dvprsRadio2.setText(R.string._2);
//        dvprsRadio3.setText(R.string._3);
//        dvprsRadio4.setText(R.string._4);
//        dvprsRadio5.setText(R.string._5);
//        dvprsRadio6.setText(R.string._6);
//        dvprsRadio7.setText(R.string._7);
//        dvprsRadio8.setText(R.string._8);
//        dvprsRadio9.setText(R.string._9);
//        dvprsRadio10.setText(R.string._10);
        dvprsRadio0.setButtonDrawable(R.drawable.dvprs0_shading);
        dvprsRadio1.setButtonDrawable(R.drawable.dvprs1_shading);
        dvprsRadio2.setButtonDrawable(R.drawable.dvprs2_shading);
        dvprsRadio3.setButtonDrawable(R.drawable.dvprs3_shading);
        dvprsRadio4.setButtonDrawable(R.drawable.dvprs4_shading);
        dvprsRadio5.setButtonDrawable(R.drawable.dvprs5_shading);
        dvprsRadio6.setButtonDrawable(R.drawable.dvprs6_shading);
        dvprsRadio7.setButtonDrawable(R.drawable.dvprs7_shading);
        dvprsRadio8.setButtonDrawable(R.drawable.dvprs8_shading);
        dvprsRadio9.setButtonDrawable(R.drawable.dvprs9_shading);
        dvprsRadio10.setButtonDrawable(R.drawable.dvprs10_shading);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio10.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio0.setPadding(0, 100, 0, 0);
        dvprsRadio1.setPadding(0, 100, 0, 0);
        dvprsRadio2.setPadding(0, 100, 0, 0);
        dvprsRadio3.setPadding(0, 100, 0, 0);
        dvprsRadio4.setPadding(0, 100, 0, 0);
        dvprsRadio5.setPadding(0, 100, 0, 0);
        dvprsRadio6.setPadding(0, 100, 0, 0);
        dvprsRadio7.setPadding(0, 100, 0, 0);
        dvprsRadio8.setPadding(0, 100, 0, 0);
        dvprsRadio9.setPadding(0, 100, 0, 0);
        dvprsRadio10.setPadding(0, 100, 0, 0);
        dvprsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dvprsSupTextLayout.setMargins(100, 20, 100, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        dvprsGroup.setPadding(0, 0, 0, 15);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsImage.setId(12);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);
        dvprsRadio5.setId(5);
        dvprsRadio6.setId(6);
        dvprsRadio7.setId(7);
        dvprsRadio8.setId(8);
        dvprsRadio9.setId(9);
        dvprsRadio10.setId(10);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsSecondLayout.addView(dvprsImage, dvprsSupImageLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio5, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio6, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio7, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio8, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio9, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio10, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);

        //Listeners for View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Sleep = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        dvprsMoodScreen();
                    }
                });
            }
        });
    }

    private void dvprsMoodScreen() {
        currentScreen = 3;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupImageLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TouchImageView dvprsImage = new TouchImageView(this);
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);
        RadioButton dvprsRadio5 = new RadioButton(this);
        RadioButton dvprsRadio6 = new RadioButton(this);
        RadioButton dvprsRadio7 = new RadioButton(this);
        RadioButton dvprsRadio8 = new RadioButton(this);
        RadioButton dvprsRadio9 = new RadioButton(this);
        RadioButton dvprsRadio10 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.BELOW, dvprsLanguageId);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsSupImageLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSupImageLayout.setMargins(0, 140, 0, 80);
        Uri imgUri = Uri.parse("android.resource://com.example.prism/" + R.drawable.mood);
        dvprsImage.setImageURI(null);
        dvprsImage.setImageURI(imgUri);
        dvprsLanguage.setText(R.string.dvprsMoodText);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsImage.getId());
//        dvprsRadio0.setText(R.string._0);
//        dvprsRadio1.setText(R.string._1);
//        dvprsRadio2.setText(R.string._2);
//        dvprsRadio3.setText(R.string._3);
//        dvprsRadio4.setText(R.string._4);
//        dvprsRadio5.setText(R.string._5);
//        dvprsRadio6.setText(R.string._6);
//        dvprsRadio7.setText(R.string._7);
//        dvprsRadio8.setText(R.string._8);
//        dvprsRadio9.setText(R.string._9);
//        dvprsRadio10.setText(R.string._10);
        dvprsRadio0.setButtonDrawable(R.drawable.dvprs0_shading);
        dvprsRadio1.setButtonDrawable(R.drawable.dvprs1_shading);
        dvprsRadio2.setButtonDrawable(R.drawable.dvprs2_shading);
        dvprsRadio3.setButtonDrawable(R.drawable.dvprs3_shading);
        dvprsRadio4.setButtonDrawable(R.drawable.dvprs4_shading);
        dvprsRadio5.setButtonDrawable(R.drawable.dvprs5_shading);
        dvprsRadio6.setButtonDrawable(R.drawable.dvprs6_shading);
        dvprsRadio7.setButtonDrawable(R.drawable.dvprs7_shading);
        dvprsRadio8.setButtonDrawable(R.drawable.dvprs8_shading);
        dvprsRadio9.setButtonDrawable(R.drawable.dvprs9_shading);
        dvprsRadio10.setButtonDrawable(R.drawable.dvprs10_shading);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio10.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio0.setPadding(0, 100, 0, 0);
        dvprsRadio1.setPadding(0, 100, 0, 0);
        dvprsRadio2.setPadding(0, 100, 0, 0);
        dvprsRadio3.setPadding(0, 100, 0, 0);
        dvprsRadio4.setPadding(0, 100, 0, 0);
        dvprsRadio5.setPadding(0, 100, 0, 0);
        dvprsRadio6.setPadding(0, 100, 0, 0);
        dvprsRadio7.setPadding(0, 100, 0, 0);
        dvprsRadio8.setPadding(0, 100, 0, 0);
        dvprsRadio9.setPadding(0, 100, 0, 0);
        dvprsRadio10.setPadding(0, 100, 0, 0);
        dvprsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dvprsSupTextLayout.setMargins(100, 20, 100, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        dvprsGroup.setPadding(0, 0, 0, 15);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsImage.setId(12);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);
        dvprsRadio5.setId(5);
        dvprsRadio6.setId(6);
        dvprsRadio7.setId(7);
        dvprsRadio8.setId(8);
        dvprsRadio9.setId(9);
        dvprsRadio10.setId(10);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsSecondLayout.addView(dvprsImage, dvprsSupImageLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio5, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio6, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio7, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio8, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio9, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio10, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);

        //Listeners for View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Mood = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        dvprsStressScreen();
                    }
                });
            }
        });
    }

    private void dvprsStressScreen() {
        currentScreen = 4;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupImageLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TouchImageView dvprsImage = new TouchImageView(this);
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);
        RadioButton dvprsRadio5 = new RadioButton(this);
        RadioButton dvprsRadio6 = new RadioButton(this);
        RadioButton dvprsRadio7 = new RadioButton(this);
        RadioButton dvprsRadio8 = new RadioButton(this);
        RadioButton dvprsRadio9 = new RadioButton(this);
        RadioButton dvprsRadio10 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupImageLayout.addRule(RelativeLayout.BELOW, dvprsLanguageId);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsSupImageLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSupImageLayout.setMargins(0, 140, 0, 80);
        Uri imgUri = Uri.parse("android.resource://com.example.prism/" + R.drawable.stress);
        dvprsImage.setImageURI(null);
        dvprsImage.setImageURI(imgUri);
        dvprsLanguage.setText(R.string.dvprsStressText);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsImage.getId());
//        dvprsRadio0.setText(R.string._0);
//        dvprsRadio1.setText(R.string._1);
//        dvprsRadio2.setText(R.string._2);
//        dvprsRadio3.setText(R.string._3);
//        dvprsRadio4.setText(R.string._4);
//        dvprsRadio5.setText(R.string._5);
//        dvprsRadio6.setText(R.string._6);
//        dvprsRadio7.setText(R.string._7);
//        dvprsRadio8.setText(R.string._8);
//        dvprsRadio9.setText(R.string._9);
//        dvprsRadio10.setText(R.string._10);
        dvprsRadio0.setButtonDrawable(R.drawable.dvprs0_shading);
        dvprsRadio1.setButtonDrawable(R.drawable.dvprs1_shading);
        dvprsRadio2.setButtonDrawable(R.drawable.dvprs2_shading);
        dvprsRadio3.setButtonDrawable(R.drawable.dvprs3_shading);
        dvprsRadio4.setButtonDrawable(R.drawable.dvprs4_shading);
        dvprsRadio5.setButtonDrawable(R.drawable.dvprs5_shading);
        dvprsRadio6.setButtonDrawable(R.drawable.dvprs6_shading);
        dvprsRadio7.setButtonDrawable(R.drawable.dvprs7_shading);
        dvprsRadio8.setButtonDrawable(R.drawable.dvprs8_shading);
        dvprsRadio9.setButtonDrawable(R.drawable.dvprs9_shading);
        dvprsRadio10.setButtonDrawable(R.drawable.dvprs10_shading);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio6.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio7.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio8.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio9.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio10.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        dvprsRadio0.setPadding(0, 100, 0, 0);
        dvprsRadio1.setPadding(0, 100, 0, 0);
        dvprsRadio2.setPadding(0, 100, 0, 0);
        dvprsRadio3.setPadding(0, 100, 0, 0);
        dvprsRadio4.setPadding(0, 100, 0, 0);
        dvprsRadio5.setPadding(0, 100, 0, 0);
        dvprsRadio6.setPadding(0, 100, 0, 0);
        dvprsRadio7.setPadding(0, 100, 0, 0);
        dvprsRadio8.setPadding(0, 100, 0, 0);
        dvprsRadio9.setPadding(0, 100, 0, 0);
        dvprsRadio10.setPadding(0, 100, 0, 0);
        dvprsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dvprsSupTextLayout.setMargins(100, 20, 100, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        dvprsGroup.setPadding(0, 0, 0, 15);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsImage.setId(12);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);
        dvprsRadio5.setId(5);
        dvprsRadio6.setId(6);
        dvprsRadio7.setId(7);
        dvprsRadio8.setId(8);
        dvprsRadio9.setId(9);
        dvprsRadio10.setId(10);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsSecondLayout.addView(dvprsImage, dvprsSupImageLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio5, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio6, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio7, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio8, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio9, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio10, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);

        //Listeners for View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                /*submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Stress = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        //dvprsQA1Question();
                    }
                });*/

                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Stress = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        addScores();
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        dvprsEND();
                    }
                });
            }
        });
    }

    private void dvprsQA1Question() {
        currentScreen = 5;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsLanguage.setText(R.string.dvprsQA1Text);
        dvprsRadio0.setText(R.string.dvprsAns1);
        dvprsRadio1.setText(R.string.dvprsAns2);
        dvprsRadio2.setText(R.string.dvprsAns3);
        dvprsRadio3.setText(R.string.dvprsAns4);
        dvprsRadio4.setText(R.string.dvprsAns5);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsGroup.setPadding(0, 20, 0, 300);
        dvprsSupTextLayout.setMargins(100, 100, 0, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsSubmitLayout.setMargins(20, 0, 0, 300);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);


        //Listeners for First View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        qa1 = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        //dvprsQA2Question();
                    }
                });
            }
        });
    }

    private void dvprsQA2Question() {
        currentScreen = 6;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsLanguage.setText(R.string.dvprsQA2Text);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsLanguage.getId());
        dvprsRadio0.setText(R.string.dvprsAns1);
        dvprsRadio1.setText(R.string.dvprsAns2);
        dvprsRadio2.setText(R.string.dvprsAns3);
        dvprsRadio3.setText(R.string.dvprsAns4);
        dvprsRadio4.setText(R.string.dvprsAns5);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsGroup.setPadding(0, 20, 0, 300);
        dvprsSupTextLayout.setMargins(100, 100, 0, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsSubmitLayout.setMargins(20, 0, 0, 300);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);

        //Listeners for View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        qa2 = selectedDvprs;
                        Log.d("Checked", " : " + selectedDvprs);
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        //dvprsQA3Question();
                    }
                });
            }
        });
    }

    private void dvprsQA3Question() {
        currentScreen = 7;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsSupGroupLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final RelativeLayout.LayoutParams dvprsSubmitLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        //Widgets to be displayed
        TextView dvprsLanguage = new TextView(this);
        RadioGroup dvprsGroup = new RadioGroup(this);
        final Button submitButton = new Button(this);
        RadioButton dvprsRadio0 = new RadioButton(this);
        RadioButton dvprsRadio1 = new RadioButton(this);
        RadioButton dvprsRadio2 = new RadioButton(this);
        RadioButton dvprsRadio3 = new RadioButton(this);
        RadioButton dvprsRadio4 = new RadioButton(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        dvprsSupGroupLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSupGroupLayout.addRule(RelativeLayout.CENTER_HORIZONTAL);
        dvprsSubmitLayout.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dvprsSubmitLayout.addRule(RelativeLayout.RIGHT_OF, dvprsGroupId);
        dvprsLanguage.setText(R.string.dvprsQA3Text);
        dvprsSupGroupLayout.addRule(RelativeLayout.BELOW, dvprsLanguage.getId());
        dvprsRadio0.setText(R.string.dvprsAns1);
        dvprsRadio1.setText(R.string.dvprsAns2);
        dvprsRadio2.setText(R.string.dvprsAns3);
        dvprsRadio3.setText(R.string.dvprsAns4);
        dvprsRadio4.setText(R.string.dvprsAns5);
        dvprsRadio0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsRadio4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        dvprsGroup.setPadding(0, 20, 0, 300);
        dvprsSupTextLayout.setMargins(100, 100, 100, 0);
        submitButton.setText("Submit");
        submitButton.setHeight(150);
        submitButton.setWidth(150);
        dvprsSubmitLayout.setMargins(20, 0, 0, 300);
        dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        //Widget IDs
        dvprsLanguage.setId(11);
        dvprsGroup.setId(13);
        submitButton.setId(14);
        dvprsRadio0.setId(0);
        dvprsRadio1.setId(1);
        dvprsRadio2.setId(2);
        dvprsRadio3.setId(3);
        dvprsRadio4.setId(4);


        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsGroup.addView(dvprsRadio0, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio1, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio2, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio3, dvprsSupGroupLayout);
        dvprsGroup.addView(dvprsRadio4, dvprsSupGroupLayout);
        dvprsSecondLayout.addView(dvprsGroup, dvprsSupGroupLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);


        //Listeners for First View
        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup dvprsGroup, int checkedId) {
                if (findViewById(14) == null) {
                    dvprsSecondLayout.addView(submitButton, dvprsSubmitLayout);
                    setContentView(dvprsSecondLayout);
                }
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedDvprs = dvprsGroup.getCheckedRadioButtonId();
                        Log.d("Checked", " : " + selectedDvprs);
                        qa3 = selectedDvprs;
                        addScores();
                        // Perform action on click
                        ((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                        dvprsEND();
                    }
                });
            }
        });
    }

    private void dvprsEND() {
        currentScreen = 8;
        final RelativeLayout dvprsSecondLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams dvprsSupTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams dvprsScoreTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Widgets to be displayed
        TextView dvprsLanguage = new TextView(this);
        TextView dvprsScore = new TextView(this);

        //Rules & Params for various Widgets
        dvprsSupTextLayout.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
        dvprsScore.setGravity(Gravity.RIGHT);
        if (Activity == -99 || Sleep == -99 || Mood == -99 || Stress == -99) {
            dvprsScore.setText("\n\nDVPRS: " + dvprs);
        } else {
            dvprsScore.setText("\n\nDVPRS: " + dvprs + "\nActivity: " + Activity + "\nSleep: " + Sleep + "\nMood: " + Mood + "\nStress: " + Stress);
        }
        dvprsLanguage.setText(R.string.dvprsEnd);
        //dvprsSupTextLayout.setMargins(100, 120, 100, 0);
        //dvprsScoreTextLayout.setMargins(100, 220, 100, 0);
        //dvprsLanguage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        //dvprsScore.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);

        //Widget IDs
        dvprsLanguage.setId(11);

        //Add Widgets and Params to layout
        dvprsSecondLayout.addView(dvprsLanguage, dvprsSupTextLayout);
        dvprsSecondLayout.addView(dvprsScore, dvprsScoreTextLayout);

        //Start the layout
        setContentView(dvprsSecondLayout);





        //Listeners for First View
/*        dvprsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup dvprsGroup, int checkedId) {
                //Log.d("chk", "id" + checkedId);
                //((ViewGroup) dvprsSecondLayout.getParent()).removeView(dvprsSecondLayout);
                //dvprsEND();
            }

        });*/

    }

    public void addScores() {
        DBHandler = new DBHandler(this, null, null, 1);
        Scores scores = new Scores(dvprs, Activity, Sleep, Mood, Stress, qa1, qa2, qa3);
        DBHandler.addScore(scores);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int eventaction = event.getAction();
        if (eventaction == MotionEvent.ACTION_UP) {

            //get system current milliseconds
            long time= System.currentTimeMillis();


            //if it is the first time, or if it has been more than 3 seconds since the first tap ( so it is like a new try), we reset everything
            if (startMillis==0 || (time-startMillis> 3000) ) {
                startMillis=time;
                count=1;
            }
            //it is not the first, and it has been  less than 3 seconds since the first
            else{ //  time-startMillis< 3000
                count++;
            }

            if (count==5) {
                finish();
                Intent mainIntent = new Intent(DvprsEntry.this, MainActivity.class);
                DvprsEntry.this.startActivity(mainIntent);
                //do whatever you need
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent objEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return super.onKeyUp(keyCode, objEvent);
    }

    public void onBackPressed() {
        goBack();
    }

    public void goBack() {
        if (Activity == -99) {
            switch (currentScreen) {
                case 0:
                    dvprsFirstScreen();
                    break;
                case 1:
                    dvprsFirstScreen();
                    break;
                case 2:
                    dvprsFirstScreen();
                    break;
                case 3:
                    dvprsFirstScreen();
                    break;
                case 4:
                    dvprsFirstScreen();
                    break;
                case 5:
                    dvprsFirstScreen();
                    break;
                case 6:
                    //dvprsQA1Question();
                    break;
                case 7:
                    //dvprsQA2Question();
                    break;
                case 8:
                    break;
                    //DvprsEntry.this.startActivity(mainIntent);
            }
        } else {
            switch (currentScreen) {
                case 0:
                    dvprsFirstScreen();
                    break;
                case 1:
                    dvprsFirstScreen();
                    break;
                case 2:
                    dvprsActivityScreen();
                    break;
                case 3:
                    dvprsSleepScreen();
                    break;
                case 4:
                    dvprsMoodScreen();
                    break;
                case 5:
                    dvprsStressScreen();
                    break;
                case 6:
                    //dvprsQA1Question();
                    break;
                case 7:
                    //dvprsQA2Question();
                    break;
                case 8:
                    break;
                    //DvprsEntry.this.startActivity(mainIntent);
            }
        }

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    /*public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("DvprsEntry Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }*/

    /*@Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }*/
}

