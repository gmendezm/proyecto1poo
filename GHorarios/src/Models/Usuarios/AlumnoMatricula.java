/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Asignaturas.I_Asignatura;
import Models.Asignaturas.Matricula;
import Models.Asignaturas.Semestre;
import java.util.ArrayList;

public class AlumnoMatricula {
    private Semestre _Semestre;
    private ArrayList<Matricula> Matricula;

    public AlumnoMatricula(Semestre _Semestre) {
        this._Semestre = _Semestre;
        this.Matricula = new ArrayList<Matricula>();
    }

    public void setMatricula(Matricula _Matricula) {
        this.Matricula.add(_Matricula);
    }
    
    
    
}
