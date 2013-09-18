package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Asignatura {
    
    
    private String nombre;
    private int creditos;

    
    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

}