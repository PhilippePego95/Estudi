package com.example.philippe.fragmentos;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    // TODO: Rename and change types of parameters
    private int mParam1_num;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(int param1) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1_num = getArguments().getInt(ARG_PARAM1);
        }
        Toast.makeText(getContext(),"onCreate-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v  = null;
        Toast.makeText(getContext(),"onCreateVIEW-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
        // dependiendo de si es par o impar mostramos distintos layouts
        if (mParam1_num % 2 == 0){
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            View tv = v.findViewById(R.id.text);
            //informamos el numero de Fragment
            ((TextView)tv).setText("Fragmento numero #" + mParam1_num);
        }
        else{
            v = inflater.inflate(R.layout.fragment_simple2, container, false);
            View tv = v.findViewById(R.id.text2);
            //informamos el nÃºmero de Fragment
            ((TextView)tv).setText("Fragmento numero #" + mParam1_num);
        }
        // Inflate the layout for this fragment
        return v;
    }

    /* Proceso para entender el ciclo de vida */
    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"onStart-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(),"onResume-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause() {
        Toast.makeText(getContext(), "onPause-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText( getContext(),"onStop-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getContext(),"onDestroy-FRAGMENTO"+ mParam1_num, Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}