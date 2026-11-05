package Clases.Persona.Admin;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Reserva;
import Clases.Persona.Cliente.Pasajero;
import Clases.Persona.Empleados.Empleado;
import Clases.Persona.Persona;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

public class Administrador extends Persona {
    private static int cont=0;
    private int id_Admin;
    private String nombreUsuario;
    private String clave;
    private GestorHotel gestorHotel;

    public Administrador(String nombre, String apellido, String dni, String email, String numeroCelular, String clave,String nombreUsuario) {
        super(nombre, apellido, dni, email, numeroCelular);
        this.clave = clave;
        this.id_Admin =cont++;
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public int getId_Admin() {
        return id_Admin;
    }

    private void altaEmpleado(Empleado e)throws Datos_Invalidos_Exeption {
        gestorHotel.agregarEmpleado(e);
    }

    private void altaHabitacion(Habitacion h)throws Datos_Invalidos_Exeption{
        gestorHotel.agregarHabitacion(h);
    }

    private void altaCliente(Pasajero p)throws Datos_Invalidos_Exeption{
        gestorHotel.agregarCliente(p);
    }

    private void altaReserva(Reserva r)throws Datos_Invalidos_Exeption{
        gestorHotel.agregarReserva(r);
    }


    public void BajaEmpleado(Empleado e)throws Datos_Invalidos_Exeption, Dato_No_Encontrado_Exeption {
        gestorHotel.eliminarEmpleado(e.getId());
    }

    public void BajaHabitacion(Habitacion h)throws Datos_Invalidos_Exeption, Dato_No_Encontrado_Exeption{
        gestorHotel.eliminarHabitacion(h.getId());
    }

    public void bajaReserva(Reserva r) throws Datos_Invalidos_Exeption, Dato_No_Encontrado_Exeption{
        gestorHotel.eliminarReserva(r.getId());
    }

    public void bajaCliente(Pasajero p)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        gestorHotel.eliminarHuesped(p.getId());
    }

    public void actualizarHabitacion(Habitacion h,int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        gestorHotel.actualizarHabitacion(id,h);
    }

    public void actualizarCliente(Pasajero p,int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        gestorHotel.actualizarCliente(id,p);
    }

    public void actualizarEmpleado(Empleado e,int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        gestorHotel.actualizarEmpleado(id,e);
    }

    public void actualizarReserva(Reserva r,int id)throws Dato_No_Encontrado_Exeption,Datos_Invalidos_Exeption{
        gestorHotel.actualizarReserva(id,r);
    }

}
