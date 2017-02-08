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

public class Delete extends AppCompatActivity {
    String cotxe="cotxe6.db";
    ListView llista;
    String mod;
    private Marca[] dades;
    public ArrayList<Marca> marcas = new ArrayList<Marca>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        ImageButton back =(ImageButton) findViewById(R.id.backdell);
        Button borrar = (Button) findViewById(R.id.buttonBorrar);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseDadesCotxe admin=new BaseDadesCotxe(Delete.this,cotxe,null,1);
                SQLiteDatabase db1=admin.getWritableDatabase();
                // Cursor c = db1.rawQuery("DELETE MARCA where model='"+mod+"'",null);
                db1.execSQL("DELETE FROM MARCA where model='"+mod+"'");
                db1.close();
                Intent back=new Intent(Delete.this,Inici.class);
                startActivity(back);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent back=new Intent(Delete.this,Inici.class);
                startActivity(back);
            }
        });
        BaseDadesCotxe admin=new BaseDadesCotxe(Delete.this,cotxe,null,1);
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
            Delete.AdaptadorMarca adaptador = new Delete.AdaptadorMarca(this);
             llista=(ListView) findViewById(R.id.listBorrar);
           // Spinner spinerMarca = (Spinner) findViewById(R.id.spinnerBorrar );
            llista.setAdapter(adaptador);

            //Cerramos la base de datos
            db.close();
        } //del if*

    //*****************************************************+
         //String missatge = "Marca: " + dades[position].getModel();
          //          marcasel = dades[position].getModel();
           //         Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();
    llista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            mod  = dades[position].getModel();
            Toast.makeText(getApplicationContext(), mod, Toast.LENGTH_LONG).show();


        }
    });


    //*****************************************************
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
