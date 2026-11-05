package Exepciones;

public class Dato_No_Encontrado_Exeption extends Exception{
    private final int id;

    public Dato_No_Encontrado_Exeption(int id) {
        super("ya existe el elemento"+id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
