package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity {

    private Button btn_back;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    private Button btn_sdoku;
    private Button btn_number;
    private Button btn_picture;
>>>>>>> Stashed changes
=======
<<<<<<< HEAD
    private Button btn_sdoku;
=======
<<<<<<< Updated upstream
=======
    private Button btn_sdoku;
    private Button btn_number;
    private Button btn_picture;
>>>>>>> Stashed changes
>>>>>>> bh
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
=======
>>>>>>> bh
>>>>>>> Stashed changes
        btn_sdoku = (Button)findViewById(R.id.btn_sdoku);
        btn_sdoku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevel.class);
                startActivity(intent);
            }
        });
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
        btn_number = (Button)findViewById(R.id.btn_number);
        btn_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevel.class);
                startActivity(intent);
            }
        });
        btn_picture = (Button)findViewById(R.id.btn_picture);
        btn_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game.this, GameLevel.class);
                startActivity(intent);
            }
        });
>>>>>>> Stashed changes
<<<<<<< Updated upstream
=======
>>>>>>> bh
>>>>>>> Stashed changes
    }
}