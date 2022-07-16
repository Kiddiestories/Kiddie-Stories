package com.example.kiddiestories.classes;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.kiddiestories.R;

public class MpClass {
    Context context;
    MediaPlayer mediaPlayer;


    public void initializeBG() {
        mediaPlayer = new MediaPlayer();
    }

    public void playBG(Context context) {

        mediaPlayer = MediaPlayer.create(context, R.raw.bgmusic);
        mediaPlayer.setLooping(true);
        if (mediaPlayer.isPlaying()) {

        } else {
            //TODO add music
            mediaPlayer.start();
        }
    }

    public void pauseBG(Context context) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            //TODO add music

        }
    }
}
