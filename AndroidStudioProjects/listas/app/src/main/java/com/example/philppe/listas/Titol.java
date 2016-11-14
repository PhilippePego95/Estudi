package com.example.philppe.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Titol{
    private String titol;
    private String subTitol;
    private int image;

    public Titol(String titol,String subTitol, int image){
        this.titol=titol;
        this.subTitol=subTitol;
        this.image=image;
    }
    public String getTitol() {return titol;}
    public String getSubTitol(){return subTitol;}
    public int getImage(){return image;}
}

