package Clases;

import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {
    private Gestor<Persona>gestor;

    public GestorPersonas() {
        this.gestor =new Gestor<>();
    }

    public boolean agregar(Persona p){
        if(gestor.agregar(p)){
            return true;
        }
        return false;
    }
    public Persona buscarPersona(int id){
        Persona p =gestor.buscarPorid(id);
        return p;
    }

    public boolean eliminar(int id){
        Persona p=buscarPersona(id);
        if(p!=null){
            return gestor.eliminarObjeto(id);
        }
        return false;
    }

    public List<Empleado> filtrarPorEmpleado(){
        List<Empleado>listaEmpleados=new ArrayList<>();
        for(Persona p:gestor){
            if(p instanceof Empleado){
                listaEmpleados.add(p);
            }
        }
        return listaEmpleados;
    }

    public List<Pasajero> filtrarPasajeros(){
        List<Pasajero>listaPasajeros=new ArrayList<>();
        for (Persona p:gestor){
            if(p instanceof Pasajero){
                listaPasajeros.add(p);
            }
        }
        return listaPasajeros;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    @Override
    public String toString() {
        return "GestorPersonas{" +
                "gestor=" + gestor +
                '}';
    }
}
