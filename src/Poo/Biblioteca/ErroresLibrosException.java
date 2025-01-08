package Poo.Biblioteca;

public class ErroresLibrosException extends Exception{

    public ErroresLibrosException() {
        super("La biblioteca tiene un error.");
    }

    public ErroresLibrosException(String message) {
        super("Error: " + message);
    }

}
