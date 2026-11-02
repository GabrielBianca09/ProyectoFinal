package gestores;

import Interfaces.Identificable;
import Exepciones.DatoNoEncontrado;
import Exepciones.DatosDuplicados;
import Exepciones.DatosInvalidos;

import java.util.ArrayList;
import java.util.List;

public class Gestor<T extends Identificable> {
    private List<T>lista;

    public Gestor() {
        this.lista =new ArrayList<>();
    }

    public boolean existe(int id){
        for (T element:lista){
            if(element.getId()==id){
                return true;
            }
        }
        return false;
    }

    public void agregar(T element) throws DatosDuplicados {
        if (element == null) {
            throw new DatosInvalidos("No se aceptan nulos");
        }

        if (existe(element.getId())) {
            throw new DatosDuplicados(element.getId());
        }

        lista.add(element);
    }

    public T buscar(int id)throws DatoNoEncontrado{
        for(T e:lista){
            if(e.getId()==id){
                return e;
            }
        }
        throw new DatoNoEncontrado(id);
    }

    public void eliminar(int id)throws DatoNoEncontrado{
        T eliminado=buscar(id);
        lista.remove(eliminado);
    }



    public List<T> listarTodo(){return new ArrayList<>(lista);
    }


}
