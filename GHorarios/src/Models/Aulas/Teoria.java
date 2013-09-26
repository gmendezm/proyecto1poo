package Models.Aulas;

/**
 *
 * @author gmendezmOsa
 */
public class Teoria extends Aula{    
     private boolean aireAcondicionado = false;
     private boolean equipoMultimedia = false;

    public Teoria(String nombre, String numero, String ubicacion, int capacidad,boolean aire,boolean  multimedia) {
        super(nombre, numero, ubicacion, capacidad);
        this.aireAcondicionado=aire;
        this.equipoMultimedia=multimedia;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public boolean isEquipoMultimedia() {
        return equipoMultimedia;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public void setEquipoMultimedia(boolean equipoMultimedia) {
        this.equipoMultimedia = equipoMultimedia;
    }
}
