package com.example.eva3_11_handler_banner_post_slide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgLoadImgPost;
    Thread thread;
    Handler handler = new Handler();
    Bitmap bitmap;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            imgLoadImgPost.setImageBitmap(bitmap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLoadImgPost = findViewById(R.id.imgLoadImgPost);
        thread = new Thread(){
            @Override
            public void run() {
                super.run();
                bitmap = decscargar("https://upload.wikimedia.org/wikipedia/commons/9/9d/RichardWagner.jpg");
                handler.post(runnable);
            }
        };
        thread.start();
    }
    private Bitmap decscargar(String url){
        try {
            InputStream inputStream = (InputStream)new URL(url).getContent();
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
            return bitmap1;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}