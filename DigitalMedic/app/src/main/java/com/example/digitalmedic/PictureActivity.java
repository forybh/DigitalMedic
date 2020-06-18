package com.example.digitalmedic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Vector;

import com.example.digitalmedic.databinding.ActivityGamePictureBinding;
import com.example.digitalmedic.R;


public class PictureActivity extends AppCompatActivity {

    ActivityGamePictureBinding binding;
    Vector<Picture> pictures;
    Vector<Integer> selectedPos;
    PictureAdapter adapter;
    private Button btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(PictureActivity.this, R.layout.activity_game_picture);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PictureActivity.this, GameLevelPic.class);
                startActivity(intent);
            }
        });

        binding.restartBtn.setOnClickListener(view -> recreate());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        binding.pictureViews.setLayoutManager(gridLayoutManager);
        adapter = new PictureAdapter(this);
        binding.pictureViews.setAdapter(adapter);


        selectedPos = new Vector<>();
        pictures = new Vector<>();
        pictures.add(new Picture(R.drawable.img1, "1"));
        pictures.add(new Picture(R.drawable.img1, "1"));
        pictures.add(new Picture(R.drawable.img2, "2"));
        pictures.add(new Picture(R.drawable.img2, "2"));
        pictures.add(new Picture(R.drawable.img3, "3"));
        pictures.add(new Picture(R.drawable.img3, "3"));
        pictures.add(new Picture(R.drawable.img4, "4"));
        pictures.add(new Picture(R.drawable.img4, "4"));
        pictures.add(new Picture(R.drawable.img5, "5"));
        pictures.add(new Picture(R.drawable.img5, "5"));
        pictures.add(new Picture(R.drawable.img6, "6"));
        pictures.add(new Picture(R.drawable.img6, "6"));
        pictures.add(new Picture(R.drawable.img7, "7"));
        pictures.add(new Picture(R.drawable.img7, "7"));
        pictures.add(new Picture(R.drawable.img8, "8"));
        pictures.add(new Picture(R.drawable.img8, "8"));
        Collections.shuffle(pictures);
        adapter.setUpPicture(pictures);

        binding.pictureLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width = binding.pictureViews.getWidth() / 4 - 10;
                int height = binding.pictureViews.getHeight() / 4 - 10;
                Log.e("width", String.valueOf(width));
                Log.e("height", String.valueOf(height));
                adapter.setLength(width, height);
                adapter.notifyDataSetChanged();
                Handler handler = new Handler();
                handler.postDelayed(PictureActivity.this::setCount3, 1000);
                binding.pictureLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }

    RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent evt) {
            int action = evt.getAction();
            switch (action) {
                case MotionEvent.ACTION_UP:
                    View child = recyclerView.findChildViewUnder(evt.getX(), evt.getY());
                    assert child != null;
                    final int pos = recyclerView.getChildAdapterPosition(child);
                    Log.e("pos", String.valueOf(pos));
                    final View txtView = child.findViewById(R.id.pictureTxtView);
                    int check = pictures.get(pos).getCheck();
                    if(check == 1) {
                        txtView.animate()
                                .rotationYBy(180)
                                .rotationY(90)
                                .setDuration(200)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        txtView.animate()
                                                .rotationYBy(90)
                                                .rotationY(0)
                                                .setDuration(200)
                                                .setListener(new AnimatorListenerAdapter() {
                                                    @Override
                                                    public void onAnimationStart(Animator animation) {
                                                        adapter.setImage(pos, pictures.get(pos).getDisplay());
                                                    }

                                                    @Override
                                                    public void onAnimationEnd(Animator animation) {
                                                        selectedPos.add(pos);
                                                        if (selectedPos.size() == 2) {
                                                            int pos1 = selectedPos.get(0);
                                                            int pos2 = selectedPos.get(1);
                                                            if(pos1 != pos2) {
                                                                String display = pictures.get(pos1).getTag();
                                                                String display2 = pictures.get(pos2).getTag();
                                                                Log.e("display1", display);
                                                                Log.e("display2", display2);
                                                                if (display.equals(display2)) {
                                                                    Toast.makeText(PictureActivity.this, "맞췄습니다!", Toast.LENGTH_SHORT).show();
                                                                    adapter.update(pos1, 2);
                                                                    adapter.update(pos2, 2);
                                                                } else {
                                                                    adapter.update(pos1, 0);
                                                                    adapter.update(pos2, 0);
                                                                }
                                                            } else {
                                                                adapter.update(pos1, 0);
                                                            }
                                                            selectedPos.removeAllElements();
                                                            selectedPos.clear();
                                                        }
                                                    }
                                                })
                                                .start();
                                    }
                                })
                                .start();
                    }
                    break;
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean b) {

        }
    };

    private void setCount3() {
        binding.count3TxtView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(this::setCount2, 1000);
    }
    private void setCount2() {
        binding.count3TxtView.setVisibility(View.GONE);
        binding.count2TxtView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(this::setCount1, 1000);

    }
    private void setCount1() {
        binding.count2TxtView.setVisibility(View.GONE);
        binding.count1TxtView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(this::start, 1000);

    }

    private void start() {
        binding.count1TxtView.setVisibility(View.GONE);
        binding.startTxtView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            binding.startTxtView.setVisibility(View.GONE);
            binding.pictureViews.addOnItemTouchListener(onItemTouchListener);
            adapter.setStartAnimate(true);
        }, 1000);

    }
}
