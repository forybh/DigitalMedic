package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
=======

>>>>>>> master
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameLevel extends AppCompatActivity {
    private Button btn_1;

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level);

        btn_back =(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLevel.this, Game.class);
                startActivity(intent);
            }
        });
    }
}