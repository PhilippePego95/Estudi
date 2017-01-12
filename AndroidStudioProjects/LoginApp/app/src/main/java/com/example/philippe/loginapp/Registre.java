package com.example.philippe.loginapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registre extends AppCompatActivity {
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        user=(EditText) findViewById(R.id.nuser);
        pass=(EditText) findViewById(R.id.npass);
        Button gurdar=(Button) findViewById(R.id.nguardar);


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
