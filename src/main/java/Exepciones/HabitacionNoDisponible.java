package Exepciones;

import Enums.EstadoHabitacion;

public class HabitacionNoDisponible extends Exception {
    private final int id;
    private final EstadoHabitacion estadoHabitacion;

    public HabitacionNoDisponible(EstadoHabitacion estadoHabitacion, int id) {
        super("la habitacion"+id+"no esta disponible ya que se encuentra:"+estadoHabitacion);
        this.estadoHabitacion = estadoHabitacion;
        this.id = id;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public int getId() {
        return id;
    }
}
