package com.example.philippe.basedades;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Registre extends AppCompatActivity {
    String cotxe="cotxe1.db";

    EditText user,pass,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        name=(EditText) findViewById(R.id.nname);
        user=(EditText) findViewById(R.id.nuser);
        pass=(EditText) findViewById(R.id.npass);
        Button gurdar=(Button) findViewById(R.id.nguardar);



        gurdar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDadesCotxe admin=new BaseDadesCotxe(Registre.this,cotxe,null,1);
                SQLiteDatabase db=admin.getWritableDatabase();

                String nom=name.getText().toString();
                String usuari=user.getText().toString();
                String pwd=pass.getText().toString();

                db.execSQL("INSERT INTO USER values('"+usuari+"','"+nom+"','"+pwd+"')");
                db.close();
                Toast toast1 = Toast.makeText(getApplicationContext(),"Guardant usuari...", Toast.LENGTH_SHORT);
                toast1.show();
                Intent ven=new Intent(Registre.this,MainActivity.class);
                startActivity(ven);
            }
        });

    }
}
