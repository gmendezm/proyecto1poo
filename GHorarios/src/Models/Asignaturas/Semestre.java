/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Asignaturas;

import java.util.ArrayList;

public class Semestre {
    private int Semestre=0;
    private int Año=0;
    private ArrayList<Matricula> Matricula;
    private ArrayList<Horario> _Horario;
    
    public Semestre(int semestre,int año) {
        Matricula = new ArrayList<Matricula>();
        this.Semestre=semestre;
        this.Año=año;      
    }

    public void insertarCurso(Matricula nn) {
        this.Matricula.add(nn);
    }

    public int getSemestre() {
        return Semestre;
    }

    public int getAño() {
        return Año;
    }

    public ArrayList<Matricula> getMatricula() {
        return Matricula;
    }
    
    
}