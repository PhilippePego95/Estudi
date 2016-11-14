package com.example.philppe.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Titol[] dades;

    public MainActivity() {
        dades = new Titol[]{
                new Titol("Eric", "Nadal", R.drawable.img),
                new Titol("Ari", "Perez", R.drawable.img),
                new Titol("Marc", "Carrio",R.drawable.img)
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adaptador = new Adaptador(this);
        ListView opcions =(ListView)findViewById(R.id.llista);
        opcions.setAdapter(adaptador);

        opcions.setOnItemClickListener(new AdapterView.OnClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Titulo: " + dades[position].getTitol() + ".Subtitulo: " + dades[position].getSubTitol();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    public class Adaptador extends ArrayAdapter{


}


    }
}