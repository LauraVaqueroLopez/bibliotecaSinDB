package Poo.Biblioteca;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws LibroEliminadoException, ErrorModificarLibroException {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();

        Autor ejemplo1 = new Autor("Juan Ruiz", 39);
        Autor ejemplo2 = new Autor("Alicia Montes", 32);

        autor.añadirAutor(ejemplo1);
        autor.añadirAutor(ejemplo2);

        Libro ejemploLibro1 = new Libro(ejemplo1, "La cenicienta", "ISBN123");
        Libro ejemploLibro2 = new Libro(ejemplo2, "Malefica", "ISBN456");

        biblioteca.insertar(ejemploLibro1);
        biblioteca.insertar(ejemploLibro2);

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
                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("Biblioteca vacía. Añada libros primero.");
                    } else {
                        for (Libro libro : biblioteca.getLibros()) {
                            System.out.println(libro);
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
                    System.out.print("Nombre del autor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad del autor: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    Autor nuevoAutor = new Autor(nombre, edad);
                    autor.añadirAutor(nuevoAutor);

                    System.out.println("Autor añadido correctamente.");
                }

                case 7 -> {
                    if (autor.getAutores().isEmpty()) {
                        System.out.println("No hay autores disponibles para eliminar.");
                    }

                    System.out.print("Nombre del autor que desea eliminar: ");
                    String nombre = scanner.nextLine();

                    autor.eliminarAutor(nombre);
                    System.out.println("Autor eliminado correctamente.");
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
}
