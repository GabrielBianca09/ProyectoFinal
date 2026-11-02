package Clases.Persona.Empleados;

public class Conserje extends Empleado {

    /// Constuctor -----------------------------


    public Conserje(String nombre, String apellido, String dni, String email, String numeroCelular, int id, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, id, horasTrabajadas, direccion, salarioPorHora);
    }

    /// ToString() -------------------------------

    @Override
    public String toString() {
        return "Empleados.Conserje{} " + super.toString();
    }
}
