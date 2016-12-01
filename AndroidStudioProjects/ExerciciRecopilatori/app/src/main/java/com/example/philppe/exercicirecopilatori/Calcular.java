package com.example.philppe.exercicirecopilatori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Calcular extends AppCompatActivity {
    private TextView tZona;
    private DestiZona desti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);
        tZona=(TextView)findViewById(R.id.lZona);
        TextView preuZona =(TextView)findViewById(R.id.lPreu);
        TextView tarifa=(TextView)findViewById(R.id.tTarifa);
        TextView complement=(TextView)findViewById(R.id.tDecoracio);
        TextView complement1=(TextView)findViewById(R.id.tDecoracio2);
        TextView pes=(TextView)findViewById(R.id.lPreu);
        TextView preuPes=(TextView)findViewById(R.id.tPes);
        TextView tcost =(TextView)findViewById(R.id.tCost);
        Button recalcular=(Button)findViewById(R.id.button2);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.inici:
                Intent inicio=new Intent (Calcular.this, MainActivity.class);
                startActivity(inicio);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
