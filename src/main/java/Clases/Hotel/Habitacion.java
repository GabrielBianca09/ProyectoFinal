package Clases.Hotel;

import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Exepciones.OperacionInvalida;
import Interfaces.Identificable;

public class Habitacion implements Identificable {
    private static int numerogen=0;
    private int numeroHabitacion;
    private int capacidadOcupantes;
    private Hotel hotel;
    private EstadoHabitacion estadoHabitacion;
    private Tipo_Habitacion tipoHabitacion;

    /// Constructores ----------------------------

    public Habitacion(int capacidadOcupantes, EstadoHabitacion estadoHabitacion, Hotel hotel,Tipo_Habitacion tipoHabitacion) {
        this.capacidadOcupantes = capacidadOcupantes;
        this.estadoHabitacion= EstadoHabitacion.DISPONIBLE;
        this.hotel = hotel;
        this.numeroHabitacion =numerogen++;
        this.tipoHabitacion=tipoHabitacion;
    }

    public void cambiardatosSinCambiarId(Habitacion h){
        this.capacidadOcupantes=h.getCapacidadOcupantes();
        this.estadoHabitacion=h.getEstadoHabitacion();
        this.hotel=h.getHotel();
        this.tipoHabitacion=h.getTipoHabitacion();
    }




    public int getCapacidadOcupantes() {
        return capacidadOcupantes;
    }

    public void setCapacidadOcupantes(int capacidadOcupantes) {
        this.capacidadOcupantes = capacidadOcupantes;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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
