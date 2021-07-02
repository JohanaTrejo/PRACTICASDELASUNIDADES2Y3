 package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
     final static int CODIGO_SECUN=1000;
     final static int CODIGO_CONTACTOS=2000;
     final static int CODIGO_IMAGEN=3000;

    Button btnInSecundaria;
    Intent intent,intentCont,intentImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,Secundaria.class);
        intentCont= new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        intentImg=new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media"));

    }

     @Override
     protected void onStart() {
         super.onStart();
         btnInSecundaria=findViewById(R.id.btnInSecundaria);
         btnInSecundaria.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 intent.putExtra("DATOS","INFORMACION ENVIADA DESDE PRINCIPAL");
                 startActivityForResult(intent,CODIGO_SECUN);


             }
         });
     }
     public void onClickCont(View v){
        startActivityForResult(intentCont,CODIGO_CONTACTOS);
        if(v.getId()== R.id.btnCont)startActivityForResult(intent,CODIGO_CONTACTOS);

        else{
            startActivityForResult(intent,CODIGO_IMAGEN); }

     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         //aqui procesamos la respuesta
         switch (requestCode){
             case CODIGO_SECUN:
                 if(resultCode== Activity.RESULT_OK){
                     Toast.makeText(this,data.getStringExtra("VALOR"),Toast.LENGTH_LONG).show();
                 }
                 break;
             case CODIGO_CONTACTOS:
                 if(resultCode== Activity.RESULT_OK) {
                     String returnData= data.getDataString();
                     Toast.makeText(this,returnData, Toast.LENGTH_LONG).show();

                 }
                 break;
             case CODIGO_IMAGEN:
                 if(resultCode== Activity.RESULT_OK) {
                     String returnData= data.getDataString();
                     Toast.makeText(this,returnData, Toast.LENGTH_LONG).show();

                 }
                 break;
             default:
         }
     }
 }