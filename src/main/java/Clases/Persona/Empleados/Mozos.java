package Clases.Persona.Empleados;

import Enums.Tipo_de_Trabajo;

public class Mozos extends Empleado {
    private Tipo_de_Trabajo tipo_de_trabajo;
    /// Constructor ----------------------------------


    public Mozos(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular, horasTrabajadas, direccion, salarioPorHora);
        this.tipo_de_trabajo=Tipo_de_Trabajo.mozo;
    }

    public Tipo_de_Trabajo getTipo_de_trabajo() {
        return tipo_de_trabajo;
    }

    public void setTipo_de_trabajo(Tipo_de_Trabajo tipo_de_trabajo) {
        this.tipo_de_trabajo = tipo_de_trabajo;
    }

    @Override
    public String toString() {
        return "Mozos{" +
                "tipo_de_trabajo=" + tipo_de_trabajo +
                "} " + super.toString();
    }

    /// ToString() ------------------------------------



    @Override
    public double calcularTotal() {
        return getHorasTrabajadas()*tipo_de_trabajo.getFactor()+getSalarioBase();
    }
}
