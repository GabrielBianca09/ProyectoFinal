package Clases.Hotel;

import Clases.Persona.Cliente.Pasajero;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Interfaces.Identificable;

import java.util.Date;
import java.util.List;

public class Reserva implements Identificable {
    private static final double simple=750;
    private static final double suite=1500;
    private static final double presidencial=3000;
    private static int gencon=0;
    private int idreserva;
    private Pasajero pasajero;
    private List<Habitacion>habitacionesXreserva;
    private Date fecha;
    private double valorTotal;
    private int cantidadDias;


    public Reserva(Date fecha,List<Habitacion> habitacionesXreserva, int idreserva, Pasajero pasajero, int cantidadDias) {
        this.fecha = fecha;
        this.habitacionesXreserva = habitacionesXreserva;
        this.idreserva =gencon++;
        this.pasajero = pasajero;
        this.valorTotal = valorTotal;
        this.cantidadDias=cantidadDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public List<Habitacion> getHabitacionesXreserva() {
        return habitacionesXreserva;
    }

    public void setHabitacionesXreserva(List<Habitacion> habitacionesXreserva) {
        this.habitacionesXreserva = habitacionesXreserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public boolean agregarHabitacion(Habitacion h){
        if(h!=null && h.getEstadoHabitacion()==EstadoHabitacion.DISPONIBLE){
            habitacionesXreserva.add(h);
            h.setEstadoHabitacion(EstadoHabitacion.RESERVADA);
            return true;
        }
        return false;
    }

    public void Devolver(Habitacion h){
        for (Habitacion habitacion:habitacionesXreserva){
            if(h.getNumeroHabitacion()==habitacion.getNumeroHabitacion()&& h.getEstadoHabitacion()==EstadoHabitacion.RESERVADA){
                habitacion.setEstadoHabitacion(EstadoHabitacion.DISPONIBLE);
            }
        }
    }


    public double calcularTotal1habitacion(Habitacion h){
        if(Tipo_Habitacion.presidencial==h.getTipoHabitacion()){
            return cantidadDias*presidencial;
        }else if(Tipo_Habitacion.simple==h.getTipoHabitacion()
        ){
            return cantidadDias*simple;
        }else {
            return cantidadDias*suite;
        }
    }

    public double calcularTotalReserva(){
        double total=0.0;
        for(Habitacion h:habitacionesXreserva){
            total+=calcularTotal1habitacion(h);
        }
        this.valorTotal=total;
        return total;
    }

    public boolean EstaEnLaListaDeHabitaciones(int numeroHabitacion){
        for(Habitacion h:habitacionesXreserva){
            if(h.getNumeroHabitacion()==numeroHabitacion){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getId() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }
}
