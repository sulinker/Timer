package com.pacoco.timer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btKhft;
    Button btPawn;
    Button btFprh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide(); //隐藏标题栏
        }

        btKhft = findViewById(R.id.bt_khft);
        btPawn = findViewById(R.id.bt_pawn);
        btFprh = findViewById(R.id.bt_fprh);

        btKhft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String purpose = "中考";
                String time = "2023-06-17";
                Intent it = new Intent(MainActivity.this, KhftTimerActivity.class);
                it.putExtra("purpose", purpose);
                it.putExtra("time", time);
                startActivity(it);
            }
        });

        btPawn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String purpose = "寒假结束";
                String time = "2023-02-01";
                Intent it = new Intent(MainActivity.this, KhftTimerActivity.class);
                it.putExtra("purpose", purpose);
                it.putExtra("time", time);
                startActivity(it);
            }
        });

        btFprh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String purpose = "春节";
                String time = "2023-01-22";
                Intent it = new Intent(MainActivity.this, KhftTimerActivity.class);
                it.putExtra("purpose", purpose);
                it.putExtra("time", time);
                startActivity(it);
            }
        });
    }
}