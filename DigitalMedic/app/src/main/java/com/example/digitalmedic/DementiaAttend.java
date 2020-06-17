package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class DementiaAttend extends AppCompatActivity {

    private Button btn_star, btn_back;
    private CheckBox cb_1, cb_2, cb_3;
    private EditText et_mission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia_attend);
        et_mission = (EditText)findViewById(R.id.et_mission);
        btn_star = (Button)findViewById(R.id.btn_star);
        btn_back = (Button)findViewById(R.id.btn_back);
        cb_1 = (CheckBox)findViewById(R.id.cb_1);
        cb_2 = (CheckBox)findViewById(R.id.cb_2);
        cb_3 = (CheckBox)findViewById(R.id.cb_3);

        btn_star.setVisibility(View.GONE);


        cb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MissionComplete();
            }
        });
        cb_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MissionComplete();
            }
        });
        cb_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                MissionComplete();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DementiaAttend.this, Dementia.class);
                startActivity(intent);
            }
        });
    }
    public void MissionComplete() {
        if(cb_1.isChecked() && cb_2.isChecked() && cb_3.isChecked() == true) {
            btn_star.setVisibility(View.VISIBLE);
            startToast("출석 완료");
        }
        else btn_star.setVisibility(View.GONE);
    }

    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}