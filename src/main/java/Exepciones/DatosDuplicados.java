package Exepciones;

public class DatosDuplicados extends Exception{
    private final int id;

    public DatosDuplicados(int id) {
        super("ya existe el elemento"+id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
