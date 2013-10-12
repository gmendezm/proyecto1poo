package Controllers;

import Models.Asignaturas.Asignatura;
import Models.Asignaturas.Horario;
import Models.Asignaturas.I_Asignatura;
import Models.Asignaturas.Matricula;
import Models.Asignaturas.Practica;
import Models.Asignaturas.Semestre;
import Models.Asignaturas.Teorica;
import Models.Aulas.Aula;
import Models.Aulas.I_Aula;
import Models.Aulas.Laboratorio;
import Models.Aulas.Teoria;
import Models.Carreras.Carrera;
import Models.Departamentos.Departamento;
import Models.Usuarios.Alumno;
import Models.Usuarios.I_Usuario;
import Models.Usuarios.Profesor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Principal {

    private static ArrayList<I_Usuario> Usuarios;
    private static ArrayList<I_Aula> Aulas;
    private static ArrayList<Departamento> Departamentos;
    private static ArrayList<I_Asignatura> Asignaturas;
    private static ArrayList<Carrera> Carreras;
    private static ArrayList<Semestre> Semestres;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    /**
     * @param data
     *
     */
    private String[] toADD(String data) {
        return data.split(",");
    }

    public static ArrayList<I_Asignatura> getAsignaturas() {
        return Asignaturas;
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
                                        Matricula nn = new Matricula(Asignaturas.get(y), Usuarios.get(z), Integer.parseInt(info[4]), null);
                                        Semestres.get(x).insertarCurso(nn);
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
    public String Login(String user, String pasw) {
        String result = "-1";
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).Login(user, pasw)) {
                if (Usuarios.get(i) instanceof Alumno) {
                    Alumno na = (Alumno) Usuarios.get(i);
                    result = na.getCarnet();
                }
                if (Usuarios.get(i) instanceof Profesor) {
                    Profesor np = (Profesor) Usuarios.get(i);
                    result = np.getCedula();
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

    public Principal() {

        // Son inicializadas todas las listas con  las que va a trabajar el sistema
        this.Usuarios = new ArrayList<I_Usuario>();
        this.Departamentos = new ArrayList<Departamento>();
        this.Asignaturas = new ArrayList<I_Asignatura>();
        this.Aulas = new ArrayList<I_Aula>();
        this.Carreras = new ArrayList<Carrera>();
        this.Semestres = new ArrayList<Semestre>();
        //Read_File("Alumnos.txt", "E");
        // Read_File("Profesores.txt", "P");

        // Primero se agrega un departamento, al que se asocian los profesores
        String[] d1 = {"EC", "Escuela de Computacion"};
        add_Departamentos(d1);

        // Debe existir una carrera, a la que se asocian los alumnos
        String[] c1 = {"IC", "Ingenieria en Computacion"};
        add_Carreras(c1);

        // Luego deben ser inscritos los estudiantes
        String[] u1 = {"Daniel Murillo", "200854763", "osa", "123", "IC"};
        String[] u2 = {"Geovanny Mendez Marin", "201014364", "gmendezm", "gmendezm", "IC"};
        add_Usuarios(u1, "E");
        add_Usuarios(u2, "E");

        // Son inscritos los profesores
        String[] p1 = {"Oscar Viquez", "1050", "osviquez", "789", "EC"};
        add_Usuarios(p1, "P");

        // Se agregan las aulas
        String[] a1 = {"T", "Administracion", "5", "Segundo Piso CyL", "28", "true", "true"};
        String[] a2 = {"P", "Laimi", "0", "Costado Soda", "30", "Lenovo i5 Monitor 22 ", "24"};

        add_Aulas(a1, "T");
        add_Aulas(a2, "P");

        // Se agregan las materias
        String[] m1 = {"P", "IC-2020", "POO", "3", "3"};
        String[] m2 = {"T", "MA-1414", "Calculo", "4", "2"};

        add_Asignaturas(m1, "P"); // Practica
        add_Asignaturas(m2, "T"); // Teorica

        // Se agregan los semestres
        add_Semestres();
       
        // Se agrega ese semestre al primer estudiante de la lista
        ((Alumno)this.Usuarios.get(0)).agregarSemestre(this.Semestres.get(0));
        
        // Se crea un horario
        Horario h = new Horario( 1, 7, this.Aulas.get(0));
        
        // Se agrega una matricula para una asignatura y un usuario especifico
        Matricula mat1 = new Matricula(this.Asignaturas.get(0), this.Usuarios.get(2),50, h);
        
         
        // Se obtiene el semestre del estudiante y se le agrega a ese semestre, la matricula
        ((Alumno)this.Usuarios.get(0)).getSemestre(1, 2013).insertarCurso(mat1);
               
       // sem1.insertarCurso(null);
             
        this.mostrarUsuarios();
        /*
       
      
         //this.add_Usuarios();
         Read_File("Departamentos.txt", "D");
         Read_File("Carreras.txt", "O");
        
        
         Read_File("aulas.txt", "A");
         Read_File("Asignaturas.txt", "C");
         Read_File("Departamento-Asignatura.txt", "DA");
         add_Semestres();
         Read_File("matricula.txt", "M");
         //this.mostrarUsuarios();
         * */
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
