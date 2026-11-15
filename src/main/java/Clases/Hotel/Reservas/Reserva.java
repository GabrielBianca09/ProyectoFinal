package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Interfaces.CalcularCosto;
import Interfaces.Identificable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva implements Identificable, CalcularCosto {

    private int gencon=0;
    private int idreserva;
    private Pasajero pasajero;
    private List<DetalleReserva>habitacionesXreserva;
    private Date fecha;

    public Reserva(Date fecha,Pasajero pasajero) {
        this.fecha = fecha;
        this.habitacionesXreserva =new ArrayList<DetalleReserva>();
        this.idreserva =gencon++;
        this.pasajero = pasajero;
    }


    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public List<DetalleReserva> getHabitacionesXreserva() {
        return habitacionesXreserva;
    }

    public void setHabitacionesXreserva(List<DetalleReserva> habitacionesXreserva) {
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




    public void agregarHabitacion(Habitacion h, int dias)throws Dato_No_Encontrado_Exeption,Habitacion_No_Disponible_Exeption{
        if (h == null || dias <= 0
                || h.getEstadoHabitacion() != EstadoHabitacion.DISPONIBLE
                || existe(h.getId())) {
            throw new Habitacion_No_Disponible_Exeption(h.getEstadoHabitacion(),h.getId());
        }
        h.reservar();
        habitacionesXreserva.add(new DetalleReserva(dias,h));
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


    public boolean existe(int numeroDetalle)throws Dato_No_Encontrado_Exeption{
        for (DetalleReserva detalleReserva:habitacionesXreserva){
            if(detalleReserva.getIdDetalleReserva()==numeroDetalle){
                return true;
            }
        }
        throw new Dato_No_Encontrado_Exeption(numeroDetalle);
    }


    @Override
    public double calcularTotal() {
        double total=0;
        for (DetalleReserva d:habitacionesXreserva){
           total+=d.calcularTotal1habitacion();
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
