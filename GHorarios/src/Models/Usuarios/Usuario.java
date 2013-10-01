package Models.Usuarios;

public abstract class Usuario{
    private int ID;
    private String Nombre;
    private String Apellidos;
    private String Usuario;
    private String Contraseña;

    public Usuario(String Usuario, String Contraseña) {
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }
     
    public boolean Login(String user,String pasw)
    {
        if((Usuario==user)&& (Contraseña==pasw))
        {
            return true;
        }
        else
            return false;
    }
}
