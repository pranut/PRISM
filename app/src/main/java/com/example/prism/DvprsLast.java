package com.example.prism;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DvprsLast extends AppCompatActivity {

    private static final String LOG_TAG = "Log: ";

    DBHandler DBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dvprs_last);
        DBHandler = new DBHandler(this, null, null, 1);
        String dbString = DBHandler.dbToString();
        updateTextView(dbString);

    }

    public void updateTextView(String toThis) {
        TextView textView = (TextView) findViewById(R.id.textViewLast);
        textView.setText(toThis);
    }

}
