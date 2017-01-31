package com.example.philippe.basedades;

/**
 * Created by philippe on 30/01/17.
 */

public class LlistaCompres {
    String idS;
    String usuari;
    String dades;
    String preuTotal;

    public LlistaCompres(String idS, String usuari, String dades, String preuTotal) {
        this.idS = idS;
        this.usuari = usuari;
        this.dades = dades;
        this.preuTotal = preuTotal;
    }

    public String getIdS() {
        return idS;
    }

    public void setIdS(String idS) {
        this.idS = idS;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getDades() {
        return dades;
    }

    public void setDades(String dades) {
        this.dades = dades;
    }

    public String getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(String preuTotal) {
        this.preuTotal = preuTotal;
    }

    @Override
    public String toString() {
        return "LlistaCompres{" +
                "id='" + idS + '\'' +
                ", usuari='" + usuari + '\'' +
                ", dades='" + dades + '\'' +
                ", preuTotal='" + preuTotal + '\'' +
                '}';
    }
}
