public class Biblioteca {
    private int numLibros;
    private int numUsuarios;
    private Usuario[] arrayUsuarios;
    private Libro[] arrayLibros;
    private Libro[] arraylibrosPrestados;
    private int nLibrosPrestados;

    /* constructor */
    public Biblioteca(int numLibros, int numUsuarios, Usuario[] arrayUsuarios, Libro[] arrayLibros,
            int nLibrosPrestados, Libro[] arraylibrosPrestados) {
        this.numLibros = numLibros;
        this.numUsuarios = numUsuarios;
        this.arrayUsuarios = arrayUsuarios;
        this.arrayLibros = arrayLibros;
        this.arraylibrosPrestados = arraylibrosPrestados;
        this.nLibrosPrestados = nLibrosPrestados;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public int getNumUsuarios() {
        return numUsuarios;
    }

    public void setNumUsuarios(int numUsuarios) {
        this.numUsuarios = numUsuarios;
    }

    public Usuario[] getArrayUsuarios() {
        return arrayUsuarios;
    }

    public void setArrayUsuarios(Usuario[] arrayUsuarios) {
        this.arrayUsuarios = arrayUsuarios;
    }

    public Libro[] getArrayLibros() {
        return arrayLibros;
    }

    public void setArrayLibros(Libro[] arrayLibros) {
        this.arrayLibros = arrayLibros;
    }

    private boolean checkeadorArraysUsuarios(String nombreUsuario) {
        boolean noExiste = true;
        for (int i = 0; i < this.arrayUsuarios.length && noExiste; i++) {
            if (arrayUsuarios[i].getNombreUsuario().equals(nombreUsuario)) {
                noExiste = false;

            }
        }

        return noExiste;
    }

    private boolean checkeadorArraysLibrosPrestados(int isbn) {
        boolean noExiste = true;
        for (int i = 0; i < this.arraylibrosPrestados.length && noExiste; i++) {
            if (arraylibrosPrestados[i].getIsbn() == (isbn)) {
                noExiste = false;

            }
        }

        return noExiste;

    }

    private boolean checkeadorArraysLibros(int isbn) {
        boolean noExiste = true;
        for (int i = 0; i < this.arrayLibros.length && noExiste; i++) {
            if (arrayLibros[i] != null && arrayLibros[i].getIsbn() == (isbn)) {
                noExiste = false;

            }
        }

        return noExiste;

    }


    public void AgregarLibroNuevo(Usuario usuario) {

        if (numUsuarios < this.arrayUsuarios.length) {
            this.arrayUsuarios[numUsuarios] = usuario;
            numUsuarios++;
        } else {
            System.out.println("No caben mas usuarios (Está lleno la biblioteca de usuarios)");
        }

    }

    public void registrarUsuario(String nombreUsuario, String dni, String contrasenia) {
        Usuario usuario = new Usuario(null, null, null);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);
        usuario.setDni(dni);
        if (numUsuarios < this.arrayUsuarios.length) {
            this.arrayUsuarios[numUsuarios] = usuario;
            numUsuarios++;
        } else {
            System.out.println("No caben mas usuarios (Está lleno la biblioteca)");
        }
    }
    
    public void mostrarInfUsuarioRegistrado() {
        boolean noExiste = true;
        for (int i = 0; i < getNumUsuarios(); i++) {
            arrayUsuarios[i].getDni();
            noExiste = false;
            System.out.println("El usuario con nombre " + arrayUsuarios[i].getNombreUsuario() + " y el dni "
                    + arrayUsuarios[i].getDni() + " tiene la contraseña " + arrayUsuarios[i].getContrasenia());

        }
        if (noExiste) {
            System.out.println("No existen usuarios para mostrar");
        }
    }
        
    public void agregarUsuario(Usuario usuario) {

        if (numUsuarios < this.arrayUsuarios.length) {
            this.arrayUsuarios[numUsuarios] = usuario;
            numUsuarios++;
        } else {
            System.out.println("No caben mas usuarios (Está lleno la biblioteca)");
        }

    }
}
