package Models.Aulas;

public class Teoria extends Aula implements I_Aula{    
     private boolean AireAcondicionado = false;
     private boolean EquipoMultimedia = false;

    public Teoria(String nombre, String numero, String ubicacion, int capacidad,boolean aire,boolean  multimedia) {
        super(nombre, numero, ubicacion, capacidad);
        this.AireAcondicionado=aire;
        this.EquipoMultimedia=multimedia;
    }
    
}
