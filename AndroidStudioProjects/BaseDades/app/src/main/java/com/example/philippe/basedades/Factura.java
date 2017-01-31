package com.example.philippe.basedades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        ImageButton back =(ImageButton) findViewById(R.id.back);
        TextView Fsegur=(TextView)findViewById(R.id.Fsegur);
        TextView dadesVehicle=(TextView)findViewById(R.id.dadesVehicle);
        TextView dies=(TextView)findViewById(R.id.dies);
        TextView complements=(TextView)findViewById(R.id.complements);
        TextView sumaTotal=(TextView)findViewById(R.id.totalFactura);

        //factura.putExtra("dadescotxe",dadescotxe);

        String Tsegur=getIntent().getStringExtra("segur");

        String dadesCotxe=getIntent().getStringExtra("dadesmarca");

        String tiempo=getIntent().getStringExtra("temps");

        String deposit=getIntent().getStringExtra("deposit");
       // String pdeposit=getIntent().getStringExtra("pdeposit");

        String gps=getIntent().getStringExtra("gps");
      //  String pgps=getIntent().getStringExtra("pgps");

        String comp=(deposit+" "+gps);
        String sum=getIntent().getStringExtra("total");

        sumaTotal.setText(sum);
        complements.setText(comp);
        dies.setText(tiempo);
        Fsegur.setText(Tsegur);
        dadesVehicle.setText(dadesCotxe);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent back=new Intent(Factura.this,Inici.class);
                startActivity(back);
            }
        });

    }
}
