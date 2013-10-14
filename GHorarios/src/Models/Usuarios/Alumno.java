/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Carreras.Carrera;
import java.util.ArrayList;

public class Alumno extends Usuario implements I_Usuario{
    private String Carnet;      
    private Carrera Carrera;
    private ArrayList<AlumnoMatricula> _Matricula ; 

    public Alumno(String Nombre,String Carnet, String Usuario, String Contraseña) { 
        super(Nombre,Usuario, Contraseña);         
         this.Carnet = Carnet;
         _Matricula = new ArrayList<AlumnoMatricula>();
    }

    public String getCarnet() {
        return Carnet;
    } 

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }

    public void setMatricula(AlumnoMatricula nn) {
        this._Matricula.add(nn);
    }

    public ArrayList<AlumnoMatricula> getMatricula() {
        return _Matricula;
    }
    
    
    public String getPerfil(){
        return "Carnet :"+this.Carnet +"\n Nombre :"+getNombre();
    } 
}
