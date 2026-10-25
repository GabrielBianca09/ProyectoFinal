package Reservas;

import java.util.Date;
import java.util.List;

public class Reserva {
    private static final double simple=750;
    private static final double suite=1500;
    private static final double presidencial=3000;
    private static int gencon=0;
    private int idreserva;
    private Pasajero pasajero;
    private List<Habitacion>habitacionesXreserva;
    private Date fecha;
    private double valorTotal;
    private Gestor gestor;
    private int cantidadDias;


    public Reserva(Date fecha, Gestor gestor, List<Habitacion> habitacionesXreserva, int idreserva, Pasajero pasajero, int cantidadDias) {
        this.fecha = fecha;
        this.gestor =new Gestor<>();
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

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public boolean agregarHabitacion(Habitacion h){
        if(h.getEstadoHabitacion()== EstadoHabitacion.DISPONIBLE){
            if(gestor.agregar(h)){
                
            }
        }
        return false;
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
        return total;
    }


}
