package com.example.loginmain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_login).setOnClickListener(onClickListener);
        findViewById(R.id.btn_sign).setOnClickListener(onClickListener);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_login:
                    Login();
                    break;
                case R.id.btn_sign:
                    myStartActivity(SignupActivity.class);
                    break;

            }
        }
    };
    private void Login(){
        String email = ((EditText)findViewById(R.id.id_text)).getText().toString();
        String password = ((EditText)findViewById(R.id.pw_text)).getText().toString();

        if(email.length() > 0 && password.length() >0 ){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인 완료되었습니다.");
                                myStartActivity(MainActivity.class);
                            } else {
                                if(task.getException() != null){
                                    startToast("아이디 비밀번호를 확인해주세요");
                                }
                            }
                            // ...
                        }
                    });
        }
        else{
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }

    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
