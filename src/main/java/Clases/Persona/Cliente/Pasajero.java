package Clases.Persona.Cliente;

import Clases.Persona.Persona;
import Interfaces.Identificable;

public class Pasajero extends Persona {

    private String direccionOrigen;


    /// Contructor ----------------------------

    public Pasajero(String nombre, String apellido, String dni, String email, String numeroCelular, int id, String direccionOrigen) {
        super(nombre, apellido, dni, email, numeroCelular, id);
        this.direccionOrigen = direccionOrigen;
    }

    ///  Getters --------------------------

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    /// Setters -----------------------------

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    /// ToString() ----------------------

    @Override
    public String toString() {
        return "Reservas.Pasajero {" + super.toString() + "direccionOrigen=" + direccionOrigen + '}';
    }




}
