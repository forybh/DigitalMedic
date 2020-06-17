package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_signUp;
    private Button btn_logIn;
    private Button btn_hidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_complete).setOnClickListener(onClickListener);
        findViewById(R.id.btn_logIn).setOnClickListener(onClickListener);


    }
    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_complete:
                    myStartActivity(SignUp.class);
                    break;
                case R.id.btn_logIn:
                    myStartActivity(LogIn.class);
                    break;
            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
//        btn_signUp = findViewById(R.id.btn_signUp);
//        btn_signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
//                startActivity(intent);
//            }
//        });
//        btn_logIn = findViewById(R.id.btn_logIn);
//        btn_logIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LogIn.class);
//                startActivity(intent);
//            }
//        });
//
//    }
}