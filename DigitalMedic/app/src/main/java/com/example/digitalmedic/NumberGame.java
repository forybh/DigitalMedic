package com.example.digitalmedic;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


class NumberGame extends AppCompatActivity {
    int array[] = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_number);

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
                    game.setText(Integer.toString(array[0]) + "누를 차례입니다.");
                }
            }
        });

        iv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 2){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "누를 차례입니다.");
                }
            }
        });

        iv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 3){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "누를 차례입니다.");
                }
            }
        });

        iv4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 4){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "누를 차례입니다.");
                }
            }
        });
          iv5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(array[0] == 5){
                    array[0] += 1;
                    game.setText(Integer.toString(array[0]) + "누를 차례입니다.");
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
