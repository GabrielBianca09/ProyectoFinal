package gestores;

import Interfaces.Identificable;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;

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

    public void agregar(T element) throws Datos_Duplicados_Exeption {
        if (element == null) {
            throw new Datos_Invalidos_Exeption("No se aceptan nulos");
        }

        if (existe(element.getId())) {
            throw new Datos_Duplicados_Exeption(element.getId());
        }

        lista.add(element);
    }

    public T buscar(int id)throws Dato_No_Encontrado_Exeption {
        for(T e:lista){
            if(e.getId()==id){
                return e;
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }

    public void eliminar(int id)throws Dato_No_Encontrado_Exeption {
        T eliminado=buscar(id);
        lista.remove(eliminado);
    }



    public List<T> listarTodo(){return new ArrayList<>(lista);
    }

    //falta el metodo para actualizar datos generico

    public void actualizar(T nuevo,int id){
        if (nuevo==null){
            throw new Datos_Invalidos_Exeption("no se aceptan datos nulos")
        }
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==id){
                lista.set(i,nuevo);
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }


}
