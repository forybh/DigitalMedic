package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DepressResult extends AppCompatActivity {

    private Button btn_back;
    private Button btn_ok;
    private TextView tv_result;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depress_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", 0);

        btn_back =(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepressResult.this, DepressTest.class);
                startActivity(intent);
            }
        });

        btn_ok =(Button)findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepressResult.this, Depress.class);
                startActivity(intent);
            }
        });


        tv_content =(TextView)findViewById(R.id.tv_content);
        tv_result =(TextView)findViewById(R.id.tv_result);
        tv_result.setText(String.valueOf(result));
        if(result <= 5) {
            tv_result.setTextColor(Color.parseColor("#81E385"));
            tv_content.setText("운동과 외부 사회활동을 잘 유지하시고, 동영상 강의와 고민톡과의 대화를 통해 예방하세요.");
        }
        else if(result <= 10) {
            tv_result.setTextColor(Color.parseColor("#F6BC0C"));
            tv_content.setText("초기 증상이 의심됩니다. 가까운 병원에서 더 정확한 검진을 받으세요");
        }
        else {
            tv_result.setTextColor(Color.parseColor("#D84314"));
            tv_content.setText("언제나 긍정적인 생각을 하도록 노력하고, 병원에서 치료를 동행하여 이겨내세요 ");
        }
    }
}