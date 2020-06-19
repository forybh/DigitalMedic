package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Depress extends AppCompatActivity {

    private ViewFlipper flipper;
    private Button btn_user;
    private Button btn_alarm;
    private Button btn_test;
    private Button btn_chatting;
    private Button btn_video;
    private Button btn_attend;
    private Button btn_chart;
    private Button btn_instruction;
    private Button btn_prev;
    private Button btn_next;
    private Button btn_mission;
    private Button btn_gotest;
    private ImageView depress_breath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depress);

        //ViewFlipper 구현
        flipper = findViewById(R.id.btn_center);
        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

        //자동으로 넘어가기
        flipper.setFlipInterval(3000);
        flipper.startFlipping();


        btn_prev = findViewById(R.id.button5);
        btn_next = findViewById(R.id.button6);
        depress_breath = (ImageView)findViewById(R.id.depress_breath);
        btn_gotest = findViewById(R.id.btn_gotest);
        btn_mission = findViewById(R.id.btn_mission);

        btn_mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this,DepressAttend.class);
                startActivity(intent);
            }
        });

        btn_gotest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this,DepressTest.class);
                startActivity(intent);
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showPrevious();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });

        depress_breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressVideo.class);
                startActivity(intent);
            }
        });


        btn_user = findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, UserInfo.class);
                startActivity(intent);
            }
        });

        btn_alarm = findViewById(R.id.btn_notice);
        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressNotice.class);
                startActivity(intent);
            }
        });

        btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressTest.class);
                startActivity(intent);
            }
        });

        btn_chatting = (Button)findViewById(R.id.btn_chatting);
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressChat.class);
                startActivity(intent);
            }
        });

        btn_video = findViewById(R.id.btn_video);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressVideo.class);
                startActivity(intent);
            }
        });

        btn_attend = findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressAttend.class);
                startActivity(intent);
            }
        });


        btn_chart = findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_instruction = findViewById(R.id.btn_instruction);
        btn_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Depress.this, DepressInstruction.class);
                startActivity(intent);
            }
        });

    }
}