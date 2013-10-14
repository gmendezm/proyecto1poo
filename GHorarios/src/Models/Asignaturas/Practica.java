package Models.Asignaturas;


public class Practica extends Asignatura implements I_Asignatura{  

    private String material;
    private String SO;

    public Practica(String ID, String Nombre, int creditos, int Semestre) {
        super(ID, Nombre, creditos, Semestre);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }


    



}
