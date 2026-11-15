package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Enums.Tipo_Habitacion;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;
import java.sql.Statement;


public class DetalleReserva implements Identificable, CalcularCosto {
    private static final double simple=750;
    private static final double suite=1500;
    private static final double presidencial=3000;
    private static int contador = 0;
    private int idDetalleReserva;
    private Habitacion habitacion;
    private int cantidadDias;

    public DetalleReserva(int cantidadDias,Habitacion habitacion) {
        this.cantidadDias = cantidadDias;
        this.habitacion = habitacion;
        this.idDetalleReserva = contador++;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    @Override
    public int getId() {
        return idDetalleReserva;
    }



    public double calcularTotal1habitacion(){
        if(Tipo_Habitacion.presidencial==habitacion.getTipoHabitacion()){
            return cantidadDias*presidencial;
        }else if(Tipo_Habitacion.simple==habitacion.getTipoHabitacion()
        ){
            return cantidadDias*simple;
        }else {
            return cantidadDias*suite;
        }
    }

    public void devolver(){
        habitacion.devolver();
    }

    @Override
    public double calcularTotal() {
        return 0;
    }

    @Override
    public void actualizarDatos(Identificable NuevosDatos) {
        DetalleReserva detalleReserva = (DetalleReserva) NuevosDatos;
        this.habitacion=detalleReserva.getHabitacion();
        this.cantidadDias=detalleReserva.getCantidadDias();
    }

    @Override
    public String toString() {
        return "DetalleReserva{" +
                "cantidadDias=" + cantidadDias +
                ", idDetalleReserva=" + idDetalleReserva +
                ", habitacion=" + habitacion+calcularTotal1habitacion()+
                '}';
    }
}
