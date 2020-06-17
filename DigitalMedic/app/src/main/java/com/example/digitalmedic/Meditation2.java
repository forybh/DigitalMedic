package com.example.digitalmedic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Meditation2 extends AppCompatActivity {

    private MediaPlayer mp;

    private Button btn_video1, btn_video2, btn_video3, btn_video4, btn_video5, btn_video6, btn_video7, btn_video8;
    private Button btn_music;
    private Button btn_stop;
    private Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation2);

        btn_video1 = (Button)findViewById(R.id.btn_video1);
        btn_video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CNYYWuH_Fcc"));
                startActivity(intent);
            }
        });

        btn_video2 = (Button)findViewById(R.id.btn_video2);
        btn_video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dZewQEbQQM0"));
                startActivity(intent);
            }
        });

        btn_video3 = (Button)findViewById(R.id.btn_video3);
        btn_video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=S3qGNAu0JuI"));
                startActivity(intent);
            }
        });

        btn_video4 = (Button)findViewById(R.id.btn_video4);
        btn_video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=OF1UccGXPWM"));
                startActivity(intent);
            }
        });

        btn_video5 = (Button)findViewById(R.id.btn_video5);
        btn_video5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Hm6icdOkiiw"));
                startActivity(intent);
            }
        });

        btn_video6 = (Button)findViewById(R.id.btn_video6);
        btn_video6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DHNFYhNv81o"));
                startActivity(intent);
            }
        });

        btn_video7 = (Button)findViewById(R.id.btn_video7);
        btn_video7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=c9W414XrdF0"));
                startActivity(intent);
            }
        });

        btn_video8 = (Button)findViewById(R.id.btn_video8);
        btn_video8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sabU4F_94Ug"));
                startActivity(intent);
            }
        });

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Meditation2.this, PanicVideo.class);
                startActivity(intent);
            }
        });

        btn_music = (Button)findViewById(R.id.btn_music);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(Meditation2.this, R.raw.meditation);
                mp.setLooping(true);
                mp.start();
            }
        });

        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.stop();
                    mp.reset();
                }
            }
        });
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        if(mp != null) {
            mp.release();
            mp = null;
        }
    }
}