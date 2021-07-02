package com.example.eva3_15_handler_banner_async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView imgBanner;
    SeekBar seekBar;
    int[] arrayImg;
    int vel;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vel = 100;
        seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vel = 100 + progress*8;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imgBanner= findViewById(R.id.imgBannerSiegfried);
        arrayImg = new int[]{
                R.drawable.siegfried,
                R.drawable.parsifal,
                R.drawable.rheingold
        };
        clase clase = new clase();
        clase.execute();
    }

    class clase extends AsyncTask<Integer,String,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            imgBanner.setImageResource(arrayImg[cont]);
            if (cont < 2)
                cont++;
            else
                cont = 0;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            publishProgress("");
            while (true){
                try {
                    Thread.sleep(vel);
                    onProgressUpdate("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}