package com.example.eva2_7_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent (this,MainActivity2.class);
    }

    public void OnClick(View v) {
        MiClase miClase=new MiClase();
        miClase.setParam1(100);
        miClase.setParam2(200);
        //Bundles
        Bundle bundle= new Bundle();
        bundle.putString("MENSAJE","HOLA MUNDO CRUEL");
        bundle.putInt("EDAD",100);
        bundle.putBoolean("EMPLEADO",true);
        bundle.putSerializable("PRUEBA",miClase);
        ///bundle.put
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
class  MiClase implements Serializable {
    private int param1;
    private int param2;

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }
}