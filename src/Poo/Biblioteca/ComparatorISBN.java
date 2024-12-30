package Poo.Biblioteca;

import java.util.Comparator;

public class ComparatorISBN implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getIsbn().compareTo(o2.getIsbn());
    }
}
