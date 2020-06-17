package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DementiaNotice extends AppCompatActivity {
    private Button btn_back, btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia_notice);

        btn_back =(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DementiaNotice.this, Dementia.class);
                startActivity(intent);
            }
        });
        btn_set =(Button)findViewById(R.id.btn_set);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DementiaNotice.this, DementiaNoticeSetting.class);
                startActivity(intent);
            }
        });
    }
}