/**
 * Es la clase donde se almacena las caracteristicas del libro.
 * 
 * @author Daniel Alvarez Morales
 * @version 1.0
 * @since 2025
 * 
 */

public class Libro {

    private String titulo;
    private String autor;
    private String categoria;
    private int isbn;
    private static int contadorIsbn;

    public Libro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.isbn = contadorIsbn;
        contadorIsbn++;

    }

    public String getTitulo() {
        return titulo;
    }

    public int getIsbn() {
        return isbn;
    }

}
