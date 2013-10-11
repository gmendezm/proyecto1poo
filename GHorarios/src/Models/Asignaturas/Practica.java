package Models.Asignaturas;

/**
 *
 * @author gmendezmOsa
 */
public class Practica extends Asignatura implements I_Asignatura{

    private String material;
    private String SO;

    public Practica(String ID, String Nombre, int creditos) {
        super(ID, Nombre, creditos);
    }



}
