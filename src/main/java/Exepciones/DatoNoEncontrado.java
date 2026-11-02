package Exepciones;

public class DatoNoEncontrado extends Exception{
    private final int id;

    public DatoNoEncontrado(int id) {
        super("ya existe el elemento"+id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
