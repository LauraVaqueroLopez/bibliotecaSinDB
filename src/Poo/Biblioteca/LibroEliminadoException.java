package Poo.Biblioteca;

public class LibroEliminadoException extends ErroresLibrosException{
    public LibroEliminadoException(){
        super("Se ha producido un error tratando de eliminar el libro.");
    }
}
