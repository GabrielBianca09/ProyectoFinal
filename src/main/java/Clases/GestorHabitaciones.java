package Clases;

public class GestorHabitaciones {
    private Gestor<Habitacion>habitaciones;

    public GestorHabitaciones() {
        this.habitaciones =new Gestor<>();
    }

    public boolean agregarHabitacion(Habitacion h){
        if(habitaciones.agregar(h)){
            return true;
        }
        return false;
    }

    public Habitacion buscarHabitacion(int id){
        Habitacion h=habitaciones.buscarPorid(id);
        return h;
    }

    public boolean eliminarHabitacion(int id){
        Habitacion h=buscarHabitacion(id);
        if(h!=null){
            habitaciones.eliminarObjeto(id);
            return true;
        }
        return false;
    }
}
