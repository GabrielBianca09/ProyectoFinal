package Clases.Persona.Empleados;

import Clases.Persona.Persona;
import Enums.Tipo_de_Trabajo;
import Interfaces.CalcularCosto;

import java.util.ArrayList;
import java.util.List;
//es una clase que hereda de persona, se hizo abstracta para que cada clase de empleado pueda implementar un calculo de sueldo diferente.

public abstract class Empleado extends Persona implements CalcularCosto {

    private int horasTrabajadas;
    private String direccion;
    private double salarioBase;
    /// Constructor ------------------------------------

    public Empleado(String nombre, String apellido, String dni, String email, String numeroCelular,int horasTrabajadas, String direccion,  double salarioBase) {
        super(nombre, apellido, dni, email, numeroCelular);
        this.horasTrabajadas = horasTrabajadas;
        this.direccion = direccion;
        this.salarioBase = salarioBase;

    }

    /// Getters --------------------------------
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getSalarioPorHora() {
        return salarioBase;
    }

    /// Setters -----------------------------------

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /// ToString() --------------------------------

    @Override
    public String toString() {
        return "Empleados.Empleado{" +super.toString() +
                "horasTrabajadas=" + horasTrabajadas +
                ", direccion='" + direccion + '\'' +
                ", salarioPorHora=" + salarioBase +
                ", salario="+
                '}';
    }

    @Override
    public abstract double calcularTotal();
}


