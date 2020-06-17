package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DepressVideo extends AppCompatActivity {

    private Button btn_back;
    private Button btn_meditation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depress_video);

        btn_back =(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepressVideo.this, Depress.class);
                startActivity(intent);
            }
        });

        btn_meditation =(Button)findViewById(R.id.btn_meditation);
        btn_meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepressVideo.this, Meditation.class);
                startActivity(intent);
            }
        });
    }
}