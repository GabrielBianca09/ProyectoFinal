package Clases.Persona.Empleados;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Reservas.Reserva;
import Clases.Persona.Cliente.Pasajero;
import Clases.Persona.Persona;
import Enums.Tipo_de_Trabajo;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import gestores.Gestor;
import gestores.GestorHotel;

public class Recepcionista extends Empleado {

    public Recepcionista(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
        agregarChamba(Tipo_de_Trabajo.RESERVAS);
    }

    @Override
    public String toString() {
        return "Recepcionista{} " + super.toString();
    }

    public Pasajero registrarPasajero(GestorHotel gestorHotel, Pasajero pasajero)throws Datos_Duplicados_Exeption{
        gestorHotel.agregarCliente(pasajero);
        return pasajero;
    }

    public Reserva crearReserva(GestorHotel gestorHotel,Reserva reserva)throws Datos_Duplicados_Exeption{
        gestorHotel.agregarReserva(reserva);
        return reserva;
    }

    public Habitacion agregarHabitaciones(GestorHotel gestorHotel, Habitacion habitacion,int idreserva,int cantidaDias)throws Datos_Duplicados_Exeption,Dato_No_Encontrado_Exeption, Habitacion_No_Disponible_Exeption {
        Reserva r=gestorHotel.buscarReserva(idreserva);
        r.agregarHabitacion(habitacion,cantidaDias);
        return  habitacion;
    }

    public void DesocuparHabitacion(GestorHotel gestorHotel,int idHabitacion)throws Dato_No_Encontrado_Exeption {
        Habitacion h=gestorHotel.buscarHabitacion(idHabitacion);
        h.devolver();
    }
}
