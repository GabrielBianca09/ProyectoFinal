package Clases.Persona.Empleados;

import Clases.Persona.Persona;
import Enums.Tipo_de_Trabajo;

public class Recepcionista extends Empleado {

    public Recepcionista(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
        agregarChamba(Tipo_de_Trabajo.RESERVAS);
    }

    @Override
    public String toString() {
        return "Recepcionista{} " + super.toString();
    }
}
