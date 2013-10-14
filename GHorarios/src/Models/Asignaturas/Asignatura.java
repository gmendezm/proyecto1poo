package Models.Asignaturas;

import Models.Carreras.Carrera;
import java.util.Calendar;

public abstract class Asignatura {
    private String ID;
    private String Nombre;
    private int Creditos=0;
    private int _Semestre;
    private Semestre H_Semestre;

    public Asignatura(String ID, String Nombre,int creditos,int Semestre) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Creditos=creditos;
        this._Semestre=Semestre;
    }

    public String getID() {
        return ID;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }

    public String getNombre() {
        return Nombre;
    }
    
    
   
    public String GetPerfil(){
        return this.ID+"_.."+this.Nombre+"..."+ Integer.toString(this.Creditos);
    }


}
