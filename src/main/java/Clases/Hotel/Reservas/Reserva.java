package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva implements Identificable, CalcularCosto {
    private static final double simple=750;
    private static final double suite=1500;
    private static final double presidencial=3000;
    private int gencon=0;
    private int idreserva;
    private Pasajero pasajero;
    private List<Habitacion>habitacionesXreserva;
    private LocalDateTime fecha;
    private int cantidadDias;
    public Reserva(LocalDateTime fecha,Pasajero pasajero) {
        this.fecha = fecha;
        this.habitacionesXreserva =new ArrayList<Habitacion>();
        this.idreserva =gencon++;
        this.pasajero = pasajero;
        this.cantidadDias=cantidadDias;
    }

    public Reserva(LocalDateTime fecha,List<Habitacion> habitacionesXreserva, Pasajero pasajero) {
        this.habitacionesXreserva = habitacionesXreserva;
        this.pasajero = pasajero;
        this.fecha=fecha;
        this.cantidadDias=cantidadDias;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
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


    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdreserva() {
        return idreserva;
    }




    public void agregarHabitacion(Habitacion h, int dias)throws Dato_No_Encontrado_Exeption,Habitacion_No_Disponible_Exeption{
        if (h == null || dias <= 0
                || h.getEstadoHabitacion() != EstadoHabitacion.DISPONIBLE
                || existe(h.getId())) {
            throw new Habitacion_No_Disponible_Exeption(h.getEstadoHabitacion(),h.getId());
        }
        h.reservar();
        habitacionesXreserva.add(h);
    }

    public void finalizarReserva(int idhabitacion)throws Dato_No_Encontrado_Exeption{
        int pos=-1;
        pos=buscarHabitacion(idhabitacion);
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


    public boolean existe(int idhabitacion)throws Dato_No_Encontrado_Exeption{
        for (Habitacion h:habitacionesXreserva){
            if(h.getId()==idhabitacion){
                return true;
            }
        }
        throw new Dato_No_Encontrado_Exeption(idhabitacion);
    }


    @Override
    public double calcularTotal() {
        double total=0;
        for (Habitacion d:habitacionesXreserva){
           total+=calcularTotal1habitacion();
        }
        return total;
    }



    public double calcularTotal1habitacion(){
        for (Habitacion h:habitacionesXreserva){
            if(Tipo_Habitacion.presidencial==h.getTipoHabitacion()){
                return cantidadDias*presidencial;
            }else if(Tipo_Habitacion.simple==h.getTipoHabitacion()
            ){
                return cantidadDias*simple;
            }else {
                return cantidadDias*suite;
            }
        }
        return  0;

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

    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public void setHabitacionesXreserva() {
        this.habitacionesXreserva = habitacionesXreserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fecha=" + fecha +
                ", gencon=" + gencon +
                ", idreserva=" + idreserva +
                ", pasajero=" + pasajero +
                ", habitacionesXreserva=" + habitacionesXreserva + "total de la reserva"+calcularTotal()+
                '}';
    }
}
