package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameLevelPic extends AppCompatActivity{
    private Button btn_1;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level_picture);

        btn_1 = (Button)findViewById(R.id.btn_1_pic);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLevelPic.this, PictureActivity.class);
                startActivity(intent);
            }
        });


        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLevelPic.this, Game.class);
                startActivity(intent);
            }
        });
    }
}
