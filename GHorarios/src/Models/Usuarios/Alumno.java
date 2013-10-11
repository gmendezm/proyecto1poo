/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

import Models.Carreras.Carrera;

public class Alumno extends Usuario implements I_Usuario{
    private String Carnet;
    private Matricula matricula;    
    private Carrera Carrera;

    public Alumno(String Nombre,String Carnet, String Usuario, String Contraseña) {
        super(Nombre,Usuario, Contraseña);
        this.Carnet = Carnet;
    }

    public String getCarnet() {
        return Carnet;
    } 
    
    public String getPerfil(){
        return "Carnet :"+this.Carnet +"\n Nombre :"+getNombre();
    } 
}
