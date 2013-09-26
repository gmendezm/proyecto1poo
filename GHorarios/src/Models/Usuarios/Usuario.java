/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Usuarios;

/**
 *
 * @author Estudiante
 */
public abstract class Usuario {
    private int ID;
    private String Nombre;
    private String Apellidos;

    public Usuario(int ID, String Nombre, String Apellidos) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
    }
     
    
}
