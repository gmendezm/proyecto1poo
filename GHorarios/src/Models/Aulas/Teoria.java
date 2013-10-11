package Models.Aulas;

public class Teoria extends Aula implements I_Aula{    
     private boolean aireAcondicionado = false;
     private boolean equipoMultimedia = false;

    public Teoria(String nombre, String numero, String ubicacion, int capacidad,boolean aire,boolean  multimedia) {
        super(nombre, numero, ubicacion, capacidad);
        this.aireAcondicionado=aire;
        this.equipoMultimedia=multimedia;
    }
}
