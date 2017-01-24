package com.example.philippe.projecte_pmm;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;
import android.widget.Spinner;


public class Registre extends AppCompatActivity {
    EditText user,pass,passAd;
    Spinner classes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        user=(EditText) findViewById(R.id.nuser);
        pass=(EditText) findViewById(R.id.npass);
        passAd=(EditText) findViewById(R.id.passAdmin);
        classes=(Spinner) findViewById(R.id.spinnerClass);

        Button gurdar=(Button) findViewById(R.id.nguardar);
        final RadioButton alumne = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton profe = (RadioButton) findViewById(R.id.radioButton2);
        passAd.setVisibility(View.INVISIBLE);
        classes.setVisibility(View.INVISIBLE);


        alumne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passAd.setVisibility(View.INVISIBLE);
                classes.setVisibility(View.VISIBLE);

            }
        });
        profe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passAd.setVisibility(View.VISIBLE);
                classes.setVisibility(View.INVISIBLE);

            }
        });
        gurdar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper admin=new DBHelper(Registre.this,"instituto",null,1);
                SQLiteDatabase db=admin.getWritableDatabase();

                String usuari=user.getText().toString();
                String contrasenya=pass.getText().toString();

        /* ContentValues values=new ContentValues();
            values.put("usuario",usuari);
            values.put("contrasena",contrasenya);
        */

                db.execSQL("insert into usuarios (usuario, contrasena) values('"+usuari+"','"+contrasenya+"')");
                db.close();
                Toast toast1 = Toast.makeText(getApplicationContext(),"Guardant...", Toast.LENGTH_SHORT);
                toast1.show();
                Intent ven=new Intent(Registre.this,MainActivity.class);
                startActivity(ven);
            }
        });

    }
}
