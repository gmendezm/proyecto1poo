/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Asignaturas;

import Models.Asignaturas.Asignatura;
import Models.Asignaturas.Semestre;
import Models.Usuarios.I_Usuario;
import Models.Usuarios.Profesor;


public class Matricula {
   private I_Asignatura _Asignatura;
   private I_Usuario _Profesor;
   private int _grupo;
   private Horario _horario;

    public Matricula(I_Asignatura _Asignatura, I_Usuario _Profesor, int grupo, Horario horario) {
        this._Asignatura = _Asignatura;
        this._Profesor = _Profesor;
        this._grupo = grupo;
        this._horario = horario;
    }

    public Horario getHorario() {
        return _horario;
    }

    public I_Usuario getProfesor() {
        return _Profesor;
    }

    public int getGrupo() {
        return _grupo;
    }
    
    
   
   
    
}
