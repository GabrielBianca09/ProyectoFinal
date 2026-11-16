package gestores;

import Interfaces.Identificable;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;

import java.util.ArrayList;
import java.util.List;
// es el gestor generico para poder hacer todas mis funciones en el gestorHotel.
//extiende de identificable para poder usar los metodos getid() y actualizarDatos.
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

    public void agregar(T element) throws Datos_Duplicados_Exeption,Datos_Invalidos_Exeption {
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

    public void actualizar(T nuevo,int id)throws Datos_Invalidos_Exeption,Dato_No_Encontrado_Exeption{
        if (nuevo==null){
            throw new Datos_Invalidos_Exeption("no se aceptan datos nulos");
        }
        for (T element:lista){
            if(element.getId()==id){
                element.actualizarDatos(nuevo);
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
}
