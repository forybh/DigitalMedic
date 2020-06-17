package com.example.digitalmedic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogIn extends AppCompatActivity {
    private static String TAG = "Login";
    private Button btn_logIn;
    private Button btn_sign;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_logIn).setOnClickListener(onClickListener);
        findViewById(R.id.btn_cancel).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_logIn:
                    Login();
                    break;
                case R.id.btn_cancel:
                    myStartActivity(MainActivity.class);
                    break;
            }
        }
    };

    private void Login(){
        String email = ((EditText)findViewById(R.id.tv_id)).getText().toString();
        String password = ((EditText)findViewById(R.id.tv_pw)).getText().toString();

        if(email.length() > 0 && password.length() >0 ){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {;
                                startToast("로그인 완료되었습니다.");

                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                FirebaseFirestore db = FirebaseFirestore.getInstance();

                                DocumentReference docRef = db.collection("users").document(user.getUid());
                                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DocumentSnapshot document = task.getResult();
                                            String data[] = document.getData().values().toArray(new String[5]);
                                            Log.d(TAG, "get failed with "+ document.getData().values());
                                            if(data[3].equals("1") || data[3].equals("dementia") || data[3].equals("치매")){//dementia
                                                myStartActivity(Dementia.class);
                                            }
                                            else if(data[3].equals("2") || data[3].equals("depress") || data[3].equals("우울증")){//Depress
                                                myStartActivity(Depress.class);
                                            }
                                            else if(data[3].equals("3") || data[3].equals("panic") || data[3].equals("공황장애")){//Panic
                                                myStartActivity(Panic.class);
                                            }
                                            else{
                                                myStartActivity(MemInit.class);
                                            }
                                        } else {
                                            Log.d(TAG, "get failed with ", task.getException());
                                        }
                                    }
                                });
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
        startActivity(intent);
    }
}