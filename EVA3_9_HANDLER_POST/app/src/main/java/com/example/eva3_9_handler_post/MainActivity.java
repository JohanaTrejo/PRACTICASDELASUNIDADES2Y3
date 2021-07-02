package com.example.eva3_9_handler_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwNombre;

    Handler handler=new Handler();

    //trabajo pesado
    Runnable background= new Runnable() {
        @Override
        public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                handler.post(foreground);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        }
    };
    Runnable foreground= new Runnable() {
        @Override
        public void run() {
            txtVwNombre.append("hola mundo!! \n");
        }
    };
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwNombre=findViewById(R.id.txtVwNombre);
        Thread thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}