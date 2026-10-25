package Clases;

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

    public T buscarPorid(int id){
        if(id>=0 && id< lista.size()){
            return lista.get(id);
        }
        return null;
    }

    public boolean eliminarObjeto(int id){
        T element=buscarPorid(id);
        if(element!=null){
            return lista.remove(element);
        }
        return false;
    }


}
