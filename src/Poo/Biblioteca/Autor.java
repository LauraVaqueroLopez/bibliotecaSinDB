package Poo.Biblioteca;

import java.util.ArrayList;
import java.util.Objects;

public class Autor {

    private String nombre;
    private Integer edad;

    private ArrayList<Autor> autores;

    public Autor(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Autor() {
        this.autores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public void añadirAutor(Autor autor){
        autores.add(autor);
    }

    public void eliminarAutor(String nombre) {
        Autor eliminarAutor = null;

        for (Autor pate : autores) {
            if (pate.getNombre().equals(nombre)) {
                System.out.println("Libro eliminado: " + pate.getNombre());
                eliminarAutor = pate;
            }

            if (eliminarAutor == null) {
                System.out.println("No se ha podido eliminar el autor.");
            } else {
                autores.remove(pate);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nombre, autor.nombre) && Objects.equals(edad, autor.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return " Nombre: " + nombre + " Edad: " + edad;
    }

}
