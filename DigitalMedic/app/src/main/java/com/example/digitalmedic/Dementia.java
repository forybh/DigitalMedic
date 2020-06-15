package com.example.digitalmedic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Dementia extends AppCompatActivity {
    private Button btn_user;
    private Button btn_notice;
    private Button btn_test;
    private Button btn_game;
    private Button btn_sos;
    private Button btn_attend;
    private Button btn_chart;
    private Button btn_instruction;
    private String pNum;

    public Dementia() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia);

        btn_user = (Button)findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Dementia.class);
                startActivity(intent);
            }
        });

        btn_notice = (Button)findViewById(R.id.btn_notice);
        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this , DementiaNotice.class);
                startActivity(intent);
            }
        });

        btn_test = (Button)findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaTest.class);
                startActivity(intent);
            }
        });

        btn_game = (Button)findViewById(R.id.btn_game);
        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Game.class);
                startActivity(intent);
            }
        });

        btn_sos = (Button)findViewById(R.id.btn_sos);
        btn_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pNum = "01051410551";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + pNum));
                startActivity(intent);
            }
        });

        btn_attend = (Button)findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaAttend.class);
                startActivity(intent);
            }
        });


        btn_chart = (Button)findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaChart.class);
                startActivity(intent);
            }
        });

        btn_instruction = (Button)findViewById(R.id.btn_instruction);
        btn_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Dementia.class);
                startActivity(intent);
            }
        });
    }


}