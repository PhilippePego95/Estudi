package com.example.mati.basededatosspinner;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Cliente[] datos;
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();


        //En caso de abrir de forma correcta la base de datos
        if (bd != null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES ('" + codigo + "', '" + nombre + "', '" + telefono + "')");
            }


        		//Ejemplo Select2
                String[] campos = new String[] {"nombre", "telefono"};
        		Cursor c = bd.query("Clientes", campos, null, null, null, null, null);
                datos=new Cliente[c.getCount()];
                int i=0;
        		//Nos aseguramos de que exista al menos un registro
        		if (c.moveToFirst()) {
        			//Recorremos el cursor hasta que no haya más registros
        			do {
        				String nombreCli = c.getString(0);
        				String telefonoCli = c.getString(1);

                        datos[i]= new Cliente(nombreCli,telefonoCli);

                        i++;

        			} while (c.moveToNext());
        		}

            AdaptadorClientes adaptador = new AdaptadorClientes(this);
            Spinner clientes = (Spinner) findViewById(R.id.clientes);
            clientes.setAdapter(adaptador);


            clientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                    String mensaje = "Nombre: " + datos[position].getNombre() + ", Telefono: " + datos[position].getTelefono();
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                }

                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //Cerramos la base de datos
            bd.close();
        } //del if
    }

    public class AdaptadorClientes extends ArrayAdapter {

        Activity context;

        AdaptadorClientes(Activity context) {

            super(context, R.layout.activity_cliente, datos);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_cliente, null);

            TextView nombre = (TextView) item.findViewById(R.id.nombre);
            nombre.setText(datos[i].getNombre());

            TextView tele = (TextView) item.findViewById(R.id.telefono);
            tele.setText(datos[i].getTelefono());


            return (item);
        }
    }
}
