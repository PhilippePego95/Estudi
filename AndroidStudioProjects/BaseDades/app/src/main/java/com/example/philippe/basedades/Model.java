package com.example.philippe.basedades;

/**
 * Created by philippe on 29/01/17.
 */

public class Model {
    String model;
    String preu;

    public Model(String model, String preu) {
        this.model = model;
        this.preu = preu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPreu() {
        return preu;
    }

    public void setPreu(String preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                ", preu='" + preu + '\'' +
                '}';
    }
}
