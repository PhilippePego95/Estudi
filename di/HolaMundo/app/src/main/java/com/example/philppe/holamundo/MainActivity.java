package com.example.philppe.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final EditText miTexto=(EditText)findViewById(R.id.editText);
    final Button boto =(Button)findViewById(R.id.button);
    TextView salud=(TextView)findViewById(R.id.textView);

   /* public void MostrarText (View v){
     text1 = (EditText)findViewById(R.id.editText);
     text2 = (TextView)findViewById(R.id.textView);

        String a = text1.getText().toString();
        String b = a+" ,Benvingut";
        text2.setText(b);
    }*/
    miTexto.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v){
            miTexto.setText("");
        }
    });

}

