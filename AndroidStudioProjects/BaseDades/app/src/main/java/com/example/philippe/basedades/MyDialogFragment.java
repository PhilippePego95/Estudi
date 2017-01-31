package com.example.philippe.basedades;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class MyDialogFragment  extends DialogFragment {

    public static MyDialogFragment newInstance(String valor) {
        MyDialogFragment frag = new MyDialogFragment();

        return frag;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

        ViewGroup dlgview = (ViewGroup) inflater.inflate(R.layout.dialog_fragment, null);

        TextView name=(TextView) dlgview.findViewById(R.id.infoUser);
        TextView pass=(TextView) dlgview.findViewById(R.id.infoPass);


        SharedPreferences prefs =getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nombre = prefs.getString("nombre", "nombre_por_defecto");
        String pw = prefs.getString("pwd", "pwd_por_defecto");

        Log.i("Preferences", "Nombre: " + nombre);
        Log.i("Preferences", "Pass: " + pw);

        // dias= dies.getText().toString();
        //  dias=ndies;
        name.setText(nombre);
        //name.setText(nom);
        pass.setText(pw);
        //name.setText(getActivity().getIntent().getStringExtra("nom"));
        //pass.setText(getActivity().getIntent().getStringExtra("pass"));

        Button home =(Button) dlgview.findViewById(R.id.bhome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                //View layout = getDialog().getWindow().findViewById(R.id.dialog_fragment);
              //layout.setVisibility(View.INVISIBLE);
            }
        });

        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }

}
