package gestores;

import Clases.Persona.Empleados.Empleado;
import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Clases.Hotel.Reserva;
import Exepciones.DatoNoEncontrado;
import Exepciones.DatosDuplicados;
import Exepciones.DatosInvalidos;

public class GestorHotel {
    private Gestor<Reserva>reservaGestor;
    private Gestor<Habitacion>habitacionGestor;
    private Gestor<Pasajero>huespedes;
    private Gestor<Empleado>empleadoGestor;


    public GestorHotel() {
        this.empleadoGestor =new Gestor<Empleado>();
        this.habitacionGestor =new Gestor<Habitacion>();
        this.huespedes =new Gestor<Pasajero>();
        this.reservaGestor =new Gestor<Reserva>();
    }

    public void agregarHabitacion(Habitacion h)throws DatosDuplicados,DatosInvalidos{
        habitacionGestor.agregar(h);
    }
    public void agregarCliente(Pasajero p)throws DatosDuplicados,DatosInvalidos{
        huespedes.agregar(p);
    }
    public void agregarEmpleado(Empleado e)throws DatosDuplicados,DatosInvalidos{
        empleadoGestor.agregar(e);
    }
    public void agregarReserva(Reserva r)throws DatosDuplicados,DatosInvalidos{
        reservaGestor.agregar(r);
    }


    public Habitacion buscar(int id)throws DatoNoEncontrado, DatosInvalidos {
       Habitacion h=habitacionGestor.buscar(id);
       return h;
    }

    public Pasajero buscarCliente(int id)throws DatoNoEncontrado,DatosInvalidos {
        return huespedes.buscar(id);
    }

    public Empleado buscarEmpleado(int id)throws DatoNoEncontrado,DatosInvalidos{
        return empleadoGestor.buscar(id);
    }

    public Reserva buscarReserva(int id)throws DatoNoEncontrado,DatosInvalidos{
        return reservaGestor.buscar(id);
    }






}
