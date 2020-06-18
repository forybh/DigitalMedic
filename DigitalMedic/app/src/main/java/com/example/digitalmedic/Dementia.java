package com.example.digitalmedic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Dementia extends AppCompatActivity {
    private ViewFlipper flipper;
    private Button btn_user;
    private Button btn_notice;
    private Button btn_test;
    private Button btn_game;
    private Button btn_sos;
    private Button btn_attend;
    private Button btn_chart;
    private Button btn_instruction;
    private Button btn_center;
    private String pNum;
    private Button btn_prev;
    private Button btn_next;


    public Dementia() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia);

        btn_prev = (Button) findViewById(R.id.button5);
        btn_next = (Button) findViewById(R.id.button6);

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


        flipper = (ViewFlipper) findViewById(R.id.btn_center);
        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        flipper.setFlipInterval(2000);
        flipper.startFlipping();

        btn_user = (Button) findViewById(R.id.btn_user);
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, UserInfo.class);
                startActivity(intent);
            }
        });

        btn_notice = (Button) findViewById(R.id.btn_notice);
        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaNotice.class);
                startActivity(intent);
            }
        });

        btn_test = (Button) findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaTest.class);
                startActivity(intent);
            }
        });

        btn_game = (Button) findViewById(R.id.btn_game);
        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Game.class);
                startActivity(intent);
            }
        });

        btn_sos = (Button) findViewById(R.id.btn_sos);
        btn_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                DocumentReference docRef = db.collection("users").document(user.getUid());
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            String data[] = document.getData().values().toArray(new String[5]);
                            pNum = data[2];
                        } else {

                        }
                    }
                });
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + pNum));
                startActivity(intent);
            }
        });

        btn_attend = (Button) findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaAttend.class);
                startActivity(intent);
            }
        });


        btn_chart = (Button) findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaChart.class);
                startActivity(intent);
            }
        });

        btn_instruction = (Button) findViewById(R.id.btn_instruction);
        btn_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, DementiaInstruction.class);
                startActivity(intent);
            }
        });

    }
}