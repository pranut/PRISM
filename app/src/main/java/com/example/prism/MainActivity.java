package com.example.prism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.aware.Aware;
import com.aware.Aware_Preferences;

public class MainActivity extends AppCompatActivity {

    EditText edtUserID, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserID  = findViewById(R.id.edtUserID);
        edt_password = findViewById(R.id.edt_password);

        Intent aware = new Intent(this, Aware.class);
        startService(aware);
        Aware.setSetting(this, Aware_Preferences.DEBUG_FLAG, false);
        new Tracking(this);

    }

    public void loginUser(View view) {
        Intent myIntent = new Intent(this, MainScreenPatient.class);
        startActivity(myIntent);
    }

}
