package com.example.digitalmedic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemInit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_init);
        findViewById(R.id.btn_complete).setOnClickListener(onClickListener);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_complete:
                    memInit();
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
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            MemberInfo memberInfo = new MemberInfo(name, phoneNum,momPhone,address,illness);

            if(user != null){
                db.collection("users").document(user.getUid()).set(memberInfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("회원정보 등록 성공");
                                startMainActivity();
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

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }


}