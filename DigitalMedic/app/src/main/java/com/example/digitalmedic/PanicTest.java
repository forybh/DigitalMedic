package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PanicTest extends AppCompatActivity {

    private Button btn_back;
    private Button btn_next;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private CheckBox checkBox9;
    private CheckBox checkBox10;
    private CheckBox checkBox11;
    private CheckBox checkBox12;
    private CheckBox checkBox13;
    private CheckBox checkBox14;
    private CheckBox checkBox15;

    private int depress_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_test);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PanicTest.this, Panic.class);
                startActivity(intent);
            }
        });

        btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PanicTest.this, PanicResult.class);
                intent.putExtra("result", depress_result);
                startActivity(intent);
            }
        });

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox2= (CheckBox)findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox5 = (CheckBox)findViewById(R.id.checkBox5);
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox6 = (CheckBox)findViewById(R.id.checkBox6);
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox7 = (CheckBox)findViewById(R.id.checkBox7);
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox8 = (CheckBox)findViewById(R.id.checkBox8);
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox9 = (CheckBox)findViewById(R.id.checkBox9);
        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox10 = (CheckBox)findViewById(R.id.checkBox10);
        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox11 = (CheckBox)findViewById(R.id.checkBox11);
        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox12 = (CheckBox)findViewById(R.id.checkBox12);
        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox13 = (CheckBox)findViewById(R.id.checkBox13);
        checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox14 = (CheckBox)findViewById(R.id.checkBox14);
        checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });

        checkBox15 = (CheckBox)findViewById(R.id.checkBox15);
        checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    //눌렸을때
                    depress_result++;
                }
                else {
                    depress_result--;
                }
            }
        });
    }
}