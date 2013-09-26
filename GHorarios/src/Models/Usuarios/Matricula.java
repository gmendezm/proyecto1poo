/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Asignaturas.Asignatura;
import Models.Asignaturas.Semestre;

/**
 *
 * @author Estudiante
 */
public class Matricula {
    private Semestre Semestre;
    private Asignatura Asignatura;

    public Matricula(Semestre Semestre, Asignatura Asignatura) {
        this.Semestre = Semestre;
        this.Asignatura = Asignatura;
    }
    
    
}
