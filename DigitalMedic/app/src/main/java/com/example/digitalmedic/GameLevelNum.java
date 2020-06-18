package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameLevelNum extends AppCompatActivity{
    private Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level_num);

        btn_1 = (Button)findViewById(R.id.btn_1_num);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLevelNum.this, NumberGame.class);
                startActivity(intent);
            }
        });
    }
}