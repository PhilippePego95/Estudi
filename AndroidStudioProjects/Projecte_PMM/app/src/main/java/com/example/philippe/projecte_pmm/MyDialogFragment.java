package com.example.philippe.projecte_pmm;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        name.setText(getActivity().getIntent().getStringExtra("nom"));
        pass.setText(getActivity().getIntent().getStringExtra("pass"));

        Button home =(Button) dlgview.findViewById(R.id.bhome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }

}
