package Clases;

import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;

public class Habitacion {
    private static int numerogen=0;
    private int numeroHabitacion;
    private int capacidadOcupantes;
    private Hotel hotel;
    private EstadoHabitacion estadoHabitacion;
    private Tipo_Habitacion tipoHabitacion;

    /// Constructores ----------------------------

    public Habitacion(int capacidadOcupantes, EstadoHabitacion estadoHabitacion, Hotel hotel, int numeroHabitacion, Tipo_Habitacion tipoHabitacion) {
        this.capacidadOcupantes = capacidadOcupantes;
        this.estadoHabitacion= EstadoHabitacion.DISPONIBLE;
        this.hotel = hotel;
        this.numeroHabitacion =numerogen++;
        this.tipoHabitacion=tipoHabitacion;
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

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Tipo_Habitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(Tipo_Habitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Reservas.Habitacion{" +
                "capacidadOcupantes=" + capacidadOcupantes +
                ", numeroHabitacion=" + numeroHabitacion +
                ", hotel=" + hotel +
                ", estadoHabitacion=" + estadoHabitacion +
                ", tipoHabitacion=" + tipoHabitacion +
                '}';
    }
}
