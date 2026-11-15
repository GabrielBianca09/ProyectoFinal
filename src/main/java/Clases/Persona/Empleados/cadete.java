package Clases.Persona.Empleados;

public class cadete extends Empleado{
    public cadete(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
    }

    @Override
    public String toString() {
        return "cadete{} " + super.toString();
    }
}
