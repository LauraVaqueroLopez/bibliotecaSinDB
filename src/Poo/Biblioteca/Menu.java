package Poo.Biblioteca;

import java.util.Comparator;
import java.util.Scanner;

public class Menu implements Comparator<Libro> {
    public static void main(String[] args) throws LibroEliminadoException, ErrorModificarLibroException{
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();

        Autor autor18 = new Autor("Antonio Perez",  37);
        Autor autor28 = new Autor("Benito Gonzalez", 40);
        autor.añadirAutor(autor18);
        autor.añadirAutor(autor28);

        Libro libro1= new Libro(autor18, "Cenicienta", "ISBN123");
        Libro libro2= new Libro(autor28, "La cabaña", "ISBN456");
        Libro libro3= new Libro(autor28, "Plancanieves", "ISBN789");
        Libro libro4= new Libro(autor18, "Ienicienta", "ISBN974");

        biblioteca.getLibros().add(libro1);
        biblioteca.getLibros().add(libro2);
        biblioteca.getLibros().add(libro3);
        biblioteca.getLibros().add(libro4);

        boolean salir = false;

        while (!salir) {

            System.out.println("\nMENU");
            System.out.println("1. Ver biblioteca");
            System.out.println("2. Ver autores");
            System.out.println("3. Añadir libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Modificar libro");
            System.out.println("6. Añadir autor");
            System.out.println("7. Eliminar autor");
            System.out.println("8. Salir");

            System.out.print("\nOPCION: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {

                case 1 -> {
                    boolean salir2 = false;
                    while (!salir2){
                        System.out.println("\n1. Ordenar normal");
                        System.out.println("2. Ordenar por autor");
                        System.out.println("3. Ordenar por titulo");
                        System.out.println("4. Ordenar por isbn");
                        System.out.println("5. Atrás");

                        System.out.println("\nElige una opción: ");
                        int opcion2 = scanner.nextInt();

                        switch (opcion2){
                            case 1 -> {
                                if (biblioteca.getLibros().isEmpty()) {
                                    System.out.println("Biblioteca vacía. Añada libros primero.");
                                } else {
                                    for (Libro libro : biblioteca.getLibros()) {
                                        System.out.println(libro);
                                    }
                                }
                            }

                            case 2 -> {

                                if (biblioteca.getLibros().isEmpty()) {
                                    System.out.println("Biblioteca vacía. Añada libros primero.");
                                } else {
                                    ComparatorAutor compararAutor = new ComparatorAutor();
                                    biblioteca.getLibros().sort(compararAutor);
                                    for (Libro libro : biblioteca.getLibros()) {
                                        System.out.println(libro);
                                    }
                                }
                            }

                            case 3 -> {
                                if (biblioteca.getLibros().isEmpty()) {
                                    System.out.println("Biblioteca vacía. Añada libros primero.");
                                } else {
                                    biblioteca.getLibros().sort(new ComparatorNombreLibro());
                                    for (Libro libro : biblioteca.getLibros()) {
                                        System.out.println(libro);
                                    }
                                }
                            }

                            case 4 -> {
                                if (biblioteca.getLibros().isEmpty()) {
                                    System.out.println("Biblioteca vacía. Añada libros primero.");
                                } else {
                                    biblioteca.getLibros().sort(new ComparatorISBN());
                                    for (Libro libro : biblioteca.getLibros()) {
                                        System.out.println(libro);
                                    }
                                }
                            }

                            case 5 -> {
                                System.out.println("Volviendo atrás...");
                                salir2 = true;
                            }
                        }
                    }
                }

                case 2 -> {
                    if (autor.getAutores().isEmpty()) {
                        System.out.println("Biblioteca vacía. Añada libros primero.");
                    } else {
                        for (Autor autor1 : autor.getAutores()) {
                            System.out.println(autor1);
                        }
                    }
                }

                case 3 -> {
                    if (autor.getAutores().isEmpty()) {
                        System.out.println("No hay autores disponibles. Añada un autor primero.");
                    }

                    System.out.println("Lista de autores disponibles:");
                    for (Autor autore : autor.getAutores()) {
                        System.out.println(autore.getNombre());
                    }

                    System.out.print("Elija un autor de la lista: ");
                    String nombre = scanner.nextLine();

                    Autor autorIngresar = null;

                    for (Autor autor1 : autor.getAutores()) {
                        if (nombre.equals(autor1.getNombre())) {
                            autorIngresar = autor1;
                        }
                    }

                    if (autorIngresar == null) {
                        System.out.println("El autor no existe. Añádalo primero.");
                    }

                    System.out.print("Escriba el título del libro: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Escriba el ISBN: ");
                    String isbn = scanner.nextLine();

                    Libro libro = new Libro(autorIngresar, nombreLibro, isbn);
                    biblioteca.insertar(libro);
                }

                case 4 -> {
                    System.out.println("Biblioteca: ");
                    for (Libro libro : biblioteca.getLibros()) {
                        System.out.println(libro);
                    }

                    System.out.print("\nISBN del libro que quiere eliminar: ");
                    String isbn = scanner.nextLine();

                    biblioteca.eliminar(isbn);
                }

                case 5 -> {
                    if(biblioteca.getLibros().isEmpty()){
                        System.out.println("La biblioteca se encuentra vacía, para modificar un libro añada libros.");
                    }else{
                        System.out.println("Libros disponibles: ");
                        for (Libro libro : biblioteca.getLibros()){
                            System.out.println(libro);
                        }
                    }

                    System.out.println("Ingrese el isbn del libro que desea modificar.");
                    String isbn = scanner.nextLine();

                    System.out.println("Ingrese los datos nuevos.");

                    System.out.println("Lista de autores disponibles:");
                    for (Autor autore : autor.getAutores()) {
                        System.out.println(autore.getNombre());
                    }

                    System.out.println("Autor: ");
                    String nombre = scanner.nextLine();

                    Autor autorIngresar = null;

                    for (Autor autor1 : autor.getAutores()) {
                        if (nombre.equals(autor1.getNombre())) {
                            autorIngresar = autor1;
                        }
                    }

                    if (autorIngresar == null) {
                        System.out.println("El autor no existe. Añádalo primero.");
                    }

                    System.out.print("Escriba el título del libro: ");
                    String nombreLibro = scanner.nextLine();

                    biblioteca.modificar(autorIngresar, nombreLibro, isbn);
                }

                case 6 -> {
                    System.out.println("Autores registrados: ");
                    for (Autor autor1 : autor.getAutores()) {
                        System.out.println(autor1);
                    }

                    System.out.println("\nIngrese los datos del nuevo autor...");
                    System.out.print("Nombre del autor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad del autor: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    boolean autorExiste = false;

                    for (Autor autor1 : autor.getAutores()) {
                        if (autor1.getNombre().equals(nombre) && autor1.getEdad() == edad) {
                            autorExiste = true;
                            break;
                        }
                    }

                    if (autorExiste) {
                        System.out.println("El autor ya existe en la base de datos.");
                    } else {
                        Autor nuevoAutor = new Autor(nombre, edad);
                        autor.añadirAutor(nuevoAutor);
                        System.out.println("Autor añadido correctamente.");
                    }
                }

                case 7 -> {
                    if (autor.getAutores().isEmpty()) {
                        System.out.println("No hay autores disponibles para eliminar.");
                    }

                    System.out.print("Nombre del autor que desea eliminar: ");
                    String nombre = scanner.nextLine();

                    autor.eliminarAutor(nombre);
                }

                case 8 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }

                default -> {
                    System.out.println("Error. Elija una opción del 1 al 8.");
                }
            }
        }

        scanner.close();
    }

    @Override
    public int compare(Libro o1, Libro o2) {
        return 0;
    }
}