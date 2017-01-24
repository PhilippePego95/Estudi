package com.example.philippe.projecte_pmm;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {

    private Users[] dades;
    public ArrayList<Users> Users = new ArrayList<Users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //Abrimos la base de datos en modo escritura
        DBHelper cliBDh = new DBHelper(this, "instituto", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();


        String[] campos = new String[] {"codigo","usuario", "contrasena"};
       // Cursor c = bd.rawQuery("SELECT codigo, usuario,contrasena FROM usuarios",null);
         Cursor c = bd.query("usuarios", campos, null, null, null, null, null);
        dades=new Users[c.getCount()];
        // datos=new Cliente[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String ids = c.getString(0);
                String nom = c.getString(1);
                String pwd = c.getString(2);

                dades[i]= new Users(ids,nom,pwd);

                i++;

            } while (c.moveToNext());
        }

        AdaptadorClientes adaptador = new AdaptadorClientes(this);
        android.widget.Spinner clientes = (android.widget.Spinner) findViewById(R.id.spinner2);
        clientes.setAdapter(adaptador);




        //Cerramos la base de datos
        bd.close();
    }


public class AdaptadorClientes extends ArrayAdapter {

        Activity context;

        AdaptadorClientes(Activity context) {

            super(context, R.layout.activity_users, dades);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_users, null);

            TextView cod = (TextView) item.findViewById(R.id.cod);
            cod.setText(dades[i].getCod());

            TextView us = (TextView) item.findViewById(R.id.user);
            us.setText(dades[i].getName());

            TextView pw = (TextView) item.findViewById(R.id.pwd);
            pw.setText(dades[i].getPwd());


            return (item);
        }
    }
}