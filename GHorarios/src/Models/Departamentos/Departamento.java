package Models.Departamentos;

import Models.Asignaturas.I_Asignatura;
import java.util.ArrayList;


public class Departamento {
    private String ID;
    private String nombre;
    private static ArrayList<I_Asignatura> Asignaturas;

    public Departamento(String ID, String nombre) {
        this.Asignaturas =  new ArrayList<I_Asignatura> ();
        this.ID = ID;
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public static void setAsignaturas(I_Asignatura nn) {
        Departamento.Asignaturas.add(nn);
    }
    
    




    
}
