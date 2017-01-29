package com.example.philippe.basedades;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Inici extends AppCompatActivity {
    String marcass;
    String marcasel;
    private Marca[] dades;
    public ArrayList<Marca> marcas = new ArrayList<Marca>();

    private Model[] dades2;
    public ArrayList<Model> models = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);
        ImageButton factura = (ImageButton) findViewById(R.id.factura);


        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factura = new Intent(Inici.this, Factura.class);
                // ventana.putExtra("nom",et1.getText().toString());
                //ventana.putExtra("pass",et2.getText().toString());
                startActivity(factura);
            }
        });


        BaseDadesCotxe admin = new BaseDadesCotxe(Inici.this, "DBCOTXES.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        //spinner de marca
        if (db != null) {
            String[] camps = new String[]{"model"};

            //Les dos formes de consulta funcionen

            //Cursor c = db.rawQuery("SELECT  codi,model from MARCA",null);
            Cursor c = db.query("MARCA", camps, null, null, null, null, null);
            dades = new Marca[c.getCount()];
            int i = 0;
            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {

                    marcass = c.getString(0);

                    dades[i] = new Marca(marcass);

                    i++;

                } while (c.moveToNext());
            }
            AdaptadorMarca adaptador = new AdaptadorMarca(this);
            Spinner spinerMarca = (Spinner) findViewById(R.id.marca);
            spinerMarca.setAdapter(adaptador);


            spinerMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                    String missatge = "Marca: " + dades[position].getModel();
                    marcasel = dades[position].getModel();
                    Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();


                        BaseDadesCotxe admin=new BaseDadesCotxe(Inici.this,"DBCOTXES.db",null,1);
                        SQLiteDatabase db=admin.getWritableDatabase();
                        //spinner de model
                        if (db != null) {
                            String[] camps = new String[] {"model", "preu"};

                            Cursor c = db.rawQuery("SELECT  model,preu from COTXE where marca='"+marcasel+"'",null);
                            // Cursor c = db.query("COTXE", camps, null, null, null, null, null);
                            dades2=new Model[c.getCount()];
                            int i=0;
                            //Nos aseguramos de que exista al menos un registro
                            if (c.moveToFirst()) {
                                //Recorremos el cursor hasta que no haya más registros
                                do {
                                    String model = c.getString(0);
                                    String preu = c.getString(1);
                                    String preu2=preu+"€";
                                    dades2[i]= new Model(model,preu2);

                                    i++;

                                } while (c.moveToNext());
                            }
                            AdaptadorModel adapt = new AdaptadorModel(Inici.this);
                            Spinner spinerModel = (Spinner) findViewById(R.id.model);
                            spinerModel.setAdapter(adapt);
                            //.setAdapter(adaptador);

                            spinerModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                                    String missatge = "Model: " + dades2[position].getModel() + ", Preu: " + dades2[position].getPreu();
                                    Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();
                                }

                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }
                }
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //Cerramos la base de datos
            db.close();
        } //del if*/

    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                DialogFragment newFragment = MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");
                newFragment.show(getFragmentManager(), "dialog");

                return true;
            case R.id.nmarca:
                Intent ven=new Intent(Inici.this,NouMarca.class);
                startActivity(ven);MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");

                return true;
             case R.id.nmodel:
                 Intent ven2=new Intent(Inici.this,NouModel.class);
                 startActivity(ven2);MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }




  public class AdaptadorMarca extends ArrayAdapter {

        Activity context;

      AdaptadorMarca(Activity context) {

            super(context, R.layout.activity_marca, dades);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_marca, null);


            TextView marca = (TextView) item.findViewById(R.id.marca);
            marca.setText(dades[i].getModel());


            return (item);
        }
    }


  public class AdaptadorModel extends ArrayAdapter {

        Activity context;

      AdaptadorModel(Activity context) {

            super(context, R.layout.activity_model, dades2);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_model, null);

            TextView model = (TextView) item.findViewById(R.id.model);
            model.setText(dades2[i].getModel());

            TextView preu = (TextView) item.findViewById(R.id.preu);
            preu.setText(dades2[i].getPreu());


            return (item);
        }
    }
}
