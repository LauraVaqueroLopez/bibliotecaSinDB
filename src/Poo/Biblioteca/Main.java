package Poo.Biblioteca;//package Poo.Biblioteca;

import java.util.Comparator;

public class Main implements Comparator<Libro>{
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Autor autor = new Autor();

        Autor autor1 = new Autor("Antonio Perez",  37);
        Autor autor2 = new Autor("Benito Gonzalez", 40);
        autor.añadirAutor(autor1);
        autor.añadirAutor(autor2);

        Libro libro1= new Libro(autor1, "Cenicienta", "ISBN123");
        Libro libro2= new Libro(autor2, "La cabaña", "ISBN456");
        Libro libro3= new Libro(autor1, "Plancanieves", "ISBN789");
        Libro libro4= new Libro(autor1, "Ienicienta", "ISBN974");

        biblioteca.getLibros().add(libro1);
        biblioteca.getLibros().add(libro2);
        biblioteca.getLibros().add(libro3);
        biblioteca.getLibros().add(libro4);

        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }

        System.out.println("\nOrdenacion por defecto:");

        biblioteca.getLibros().sort(null);

        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }

        System.out.println("\nOrdenar por nombre autor:");

        ComparatorAutor compararAutor = new ComparatorAutor();
        biblioteca.getLibros().sort(compararAutor);
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }

        System.out.println("\nOrdenar por nombre libro:");
        ComparatorNombreLibro compararNombreLibro = new ComparatorNombreLibro();
        biblioteca.getLibros().sort(compararNombreLibro);
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }

        System.out.println("\nOrdenar por isbn:");

        biblioteca.getLibros().sort(new ComparatorISBN());
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(libro);
        }

    }

    @Override
    public int compare(Libro o1, Libro o2) {
        return 0;
    }
}
