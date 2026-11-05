package Exepciones;

public class Error_De_Acceso_A_Datos_Exeption extends Exception {
    public Error_De_Acceso_A_Datos_Exeption(String message, Throwable causa) {
        super(message,causa);
    }
}
