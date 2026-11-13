package Clases.Hotel.Servicios;

import Clases.Persona.Empleados.Empleado;
import Enums.Tipo_de_Trabajo;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.OperacionInvalida;
import Interfaces.Identificable;

import java.util.ArrayList;
import java.util.List;


public class Servicio implements Identificable {
    private static int contador=0;
    private int idServicio;
    private double precio;
    private String nombreServicio;
    private List<EmpleadoServicio>EmpleadosxServicio;
    private Tipo_de_Trabajo tipo;

    public Servicio(double precio, String nombreServicio,Tipo_de_Trabajo tipo) {
        this.precio = precio;
        this.nombreServicio = nombreServicio;
        this.idServicio=contador++;
        this.EmpleadosxServicio=new ArrayList<>();
        this.tipo=tipo;
    }

    public void Agregar1EmpleadoServicio(EmpleadoServicio e)throws OperacionInvalida,Datos_Duplicados_Exeption{
        if(e==null){
            throw new Datos_Invalidos_Exeption("no se puede agregar un empleado con datos nulos");
        }
        if(!(e.getEmpleado().puedeHacerEseTrabajo(tipo))){
            throw new OperacionInvalida("No puede realizar ese trabajo");
        }
        for (int i=0;i<EmpleadosxServicio.size();i++){
            if(EmpleadosxServicio.get(i).getEmpleado().getId()==e.getId()){
                throw new Datos_Duplicados_Exeption(e.getId());
            }
        }


        EmpleadosxServicio.add(e);
    }

    public boolean quitarEmpleado(Empleado e)throws Datos_Invalidos_Exeption,Dato_No_Encontrado_Exeption{
        if(e==null){
            throw new Datos_Invalidos_Exeption("no se puede quitar algo null");
        }

        for (int i=0;i<EmpleadosxServicio.size();i++){
            if (EmpleadosxServicio.get(i).getId()==e.getId()){
                EmpleadosxServicio.remove(i);
                return true;
            }
        }
        throw new Dato_No_Encontrado_Exeption(e.getId());
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public List<EmpleadoServicio> getEmpleadosxServicio() {
        return EmpleadosxServicio;
    }

    public void setEmpleadosxServicio(List<EmpleadoServicio> empleadosxServicio) {
        EmpleadosxServicio = empleadosxServicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Tipo_de_Trabajo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_de_Trabajo tipo) {
        this.tipo = tipo;
    }

    public void setEmpleadosxServicio() {
       this.EmpleadosxServicio =new ArrayList<>(EmpleadosxServicio);
    }

    @Override
    public void actualizarDatos(Identificable NuevosDatos) {
        Servicio s=(Servicio)NuevosDatos;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.EmpleadosxServicio=new ArrayList<>(s.getEmpleadosxServicio());
    }

    @Override
    public int getId() {
        return idServicio;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", precio=" + precio +
                ", nombreServicio='" + nombreServicio + '\'' +
                '}';
    }

    public void mostrarEmpleadosxServicio(){
        for (EmpleadoServicio e:EmpleadosxServicio){
            System.out.println(e.toString());
        }
    }
}
