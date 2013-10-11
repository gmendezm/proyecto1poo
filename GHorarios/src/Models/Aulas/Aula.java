package Models.Aulas;

public abstract class Aula  {

    private String nombre="";
    private String numero="";
    private String ubicacion="";
    private int capacidad=0;

    public Aula(String nombre, String numero, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }  
    
}
