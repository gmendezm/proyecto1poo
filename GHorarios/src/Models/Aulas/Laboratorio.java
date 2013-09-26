package Models.Aulas;

/**
 *
 * @author gmendezmOsa
 */
public class Laboratorio extends Aula{
     private String equipo = "";
     private int cantidad = 0; 

    public Laboratorio(String nombre, String numero, String ubicacion, int capacidad,String equipo,int cant) {
        super(nombre, numero, ubicacion, capacidad);
        this.cantidad=cant;
        this.equipo=equipo;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
}
