package com.example.digitamedic;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {


    private Button btn_signUp;
    private Button btn_logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_signUp = findViewById(R.id.btn_signUp);
        btn_logIn = findViewById(R.id.btn_logIn);


        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        btn_logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent);
            }
        });

    }

}
