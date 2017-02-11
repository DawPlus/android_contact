package com.hanbit.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.hanbit.app.contactapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbCalendar, rbClock;
    CalendarView cvSet;
    TimePicker tpSet;
    Button btSet;
    TextView tvYear, tvMonth, tvDate, tvHour, tvMinute ,tvToday;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // Radio
        rbCalendar = (RadioButton) findViewById(R.id.rbCalendar);
        rbClock = (RadioButton) findViewById(R.id.rbClock);

        //Calander
        cvSet = (CalendarView) findViewById(R.id.cvSet);
        tpSet = (TimePicker) findViewById(R.id.tpSet);

        //Button
        btSet = (Button) findViewById(R.id.btSet);

        //TextView
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        tvToday = (TextView) findViewById(R.id.tvToday);


        //Set Visible
        cvSet.setVisibility(View.VISIBLE);
        tpSet.setVisibility(View.INVISIBLE);


        tvToday.setText("Today : "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        date = "";
        cvSet.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Long curDate = view.getDate();


                date = year+"-"+month+"-"+dayOfMonth;




            }
        });


        //OnclickListener
        rbCalendar.setOnClickListener(this);
        rbClock.setOnClickListener(this);
        btSet.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.rbCalendar:
                cvSet.setVisibility(View.VISIBLE);
                tpSet.setVisibility(View.INVISIBLE);

                break;

            case R.id.rbClock:

                cvSet.setVisibility(View.INVISIBLE);
                tpSet.setVisibility(View.VISIBLE);
                break;

            case R.id.btSet:

                String[] arr = date.split("-");

                tvYear.setText(arr[0]);
                tvMonth.setText(arr[1]);
                tvDate.setText(arr[2]);


                tvHour.setText(Integer.toString(tpSet.getHour()));
                tvMinute.setText(Integer.toString(tpSet.getMinute()));

                break;
        }


    }
}
