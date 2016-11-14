package com.example.philppe.exercicirecopilatori;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujar);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.inici:
                Intent inicio=new Intent (Dibujar.this, MainActivity.class);
                startActivity(inicio);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
