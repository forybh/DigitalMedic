package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DementiaResult extends AppCompatActivity {

    private Button btn_back;
    private Button btn_ok;
    private TextView tv_result;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", 0);

        btn_back =(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DementiaResult.this, DementiaTest.class);
                startActivity(intent);
            }
        });

        btn_ok =(Button)findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DementiaResult.this, Dementia.class);
                startActivity(intent);
            }
        });


        tv_content =(TextView)findViewById(R.id.tv_content);
        tv_result =(TextView)findViewById(R.id.tv_result);
        tv_result.setText(String.valueOf(result));
        if(result <= 5) {
            tv_result.setTextColor(Color.parseColor("#81E385"));
            tv_content.setText("운동과 외부 사회활동을 잘 유지하시고, 치매 예방 게임을 통해 치매를 예방하세요.");
        }
        else if(result <= 10) {
            tv_result.setTextColor(Color.parseColor("#F6BC0C"));
            tv_content.setText("초기 증상이 의심됩니다. 가까운 보건소나 치매지원센터를 방문해 더 정확한 치매검진을 받으세요 ");
        }
        else {
            tv_result.setTextColor(Color.parseColor("#D84314"));
            tv_content.setText("치매 위험 단계입니다. 가까운 보건소나 치매지원센터에서 치료를 병행하세요 ");
        }



    }

}