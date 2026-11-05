package gestores;

import Clases.Persona.Empleados.Empleado;
import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Clases.Hotel.Reserva;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;

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

    public void agregarHabitacion(Habitacion h)throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        habitacionGestor.agregar(h);
    }
    public void agregarCliente(Pasajero p)throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        huespedes.agregar(p);
    }
    public void agregarEmpleado(Empleado e)throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        empleadoGestor.agregar(e);
    }
    public void agregarReserva(Reserva r)throws Datos_Duplicados_Exeption, Datos_Invalidos_Exeption {
        reservaGestor.agregar(r);
    }


    public Habitacion buscar(int id)throws Dato_No_Encontrado_Exeption, Datos_Invalidos_Exeption {
       Habitacion h=habitacionGestor.buscar(id);
       return h;
    }

    public Pasajero buscarCliente(int id)throws Dato_No_Encontrado_Exeption, Datos_Invalidos_Exeption {
        return huespedes.buscar(id);
    }

    public Empleado buscarEmpleado(int id)throws Dato_No_Encontrado_Exeption, Datos_Invalidos_Exeption {
        return empleadoGestor.buscar(id);
    }

    public Reserva buscarReserva(int id)throws Dato_No_Encontrado_Exeption, Datos_Invalidos_Exeption {
        return reservaGestor.buscar(id);
    }


    public void eliminarHabitacion(int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        habitacionGestor.eliminar(id);
    }

    public void eliminarReserva(int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        reservaGestor.eliminar(id);
    }

    public void eliminarHuesped(int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        huespedes.eliminar(id);
    }

    public void eliminarEmpleado(int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        empleadoGestor.eliminar(id);
    }
    //falta metodo para actualizar los datos.........

    public void actualizarHabitacion(int id,Habitacion h)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        habitacionGestor.actualizar(h,id);
    }

    public void actualizarReserva(int id,Reserva r)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        reservaGestor.actualizar(r,id);
    }

    public void actualizarCliente(int id,Pasajero p)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        huespedes.actualizar(p,id);
    }

    public void actualizarEmpleado(int id,Empleado e)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        empleadoGestor.actualizar(e,id);
    }


}
