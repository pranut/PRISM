package com.example.prism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUserID, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserID  = findViewById(R.id.edtUserID);
        edt_password = findViewById(R.id.edt_password);
    }

    public void loginUser(View view) {

        String user = edtUserID.getText().toString();

        if(user.equals("phy")){
            Intent myIntent = new Intent(this, MainScreenPatient.class);
            //Intent myIntent = new Intent(this, LinearChartActivity.class);
            startActivity(myIntent);
        } else{
            Intent myIntent = new Intent(this, MainScreenPatient.class);
            //Intent myIntent = new Intent(this, LinearChartActivity.class);
            startActivity(myIntent);
        }
    }

}
