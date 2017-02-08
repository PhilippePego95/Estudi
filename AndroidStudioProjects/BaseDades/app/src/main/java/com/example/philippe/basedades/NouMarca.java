package com.example.philippe.basedades;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NouMarca extends AppCompatActivity {
    String cotxe="cotxe5.db";

    private Marca[] dades;
    public ArrayList<Marca> marcas = new ArrayList<Marca>();
   private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_marca);
         name = (EditText) findViewById(R.id.nmarcas);
        ImageButton back =(ImageButton) findViewById(R.id.marcainici);


        Button guardar= (Button) findViewById(R.id.guardarMarca);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent back=new Intent(NouMarca.this,Inici.class);
                startActivity(back);
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDadesCotxe admin=new BaseDadesCotxe(NouMarca.this,cotxe,null,1);
                SQLiteDatabase db=admin.getWritableDatabase();
                String nom=name.getText().toString();
                db.execSQL("INSERT INTO MARCA values('"+nom+"')");
                db.close();
                Toast toast1 = Toast.makeText(getApplicationContext(),"Nova marca creada...", Toast.LENGTH_SHORT);
                toast1.show();

                Intent ventana=new Intent(NouMarca.this,Inici.class);
                startActivity(ventana);
            }
        });
        BaseDadesCotxe admin=new BaseDadesCotxe(NouMarca.this,cotxe,null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
            //spinner de marca
        if (db != null) {
                String[] camps = new String[] {"model"};

            //Les dos formes de consulta funcionen

            //Cursor c = db.rawQuery("SELECT  codi,model from MARCA",null);
            Cursor c = db.query("MARCA", camps, null, null, null, null, null);
                dades=new Marca[c.getCount()];
                int i=0;
	                //Nos aseguramos de que exista al menos un registro
        		if (c.moveToFirst()) {
        			//Recorremos el cursor hasta que no haya más registros
        			do {
        				 String marcass = c.getString(0);

                        dades[i]= new Marca(marcass);

                        i++;

        			} while (c.moveToNext());
        		}
            AdaptadorMarca adaptador = new AdaptadorMarca(this);
            ListView spinerMarca =(ListView)findViewById(R.id.spinnerMarca );
            // Spinner spinerMarca = (Spinner) findViewById(R.id.spinnerMarca );
            spinerMarca.setAdapter(adaptador);
                    //.setAdapter(adaptador);

            spinerMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                    String missatge = "Marca: " + dades[position].getModel();
                    Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();
                }

                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        //Cerramos la base de datos
            db.close();
        } //del if*
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

}
