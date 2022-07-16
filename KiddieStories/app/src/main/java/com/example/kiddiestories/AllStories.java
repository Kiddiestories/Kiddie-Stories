package com.example.kiddiestories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllStories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_stories);
    }

    public void s1(View view) {
        startActivity(new Intent(this,s1.class));
    }
    public void s2(View view){
        startActivity(new Intent(this,s2.class));
    }
    public void s3(View view){
        startActivity(new Intent(this,s3.class));
    }
    public void s4(View view){
        startActivity(new Intent(this,s4.class));
    }
    public void s5(View view){
        startActivity(new Intent(this,s5.class));
    }
    public void s6(View view){
        startActivity(new Intent(this,s6.class));
    }
    public void s7(View view){
        startActivity(new Intent(this,s7.class));
    }
    public void s8(View view){
        startActivity(new Intent(this,s8.class));
    }
    public void s9(View view){
        startActivity(new Intent(this,s9.class));
    }
    public void s10(View view){
        startActivity(new Intent(this,s10.class));
    }
}