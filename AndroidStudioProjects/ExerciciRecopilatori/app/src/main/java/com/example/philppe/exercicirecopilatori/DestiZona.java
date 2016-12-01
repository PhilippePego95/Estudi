package com.example.philppe.exercicirecopilatori;

import java.io.Serializable;

public class DestiZona implements Serializable {
    private String zona;
    private String continent;
    private double preu;

    public DestiZona(String zona, String continent, double preu) {
        this.zona = zona;
        this.continent = continent;
        this.preu = preu;
    }

    public String getZona() {
        return zona;
    }

    public String getContinent() {
        return continent;
    }

    public double getPreu() {
        return preu;
    }

}
