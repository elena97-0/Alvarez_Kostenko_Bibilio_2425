import java.util.Scanner;

public class App {

    public static void login() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|         Bienvenidos a la biblioteca.          |");
        System.out.println("|                ¡Inicia sesion!                |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                   Log-in                      |");
        System.out.println("|                                               |");
        System.out.println("|           ¿Usuario  o Administrador?          |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void menu() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|         Bienvenidos a la biblioteca           |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|         1.-Gestión de libros                  |");
        System.out.println("|         2.-Gestión de usuarios                |");
        System.out.println("|         3.-Gestión de prestamos               |");
        System.out.println("|         4.-Estadísticas                       |");
        System.out.println("|         5.-Salir                              |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void submenu1() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|       Bienvenidos a la gestión de libros      |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|    1.-Agregar libros nuevos (admin)           |");
        System.out.println("|    2.-Eliminar libros existentes (admin)      |");
        System.out.println("|    3.-Buscar libros                           |");
        System.out.println("|    4.-Todos los libros disponibles            |");
        System.out.println("-------------------------------------------------");

    }

    public static void submenu2() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|       Bienvenidos a la gestión de usuarios    |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|     1.-Registrar nuevos usuarios (admin)      |");
        System.out.println("|     2.-Consultar informacion usuarios (admin) |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void submenu3() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|      Bienvenidos a la gestión de préstamos    |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|      1.-Realizar préstamos de libros          |");
        System.out.println("|      2.-Devolver libros prestados             |");
        System.out.println("|      3.-Libros actualmente prestados (admin)  |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void submenu4() {

        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|      Bienvenidos a las estadísticas           |");
        System.out.println("|                                               |");
        System.out.println("|                                               |");

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|    1.-Numeros de préstamos totales y activos  |");
        System.out.println("|    2.-Libros más prestados                    |");
        System.out.println("|    3.-Usuario con más préstamos activos       |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");

    }

    public static void main(String[] args) {

        // Creacion de objetos

        // Arrays con limite 15
        Libro[] arrayLibros = new Libro[15];
        Libro[] arrayLibrosPrestados = new Libro[15];
        Libro[] arrayLibrosTomados = new Libro[15];

        // Usuarios
        Usuario[] arrayUsuarios = new Usuario[15];
        Usuario daniel = new Usuario("dani55", "1234", "12345678H");
        // Usuario elena = new Usuario("elena55", "1111", "13");

        Biblioteca biblioteca = new Biblioteca(0, 0, arrayUsuarios, arrayLibros, 0, arrayLibrosPrestados);

        // Libro
        Libro don_Quijote = new Libro("Don_Quijote", "Miguel de Cervantes", "Comedia");
        Libro el_Conde_Monte_Cristo = new Libro("El Conde de Montecristo", "Alexandre Dumas", "Aventura");
        Libro crimen_y_Castigo = new Libro("Crimen y Castigo", "Fiódor Dostoievski", "Drama psicológico");
        Libro mil_novecientos_ochenta_y_cuatro = new Libro("1984", "George Orwell", "Ciencia ficción distópica");
        biblioteca.agregarUsuario(daniel);
        // Programa
        String libroIsbn = "";
        boolean noVolverIniciarSesion = true;
        Usuario sesionUsuario = null;
        do {
            login();

            Scanner sc = new Scanner(System.in);
            sesionUsuario = null;

            boolean logInIncorrecto = true;

            do {
                String logIn = sc.nextLine().toLowerCase();

                switch (logIn) {
                    case "usuario":
                        logInIncorrecto = false;
                        System.out.println("Vas a iniciar sesión como usuario");

                        break;
                    case "administrador":
                        logInIncorrecto = false;
                        System.out.println("Vas a iniciar sesión como administrador");

                        break;
                    default:
                        System.out.println("No permitido, intentalo otra vez");
                        System.out.println("Tienes que introducir usuario o administrador");

                        break;
                }
            } while (logInIncorrecto);

            // No se crean usuarios nuevos sino que se inician ya existentes por ahora
            int posPassword = -1;
            boolean usuarioNoEcontrado;
            boolean contraseniaIncorrecta;

            do {
                usuarioNoEcontrado = true;
                contraseniaIncorrecta = true;

                System.out.println("Introduce un nombre de usuario");
                String nameUser = sc.nextLine();
                System.out.println("Introduce una contraseña");
                String passwordUser = sc.nextLine();
                boolean usuarioEncontrado = true;
                for (int i = 0; i < biblioteca.getNumUsuarios() && usuarioEncontrado; i++) {
                    if (biblioteca.getArrayUsuarios()[i].getNombreUsuario().equals(nameUser)) {
                        usuarioNoEcontrado = false;
                        posPassword = i;

                        usuarioEncontrado = false;
                    }
                }

                if (!usuarioNoEcontrado) {
                    System.out.println("Usuario " + nameUser + " encontrado con éxito");

                    // IMporatnate //Quizas borrar.
                    // Asignamos el préstamo al usuario que acaba de iniciar sesión
                    sesionUsuario = biblioteca.getArrayUsuarios()[posPassword];

                    if (biblioteca.getArrayUsuarios()[posPassword].getContrasenia().equals(passwordUser)) {
                        contraseniaIncorrecta = false;
                        System.out.println("Contraseña correcta, inicio de sesión exitoso.");
                    } else {
                        System.out.println("Contraseña incorrecta, intentalo otra vez.");
                    }
                } else {
                    System.out.println("Usuario " + nameUser + " no encontrado, intentalo otra vez");
                }

            } while (usuarioNoEcontrado || contraseniaIncorrecta);

            int opcion;

            boolean salir = true;
            do {
                menu();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has elegido gestion de libros");
                        submenu1();
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:

                                System.out.println("Has elegido Agregar libros");

                                break;
                            case 2:
                                System.out.println("Has elegido eliminar libros");

                                break;
                            case 3:
                                System.out.println("Has elegido buscar libros ya sea por titulo, categoria o autor");

                                break;

                            case 4:
                                System.out.println("Has elegido mostrar todos los libros disponibles");
                                break;

                            default:
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Has elegido gestion de usuarios");
                        submenu2();
                        opcion = sc.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println("Has elegido registrar nuevo usuario ");
                                System.out.println("Introduce el nombre de usuario a registrar");
                                sc.nextLine(); //limpiar el buffer
                                String nombreUsuario = sc.nextLine();
                                System.out.println("Introduce el dni de usuario a registrar");
                                String dni = sc.nextLine();
                                System.out.println("Introduce la contraseña de usuario a registrar");
                                String contrasenia = sc.nextLine();
                                biblioteca.registrarUsuario(nombreUsuario, dni, contrasenia);
                                
                                
                                break;
                            case 2:
                                System.out.println("Has elegido consultar informacion de usuarios registrados ");
                                biblioteca.mostrarInfUsuarioRegistrado();

                                break;

                            default:
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("Has elegido gestion de préstamos");

                        submenu3();
                        opcion = sc.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println("Has elegido realizar prestamo de libro ");

                                break;
                            case 2:
                                System.out.println("Has elegido devolver libros prestados ");

                                break;
                            case 3:
                                System.out.println("Has elegido mostrar libros actualmente prestados ");
                                break;

                            default:
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("Has elegido las estadisticas de la biblioteca");
                        submenu4();
                        opcion = sc.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.println("Has elegido numeros de prestamos totales y activos");

                                break;
                            case 2:
                                System.out.println("Has elegido listar los libros mas prestados ");

                                break;
                            case 3:
                                System.out.println("Has elegido mostrar que usuario tiene más préstamos activos");

                                break;
                            default:
                                break;
                        }

                        break;

                    case 5:
                        System.out.println("Has elegido: Salir de la cuenta");

                        salir = false;
                        break;
                    default:
                        System.out.println("Porfavor, ingresa una de la opciones que se muestran en el menu");
                        System.out.println("Intentelo otra vez");

                        break;
                }

            } while (salir);

            System.out.println("Has salido de la cuenta");

            System.out.println("¿Quieres volver a iniciar sesion?");
            System.out.println("si/no");
            // Limpiando buffer;
            sc.nextLine();
            String cambiarSesion = sc.nextLine().toLowerCase();

            if (cambiarSesion.equals("no")) {
                noVolverIniciarSesion = false;
            }

        } while (noVolverIniciarSesion);

        System.out.println("Has salido del programa");

    }
}
