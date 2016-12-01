package com.example.philppe.exercicirecopilatori;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DestiZona[] dades = new DestiZona[]{
         new DestiZona ("Zona A: ","Asia i Oceania",30),
         new DestiZona ("Zona B: ","America i Africa",20),
         new DestiZona ("Zona C: ","Europa",10),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorZones adaptador = new AdaptadorZones(this);
        final Spinner triar = (Spinner)findViewById(R.id.triar);
        triar.setAdapter(adaptador);

        Button calcular = (Button)findViewById(R.id.button);
        final RadioGroup tarifes = (RadioGroup)findViewById(R.id.RGrup);
        final Button urgent = (Button)findViewById(R.id.rUrgent);
        final Button normal = (Button)findViewById(R.id.rNormal);
        final EditText pes = (EditText)findViewById(R.id.ePes);
        final CheckBox regal = (CheckBox)findViewById(R.id.cRegal);
        final CheckBox tarjeta = (CheckBox)findViewById(R.id.cTarjeta);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasar = new Intent(MainActivity.this, Calcular.class);

                Bundle passarObjectes = new Bundle();
                double preuZona = dades[triar.getSelectedItemPosition()].getPreu();

                DestiZona desti = new DestiZona(
                        dades[triar.getSelectedItemPosition()].getZona(),
                        dades[triar.getSelectedItemPosition()].getContinent(),
                        dades[triar.getSelectedItemPosition()].getPreu());

                passarObjectes.putSerializable("DestiZona",desti);
                pasar.putExtras(passarObjectes);
                double preuPes =0;

                if (pes.getText().toString().isEmpty()){
                    pes.setText("0");
                }
                if(Double.parseDouble(pes.getText().toString())<6){
                    preuPes=Double.parseDouble(pes.getText().toString())*1;
                }
                if (Double.parseDouble(pes.getText().toString())>=6 && Double.parseDouble(pes.getText().toString())<10){
                    preuPes=Double.parseDouble(pes.getText().toString())*1.5;
                }
                if (Double.parseDouble(pes.getText().toString())<=10){
                    preuPes=Double.parseDouble(pes.getText().toString())*2;
                }
                pasar.putExtra("pes",pes.getText().toString());
                pasar.putExtra("preuPes",String.valueOf(preuPes));
                double total= preuPes+preuZona;

                double tarifa =0;
                String nTarifa=" ";
                if (tarifes.getCheckedRadioButtonId()==R.id.rUrgent){
                    nTarifa= urgent.getText().toString();
                    tarifa = (total*30)/100;
                    nTarifa = urgent.getText().toString();
                }
                if(tarifes.getCheckedRadioButtonId()==R.id.rNormal){
                    nTarifa= normal.getText().toString();
                    tarifa= 0;
                    nTarifa= normal.getText().toString();
                }
                pasar.putExtra("nomTarifa",nTarifa);
                pasar.putExtra("tarifa",String.valueOf(tarifa));
                total = total+ tarifa;
                pasar.putExtra("total", String.valueOf(total));

                boolean checked=false;
                if (regal.isChecked()){
                    checked=true;
                    pasar.putExtra("CaixaRegal",regal.getText().toString());
                    pasar.putExtra("checked",checked);
                }
                if (tarjeta.isChecked()){
                    checked=true;
                    pasar.putExtra("Tarjeta",tarjeta.getText().toString());
                    pasar.putExtra("checked2",checked);
                }
                startActivity(pasar);
            }
        });
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

    //omplir SPinner
    public class AdaptadorZones extends ArrayAdapter<DestiZona>{
        Activity context;

        AdaptadorZones(Activity context){
            super(context, R.layout.activity_desti_zona, dades);
            this.context=context;
        }
        public View getDropDownView (int position, View convertView,ViewGroup parent){
            View vistaDesplega=getView(position,convertView,parent);
            return vistaDesplega;
        }
        public View getView(int i, View convertView, ViewGroup parent){

            LayoutInflater inflater =context.getLayoutInflater();
            View item= inflater.inflate(R.layout.activity_desti_zona, null);

            TextView lTitol=(TextView) item.findViewById(R.id.lZona);
            TextView lSubTitol=(TextView) item.findViewById(R.id.lContinent);
            TextView lPreu=(TextView) item.findViewById(R.id.lPreu);

            lTitol.setText(dades[i].getZona());
            lSubTitol.setText(dades[i].getContinent());
            lPreu.setText(String.valueOf(dades[i].getPreu())+"€");

            return (item);

        }
    }


}
