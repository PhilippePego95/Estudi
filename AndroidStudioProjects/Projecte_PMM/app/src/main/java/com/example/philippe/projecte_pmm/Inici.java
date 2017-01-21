package com.example.philippe.projecte_pmm;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Inici extends AppCompatActivity {
   TextView idUser;
   TextView idPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);

        idUser=(TextView)findViewById(R.id.idUser);
        idPass=(TextView)findViewById(R.id.idPass);

        idUser.setText(getIntent().getStringExtra("nom"));
        idPass.setText(getIntent().getStringExtra("pass"));

        idUser.setVisibility(View.INVISIBLE);
        idPass.setVisibility(View.INVISIBLE);

      //  Toast toast1 = Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT);
    //   toast1.show();
    } public boolean onCreateOptionsMenu(Menu menu){
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


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
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
