package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//esta clase se utiliza para la creacion de reservas.
//una reserva puede tener varias habitaciones por lo que se usa una lista.
//para cambiar el estado de la habitacion se usan los metodos desocupar y devolver de la clase habitacion.
// Implementando exepciones HabitacionNoDisponibleExeption, y DatoNoencontradoExeption ambas exepciones checked por lo que se declaran en el thows.
//permite actualizar datos, agregarHabitaciones,calcularTotaldelaReserva o de 1 sola habitacion, tambien permite mostrar datos.

public class Reserva implements Identificable, CalcularCosto {
    private static final double simple=750;
    private static final double suite=1500;
    private static final double presidencial=3000;
    private static int gencon=0;
    private int idreserva;
    private Pasajero pasajero;
    private List<Habitacion>habitacionesXreserva;
    private LocalDateTime fecha;
    private int cantidadDias;

    public Reserva(LocalDateTime fecha,Pasajero pasajero,int cantidadDias) {
        setFecha(fecha);
        this.habitacionesXreserva =new ArrayList<Habitacion>();
        this.idreserva =gencon++;
        setPasajero(pasajero);
        setCantidadDias(cantidadDias);
    }

    public Reserva(LocalDateTime fecha,List<Habitacion> habitacionesXreserva, Pasajero pasajero,int cantidadDias) {
        this.habitacionesXreserva = habitacionesXreserva;
        this.pasajero = pasajero;
        this.fecha=fecha;
        setCantidadDias(cantidadDias);
    }

    public int getCantidadDias() {
        return cantidadDias;
    }



    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setCantidadDias(int cantidadDias) {
        if (cantidadDias <= 0) {
            throw new Datos_Invalidos_Exeption("La cantidad de días debe ser mayor a cero");
        }
        this.cantidadDias = cantidadDias;
    }

    public void setPasajero(Pasajero pasajero) {
        if (pasajero == null) {
            throw new Datos_Invalidos_Exeption("El pasajero no puede ser nulo");
        }
        this.pasajero = pasajero;
    }

    public List<Habitacion> getHabitacionesXreserva() {
        return habitacionesXreserva;
    }

    public void setHabitacionesXreserva(List<Habitacion> habitacionesXreserva) {
        this.habitacionesXreserva = habitacionesXreserva;
    }

    public void setFecha(LocalDateTime fecha) {
        if (fecha == null) {
            throw new Datos_Invalidos_Exeption("La fecha no puede ser nula");
        }
        this.fecha = fecha;
    }




    public LocalDateTime getFecha() {
        return fecha;
    }



    public int getIdreserva() {
        return idreserva;
    }




    public void agregarHabitacion(Habitacion h)throws Dato_No_Encontrado_Exeption,Habitacion_No_Disponible_Exeption{
        if (h == null) {
            throw new IllegalArgumentException("La habitación no puede ser nula");
        }

        if (h.getEstadoHabitacion() != EstadoHabitacion.DISPONIBLE) {
            throw new Habitacion_No_Disponible_Exeption(
                    h.getEstadoHabitacion(), h.getId()
            );
        }

        if (existe(h.getId())) {
            throw new Habitacion_No_Disponible_Exeption(
                    h.getEstadoHabitacion(), h.getId()
            );
        }

        h.reservar();
        habitacionesXreserva.add(h);
    }

    public void finalizarUsoHabitacion(int idhabitacion)throws Dato_No_Encontrado_Exeption{
        int pos=-1;
        pos=buscarHabitacion(idhabitacion);
        if(pos!=-1){
            habitacionesXreserva.get(pos).devolver();
        }
    }

    public void devolverTodo() throws Dato_No_Encontrado_Exeption {

        if (habitacionesXreserva == null || habitacionesXreserva.isEmpty()) {
            throw new Datos_Invalidos_Exeption(
                    "La reserva no tiene habitaciones para devolver"
            );
        }

        for (Habitacion h : habitacionesXreserva) {
            if (h.getEstadoHabitacion() == EstadoHabitacion.RESERVADA) {
                h.devolver();
            }
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


    public boolean existe(int idhabitacion) {
        for (Habitacion h : habitacionesXreserva) {
            if (h.getId() == idhabitacion) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calcularTotal() {
            double total = 0;

            for (Habitacion h : habitacionesXreserva) {

                if (h.getTipoHabitacion() == Tipo_Habitacion.presidencial) {
                    total += cantidadDias * presidencial;

                } else if (h.getTipoHabitacion() == Tipo_Habitacion.simple) {
                    total += cantidadDias * simple;

                } else {
                    total += cantidadDias * suite;
                }
            }

            return total;
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
        this.cantidadDias=r.getCantidadDias();

    }


    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public void setHabitacionesXreserva() {
        this.habitacionesXreserva = habitacionesXreserva;
    }

    @Override
    public String toString() {
        return "========== RESERVA ==========\n" +
                "ID de reserva: " + idreserva + "\n" +
                "Pasajero: " + pasajero + "\n" +
                "Fecha: " + fecha + "\n" +
                "Cantidad de días: " + cantidadDias + "\n" +
                "Habitaciones:\n" + habitacionesXreserva + "\n" +
                "-----------------------------\n" +
                "TOTAL DE LA RESERVA: $" + calcularTotal() + "\n" +
                "=============================";
    }
}
