package Exepciones;

import Enums.EstadoHabitacion;

public class Habitacion_No_Disponible_Exeption extends Exception {
    private final int id;
    private final EstadoHabitacion estadoHabitacion;

    public Habitacion_No_Disponible_Exeption(EstadoHabitacion estadoHabitacion, int id) {
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
