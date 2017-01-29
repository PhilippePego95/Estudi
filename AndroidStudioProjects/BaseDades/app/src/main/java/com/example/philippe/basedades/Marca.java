package com.example.philippe.basedades;

/**
 * Created by philippe on 28/01/17.
 */

public class Marca {
    String model;

    public Marca( String model) {

        this.model = model;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Marca{" +

                ", model='" + model + '\'' +
                '}';
    }
}
