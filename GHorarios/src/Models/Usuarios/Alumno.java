/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Carreras.Carrera;

public class Alumno extends Usuario implements I_Usuario{
    private String Carnet;
    private Matricula matricula;    
    private Carrera Carrera;

    public Alumno(String Carnet, String Usuario, String Contraseña) {
        super(Usuario, Contraseña);
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
