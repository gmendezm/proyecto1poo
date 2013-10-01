package Models.Aulas;

public  abstract class Aula  {

    private String nombre;
    private String numero;
    private String ubicacion;
    private int capacidad;

    public Aula(String nombre, String numero, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
        
    
}
