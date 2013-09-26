/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Carreras.Carrera;

/**
 *
 * @author Estudiante
 */
public class Alumno extends Usuario{
    private String Carnet;
    private Matricula matricula;    
    private Carrera Carrera;

    public Alumno(String Carnet, int ID, String Nombre, String Apellidos) {
        super(ID, Nombre, Apellidos);
        this.Carnet = Carnet;
    }

    public String getCarnet() {
        return Carnet;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }
    
}
