package com.example.eva3_5_hilos_vs_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensaje;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensaje=findViewById(R.id.txtVwMensaje);
        // txtVwMensaje.setText("HOLA MUNDO CRUEL!!!");
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true){
                    try{
                        Thread.sleep(1000);
                        String cade="i=" + i;
                        i++;
                        txtVwMensaje.append(cade + "\n");
                        Log.wtf("runnable",cade);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }

            }
        };
        thread= new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
