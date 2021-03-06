package com.example.digitalmedic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserInfo extends AppCompatActivity {
    private static String TAG = "UserInfo";
    private Button btn_logout;
    private Button btn_edit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        final TextView setName = findViewById(R.id.et_name2);
        final TextView setIll = findViewById(R.id.et_illness2);
        final TextView setPhone = findViewById(R.id.et_phoneNum2);
        final TextView setMomPhone= findViewById(R.id.et_phonemom2);
        final TextView setAddress= findViewById(R.id.et_address);


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
                    setPhone.setText( data[0]);
                    setMomPhone.setText(data[2]);
                    setAddress.setText(data[4]);
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        btn_logout = (Button)findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStartActivity(MainActivity.class);
            }
        });

        btn_edit = (Button)findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStartActivity(EditInfo.class);
            }
        });

    }
    public void myStartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}