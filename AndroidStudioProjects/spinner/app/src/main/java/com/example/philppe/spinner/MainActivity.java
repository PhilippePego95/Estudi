package com.example.philppe.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //spinner.setOnItemClickListener(new info());
    }
    ArrayAdapter<String>
    private void showToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
   /* private class info implements AdapterView.OnItemClickListener
    {
        public void onItemClick(AdapterView<?> spinner,View selectedView,int selectedIndex,long id)
        {
            String selection= spinner.getItemAtPosition(selectedIndex).toString();
            showToast(selection);
        }
    }
   public void onNothingSelected(AdapterView<?>spinner){

    }*/

}
