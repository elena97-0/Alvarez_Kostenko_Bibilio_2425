/**
 * Es la clase donde se almacena las caracteristicas del usuario.
 * 
 * @author Daniel Alvarez Morales
 * @version 1.0
 * @since 2025
 * 
 * @author Elena Kostenko
 * @version 2.0
 * @since 2025
 * 
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

    
    /** Es un método que devuelve el nombre de usuario
     * @return String Nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    
    /**
     * Es un método que devuelve la contraseña de usuario
     * 
     * @return String de contraseña
     */
    public String getContrasenia() {
        return contrasenia;
    }

    
    /**
     * Es un método que devuelve el DNI de usuario
     * 
     * @return String de DNI de usuario
     */
    public String getDni() {
        return dni;
    }

    
    /**
     * Es una función que pasa por parámetro el nombre de usuario 
     * 
     * @param nombreUsuario nombre
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    /** Es una función que pasa por parámetro la contraseña
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
