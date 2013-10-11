package Models.Asignaturas;

import Models.Carreras.Carrera;

public abstract class Asignatura {  
    private String ID;
    private String Nombre;
    private int Creditos=0;

    public Asignatura(String ID, String Nombre,int creditos) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Creditos=creditos;
    }

    
    

}
