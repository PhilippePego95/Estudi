package com.example.philippe.basedades;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String cotxe="cotxe6.db";
    EditText et1,et2;
    private Cursor fila,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.etUsuari);
        et2 = (EditText) findViewById(R.id.etContrasenya);
        Button Entrar = (Button) findViewById(R.id.Entrar);
        Button Salir = (Button) findViewById(R.id.Salir);
        final Button Registrar = (Button) findViewById(R.id.Registrar);
       // DBHelper admin=new DBHelper(MainActivity.this,"Registre.db",null,1);

        Entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nom =et1.getText().toString();
                String pw=et2.getText().toString();


                BaseDadesCotxe admin=new BaseDadesCotxe(MainActivity.this,cotxe,null,1);
                SQLiteDatabase db=admin.getWritableDatabase();


                fila=db.rawQuery("select usuari,pwd from USER where usuari='"+nom+"' and  pwd='"+pw+"'",null);
                //preguntamos si el cursor tiene algun valor almacenado
                if(fila.moveToFirst()==true){

                    //capturamos los valores del cursos y lo almacenamos en variable
                    String usua=fila.getString(0);
                    String pass=fila.getString(1);

                    //preguntamos si los datos ingresados son iguales
                    if (nom.equals(usua)&&pw.equals(pass)){

                        //si son iguales entonces vamos a otra ventana

                        //Menu es una nueva actividad empty
                        Intent ventana=new Intent(MainActivity.this,Inici.class);
                      //  ventana.putExtra("nom",et1.getText().toString());
                       // ventana.putExtra("pass",et2.getText().toString());
                        startActivity(ventana);

                        Toast toast1 = Toast.makeText(getApplicationContext(),"entrant...", Toast.LENGTH_SHORT);
                        toast1.show();
                                         }
                }else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),"error...", Toast.LENGTH_SHORT);
                    toast1.show();

                }
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre", nom);
                editor.putString("pwd", pw);
                editor.commit();
            }
        });
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ven=new Intent(MainActivity.this,Registre.class);
                startActivity(ven);MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");


            }
        });
    }
}
