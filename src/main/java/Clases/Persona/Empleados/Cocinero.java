package Clases.Persona.Empleados;

import Enums.Tipo_de_Trabajo;

public class Cocinero extends Empleado {

    /// Constructor -------------------------

    public Cocinero(String nombre, String apellido, String dni, String email, String numeroCelular,int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
        agregarChamba(Tipo_de_Trabajo.COCINA);
    }

    /// ToString() ------------------------------

    @Override
    public String toString() {
        return "Empleados.Cocinero{} " + super.toString();
    }
}
