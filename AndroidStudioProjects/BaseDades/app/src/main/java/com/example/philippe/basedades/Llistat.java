package com.example.philippe.basedades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Llistat extends AppCompatActivity {
    String cotxe="cotxe6.db";

    private LlistaCompres[] dades;
    public ArrayList<LlistaCompres> llistatCompres = new ArrayList<LlistaCompres>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistat);
        ImageButton back =(ImageButton) findViewById(R.id.llistatback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(Llistat.this,Inici.class);
                startActivity(back);
            }
        });
        BaseDadesCotxe admin=new BaseDadesCotxe(Llistat.this,cotxe,null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        //spinner de marca
        if (db != null) {
            String[] camps = new String[] {"ID,usuari,dades,preutotal"};

            //Les dos formes de consulta funcionen
            SharedPreferences prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
            String nombre = prefs.getString("nombre", "nombre_por_defecto");
            Log.i("Preferences", "Nombre: " + nombre);
           // usu.setText(nombre);
            Cursor c = db.rawQuery("SELECT  ID,usuari,dades,preutotal from FACTURA where usuari='"+nombre+"'",null);
           // Cursor c = db.query("FACTURA", camps, null, null, null, null, null);
            dades=new LlistaCompres[c.getCount()];
            int i=0;
            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String codi = c.getString(0);
                    String us = c.getString(1);
                    String cotxe = c.getString(2);
                    String money = c.getString(3);

                    dades[i]= new LlistaCompres(codi,us,cotxe,money);

                    i++;

                } while (c.moveToNext());
            }

            AdaptadorLlista adaptador = new AdaptadorLlista(this);
            ListView llistafactura =(ListView)findViewById(R.id.llistafact );
            // Spinner spinerMarca = (Spinner) findViewById(R.id.spinnerMarca );
            llistafactura.setAdapter(adaptador);
            //.setAdapter(adaptador);

            llistafactura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                    //String missatge = "Marca: " + dades[position].getModel();
                   // Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();
                }

                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //Cerramos la base de datos
            db.close();
        } //del if*
    }
    public class AdaptadorLlista extends ArrayAdapter {

        Activity context;

        AdaptadorLlista(Activity context) {

            super(context, R.layout.activity_llistat_compres, dades);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_llistat_compres, null);


            TextView codi = (TextView) item.findViewById(R.id.codi);
            codi.setText(dades[i].getIdS());

            TextView user = (TextView) item.findViewById(R.id.usuari);
            user.setText(dades[i].getUsuari());

            TextView cotxe = (TextView) item.findViewById(R.id.datos);
            cotxe.setText(dades[i].getDades());

            TextView preu = (TextView) item.findViewById(R.id.preu);
            preu.setText(dades[i].getPreuTotal());

            return (item);
        }
    }

}
