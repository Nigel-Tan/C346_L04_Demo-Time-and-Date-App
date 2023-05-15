package sg.edu.rp.c346.id21023028.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayTime;
    Button btnDisplayDate;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link view to variables
        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        btnDisplayTime = findViewById(R.id.btnDisplayTime);
        btnDisplayDate = findViewById(R.id.btnDisplayDate);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnReset = findViewById(R.id.btnReset);

        //listener for display time
        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = String.format("Time is %d:%d",tp.getCurrentHour(),tp.getCurrentMinute());
                tvDisplay.setText(time);
            }
        });
        //listener for display date
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = String.format("Date is %s/%s/%s",dp.getDayOfMonth(),dp.getMonth()+1
                    ,dp.getYear());
                tvDisplay.setText(date);
            }
        });
        //listener for reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020,0,1); //set the date
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
            }
        });
    }
}