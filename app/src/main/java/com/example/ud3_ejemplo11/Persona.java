package com.example.ud3_ejemplo11;

import java.io.Serializable;

// Implementamos la interfaz Serializable para poder pasar el objeto creado de una actividad a otra.
public class Persona implements Serializable {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
