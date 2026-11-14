package Clases.Persona.Cliente;

import Clases.Persona.Persona;
import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.Identificable;

public class Pasajero extends Persona {

    private String direccionOrigen;


    /// Contructor ----------------------------

    public Pasajero(String nombre, String apellido, String dni, String email, String numeroCelular,String direccionOrigen) {
        super(nombre, apellido, dni, email, numeroCelular);
        this.direccionOrigen = direccionOrigen;
    }

    ///  Getters --------------------------

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    /// Setters -----------------------------

    public void setDireccionOrigen(String direccionOrigen) {
        if (direccionOrigen == null || direccionOrigen.isBlank()) {
            throw new Datos_Invalidos_Exeption("La dirección de origen no puede estar vacía");
        }
        this.direccionOrigen = direccionOrigen;
    }

    /// ToString() ----------------------

    @Override
    public String toString() {
        return "Reservas.Pasajero {" + super.toString() + "direccionOrigen=" + direccionOrigen + '}';
    }




}
