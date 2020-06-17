package com.example.digitalmedic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

        array[0] = 1;
        for(int i = 1; i < 6; i++){
            array[i] = i;
        }
    }

    public void onClick(View view){
    }
}
