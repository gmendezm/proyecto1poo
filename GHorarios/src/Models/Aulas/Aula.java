package Models.Aulas;

import Models.Asignaturas.Horario;
import Models.Asignaturas.Semestre;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Aula  {

    private String nombre="";
    private String numero="";
    private String ubicacion="";
    private int capacidad=0;
    public static ArrayList<Semestre> _Semestres;
    private Calendar _HoraFecha;

    public Aula(String nombre, String numero, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        
        this._Semestres= new ArrayList<Semestre>();   
        this._HoraFecha=Calendar.getInstance();
        this._HoraFecha.set(Calendar.DAY_OF_MONTH,1);
        this._HoraFecha.set(Calendar.HOUR_OF_DAY,7);
        this._HoraFecha.set(Calendar.MINUTE,0);
    }     

     private Semestre GetSemestre(int S,int _Año)
     {
         Semestre result=null;
         for(int i=0;i<Aula._Semestres.size();i++){
            if((Aula._Semestres.get(i).getSemestre()==S)&&(Aula._Semestres.get(i).getAño()==_Año))
                result=Aula._Semestres.get(i);
        }
         return  result;
     }
     
    public void setSemestre(Semestre _Semestres_) {        
        if(GetSemestre(_Semestres_.getSemestre(),_Semestres_.getAño())==null){
             Aula._Semestres.add(_Semestres_);
        }       
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }
    
    public void setHoraFecha_MHD(int M,int H,int D){
        this._HoraFecha.set(Calendar.DAY_OF_MONTH,(_HoraFecha.get(Calendar.DAY_OF_MONTH)+ D));
        this._HoraFecha.set(Calendar.HOUR_OF_DAY,H);
        this._HoraFecha.set(Calendar.MINUTE,M);
    }

    public void setHoraFecha(Calendar C) {
        this._HoraFecha.set(Calendar.DAY_OF_MONTH,C.get(Calendar.DAY_OF_MONTH));
        this._HoraFecha.set(Calendar.HOUR_OF_DAY,C.get(Calendar.HOUR_OF_DAY));
        this._HoraFecha.set(Calendar.MINUTE,C.get(Calendar.MINUTE));
    }

    public Calendar getHoraFecha() {
        return _HoraFecha;
    }
    
      public String GetPerfil(){
        return this.nombre+"..."+this.numero+"..."+this.ubicacion+"..."+Integer.toString(this.capacidad);
    }
      
     
}
