package com.example.digitalmedic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class NumberGame extends AppCompatActivity {
    private Button btn_back;
    int array[] = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_number);

        btn_back =(Button)findViewById(R.id.btn_back_num);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NumberGame.this, GameLevelNum.class);
                startActivity(intent);
            }
        });

        final ImageView iv1 = (ImageView)findViewById(R.id.number_1);
        final ImageView iv2 = (ImageView)findViewById(R.id.number_2);
        final ImageView iv3 = (ImageView)findViewById(R.id.number_3);
        final ImageView iv4 = (ImageView)findViewById(R.id.number_4);
        final ImageView iv5 = (ImageView)findViewById(R.id.number_5);
        final ImageView iv6 = (ImageView)findViewById(R.id.number_6);
        final TextView game = (TextView)findViewById(R.id.game);

        array[0] = 1;
        for(int i = 1; i < 6; i++){
            array[i] = i;
        }

        iv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 1){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "를 누를 차례입니다.");
                }
            }
        });

        iv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 2){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "을 누를 차례입니다.");
                }
            }
        });

        iv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 3){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "를 누를 차례입니다.");
                }
            }
        });

        iv4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 4){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "를 누를 차례입니다.");
                }
            }
        });
          iv5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 5){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "을 누를 차례입니다.");
                }
            }
        });
          iv6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 6){
                    array[0] += 1;
                    game.setText("게임 끝!!");
                }
            }
        });

    }


}
