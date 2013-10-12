package Models.Asignaturas;

public class Teorica extends Asignatura implements I_Asignatura{
    private String apuntes;

    public Teorica(String ID, String Nombre, int creditos, int Semestre) {
        super(ID, Nombre, creditos, Semestre);
    }


 
}
