package com.gmendezm.tec.poo;

/**
 *
 * @author gmendezmOsa
 */
public class Horario {
    
    private int dia;
    private int hora;
    private Asignatura asignatura;
    private Aula aula;

    public Horario(int dia, int hora, Asignatura asignatura, Aula aula) {
        this.dia = dia;
        this.hora = hora;
        this.asignatura = asignatura;
        this.aula = aula;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Aula getAula() {
        return aula;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
    
    
    

}
