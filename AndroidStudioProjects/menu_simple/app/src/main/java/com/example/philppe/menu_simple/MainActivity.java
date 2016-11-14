package com.example.philppe.menu_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   // final TextView text = (TextView)findViewById(R.id.Mensaje);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.activity_menu, menu);
       return true;
   }
/*
  public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
           case R.id.MnuOpc1:
               Toast toast =Toast.makeText(getApplicationContext(),"Opció 1", Toast.LENGTH_LONG);
               toast.show();
               return true;
           case R.id.MnuOpc2:
               Toast toast2 =Toast.makeText(getApplicationContext(),"Opció 2", Toast.LENGTH_LONG);
               toast2.show();
               return true;
           case R.id.MnuOpc3:
               Toast toast3 =Toast.makeText(getApplicationContext(),"Opció 3", Toast.LENGTH_LONG);
               toast3.show();
               return true;
           case R.id. MnuOpc4:
               Toast toast31 =Toast.makeText(getApplicationContext(),"Submenu: Opcion 1!", Toast.LENGTH_LONG);
               toast31.show();

               return true;
           case R.id. MnuOpc5:
               Toast toast32 =Toast.makeText(getApplicationContext(),"Submenu: Opcion 2!", Toast.LENGTH_LONG);
               toast32.show();

               return true;
           default:
               return super.onOptionsItemSelected(item);
       }

   }
  public boolean onOptionsItemSelected(MenuItem item)
   {
       switch (item.getItemId()) {
           case R.id. SubMnuOpc1:
               Toast toast31 =Toast.makeText(getApplicationContext(),"Submenu: Opcion 1!", Toast.LENGTH_LONG);
               toast31.show();

               return true;
           case R.id. SubMnuOpc2:
               Toast toast32 =Toast.makeText(getApplicationContext(),"Submenu: Opcion 2!", Toast.LENGTH_LONG);
               toast32.show();

               return true;
          default:
              return super.onOptionsItemSelected(item);


    }*/

}
