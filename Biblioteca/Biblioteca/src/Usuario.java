/**
 * Es la clase donde se almacena las caracteristicas del usuario.
 * 
 * @author Daniel Alvarez Morales
 * @version 1.0
 * @since 2025
 * 
 */
public class Usuario {

    private String nombreUsuario;
    private String contrasenia;
    private String dni;

    public Usuario(String nombreUsuario, String contrasenia, String dni) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.dni = dni;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getDni() {
        return dni;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
