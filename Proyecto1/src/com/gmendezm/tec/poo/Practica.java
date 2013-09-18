package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Practica extends Asignatura{

    private String material;
    private String SO;

    public Practica(String nombre, int creditos) {
        super(nombre, creditos);
    }

    public String getMaterial() {
        return material;
    }


    public String getSO() {
        return SO;
    }


    public void setMaterial(String material) {
        this.material = material;
    }


    public void setSO(String SO) {
        this.SO = SO;
    }
    
    
    
}
