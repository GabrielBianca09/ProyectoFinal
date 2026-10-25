package Clases;

public class Cocinero extends Empleado {

    /// Constructor -------------------------

    public Cocinero(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
    }

    /// ToString() ------------------------------

    @Override
    public String toString() {
        return "Empleados.Cocinero{} " + super.toString();
    }
}
