/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Asignaturas.Cursos;
import Models.Asignaturas.Semestre;
import java.util.ArrayList;

public class AlumnoMatricula {
    private Semestre _Semestre;
    private ArrayList<Cursos> Matricula;

    public AlumnoMatricula(Semestre _Semestre) {
        this._Semestre = _Semestre;
        this.Matricula = new ArrayList<Cursos>();
    }

    public void setMatricula(Cursos _Matricula) {
        this.Matricula.add(_Matricula);
    }
    
    
    
}
