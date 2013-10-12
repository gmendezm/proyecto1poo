/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Asignaturas.Matricula;
import Models.Asignaturas.Semestre;
import Models.Carreras.Carrera;
import java.util.ArrayList;

public class Alumno extends Usuario implements I_Usuario{
    private String Carnet;      
    private Carrera Carrera;
    private ArrayList<Semestre> semestres ; 

    public Alumno(String Nombre,String Carnet, String Usuario, String Contraseña) { 
        super(Nombre,Usuario, Contraseña);
         semestres = new ArrayList<Semestre>();
        this.Carnet = Carnet;
    }

    public String getCarnet() {
        return Carnet;
    } 

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }
    

    public String getPerfil(){
        return "Carnet :"+this.Carnet +"\n Nombre :"+getNombre();
    } 
    
    public void agregarSemestre(Semestre x){
        this.semestres.add(x);
    }

    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }
    
    public Semestre getSemestre(int semestre, int año){
        for(int i = 0 ; i < this.semestres.size() ; i ++){
            if(this.semestres.get(i).getSemestre() == semestre && this.semestres.get(i).getAño() == año){
                return this.semestres.get(i);
                
            }
        }
        
        System.out.println("No se encontro el semestre");
        return null;
     
    }
    
    
    
}
