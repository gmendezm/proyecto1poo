/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Asignaturas;

import Models.Usuarios.I_Usuario;


public class Cursos {
   private I_Asignatura _Asignatura;
   private I_Usuario _Profesor;
   private int _grupo;

    public Cursos(I_Asignatura _Asignatura, I_Usuario _Profesor, int grupo) {
        this._Asignatura = _Asignatura;
        this._Profesor = _Profesor;
        this._grupo = grupo;
    }

    public I_Asignatura getAsignatura() {
        return _Asignatura;
    }  
}
