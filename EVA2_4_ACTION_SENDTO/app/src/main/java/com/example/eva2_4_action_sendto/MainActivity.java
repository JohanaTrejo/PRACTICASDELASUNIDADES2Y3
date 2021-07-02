package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {
    EditText edtTxtMensa,edtTxtNotel;
    Button btnenviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtMensa=findViewById(R.id.edtTxtMensa);
        edtTxtNotel=findViewById(R.id.edtTxtNoTel);
        btnenviar=findViewById(R.id.btnenviar);
        btnenviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String sTel,sMensa;

        sTel= "smsto"+ edtTxtNotel.getText().toString();
        sMensa=edtTxtMensa.getText().toString();

        Intent intent= new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        intent.putExtra("sms_body",sMensa);
        startActivity(intent);

    }
}