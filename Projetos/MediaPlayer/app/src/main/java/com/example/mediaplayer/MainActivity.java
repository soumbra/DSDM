package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSound;
    ImageButton imVianna, imIta, imVn, imWs;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSound = findViewById(R.id.btnSound);
        imVianna = findViewById(R.id.iBtnVianna);
        imVn = findViewById(R.id.iBtnVN);
        imIta = findViewById(R.id.iBtnIta);
        imWs = findViewById(R.id.iBtnWs);
        btnSound.setOnClickListener(this);
        imVianna.setOnClickListener(this);
        imVn.setOnClickListener(this);
        imIta.setOnClickListener(this);
        imWs.setOnClickListener(this);
    }

    //Fazer usando dataPath global

    @Override
    public void onClick(View v) {
        /*if (mediaPlayer.isPlaying() == true) {
            mediaPlayer.stop();
        }*/

        if (v == imVianna) {
            //Deve invocar o media Player
            Toast.makeText(this, "Botao forro foi cricado", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.viana);
            mediaPlayer.start();
        } else if (v == imVn) {
            Toast.makeText(this, "Botao forro foi cricado", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.a1);
            mediaPlayer.start();
        } else if (v == imIta) {
            Toast.makeText(this, "Botao forro foi cricado", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.a2);
            mediaPlayer.start();
        } else if (v == imWs) {
            Toast.makeText(this, "Botao forro foi cricado", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.a3);
            mediaPlayer.start();
        }
    }

}