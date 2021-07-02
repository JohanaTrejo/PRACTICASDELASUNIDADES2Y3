package com.example.eva3_16_load_image_post_asynctask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgAsync;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAsync = findViewById(R.id.imgAsync);
        clase clase = new clase();
        clase.execute();
    }
    private Bitmap download(){
        try {
            InputStream inputStream = (InputStream)new URL("https://upload.wikimedia.org/wikipedia/commons/9/9d/RichardWagner.jpg").getContent();
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
            return bitmap1;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
            imgAsync.setImageBitmap(bitmap);

        }

        @Override
        protected Void doInBackground(Integer... integers) {
            bitmap = download();
            publishProgress("");
            return null;
        }
    }
}