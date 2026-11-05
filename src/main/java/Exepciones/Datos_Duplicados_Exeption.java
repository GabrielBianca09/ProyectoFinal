package Exepciones;

public class Datos_Duplicados_Exeption extends Exception{
    private final int id;

    public Datos_Duplicados_Exeption(int id) {
        super("ya existe ese id"+id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
