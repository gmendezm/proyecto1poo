/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Asignaturas;

import Models.Usuarios.Profesor;


public class Cursos {
   private I_Asignatura _Asignatura;
   private Profesor _Profesor;
   private int _grupo;
   private boolean _Asignado=false;
   private int MinAsignados;

    public Cursos(I_Asignatura _Asignatura, Profesor _Profesor, int grupo) {
        this._Asignatura = _Asignatura;
        this._Profesor = _Profesor;
        this._grupo = grupo;
        this.MinAsignados=_Asignatura.getCreditos()*50;
    }

    public I_Asignatura getAsignatura() {
        return _Asignatura;
    }

    public Profesor getProfesor() {
        return _Profesor;
    }

    public boolean isAsignado() {
        return _Asignado;
    }

    public int getMinAsignados() {
        return MinAsignados;
    }

    public void setMinAsignados(int _Min) {
        if(this.MinAsignados==_Min){
            this.MinAsignados=0;
            this._Asignado=true;            
        }
        else{
            this.MinAsignados-=_Min;
        }
    }
    
    
    

    
    
}
