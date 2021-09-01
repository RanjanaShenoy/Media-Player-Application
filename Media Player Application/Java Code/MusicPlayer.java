package com.example.allinoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayer extends AppCompatActivity {
    MediaPlayer music;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        music=MediaPlayer.create(this,R.raw.faded);

        homeBtn=findViewById(R.id.backbtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back_home=new Intent(MusicPlayer.this,MainActivity.class);
                startActivity(intent_back_home);
            }
        });
    }

    public void musicplay(View v)
    {
        music.start();
    }

    public void musicpause(View v)
    {
        music.pause();
    }


    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(this, R.raw.faded);
    }
}
