package com.example.philippe.projecte_pmm;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        DialogFragment newFragment = MyDialogFragment.newInstance("Cadena de ejemplo como parÃ¡metro");
        newFragment.show(getFragmentManager(), "dialog");
    }
}
