package Poo.Biblioteca;

public class LibroEliminadoException extends Exception{
    public String LibroEliminadoException (String message){
        return "El libro no ha podido ser eliminado.";
    }
}
