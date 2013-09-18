package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Profesor {
    private String nombre;
    private String cedula;
    private Horario horario;
    private Departamento departamento;

    public Profesor(String nombre, String cedula, Horario horario, Departamento departamento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.horario = horario;
        this.departamento = departamento;
    }

    public String getCedula() {
        return cedula;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
