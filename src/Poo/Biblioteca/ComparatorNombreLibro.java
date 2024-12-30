package Poo.Biblioteca;

import java.util.Comparator;

public class ComparatorNombreLibro implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getNombreLibro().compareTo(o2.getNombreLibro());
    }
}
