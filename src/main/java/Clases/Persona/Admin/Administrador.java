package Clases.Persona.Admin;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Reservas.Reserva;
import Clases.Persona.Cliente.Pasajero;
import Clases.Persona.Empleados.Empleado;
import Clases.Persona.Persona;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.Identificable;
import gestores.GestorHotel;

public class Administrador extends Persona implements Identificable {
    private static int cont=0;
    private int id_Admin;
    private String nombreUsuario;
    private String clave;

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

    @Override
    public int getId() {
        return id_Admin;
    }

    @Override
    public void actualizarDatos(Identificable actualizar) {
        Administrador admin = (Administrador) actualizar;
        this.nombreUsuario = admin.getNombreUsuario();
        this.clave = admin.getClave();
    }

    public boolean validarClave(String claveingresada,String nombreUsuario) {
        return this.nombreUsuario.equals(nombreUsuario) && this.clave.equals(claveingresada);
    }
}
