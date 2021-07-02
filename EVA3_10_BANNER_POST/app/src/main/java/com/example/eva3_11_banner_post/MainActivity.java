package com.example.eva3_11_banner_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
ImageView imgBanner;
Thread thread;
SeekBar seekBar;
int[] img;
int vel;
int cont = 0;

Handler handler = new Handler();
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        imgBanner.setImageResource(img[cont]);
        if (cont<2){
            cont++;
        }else {
            cont = 0;
        }
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vel = 100;
        seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                vel=100+i*8;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imgBanner=findViewById(R.id.imgBanner);
        thread=new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(vel);
                        handler.post(runnable);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        img=new int[]{
                R.drawable.parsifal,
                R.drawable.siegfried,
                R.drawable.rheingold
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}