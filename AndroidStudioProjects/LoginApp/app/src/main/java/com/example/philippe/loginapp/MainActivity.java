package com.example.philippe.loginapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.etUsuari);
        et2 = (EditText) findViewById(R.id.etContrasenya);
        Button Entrar = (Button) findViewById(R.id.Entrar);


        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=et1.getText().toString();
                String pass=et2.getText().toString();
                Toast.makeText(getApplicationContext(),"Entrant..."+name+" "+pass,Toast.LENGTH_LONG).show();

                DBHelper admin=new DBHelper(MainActivity.this, "instituto",null,1);
                SQLiteDatabase db=admin.getWritableDatabase();
                fila=db.rawQuery("SELECT usuario,contrasenya from usuarios where usuario= '"+name+"' ",null);

        /*      while (fila.moveToFirst()== true){
                    String usua=fila.getString(0);
                   // String pas=fila.getString(1);
                    if (name.equals(usua)){
                       // if (name.equals(usua)&&pass.equals(pas)){
                        Intent menu=new Intent(MainActivity.this, Menu.class);
                        startActivity(menu);
                        et1.setText("");
                        et2.setText("");
                    }else
                        Toast.makeText(getApplicationContext(),"Usuari i contrasenya incorrectes",Toast.LENGTH_LONG).show();

               }*/
            }
        });
    }

}
