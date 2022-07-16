package com.example.kiddiestories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class s10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s10);
        ImageView iv = findViewById(R.id.iv);
        Glide.with(this).load(R.drawable.s10).into(iv);
    }
}