package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    Intent intent;
    TextView txtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        intent= getIntent();
        String sNom=intent.getStringExtra("NOMBRE");
        Double dSal=intent.getDoubleExtra("SALARIO",0.0);
        boolean bInfo=intent.getBooleanExtra("INFO",false);
        int iEstado = intent.getIntExtra("ESTADO CIVIL",0);
        TextView txtVwDatos;
        txtVwDatos=findViewById(R.id.txtVwDatos);
        txtVwDatos.append("NOMBRE: \n");
        txtVwDatos.append(sNom +"\n");
        txtVwDatos.append("SALARIO: \n");
        txtVwDatos.append(dSal +"\n");
        txtVwDatos.append("INFORMACION: \n");
        if(bInfo)
            txtVwDatos.append("CON INFORMACION\n");
        else
            txtVwDatos.append("SIN INFORMACION \n");
        //RadioButton rdTemp=findViewById(iEstado);
        txtVwDatos.append("ESTADO CIVIL: \n");
        txtVwDatos.append(iEstado+"\n");

    }
    public void onClickSal (View v){
        finish();

    }
}