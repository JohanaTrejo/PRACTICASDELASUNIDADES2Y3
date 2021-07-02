package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtNom,edtTxtSal;
   CheckBox chkboxInfo;
   RadioGroup rdGrpEdoCivil;
   Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,Secundaria.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTxtNom=findViewById(R.id.edtTxtNom);
        edtTxtSal=findViewById(R.id.edtTxtSal);
        chkboxInfo=findViewById(R.id.chkboxInfo);
        rdGrpEdoCivil=findViewById(R.id.rdGrpEdoCivil);


    }

    public void onClick(View v){
        intent.putExtra("NOMBRE",edtTxtNom.getText().toString());
       Double dSalario= 0.0;
       dSalario=Double.parseDouble(edtTxtSal.getText().toString());
        intent.putExtra("SALARIO",dSalario);
        intent.putExtra("INFO",chkboxInfo.isChecked());
        intent.putExtra("ESTADO CIVIL",rdGrpEdoCivil.getCheckedRadioButtonId());

        startActivity(intent);


    }
}