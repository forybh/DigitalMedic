package com.example.digitamedic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Dementia extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private Button btn_userInfo;
    private Button btn_open;
    private Button btn_close;
    private Button btn_home;
    private Button btn_back;
    private Button btn_degree;
    private Button btn_attend;
    private Button btn_lecture;
    private Button btn_gamelevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dementia);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);

        btn_open = (Button)findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        btn_userInfo = (Button)findViewById(R.id.btn_userInfo);
        btn_userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, UserInfo.class);
                startActivity(intent);
            }
        });

        btn_degree = (Button)findViewById(R.id.btn_degree);
        btn_degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Degree.class);
                startActivity(intent);
            }
        });

        btn_attend = (Button)findViewById(R.id.btn_attend);
        btn_attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Attend.class);
                startActivity(intent);
            }
        });

        btn_lecture = (Button)findViewById(R.id.btn_lecture);
        btn_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Lecture.class);
                startActivity(intent);
            }
        });

        btn_gamelevel = (Button)findViewById(R.id.btn_gamelevel);
        btn_gamelevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, GameLevel.class);
                startActivity(intent);
            }
        });

        btn_home = (Button)findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Home.class);
                startActivity(intent);
            }
        });

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dementia.this, Home.class);
                startActivity(intent);
            }
        });
        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {//어떤 액션을 했을때 일어날
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}