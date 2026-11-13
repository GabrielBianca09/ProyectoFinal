package Clases.Hotel.Servicios;

import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;

import java.util.ArrayList;
import java.util.List;

public class Servicios_X_Cliente implements Identificable, CalcularCosto {
    private static int cont = 1;
    private int idservicio_cliente;
    private List<Servicio> serviciosUsados;


    public Servicios_X_Cliente() {
        this.idservicio_cliente = cont++;
        this.serviciosUsados =new ArrayList<Servicio>();
    }


    public List<Servicio> getServiciosUsados() {
        return serviciosUsados;
    }



    @Override
    public int getId() {
        return idservicio_cliente;
    }

    @Override
    public void actualizarDatos(Identificable NuevosDatos) {
        Servicios_X_Cliente s = (Servicios_X_Cliente) NuevosDatos;
        this.serviciosUsados = s.getServiciosUsados();
    }

    public void agregarConsumo(Servicio s) throws Datos_Invalidos_Exeption{
        if(s==null){
            throw new Datos_Invalidos_Exeption("no se aceptan nulos");
        }

        serviciosUsados.add(s); //no verifico si se repite porque puede agregar el mismo varias veces.
    }


    public void eliminarConsumo(Servicio s)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        if(s==null){
            throw new Datos_Invalidos_Exeption("no se aceptan nulos");
        }
        for (int i=0;i<serviciosUsados.size();i++){
            if(s.getId()==serviciosUsados.get(i).getId()){
                serviciosUsados.remove(i);
                return;
            }
        }
        throw new Dato_No_Encontrado_Exeption(s.getId());
    }

    public void setServiciosUsados(List<Servicio> serviciosUsados) {
        this.serviciosUsados = serviciosUsados;
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (Servicio s : serviciosUsados) {
            total += s.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Servicios_X_Cliente{" +
                "idservicio_cliente=" + idservicio_cliente +
                ", serviciosUsados=" + serviciosUsados +
                ", subtotal="  +
                '}';
    }
}
