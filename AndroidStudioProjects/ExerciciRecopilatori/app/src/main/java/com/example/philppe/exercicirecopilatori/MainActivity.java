package com.example.philppe.exercicirecopilatori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Acerca:
                Intent acerca=new Intent (MainActivity.this, Acerca.class);
                startActivity(acerca);
                return true;
            case R.id.dibuix:
                Intent dibuixar=new Intent (MainActivity.this, Dibujar.class);
                startActivity(dibuixar);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
