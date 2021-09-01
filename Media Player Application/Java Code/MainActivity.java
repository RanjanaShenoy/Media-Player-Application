package com.example.allinoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton gallerybtn;
    ImageButton musicbtn;
    Button aboutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallerybtn=findViewById(R.id.gallery);
        gallerybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Camera.class);
                startActivity(intent);
            }
        });

        musicbtn=findViewById(R.id.music);
        musicbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmusic=new Intent(MainActivity.this,MusicPlayer.class);
                startActivity(intentmusic);
            }
        });

        aboutbtn=findViewById(R.id.btnabt);
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentabout=new Intent(MainActivity.this,Aboutus.class);
                startActivity(intentabout);
            }
        });
    }
}