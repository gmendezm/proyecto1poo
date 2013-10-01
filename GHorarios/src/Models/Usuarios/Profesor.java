package Models.Usuarios;

import Models.Departamentos.Departamento;
import Models.Asignaturas.Horario;

public class Profesor extends Usuario  implements I_Usuario{
    private String nombre;
    private String cedula;
    private Departamento Departamento;
    private Matricula Matricula;

    public Profesor(String nombre, String cedula, String Usuario, String Contraseña) {
        super(Usuario, Contraseña);
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.Departamento = Departamento;
    }

    public Matricula getMatricula() {
        return Matricula;
    }

    public void setMatricula(Matricula Matricula) {
        this.Matricula = Matricula;
    }

    
    

}
