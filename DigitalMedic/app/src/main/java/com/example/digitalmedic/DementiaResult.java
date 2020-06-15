package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DementiaResult extends AppCompatActivity {

    private Button btn_back;
    private TextView tv_result;

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
                Intent intent = new Intent(DementiaResult.this, Dementia.class);
                startActivity(intent);
            }
        });

        tv_result =(TextView)findViewById(R.id.tv_result);
        tv_result.setText(String.valueOf(result));
    }
}