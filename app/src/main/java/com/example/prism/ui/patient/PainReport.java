package com.example.prism.ui.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.prism.R;

public class PainReport extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar painLevelSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_report);

        painLevelSeekBar = findViewById(R.id.painLevelSeekBar);
        painLevelSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        ImageView imgshare = (ImageView) findViewById(R.id.left_arm);
        TextView txtView = (TextView ) findViewById(R.id.painLevelNumber);

        txtView.setText(String.valueOf(progress));
        switch (progress){
            case 1:
                DrawableCompat.setTint(imgshare.getDrawable(), ContextCompat.getColor(this, R.color.colorGreen));
                break;
            case 2: DrawableCompat.setTint(imgshare.getDrawable(), ContextCompat.getColor(this, R.color.colorYellow));break;
            case 3: DrawableCompat.setTint(imgshare.getDrawable(), ContextCompat.getColor(this, R.color.colorYellowish));break;
            case 4: DrawableCompat.setTint(imgshare.getDrawable(), ContextCompat.getColor(this, R.color.colorOrange));break;
            case 5: DrawableCompat.setTint(imgshare.getDrawable(), ContextCompat.getColor(this, R.color.colorRed));break;
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

}
