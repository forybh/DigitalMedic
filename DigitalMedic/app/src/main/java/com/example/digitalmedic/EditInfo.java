package com.example.digitalmedic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditInfo extends AppCompatActivity {
    private static String TAG = "EditINfo";
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        findViewById(R.id.btn_complete).setOnClickListener(onClickListener);




        final TextView setName = findViewById(R.id.et_name);
        final TextView setIll = findViewById(R.id.et_illness);
        final TextView setPhone = findViewById(R.id.et_phoneNum);
        final TextView setMomPhone= findViewById(R.id.et_momPhone);
        final TextView setAddress = findViewById(R.id.et_address);


        DocumentReference docRef = db.collection("users").document(user.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    String data[] = document.getData().values().toArray(new String[5]);
                    Log.d(TAG, "get failed with "+ document.getData().values());
                    setName.setText(data[1]);
                    setIll.setText(data[3]);
                    setPhone.setText(data[0]);
                    setMomPhone.setText(data[2]);
                    setAddress.setText(data[4]);
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }


    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_complete:
                    memInit();
                    break;
                case R.id.btn_cancel:
                    myStartActivity(UserInfo.class);
                    break;
            }
        }
    };
    private void memInit(){
        String name = ((EditText)findViewById(R.id.et_name)).getText().toString();
        String phoneNum = ((EditText)findViewById(R.id.et_phoneNum)).getText().toString();
        String momPhone = ((EditText)findViewById(R.id.et_momPhone)).getText().toString();
        String address = ((EditText)findViewById(R.id.et_address)).getText().toString();
        String illness = ((EditText)findViewById(R.id.et_illness)).getText().toString();

        if(name.length() > 0 && phoneNum.length() > 0 && momPhone.length() >0 && address.length() >0 && illness.length() >0){


            MemberInfo memberInfo = new MemberInfo(name, phoneNum,momPhone,address,illness);

            if(user != null){
                db.collection("users").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("회원정보 수정 성공");

                                DocumentReference docRef = db.collection("users").document(user.getUid());
                                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DocumentSnapshot document = task.getResult();
                                            String data[] = document.getData().values().toArray(new String[5]);
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
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("회원정보 등록 실패");
                            }
                        });

            }

        }
        else{
            startToast("회원정보를 입력해주세요.");
        }

    }
    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void myStartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
