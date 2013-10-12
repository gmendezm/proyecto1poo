/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Asignaturas;

import java.util.ArrayList;

public class Semestre {
    private int Semestre=0;
    private int Año=0;
    private ArrayList<Cursos> _Cursos;
    private ArrayList<Horario> _Horario;
    
    public Semestre(int semestre,int año) {
        _Cursos = new ArrayList<Cursos>();
        this.Semestre=semestre;
        this.Año=año;      
    }

    public void setCursos(Cursos nn) {
         this._Cursos.add(nn);
    }

    public int getSemestre() {
        return Semestre;
    }

    public int getAño() {
        return Año;
    }

    public ArrayList<Cursos> getCursos() {
        return _Cursos;
    }
    
    
}