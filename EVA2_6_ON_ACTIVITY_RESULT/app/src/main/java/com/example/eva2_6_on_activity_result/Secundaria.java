package com.example.eva2_6_on_activity_result;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        intent=getIntent();
        Toast.makeText(this,intent.getStringExtra("DATOS"),Toast.LENGTH_LONG).show();
    }
    public void OnClick(View v){
        intent.putExtra("VALOR","HOLA MUNDO CRUEL!!!");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
    public void OnClickCancel(View w){
        setResult(Activity.RESULT_CANCELED);
        finish();

    }
}