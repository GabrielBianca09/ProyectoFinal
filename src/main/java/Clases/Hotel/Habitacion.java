package Clases.Hotel;

import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Exepciones.OperacionInvalida;
import Interfaces.Identificable;
//en esta clase estan las funciones para cambiar el estado de habitacion que despues se utilizan en los check in y check outs.
// tambien permite actualizar.
//es una composicion con hotel e implementa los enums estado y tipo habitacion
public class Habitacion implements Identificable {
    private static int numerogen=0;
    private int numeroHabitacion;
    private int capacidadOcupantes;
    private Hotel hotel;
    private EstadoHabitacion estadoHabitacion;
    private Tipo_Habitacion tipoHabitacion;

    /// Constructores ----------------------------

    public Habitacion(int capacidadOcupantes, EstadoHabitacion estadoHabitacion, Hotel hotel,Tipo_Habitacion tipoHabitacion) {
        setCapacidadOcupantes(capacidadOcupantes);
        this.estadoHabitacion= EstadoHabitacion.DISPONIBLE;
        setHotel(hotel);
        this.numeroHabitacion =numerogen++;
        this.tipoHabitacion=tipoHabitacion;
    }

    public Habitacion(int numeroHabitacion, int capacidadOcupantes, Hotel hotel, EstadoHabitacion estadoHabitacion, Tipo_Habitacion tipoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.capacidadOcupantes = capacidadOcupantes;
        this.hotel = hotel;
        this.estadoHabitacion = estadoHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }
    public int getCapacidadOcupantes() {
        return capacidadOcupantes;
    }

    public void setCapacidadOcupantes(int capacidadOcupantes) {
        if (capacidadOcupantes <= 0) {
            throw new Datos_Invalidos_Exeption("La capacidad de ocupantes debe ser mayor a cero");
        }
        this.capacidadOcupantes = capacidadOcupantes;
    }

    public void setHotel(Hotel hotel) {
        if (hotel == null) {
            throw new Datos_Invalidos_Exeption("El hotel no puede ser nulo");
        }
        this.hotel = hotel;
    }
    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }



    public static int getNumerogen() {
        return numerogen;
    }

    public static void setNumerogen(int numerogen) {
        Habitacion.numerogen = numerogen;
    }



    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }


    public Tipo_Habitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(Tipo_Habitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }



    @Override
    public int getId() {
        return numeroHabitacion;
    }

    @Override
    public void actualizarDatos(Identificable actualizar) {
       Habitacion h=(Habitacion)actualizar;
       this.tipoHabitacion=h.getTipoHabitacion();
       this.hotel=h.getHotel();
       this.estadoHabitacion=h.getEstadoHabitacion();
       this.capacidadOcupantes=h.getCapacidadOcupantes();
    }


    public void reservar()throws Habitacion_No_Disponible_Exeption{
        if(!(estadoHabitacion==EstadoHabitacion.DISPONIBLE)){
            throw new Habitacion_No_Disponible_Exeption(estadoHabitacion,getId());
        }
        this.estadoHabitacion=EstadoHabitacion.RESERVADA;
    }

    public void devolver(){
        if(!(estadoHabitacion==EstadoHabitacion.RESERVADA)){
            throw new OperacionInvalida("la habitacion no esta en un estado elijible");
        }
        this.estadoHabitacion=EstadoHabitacion.DISPONIBLE;
    }

    public void hacerMantenimiento(){
        if(!(estadoHabitacion==EstadoHabitacion.EN_MANTENIMIENTO)){
            this.estadoHabitacion=EstadoHabitacion.EN_MANTENIMIENTO;
        }
        throw new OperacionInvalida("no se puede realizar la operacion");
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "tipoHabitacion=" + tipoHabitacion +
                ", numeroHabitacion=" + numeroHabitacion +
                ", estadoHabitacion=" + estadoHabitacion +
                ", capacidadOcupantes=" + capacidadOcupantes +
                '}';
    }
}
