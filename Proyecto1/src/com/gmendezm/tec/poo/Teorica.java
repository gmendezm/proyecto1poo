package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Teorica extends Asignatura{
    private String apuntes;

    public Teorica(String apuntes, String nombre, int creditos) {
        super(nombre, creditos);
        this.apuntes = apuntes;
    }

    public String getApuntes() {
        return apuntes;
    }

    public void setApuntes(String apuntes) {
        this.apuntes = apuntes;
    }
    
    
}
