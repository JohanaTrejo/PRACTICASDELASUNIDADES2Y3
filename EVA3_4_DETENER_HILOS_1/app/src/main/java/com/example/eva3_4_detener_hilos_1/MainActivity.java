package com.example.eva3_4_detener_hilos_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread infinito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread infinito = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    int i = 0;
                    Log.wtf("HILO INFINITO", "i=" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;

                }
            }
        };
        infinito.start();
        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        infinito.interrupt();
    }
}
