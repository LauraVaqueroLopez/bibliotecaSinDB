package Poo.Biblioteca;

//ordenar por nombre del autor, si es igual, titulo del libro y si es igual isbn
//escoger por consola si quiero ordenarlo por cada tributo
//que se pueda eliminar libros, modificar libros, añadir libros

//TODO MODIFICAR LIBROS

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        libros = libros;
    }

    public void insertar(Libro libro) {
        if (libros.isEmpty()) {
            libros.add(libro);
            System.out.println("Libro añadido con éxito.");
        } else {
            for (Libro pate : libros) {
                if (libro.getIsbn().equals(pate.getIsbn())) {
                    System.out.println("El ISBN coincide con otro de la biblioteca. Escoja otro.");
                    return;
                }
            }
            libros.add(libro);
            System.out.println("Libro añadido con éxito.");
        }
    }


    public void modificar(Autor autor, String nombreLibro, String isbn) throws ErrorModificarLibroException{
        Libro Libro = null;

        for (Libro libroActual : libros){
            if (libroActual.getIsbn().equals(isbn)){
                System.out.println("Libro a modificar: " + libroActual.getNombreLibro());
                Libro = libroActual;
            }else if (Libro == null) {
                throw new ErrorModificarLibroException();
                }else{
                    libroActual.setAutorLibro(autor);
                    libroActual.setNombreLibro(nombreLibro);
                    libroActual.setIsbn(isbn);
                    System.out.println(libroActual);
                    System.out.println("Actualizado con éxito.");
                }
        }
    }

    public void eliminar(String isbn) throws LibroEliminadoException{
        Libro libro = null;

        for (Libro libroActual : libros){
            if (libroActual.getIsbn().equals(isbn)){
                System.out.println("Libro eliminado: " + libroActual.getNombreLibro());
                libro = libroActual;
            }

            if (libro == null) {
                throw new LibroEliminadoException();
            }else {

                libros.remove(libroActual);

            }
        }
    }

}
