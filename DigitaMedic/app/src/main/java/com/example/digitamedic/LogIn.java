package com.example.digitamedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    private Button btn_logIn;
    private Button btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btn_logIn = findViewById(R.id.btn_logIn);

        btn_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, Home.class);
                startActivity(intent);
            }
        });

        btn_cancle = findViewById(R.id.btn_cancle);

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
