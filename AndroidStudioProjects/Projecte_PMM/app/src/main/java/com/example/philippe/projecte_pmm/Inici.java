package com.example.philippe.projecte_pmm;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Inici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);
        Button spinner =(Button)findViewById(R.id.bsp);

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana=new Intent(Inici.this,Spinner.class);
                startActivity(ventana);

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }
 /*   private void rellenar(){
    String name="";
     idUser.setText(getIntent().getStringExtra("nom"));
    Toast toast1 = Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT);
    toast1.show();
}*/


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                DialogFragment newFragment = MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");
                newFragment.show(getFragmentManager(), "dialog");
                //  Intent acerca=new Intent (Inici.this, Info.class);
                // acerca.putExtra("nom",idUser.getText().toString());
                // acerca.putExtra("pass",idPass.getText().toString());

                // startActivity(acerca);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}





