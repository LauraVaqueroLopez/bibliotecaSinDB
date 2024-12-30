package Poo.Biblioteca;

import java.util.Objects;

public class Libro implements Comparable<Libro>{
    private Autor autorLibro;
    private String nombreLibro;
    private String isbn;

    public Libro(){

    }

    public Libro(Autor autorLibro, String nombreLibro, String isbn) {
        this.autorLibro = autorLibro;
        this.nombreLibro = nombreLibro;
        this.isbn = isbn;
    }

    public Autor getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(Autor autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(autorLibro, libro.autorLibro) && Objects.equals(nombreLibro, libro.nombreLibro) && Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autorLibro, nombreLibro, isbn);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autorLibro:" + autorLibro +
                ", nombreLibro:'" + nombreLibro + '\'' +
                ", isbn:'" + isbn + '\'' +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
        if (this.autorLibro.getNombre().equals(o.autorLibro.getNombre())) {
            if (this.nombreLibro.equals(o.nombreLibro)) {
                if (this.isbn.equals(o.isbn)) {
                    return 0;
                } else if (this.isbn.compareTo(o.isbn) == 1) {
                    return 1;
                }else {
                    return -1;
            }
            }else if(this.nombreLibro.compareTo(o.nombreLibro) == 1){
                return 1;
            }else {
                return -1;
            }
        } else if (this.autorLibro.getNombre().compareTo(o.autorLibro.getNombre()) == 1) {
            return 1;
        }else{
            return -1;
        }
    }
}
