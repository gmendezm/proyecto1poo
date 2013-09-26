package Models.Asignaturas;

import Models.Aulas.Aula;

/**
 *
 * @author gmendezmOsa
 */
public class Horario {
    
    private int dia;
    private int hora;
    private Asignatura asignatura;
    private Aula aula;

    public Horario(int dia, int hora, Asignatura asignatura, Aula aula) {
        this.dia = dia;
        this.hora = hora;
        this.asignatura = asignatura;
        this.aula = aula;
    }

}
