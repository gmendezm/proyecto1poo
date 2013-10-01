
package Controllers;

import Models.Carreras.Carrera;
import Models.Usuarios.Alumno;
import Models.Usuarios.I_Usuario;
import Models.Usuarios.Profesor;
import Models.Usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import sun.awt.geom.AreaOp;

/**
 *
 * @author Soporte
 */
public class main {
    private ArrayList<I_Usuario> Usuarios ;
    
    
    private void add_Usuarios()
    {
         I_Usuario a1= new Alumno("2008","Osa","123");
         I_Usuario p1= new Profesor("Oscar", "6-0000-0000","Oviquez","123");
        Usuarios.add(a1);
        Usuarios.add(p1);
          
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

    public main() {
        this.Usuarios =  new ArrayList<I_Usuario> ();
         this.add_Usuarios();
         this.mostrarUsuarios();
    }  
    
  public static void main(String arg[])
  {
      new main();
      return;
  }
}
