package Models.Usuarios;

import javax.print.DocFlavor;

public abstract class Usuario{

    private String Nombre;
    private String Usuario;
    private String Contraseña;

    public Usuario(String nombre,String Usuario, String Contraseña) {
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Nombre= nombre;
    }

    public String getNombre() {
        return Nombre;
    }
    
    public boolean Login(String user,String pasw)
    {
        if(user.equals(this.Usuario)&& pasw.equals(this.Contraseña))
        {
            return true;
        }
        else
            return false;
    }
}
