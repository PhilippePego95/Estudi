package com.example.philippe.basedades;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class Inici extends AppCompatActivity {
    String cotxe="cotxe1.db";
    String depos=" ";
    String gp=" ";
    Integer Pgps=0;
    Integer Pdeposit=0;
    String seguro =" ";
    Integer Psegur=0;
    private String dmodel,dpreu,marcass,marcasel,nombre;
    private Marca[] dades;
    public ArrayList<Marca> marcas = new ArrayList<Marca>();
    TextView dies;
    private RadioButton segurcomplet,segur;
   private CheckBox deposit, gps;
    private Model[] dades2;
    public ArrayList<Model> models = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);
        ImageButton factura = (ImageButton) findViewById(R.id.factura);

         deposit =(CheckBox) findViewById(R.id.deposit);
         gps =(CheckBox) findViewById(R.id.gps);
         segurcomplet =(RadioButton) findViewById(R.id.segurcomplet);
         segur =(RadioButton) findViewById(R.id.segur);
         dies =(TextView)findViewById(R.id.nudies);
        TextView usu=(TextView)findViewById(R.id.idsu);

        SharedPreferences prefs =getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        nombre = prefs.getString("nombre", "nombre_por_defecto");
        	Log.i("Preferences", "Nombre: " + nombre);
            usu.setText(nombre);

        segur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seguro = "Segur a tercers";
                Psegur=0;
            }
        });
         segurcomplet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seguro = "Segur a tot risc";
                Psegur=60;
            }
        });
        factura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent factura = new Intent(Inici.this, Factura.class);
                factura.putExtra("segur",seguro);
                String dadescotxe= marcasel+" "+dmodel+" "+dpreu;


                String ndies =dies.getText().toString();
                int preuCotxe = Integer.parseInt(dpreu);
               // int preuDeposit=Pdeposit;
                int numdies=0;
                try {
                numdies=Integer.parseInt(ndies);
                }catch (Exception e){

                }
                if (deposit.isChecked()){
                    //Codigo si el boton esta marcado
                    depos = "Deposit ple";
                    Pdeposit=60;
                }
                if (gps.isChecked()){
                    //Codigo si el boton esta marcado
                    gp = "GPS";
                    Pgps=20;
                }
               // int preuSegur=Psegur;
              //  int preuGPS=Pgps;



                int  total = ((preuCotxe + Psegur) * numdies + Pdeposit + Pgps);
                factura.putExtra("dadesmarca",dadescotxe);
                String sumaTotal=String.valueOf(total);

                factura.putExtra("temps",ndies);


                factura.putExtra("total",sumaTotal);
                factura.putExtra("deposit",depos);
                factura.putExtra("pdeposit",Pdeposit);

                factura.putExtra("gps",gp);

                startActivity(factura);

                BaseDadesCotxe admin=new BaseDadesCotxe(Inici.this,cotxe,null,1);
                SQLiteDatabase db=admin.getWritableDatabase();

               // String nom=name.getText().toString();
               // String usuari=user.getText().toString();
               // String pwd=pass.getText().toString();
                       //             "ID,usuari,dades,preutotal
                db.execSQL("INSERT INTO FACTURA (usuari,dades,preutotal)values('"+nombre+"','"+dadescotxe+"','"+sumaTotal+"')");
                db.close();
            }
        });


        BaseDadesCotxe admin = new BaseDadesCotxe(Inici.this, cotxe, null, 1);
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
                   // Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();


                        BaseDadesCotxe admin=new BaseDadesCotxe(Inici.this,cotxe,null,1);
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

                                    dades2[i]= new Model(model,preu);

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
                                 //   Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_LONG).show();
                                    dmodel= dades2[position].getModel();
                                    dpreu=dades2[position].getPreu();
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
             case R.id.keyss:
                 Intent lloguers=new Intent(Inici.this,Llistat.class);
                 startActivity(lloguers);MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");

                return true;
             case R.id.dell:
                 Intent delete=new Intent(Inici.this,Delete.class);
                 startActivity(delete);MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");

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
