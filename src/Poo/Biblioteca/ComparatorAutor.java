package Poo.Biblioteca;

import java.util.Comparator;

public class ComparatorAutor implements Comparator<Libro> {

    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getAutorLibro().getNombre().compareTo(o1.getAutorLibro().getNombre());
    }
}
