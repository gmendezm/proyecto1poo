/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Asignaturas.I_Asignatura;
import Models.Asignaturas.Practica;
import Models.Asignaturas.Teorica;
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
    private static ArrayList<I_Usuario> Usuarios ;
    private static ArrayList<I_Aula> Aulas;
    private static ArrayList<I_Asignatura> Asignaturas;
    private static ArrayList<Departamento> Departamentos;
    private static ArrayList<Carrera> Carreras;
    
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    private String[] toADD(String data){
            return data.split(",");
    }
        
     private void Read_File(String thisfile,String T)
     {
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (thisfile);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            add_to(toADD(linea),T);//System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }    
    
      private void add_to(String[] info,String T){
          if((T.equals("E"))||(T.equals("P")))
               add_Usuarios(info, T);
            if(T.equals("A"))
                add_Aulas(info,info[0]);
            if(T.equals("C"))
                add_Asignaturas(info,info[0]);
            if(T.equals("D"))
                add_Departamentos(info);
             if(T.equals("O"))
                add_Carreras(info);
             if(T.equals("PD"))
                add_Profesor_Departamento(info);
             
             
      }
     
    private void add_Usuarios(String[] info,String T)
    {
        if(info.length==4){
            if(T.equals("E")){
                I_Usuario nn= new Alumno(info[0],info[1],info[2],info[3]);
                Usuarios.add(nn);  
            }
            if(T.equals("P")){
                I_Usuario nn= new Profesor(info[0],info[1],info[2],info[3]);
                 Usuarios.add(nn);  
            }
        }
}
   
    private void add_Aulas(String[] info,String T){
        if(info.length==7){
            if(T.equals("T")){
                I_Aula nn= new Teoria(info[1],info[2],info[3],Integer.parseInt(info[4]),Boolean.parseBoolean(info[5]),Boolean.parseBoolean(info[6]));
                Aulas.add(nn);  
            }
            if(T.equals("P")){
                I_Aula nn= new Laboratorio(info[1],info[2],info[3],Integer.parseInt(info[4]),info[5],Integer.parseInt(info[6]));
                Aulas.add(nn);  
            }
        }
    }
    
      private void add_Asignaturas(String[] info,String T){
        if(info.length==4){
            if(T.equals("T")){
                I_Asignatura nn= new Teorica(info[1], info[2], Integer.parseInt(info[3]));
                Asignaturas.add(nn);  
            }
            if(T.equals("P")){
                I_Asignatura nn= new Practica(info[1], info[2], Integer.parseInt(info[3]));
                Asignaturas.add(nn);  
            }
        }
    }
  
     private void add_Departamentos(String[] info){
        if(info.length==2){
                Departamento nn= new Departamento(info[0],info[1]);
                Departamentos.add(nn);  
        }
    }
     
     private void add_Carreras(String[] info){
        if(info.length==2){
            Carrera nn= new Carrera(info[0], info[1]);
            Carreras.add(nn);  
        }
    }
     
    private void add_Profesor_Departamento(String[] info){
        if(info.length==2){
             for(int  i = 0; i < Usuarios.size(); i++){
                 if( Usuarios.get(i) instanceof Profesor){
                     Profesor P=(Profesor)Usuarios.get(i);
                     if(P.getCedula().equals(info[0])){
                         for(int  y = 0; y < Departamentos.size(); y++){
                             if(Departamentos.get(y).getID().equals(info[1])){
                                 P.setDepartamento(Departamentos.get(y));
                             }
                         }
                     }
                 }
             }
        }
    }
     
  public String Login(String user,String pasw)
  {
      String result= "-1";
      for(int  i = 0; i < Usuarios.size(); i++){
           if(Usuarios.get(i).Login(user, pasw)){
               if( Usuarios.get(i) instanceof Alumno){
                   Alumno na=(Alumno)Usuarios.get(i);
                    result=na.getCarnet();}
               if( Usuarios.get(i) instanceof Profesor){
                   Profesor np=(Profesor)Usuarios.get(i);
                   result=np.getCedula();}
           }
      } 
      return result;
  }

  public String Perfil(String userID){
      String result="";
      for(int  i = 0; i < Usuarios.size(); i++){
               if( Usuarios.get(i) instanceof Alumno){
                   Alumno user=(Alumno)Usuarios.get(i);
                   if(user.getCarnet().equals(userID))
                       result=user.getPerfil();
               }
               if( Usuarios.get(i) instanceof Profesor){
                   Profesor user=(Profesor)Usuarios.get(i);
                   if(user.getCedula().equals(userID))
                       result=user.getPerfil();
               }
           }
      return result;
  }
  
    public Principal(){
        this.Usuarios =  new ArrayList<I_Usuario> ();
        this.Departamentos =  new ArrayList<Departamento> ();
        this.Aulas =  new ArrayList<I_Aula> ();
        this.Asignaturas =  new ArrayList<I_Asignatura> ();
        this.Carreras =  new ArrayList<Carrera> ();
         //this.add_Usuarios();
         Read_File("Departamentos.txt","D");
         Read_File("Alumnos.txt","E");
         Read_File("Profesores.txt","P");
         Read_File("aulas.txt","A");
         Read_File("Asignaturas.txt","C");
         Read_File("Carreras.txt","O");
         Read_File("Profesor-Departamento.txt","PD");
         //add_Aulas();
         //this.mostrarUsuarios();
    }  
   
    
     private void mostrarUsuarios(){
  
      for(int  i = 0; i < Usuarios.size(); i++){
              
       if( Usuarios.get(i) instanceof Alumno)
       {
           Alumno x = (Alumno)Usuarios.get(i);           
           System.out.println(x.getCarnet());    
       }       
       else if( Usuarios.get(i) instanceof Profesor)
       {
           Profesor x = (Profesor)Usuarios.get(i);
           System.out.println(x.getCedula());
       }
      }
  }
}


