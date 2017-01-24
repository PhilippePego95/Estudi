package com.example.philippe.projecte_pmm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {

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

        Entrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nom =et1.getText().toString();
                String pw=et2.getText().toString();



                DBHelper admin=new DBHelper(MainActivity.this,"instituto",null,1);
                SQLiteDatabase db=admin.getWritableDatabase();


                fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+nom+"' and  contrasena='"+pw+"'",null);
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
                        ventana.putExtra("nom",et1.getText().toString());
                        ventana.putExtra("pass",et2.getText().toString());

                        startActivity(ventana);
                        Toast toast1 = Toast.makeText(getApplicationContext(),"entrant...", Toast.LENGTH_SHORT);
                        toast1.show();
                        //limpiamos las las cajas de texto
                      //  et1.setText("");
                       // et2.setText("");
                    }
                }else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),"error...", Toast.LENGTH_SHORT);
                    toast1.show();

                }
            }
        });
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               // Intent ven=new Intent(MainActivity.this,Fragment.class);

           }
        });
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ven=new Intent(MainActivity.this,Registre.class);
                startActivity(ven);
            }
        });
    }
}



