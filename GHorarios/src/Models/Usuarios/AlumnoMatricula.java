/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Asignaturas.Asignatura;
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

    public Semestre getSemestre() {
        return _Semestre;
    }

    public ArrayList<Cursos> getAMatricula() {
        return Matricula;
    }
    
    public boolean Existe(String ID){
        boolean result=false;
        for(int i=0;i<this.Matricula.size();i++){
            if(this.Matricula.get(i).getAsignatura().getID().equals(ID))
                result=true;
        }
        return result;           
    }

}
