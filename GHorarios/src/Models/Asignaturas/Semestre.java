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
        _Horario = new ArrayList<Horario>();
        this.Semestre=semestre;
        this.Año=año;      
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

    public ArrayList<Horario> getHorario() {
        return _Horario;
    }
    
    public int getSizeHorario() {
        return _Horario.size();
    }
        
     public Cursos getCurso(String T) {
         Cursos result=null;
          for(int i = 0; i < this._Cursos.size();i++) {
             if(T.equals("T")){
                 if((this._Cursos.get(i).getAsignatura() instanceof Teorica)&&(!this._Cursos.get(i).isAsignado())){
                     result=this._Cursos.get(i);
                 }
             }
             if(T.equals("P")){
                  if((this._Cursos.get(i).getAsignatura() instanceof Practica)&&(!this._Cursos.get(i).isAsignado())){
                      result=this._Cursos.get(i);
                  }
             }
          }
          return result;
    }
    
    public void setCursos(Cursos nn) {
         this._Cursos.add(nn);
    }

    public void setHorario(Horario nn) {
        this._Horario.add(nn);
    }
    
    


    
    
}