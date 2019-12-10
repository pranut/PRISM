package com.example.prism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.prism.model.Routine;
import com.example.prism.model.TimeEvent;
import com.example.prism.model.TimeSeriesPrivatizer;

import java.util.ArrayList;

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
            Intent myIntent = new Intent(this, MainScreenPhysician.class);


            startActivity(myIntent);
        } else{
            Intent myIntent = new Intent(this, MainScreenPatient.class);

            ArrayList<Routine> routines = createDummyDate();
            myIntent.putExtra("ROUTINES", routines);

            startActivity(myIntent);
        }
    }

    private ArrayList<Routine> createDummyDate(){

        // Initialize contacts
        ArrayList<Routine> routines = Routine.createRoutinesList(20);

        TimeSeriesPrivatizer priv = new TimeSeriesPrivatizer();

        for(Routine r : routines){
            r.rawData = priv.generateDummyData(100, 1500);
        }

        return routines;
    }

}
