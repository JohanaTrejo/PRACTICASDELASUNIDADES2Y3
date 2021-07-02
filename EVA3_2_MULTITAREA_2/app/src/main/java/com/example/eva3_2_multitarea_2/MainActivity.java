package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //thread --> clase para crear hilos
        //clase thread -->metodo run es generico
        //crear propia clase que herede un theard
        //crear clase anonima

        Thread miHilo= new Thread(){
            //aqui van las tareas en segundos
            @Override
            public void run() {
                super.run();
                for (int i=0; i<10; i++){
                    try {
                        Thread.sleep(100);
                        Log.wtf("HILO PRINCIPAL","i = "+(i+1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        miHilo.start();//iniciamos el hilo de ejecucion
        MiHilote miHilote= new MiHilote();
        //miHilote.run();//llamada a funcion dentro del hilo principal 
        miHilote.start();

        }

    }
class MiHilote extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                Log.wtf("HILO MiHilote", "i = " + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
