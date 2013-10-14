package Controllers;

import Models.Asignaturas.Cursos;
import Models.Asignaturas.Horario;
import Models.Asignaturas.I_Asignatura;
import Models.Asignaturas.Practica;
import Models.Asignaturas.Semestre;
import Models.Asignaturas.Teorica;
import Models.Aulas.I_Aula;
import Models.Aulas.Laboratorio;
import Models.Aulas.Teoria;
import Models.Carreras.Carrera;
import Models.Departamentos.Departamento;
import Models.Usuarios.Alumno;
import Models.Usuarios.AlumnoMatricula;
import Models.Usuarios.I_Usuario;
import Models.Usuarios.Profesor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Principal {

    public static ArrayList<I_Usuario> Usuarios;
    public static ArrayList<I_Aula> Aulas;
    private static ArrayList<Departamento> Departamentos;
    private static ArrayList<I_Asignatura> Asignaturas;
    private static ArrayList<Carrera> Carreras;
    public static ArrayList<Semestre> Semestres;
    
    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;

    /**
     * @param data
     *
     */
    private String[] toADD(String data) {
        return data.split(",");
    }
    
    /**
     * @param thisfile
     * @param T
     */
    private void Read_File(String thisfile, String T) {
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(thisfile);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                add_to(toADD(linea), T);//System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * @param info
     * @param T
     */
    private void add_to(String[] info, String T) {
        if ((T.equals("E")) || (T.equals("P"))) {
            add_Usuarios(info, T);
        }
        if (T.equals("A")) {
            add_Aulas(info, info[0]);
        }
        if (T.equals("C")) {
            add_Asignaturas(info, info[0]);
        }
        if (T.equals("D")) {
            add_Departamentos(info);
        }
        if (T.equals("O")) {
            add_Carreras(info);
        }
        if (T.equals("DA")) {
            add_Departamento_Asignatura(info);
        }
        if (T.equals("M")) {
            add_Semestres_MAtricula(info);
        }
       if (T.equals("AM")) {
            add_AlumnoMatricula(info);
        }
    }

    /**
     * @param info
     * @param T
     */
    private void add_Usuarios(String[] info, String T) {
        if (info.length >= 4) {
            if (T.equals("E")) {
                Alumno A = new Alumno(info[0], info[1], info[2], info[3]);
                for (int i = 0; i < Carreras.size(); i++) {
                    if (Carreras.get(i).getID().equals(info[4])) {
                        A.setCarrera(Carreras.get(i));
                        I_Usuario nn = A;
                        Usuarios.add(nn);
                    }
                }
            }
            if (T.equals("P")) {
                Profesor P = new Profesor(info[0], info[1], info[2], info[3]);
                for (int y = 0; y < Departamentos.size(); y++) {
                    if (Departamentos.get(y).getID().equals(info[4])) {
                        P.setDepartamento(Departamentos.get(y));
                        I_Usuario nn = P;
                        Usuarios.add(nn);
                    }
                }
            }
        }
    }

    /**
     * @param info
     * @param T
     */
    private void add_Aulas(String[] info, String T) {
        if (info.length == 7) {
            if (T.equals("T")) {
                I_Aula nn = new Teoria(info[1], info[2], info[3], Integer.parseInt(info[4]), Boolean.parseBoolean(info[5]), Boolean.parseBoolean(info[6]));
                Aulas.add(nn);
            }
            if (T.equals("P")) {
                I_Aula nn = new Laboratorio(info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], Integer.parseInt(info[6]));
                Aulas.add(nn);
            }
        }
    }

    /**
     * @param info
     * @param T
     */
    private void add_Asignaturas(String[] info, String T) {
        if (info.length >= 4) {
            if (T.equals("T")) {
                I_Asignatura nn = new Teorica(info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                Asignaturas.add(nn);
            }
            if (T.equals("P")) {
                I_Asignatura nn = new Practica(info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4]));
                Asignaturas.add(nn);
            }
        }
    }

    /**
     * @param info
     */
    private void add_Departamentos(String[] info) {
        if (info.length == 2) {
            Departamento nn = new Departamento(info[0], info[1]);
            Departamentos.add(nn);
        }
    }

    /**
     * @param info
     */
    private void add_Carreras(String[] info) {
        if (info.length == 2) {
            Carrera nn = new Carrera(info[0], info[1]);
            Carreras.add(nn);
        }
    }
    /**
     * @param info
     */
    private void add_Departamento_Asignatura(String[] info) {
        if (info.length == 2) {
            for (int i = 0; i < Departamentos.size(); i++) {
                if (Departamentos.get(i).getID().equals(info[0])) {
                    for (int y = 0; y < Asignaturas.size(); y++) {
                        if (Asignaturas.get(y).getID().equals(info[1])) {
                            Departamentos.get(i).setAsignaturas(Asignaturas.get(y));
                        }
                    }
                }
            }
        }
    }

    
    private void add_Semestres() {
        Semestre n1 = new Semestre(1, 2013);
        Semestre n2 = new Semestre(2, 2013);
        Semestre n3 = new Semestre(1, 2014);
        Semestres.add(n1);
        Semestres.add(n2);
        Semestres.add(n3);
    }

    /**
     * @param info
     */
    private void add_Semestres_MAtricula(String[] info) {
        if (info.length == 5) {
            for (int x = 0; x < Semestres.size(); x++) {
                if ((Semestres.get(x).getSemestre() == Integer.parseInt(info[0]))
                        && (Semestres.get(x).getAño() == Integer.parseInt(info[1]))) {
                    for (int y = 0; y < Asignaturas.size(); y++) {
                        if (Asignaturas.get(y).getID().equals(info[2])) {
                            for (int z = 0; z < Usuarios.size(); z++) {
                                if (Usuarios.get(z) instanceof Profesor) {
                                    Profesor P = (Profesor) Usuarios.get(z);
                                    if (P.getCedula().equals(info[3])) {
                                        Cursos nn = new Cursos(Asignaturas.get(y), P, Integer.parseInt(info[4]));
                                        Semestres.get(x).setCursos(nn);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

        /**
     * @param info
     */
    private void add_AlumnoMatricula(String[] info) {
       if (info.length == 4) {
          for (int i = 0; i < Usuarios.size(); i++) {
                if (Usuarios.get(i) instanceof Alumno) {
                    Alumno A = (Alumno) Usuarios.get(i);
                    if(A.getCarnet().equals(info[0])){
                        for (int x = 0; x < Semestres.size(); x++) {
                            if ((Semestres.get(x).getSemestre() == Integer.parseInt(info[1]))
                                    && (Semestres.get(x).getAño() == Integer.parseInt(info[2]))){
                                for (int y = 0; y < Semestres.get(x).getCursos().size(); y++) {
                                    if (Semestres.get(x).getCursos().get(y).getAsignatura().getID().equals(info[3])) {
                                        AlumnoMatricula nn= new AlumnoMatricula(Semestres.get(x));
                                        nn.setMatricula(Semestres.get(x).getCursos().get(y));
                                        A.setMatricula(nn);
                                    }
                                }
                            }
                        }
                    }
                }
          }
       }
    }
    
    /**
     * @param user
     * @param pasw
     */
    public String[] Login(String user, String pasw) {
        String[] result ={"-1","-1"};
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).Login(user, pasw)) {
                if (Usuarios.get(i) instanceof Alumno) {
                    Alumno na = (Alumno) Usuarios.get(i);
                    result[0] = na.getCarnet();
                    result[1]="A";
                }
                if (Usuarios.get(i) instanceof Profesor) {
                    Profesor np = (Profesor) Usuarios.get(i);
                    result[0] = np.getCedula();
                    result[1]="P";
                }
            }
        }
        return result;
    }

    /**
     * @param userID
     */
    public String Perfil(String userID) {
        String result = "";
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i) instanceof Alumno) {
                Alumno user = (Alumno) Usuarios.get(i);
                if (user.getCarnet().equals(userID)) {
                    result = user.getPerfil();
                }
            }
            if (Usuarios.get(i) instanceof Profesor) {
                Profesor user = (Profesor) Usuarios.get(i);
                if (user.getCedula().equals(userID)) {
                    result = user.getPerfil();
                }
            }
        }
        return result;
    }
       
    
    /* 1.semestre     
     * 2.Aula
     * 3.Curso
     * 4.Crear nuevo Horario
     * 5. Horario -> Semetre
     */
    
    public void GenerarHorario(int S,int _año){
        for(int x=0;x<Semestres.size();x++){
            if((Semestres.get(x).getSemestre()==S)&&(Semestres.get(x).getAño()==_año)){
                if(Semestres.get(x).getSizeHorario()==0){ // tiene horario?
                    for(int y=0;y<Aulas.size();y++){
                        
                        if(Aulas.get(y).getHoraFecha().get(Calendar.DAY_OF_MONTH)<=5){ // dias de semana                           
                            if(Aulas.get(y).getHoraFecha().get(Calendar.HOUR_OF_DAY)<=16){          //horas del dia        
                                
                                if((Aulas.get(y) instanceof Teoria)&&((Semestres.get(x).getCurso("T")!=null))){
                                    Horario NH= new Horario(Aulas.get(y).getHoraFecha(),Semestres.get(x).getCurso("T"),Aulas.get(y)); //nuevo horario
                                    if(NH.getHoraFecha_Final().get(Calendar.HOUR_OF_DAY)>15){                       //Hora maxima
                                        Calendar HI=NH.getHoraFecha_Inicio();                     
                                        int Min=Semestres.get(x).getCurso("T").getMinAsignados();
                                        while((Semestres.get(x).getCurso("T").getMinAsignados()>=Min)&&(HI.get(Calendar.HOUR_OF_DAY)<16)){
                                            HI.add(Calendar.MINUTE, 50);
                                            Min+=50;
                                        }
                                        if(Min>0){
                                            Calendar HF=NH.getHoraFecha_Inicio();
                                            HF.add(Calendar.MINUTE, Min);                                    
                                            NH.setHoraFecha_Final(HF);
                                            Semestres.get(x).getCurso("T").setMinAsignados(Min);                                      

                                            Semestres.get(x).setHorario(NH);
                                            Aulas.get(y).setHoraFecha_MHD(1,7,0);
                                            Horario recreo= new Horario(Aulas.get(y).getHoraFecha(), null, null);
                                            Semestres.get(x).setHorario(recreo);
                                        }
                                    }
                                    else{ // horario sin problemas
                                        Aulas.get(y).setHoraFecha(NH.getHoraFecha_Final());
                                        Semestres.get(x).setHorario(NH);
                                        Horario recreo= new Horario(Aulas.get(y).getHoraFecha(), null, null);
                                        Semestres.get(x).setHorario(recreo);
                                    }
                                }
                                if((Aulas.get(y) instanceof Laboratorio)&&((Semestres.get(x).getCurso("P")!=null))){
                                    Horario NH= new Horario(Aulas.get(y).getHoraFecha(),Semestres.get(x).getCurso("P"),Aulas.get(y)); //nuevo horario
                                    if(NH.getHoraFecha_Final().get(Calendar.HOUR_OF_DAY)>15){                       //Hora maxima
                                        Calendar HI=NH.getHoraFecha_Inicio();                     
                                        int Min=Semestres.get(x).getCurso("P").getMinAsignados();
                                        while((Semestres.get(x).getCurso("P").getMinAsignados()>=Min)&&(HI.get(Calendar.HOUR_OF_DAY)<16)){
                                            HI.add(Calendar.MINUTE, 50);
                                            Min+=50;
                                        }
                                        if(Min>0){
                                            Calendar HF=NH.getHoraFecha_Inicio();
                                            HF.add(Calendar.MINUTE, Min);                                    
                                            NH.setHoraFecha_Final(HF);
                                            Semestres.get(x).getCurso("P").setMinAsignados(Min);                                      

                                            Semestres.get(x).setHorario(NH);
                                            Aulas.get(y).setHoraFecha_MHD(1,7,0);
                                            Horario recreo= new Horario(Aulas.get(y).getHoraFecha(), null, null);
                                            Semestres.get(x).setHorario(recreo);
                                        }
                                    }
                                    else{ // horario sin problemas
                                        Aulas.get(y).setHoraFecha(NH.getHoraFecha_Final());
                                        Semestres.get(x).setHorario(NH);
                                        Horario recreo= new Horario(Aulas.get(y).getHoraFecha(), null, null);
                                        Semestres.get(x).setHorario(recreo);
                                    }
                                }
                            }
                            else{
                                Aulas.get(y).setHoraFecha_MHD(1,7,0);
                            }
                        }
                        
                    }
                }
            }
        }
    }
    
    public Principal() {

        // Son inicializadas todas las listas con  las que va a trabajar el sistema        
        this.Usuarios = new ArrayList<I_Usuario>();
        this.Departamentos = new ArrayList<Departamento>();
        this.Asignaturas = new ArrayList<I_Asignatura>();
        this.Aulas = new ArrayList<I_Aula>();
        this.Carreras = new ArrayList<Carrera>();
        this.Semestres = new ArrayList<Semestre>();
        Read_File("Carreras.txt", "O");   
        Read_File("Departamentos.txt", "D");   
        Read_File("Alumnos.txt", "E");
        Read_File("Profesores.txt", "P");             
        Read_File("aulas.txt", "A");
        Read_File("Asignaturas.txt", "C");
        Read_File("Departamento-Asignatura.txt", "DA");        
        add_Semestres();
        Read_File("matricula.txt", "M");
        Read_File("AlumnoMatricula.txt", "AM");
        
        this.mostrarUsuarios();
//        /*
       
    }

    private void mostrarUsuarios() {

        for (int i = 0; i < Usuarios.size(); i++) {

            if (Usuarios.get(i) instanceof Alumno) {
                Alumno x = (Alumno) Usuarios.get(i);
                System.out.println(x.getCarnet());
            } else if (Usuarios.get(i) instanceof Profesor) {
                Profesor x = (Profesor) Usuarios.get(i);
                System.out.println(x.getCedula());
            }
        }
    }
}
