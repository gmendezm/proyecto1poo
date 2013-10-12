package Models.Asignaturas;

import Models.Carreras.Carrera;

public abstract class Asignatura {  
    private String ID;
    private String Nombre;
    private int Creditos=0;
    private int _Semestre;

    public Asignatura(String ID, String Nombre,int creditos,int Semestre) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Creditos=creditos;
        this._Semestre=Semestre;
    }

    public String getID() {
        return ID;
    }

    
    
    

}
