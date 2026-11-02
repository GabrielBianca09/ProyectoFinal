package Exepciones;

public class DatosInvalidos extends RuntimeException {
    public DatosInvalidos(String message) {
        super(message);
    }
}
