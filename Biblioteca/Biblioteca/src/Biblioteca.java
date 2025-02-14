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


    public void AgregarLibroNuevo(String titulo, String autor, String categoria) {
        Libro libro = new Libro(titulo, autor, categoria);
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setTitulo(titulo);
        if (numLibros < this.arrayLibros.length) {
            this.arrayLibros[numLibros] = libro;
            numLibros++;
        } else {
            System.out.println("No caben mas libros (Está lleno la biblioteca de libros)");
        }

    }

    public void mostrarLibrosDisponibles() {
        boolean noExiste = true;
        for (int i = 0; i < getNumLibros(); i++) {
            arrayLibros[i].getIsbn();
            noExiste = false;
            System.out.println("El libro con título " + arrayLibros[i].getTitulo() + " y el autor "
                    + arrayLibros[i].getAutor() + " tiene la categoría " + arrayLibros[i].getCategoria() + " y isbn "
                    + arrayLibros[i].getIsbn());

        }
        if (noExiste) {
            System.out.println("No existen libros para mostrar");
        }
    }
    
    public void buscarlibro(int isbn_introducido) {
        boolean noExiste = checkeadorArraysLibros(isbn_introducido);
        
        if (noExiste) {
            System.out.println("No existe");
        } else {
            for (int i = 0; i < getNumLibros(); i++) {
                if (arrayLibros[i].getIsbn() == isbn_introducido) {
                    System.out.println("El libro con isbn " + arrayLibros[i].getIsbn() + " , el título "
                            + arrayLibros[i].getTitulo() + ", la categoría " + arrayLibros[i].getCategoria()
                            + " y el autor " + arrayLibros[i].getAutor() + " encontrado");

                }
            }
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

    public void eliminarLibro(int isbn) {
        boolean noExiste = checkeadorArraysLibros(isbn);
        if (noExiste == true) {
            System.out.println("Error, no existe el libro a eliminar");
        } else {
            System.out.println("Eliminación realizada con éxito");
            if (getNumLibros() >= 1) {
                boolean encontrado = true;
                for (int i = 0; getNumLibros() < i && encontrado; i++) {
                    if (arrayLibros[i].getIsbn() == isbn) {
                        encontrado = false;
                        arrayLibros[i] = null;
                        numLibros--;
                        for (int j = 0; j < numLibros - 1; j++) {
                            arrayLibros[j] = arrayLibros[j + 1];
                        }
                    }
                    
                }

            } else {
                System.out.println("No se puede eliminar, no hay ningún libro");

            }
        }
        
    }
}
