package com.example.digitalmedic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Vector;

import com.example.digitalmedic.R;
import com.example.digitalmedic.databinding.ActivityGameItemBinding;



public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    Vector<Picture> pictures = new Vector<>();
    private Activity activity;
    private Context context;
    private int width = 0, height = 0;
    private boolean startAnimate = false;

    PictureAdapter(Activity activity) {
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityGameItemBinding binding = ActivityGameItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ActivityGameItemBinding binding = holder.binding;

        if (height != 0 && width != 0) {
            binding.pictureLayout.getLayoutParams().width = width;
            binding.pictureLayout.getLayoutParams().height = height;
        }

        final Picture picture = pictures.get(position);
        int check = picture.getCheck();
        binding.pictureTxtView.setImageDrawable(ContextCompat.getDrawable(context, picture.getDisplay()));
        Log.e("check[" + position + "] = ", String.valueOf(check));
        if(check == 0 && startAnimate) {
            binding.pictureTxtView.animate()
                    .rotationY(90)
                    .setDuration(200)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            binding.pictureTxtView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.white_bg));
                            binding.pictureTxtView.animate()
                                    .rotationYBy(90)
                                    .rotationY(180)
                                    .setDuration(200)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            picture.setCheck(1);
                                        }
                                    })
                                    .start();
                        }
                    })
                    .start();
        } else if (check == 2) {
            binding.pictureTxtView.setBackgroundColor(Color.BLACK);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    void setImage(int pos, int image) {
        pictures.get(pos).setDisplay(image);
        notifyItemChanged(pos);
    }

    void setUpPicture(Vector<Picture> pictures) {
        this.pictures = pictures;
        notifyDataSetChanged();
    }

    void setLength(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void setStartAnimate(boolean startAnimate) {
        this.startAnimate = startAnimate;
        notifyDataSetChanged();
    }

    void update(int pos, int check) {
        pictures.get(pos).setCheck(check);
        notifyItemChanged(pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ActivityGameItemBinding binding;

        ViewHolder(ActivityGameItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}

