package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Depress extends AppCompatActivity {

    private Button btn_user;
    private Button btn_alarm;
    private Button btn_test;
    private Button btn_chatting;
    private Button btn_video;
    private Button btn_attend;
    private Button btn_chart;
    private Button btn_instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depress);

        btn_user = (Button)findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_alarm = (Button)findViewById(R.id.btn_alarm);
        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_chatting = (Button)findViewById(R.id.btn_chatting);
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_video = (Button)findViewById(R.id.btn_video);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_attend = (Button)findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });


        btn_chart = (Button)findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_instruction = (Button)findViewById(R.id.btn_instruction);
        btn_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });
    }
}