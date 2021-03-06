package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity {

    private Button btn_back;
    private Button btn_sdoku;
    private Button btn_number;
    private Button btn_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, Dementia.class);
                startActivity(intent);
            }
        });

        btn_sdoku = (Button)findViewById(R.id.btn_sdoku);
        btn_sdoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevelSudoku.class);
                startActivity(intent);
            }
        });

        btn_number = (Button)findViewById(R.id.btn_number);
        btn_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevelNum.class);
                startActivity(intent);
            }
        });

        btn_picture = (Button)findViewById(R.id.btn_picture);
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevelPic.class);
                startActivity(intent);
            }
        });
    }
}