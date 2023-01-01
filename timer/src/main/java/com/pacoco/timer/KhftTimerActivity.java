package com.pacoco.timer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhftTimerActivity extends AppCompatActivity {
    private static final String TAG = "CocoUnhappy";
    TextView tv_day;
    TextView tv_hour;
    TextView tv_minute;
    TextView tv_second;
    TextView tv_hint;
    String time;
    String purpose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khft_timer);

        Intent it = getIntent();
        purpose = it.getStringExtra("purpose");
        time = it.getStringExtra("time");

        tv_day = findViewById(R.id.tv_day);
        tv_hour = findViewById(R.id.tv_hour);
        tv_minute = findViewById(R.id.tv_minute);
        tv_second = findViewById(R.id.tv_second);
        tv_hint = findViewById(R.id.hint);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide(); //隐藏标题栏
        }

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                setText();
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);

    }

    @SuppressLint("SetTextI18n")
    private void setText() {
        tv_hint.setText("距离"+purpose+"还有：");
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date there;
        try {
            there = df.parse(time);
            long allsc = (there.getTime() - now.getTime()) / 1000;
            Log.d(TAG, String.valueOf(allsc) + "  " + String.valueOf(there.getTime()) + "  " + String.valueOf(now.getTime()));
            int day = (int) (allsc / 86400);
            allsc %= 86400;
            int hour = (int) (allsc / 3600);
            allsc %= 3600;
            int minute = (int) (allsc / 60);
            int second = (int) (allsc % 60);

            tv_day.setText(day + "天");
            tv_hour.setText(hour + "时");
            tv_minute.setText(minute + "分");
            tv_second.setText(second + "秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}