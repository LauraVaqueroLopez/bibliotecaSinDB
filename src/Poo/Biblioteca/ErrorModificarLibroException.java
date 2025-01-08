package Poo.Biblioteca;

public class ErrorModificarLibroException extends ErroresLibrosException{
    public ErrorModificarLibroException() {
        super("Se ha producido un error tratando de modificar el libro");
    }
}
