package Models.Usuarios;

import Models.Departamentos.Departamento;

public class Profesor extends Usuario  implements I_Usuario{
    private String cedula;
    private Departamento Departamento;

    public Profesor(String nombre, String cedula, String Usuario, String Contraseña) {
        super(nombre,Usuario, Contraseña);
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setDepartamento(Departamento Departamento) {
        this.Departamento = Departamento;
    }

      public String getPerfil(){
        return "Cedula :"+this.cedula +"\n Nombre :"+getNombre();
    } 
}
