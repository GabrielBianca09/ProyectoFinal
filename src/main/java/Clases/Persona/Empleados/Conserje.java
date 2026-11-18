package Clases.Persona.Empleados;

import Enums.Tipo_de_Trabajo;

public class Conserje extends Empleado {
    private Tipo_de_Trabajo tipoDeTrabajo;
    /// Constuctor -----------------------------


    public Conserje(String nombre, String apellido, String dni, String email, String numeroCelular,int horasTrabajadas, String direccion, double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular,horasTrabajadas, direccion, salarioPorHora);
        this.tipoDeTrabajo=Tipo_de_Trabajo.conserje;
    }

    public Tipo_de_Trabajo getTipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public void setTipoDeTrabajo(Tipo_de_Trabajo tipoDeTrabajo) {
        this.tipoDeTrabajo = tipoDeTrabajo;
    }



    /// ToString() -------------------------------
    @Override
    public String toString() {
        return "========== CONSERJE ==========\n" +
                "Tipo de trabajo: " + tipoDeTrabajo + "\n" +
                super.toString();
    }



    @Override
    public double calcularTotal() {
        return getHorasTrabajadas()*tipoDeTrabajo.getFactor()+getSalarioBase();
    }
}
