package com.example.eva3_18_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,MyService.class);
    }
    public void iniciarServicio(View v){
        startService(intent);
        Log.wtf("Servicio" ,"onCreate");
        
    }
    public void detenerServicio(View v){
        stopService(intent);

    }
}