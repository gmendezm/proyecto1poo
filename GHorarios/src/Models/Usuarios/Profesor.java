package Models.Usuarios;

import Models.Departamentos.Departamento;
import Models.Asignaturas.Horario;

/**
 *
 * @author gmendezmOsa
 */
public class Profesor extends Usuario{
    private String nombre;
    private String cedula;
    private Departamento Departamento;
    private Matricula Matricula;

    public Profesor(String nombre, String cedula, Departamento Departamento, Matricula Matricula, int ID, String Nombre, String Apellidos) {
        super(ID, Nombre, Apellidos);
        this.nombre = nombre;
        this.cedula = cedula;
        this.Departamento = Departamento;
        this.Matricula = Matricula;
    }

}
