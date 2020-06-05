package com.example.digitamedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    private Button btn_signUp;
    private Button btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_signUp = findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });

        btn_cancle = findViewById(R.id.btn_cancle);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
