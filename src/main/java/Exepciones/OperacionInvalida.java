package Exepciones;

public class OperacionInvalida extends RuntimeException {
    public OperacionInvalida(String message) {
        super(message);
    }
}
