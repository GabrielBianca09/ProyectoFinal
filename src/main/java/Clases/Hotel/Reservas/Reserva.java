package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;

import java.util.Date;
import java.util.List;

public class Reserva implements Identificable, CalcularCosto {
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

    public Reserva(int cantidadDias, Date fecha, List<Habitacion> habitacionesXreserva, Pasajero pasajero, double valorTotal) {
        this.cantidadDias = cantidadDias;
        this.fecha = fecha;
        this.habitacionesXreserva = habitacionesXreserva;
        this.pasajero = pasajero;
        this.valorTotal = valorTotal;
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


    public boolean agregarHabitacion(Habitacion h)throws Habitacion_No_Disponible_Exeption {
        if(h!=null && h.getEstadoHabitacion()==EstadoHabitacion.DISPONIBLE && !habitacionesXreserva.contains(h)){
            h.reservar();
            habitacionesXreserva.add(h);
            return true;
        }
        return false;
    }
    public void finalizarReserva(Habitacion habitacion)throws Dato_No_Encontrado_Exeption{
        int pos=-1;
        pos=buscarHabitacion(habitacion.getId());
        if(pos!=-1){
            habitacionesXreserva.get(pos).devolver();
        }
    }

    public int buscarHabitacion(int id)throws Dato_No_Encontrado_Exeption{
        for(int i=0;i<habitacionesXreserva.size();i++){
            if(habitacionesXreserva.get(i).getId()==id){
                return i;
            }
        }
        throw new Dato_No_Encontrado_Exeption(id);
    }


    public boolean existe(int numeroHabitacion)throws Dato_No_Encontrado_Exeption{
        for (Habitacion habitacion:habitacionesXreserva){
            if(habitacion.getNumeroHabitacion()==numeroHabitacion){
                return true;
            }
        }
        throw new Dato_No_Encontrado_Exeption(numeroHabitacion);
    }

    @Override
    public double calcularTotal() {
        double total=0.0;
        for(Habitacion h:habitacionesXreserva){
            total+=calcularTotal1habitacion(h);
        }
        this.valorTotal=total;
        return total;
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



    public boolean EstaEnLaListaDeHabitaciones(int numeroHabitacion)throws Dato_No_Encontrado_Exeption {
        for(Habitacion h:habitacionesXreserva){
            if(h.getNumeroHabitacion()==numeroHabitacion){
                return true;
            }
        }
        throw new Dato_No_Encontrado_Exeption(numeroHabitacion);
    }


    @Override
    public int getId() {
        return idreserva;
    }

    @Override
    public void actualizarDatos(Identificable actualizada) {
        Reserva r=(Reserva)actualizada;
        this.fecha =r.getFecha();
        this.habitacionesXreserva=r.getHabitacionesXreserva();
        this.pasajero =r.getPasajero();
        this.valorTotal =r.getValorTotal();
        this.cantidadDias=r.getCantidadDias();
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "cantidadDias=" + cantidadDias +
                ", idreserva=" + idreserva +
                ", pasajero=" + pasajero +
                ", habitacionesXreserva=" + habitacionesXreserva +
                ", fecha=" + fecha +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
