package Models.Aulas;

public class Laboratorio extends Aula implements I_Aula{
     private String equipo="";
     private int cantidad = 0; 

    public Laboratorio(String nombre, String numero, String ubicacion, int capacidad,String equipo,int cant) {
        super(nombre, numero, ubicacion, capacidad);
        this.cantidad=cant;
        this.equipo=equipo;
    }

}
