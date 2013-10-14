package Models.Asignaturas;

import Models.Aulas.Aula;
import Models.Aulas.I_Aula;
import java.util.Calendar;

public class Horario {
    private Calendar HoraFecha_Inicio;
    private Calendar HoraFecha_Final;
    private Cursos _Curso;
    private I_Aula _aula;

    public Horario(Calendar HoraFecha_Inicio, Cursos _Curso, I_Aula _aula) {
        this.HoraFecha_Inicio = _getHoraFecha_Inicio(HoraFecha_Inicio);
        this._Curso = _Curso;
        this._aula = _aula;
        if((_Curso == null)&&(_aula==null)){
            this.HoraFecha_Final=(_getHoraFecha_Final(HoraFecha_Inicio, 5));}
        else{                     
            this.HoraFecha_Final=(_getHoraFecha_Final(HoraFecha_Inicio, (_Curso.getAsignatura().getCreditos()*50)));}
    }

    private Calendar _getHoraFecha_Final(Calendar Inicio,int min) {
        Calendar myC=Calendar.getInstance();
        myC.set(Calendar.DAY_OF_MONTH,Inicio.get(Calendar.DAY_OF_MONTH));
        myC.set(Calendar.HOUR_OF_DAY,Inicio.get(Calendar.HOUR_OF_DAY));
        myC.set(Calendar.MINUTE,Inicio.get(Calendar.MINUTE));        
        myC.add(Calendar.MINUTE,min);
        return myC;
    }
    
      private Calendar _getHoraFecha_Inicio(Calendar Inicio) {
        Calendar myC=Calendar.getInstance();
        myC.set(Calendar.DAY_OF_MONTH,Inicio.get(Calendar.DAY_OF_MONTH));
        myC.set(Calendar.HOUR_OF_DAY,Inicio.get(Calendar.HOUR_OF_DAY));
        myC.set(Calendar.MINUTE,Inicio.get(Calendar.MINUTE));        
        return myC;
    }

    public Calendar getHoraFecha_Inicio() {
        return HoraFecha_Inicio;
    }

    public Calendar getHoraFecha_Final() {
        return HoraFecha_Final;
    }

    public Cursos getCurso() {
        return _Curso;
    }

    public I_Aula getAula() {
        return _aula;
    }
    
    public void setHoraFecha_Final(Calendar _Final) {
        this.HoraFecha_Final = _Final;
        this.HoraFecha_Final.set(Calendar.DAY_OF_MONTH,_Final.get(Calendar.DAY_OF_MONTH));
        this.HoraFecha_Final.set(Calendar.HOUR_OF_DAY,_Final.get(Calendar.HOUR_OF_DAY));
        this.HoraFecha_Final.set(Calendar.MINUTE,_Final.get(Calendar.MINUTE));
    }

}
