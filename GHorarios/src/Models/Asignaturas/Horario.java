package Models.Asignaturas;

import Models.Aulas.Aula;
import Models.Aulas.I_Aula;

/**
 *
 * @author gmendezmOsa
 */
public class Horario {
    
    private int dia;
    private int hora;
    private I_Aula aula;

    public Horario(int dia, int hora, I_Aula aula) {
        this.dia = dia;
        this.hora = hora;
        this.aula = aula;
    }
    


}
