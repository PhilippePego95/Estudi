package com.example.philippe.projecte_pmm;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Button bToast =(Button) findViewById(R.id.bToast) ;
        bToast.setOnClickListener(new View.OnClickListener() {
            int num=1;
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getApplicationContext(),num+" Toast...", Toast.LENGTH_SHORT);
                toast1.show();
                num++;
            }
        });
    }
}
