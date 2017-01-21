package com.example.mati.basededatosspinner;

/**
 * Created by mati on 11/01/17.
 */

public class Cliente {

    String nombre;
    String telefono;

    public Cliente(String nombre, String telefono){

        this.nombre = nombre;
        this.telefono = telefono;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
