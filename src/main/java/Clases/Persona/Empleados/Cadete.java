package Clases.Persona.Empleados;

import Enums.Tipo_de_Trabajo;

public class Cadete extends Empleado{
    public Cadete(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
        agregarChamba(Tipo_de_Trabajo.ESTACIONAMIENTO);
        agregarChamba(Tipo_de_Trabajo.ATENCION);
        agregarChamba(Tipo_de_Trabajo.EQUIPAJE);
    }

    @Override
    public String toString() {
        return "Botones{} " + super.toString();
    }
}
