package Reservas;

import java.util.ArrayList;
import java.util.List;

public class Gestor<T> {
    private List<T>lista;

    public Gestor() {
        this.lista =new ArrayList<>();
    }

    public boolean agregar(T elemento){
        if(!(lista.contains(elemento))){
            lista.add(elemento);
            return true;
        }
        return false;
    }

    public T buscarPorid(int pos){
        if(pos>=0 && pos< lista.size()){
            return lista.get(pos);
        }
        return null;
    }

    public boolean eliminarObjeto(int pos){
        T element=buscarPorid(pos);
        if(element!=null){
            return lista.remove(element);
        }
        return false;
    }


}
