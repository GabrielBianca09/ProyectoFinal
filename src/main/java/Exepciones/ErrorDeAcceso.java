package Exepciones;

public class ErrorDeAcceso extends RuntimeException {
    public ErrorDeAcceso(String message) {
        super(message);
    }
}
