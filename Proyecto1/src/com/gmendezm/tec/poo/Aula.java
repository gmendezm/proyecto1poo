package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Aula implements Teoria, Laboratorio {

    private String nombre;
    private String numero;
    private String ubicacion;
    private int capacidad;

    public Aula(String nombre, String numero, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
    
    public static int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public static String getEquipo() {
        return equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    
    
}
