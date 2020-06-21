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

import com.google.firebase.firestore.auth.User;

public class Panic extends AppCompatActivity {

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
    private ImageView panic_breath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);

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
        panic_breath = (ImageView)findViewById(R.id.panic_breath);

        btn_gotest = findViewById(R.id.btn_gotest);
        btn_mission = findViewById(R.id.btn_mission);

        btn_mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this,PanicAttend.class);
                startActivity(intent);
            }
        });

        btn_gotest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this,PanicTest.class);
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

        panic_breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicVideo.class);
                startActivity(intent);
            }
        });

        btn_user = (Button)findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, UserInfo.class);
                startActivity(intent);
            }
        });

        btn_alarm = (Button)findViewById(R.id.btn_notice);
        btn_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicNotice.class);
                startActivity(intent);
            }
        });

        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicTest.class);
                startActivity(intent);
            }
        });

        btn_chatting = (Button)findViewById(R.id.btn_chatting);
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicChat.class);
                startActivity(intent);
            }
        });

        btn_video = (Button)findViewById(R.id.btn_video);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicVideo.class);
                startActivity(intent);
            }
        });

        btn_attend = (Button)findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicAttend.class);
                startActivity(intent);
            }
        });


        btn_chart = (Button)findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, Panic.class);
                startActivity(intent);
            }
        });

        btn_instruction = (Button)findViewById(R.id.btn_instruction);
        btn_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Panic.this, PanicInstruction.class);
                startActivity(intent);
            }
        });
    }
}