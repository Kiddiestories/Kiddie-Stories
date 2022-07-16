package com.example.kiddiestories;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.kiddiestories.classes.GlobalVariables;
import com.example.kiddiestories.classes.MpClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    TextView tvWelcome;
    LinearLayout layout;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    MediaPlayer mediaPlayer, pop;
    GlobalVariables globalVariables;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout = findViewById(R.id.bg);


        globalVariables = (GlobalVariables) this.getApplication();
        tvWelcome = findViewById(R.id.tvWelcome);

        mediaPlayer = MediaPlayer.create(this, R.raw.bgmusic);
        mediaPlayer.setLooping(true);
        if (mediaPlayer.isPlaying()) {

        } else {
            //TODO add music
            mediaPlayer.start();
        }

        startMusic();

        if (name != null) {
            tvWelcome.setText("Welcome " + name);
        } else {
           showDialog();
        }


//        progressDialog = new ProgressDialog(this);
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance().getReference("users");

//        getUser();

    }

//    public void getUser() {
//
//        progressDialog.setMessage("Please wait...");
//        progressDialog.setTitle("Getting data...");
//        progressDialog.setCanceledOnTouchOutside(false);
//        progressDialog.show();
//        Query checkUser = databaseReference.orderByChild("email");
//
//        String email = firebaseUser.getEmail();
//
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String _email = email.replace(".com", "");
//                String gEmail = snapshot.child(_email).child("email").getValue(String.class);
//                String fname = snapshot.child(_email).child("fname").getValue(String.class);
//                String lname = snapshot.child(_email).child("lname").getValue(String.class);
//
//                tvWelcome.setText("WELCOME\n" + fname + " " + lname);
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                progressDialog.dismiss();
//            }
//        });
//    }

    public void startMusic() {
        pop = MediaPlayer.create(this, R.raw.pop);
    }

    public void profile(View view) {
        Intent intent = new Intent(MainActivity2.this, profile.class);
        startActivity(intent);
    }

    public void stories(View view) {
        pop.start();
        Intent intent = new Intent(MainActivity2.this, AllStories.class);
        startActivity(intent);
        pop.start();
    }

    public void favorites(View view) {
        pop.start();
        mediaPlayer.pause();
        Intent intent = new Intent(MainActivity2.this, MainActivity14.class);
        startActivity(intent);
    }

    public void quiz(View view) {
        pop.start();
        Intent intent = new Intent(MainActivity2.this, QuizListActivity.class);
        startActivity(intent);
    }


    public void scores(View view) {
        Intent intent = new Intent(MainActivity2.this, ScoreBoardActivity.class);
        startActivity(intent);
    }

    public void dictionary(View view) {
        pop.start();
        Intent intent = new Intent(MainActivity2.this, DictionaryActivity.class);
        startActivity(intent);
    }

    public void test(View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_name);
        dialog.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.show();

        EditText etName = dialog.findViewById(R.id.etName);
        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    tvWelcome.setText("Welcome " + etName.getText().toString());
                    globalVariables.setName(etName.getText().toString());
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mediaPlayer.isPlaying()) {

        } else {
            //TODO add music
            mediaPlayer.start();
        }
    }
}
