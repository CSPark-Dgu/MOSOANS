package com.example.finalexam;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class ImageActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        Glide.with(this)
                .load(imageResId)
                .into(imageView);
    }
}