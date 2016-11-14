package com.example.philppe.menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.primer_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
           // Log.i("ActionBar", "Settings!");
           // Intent about = new Intent(getApplicationContext(), About.class);
           // startActivity(about);
           // return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

