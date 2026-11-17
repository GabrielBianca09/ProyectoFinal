package Clases.Persona.Empleados;

import Clases.Persona.Persona;
import Enums.Tipo_de_Trabajo;
import Exepciones.Datos_Invalidos_Exeption;
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
        this.horasTrabajadas =setHorasTrabajadas(horasTrabajadas);
        this.direccion =setDireccion(direccion);
        this.salarioBase =setSalarioBase(salarioBase);

    }

    /// Getters --------------------------------
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    /// Setters -----------------------------------

    public int setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas <= 0) {
            throw new Datos_Invalidos_Exeption("Las horas trabajadas deben ser mayores a cero");
        }
        return this.horasTrabajadas = horasTrabajadas;
    }

    public String setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            throw new Datos_Invalidos_Exeption("La dirección no puede estar vacía");
        }
        return this.direccion = direccion;
    }

    public double setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            throw new Datos_Invalidos_Exeption("El salario base debe ser mayor a cero");
        }
        return this.salarioBase = salarioBase;
    }

    /// ToString() --------------------------------

    @Override
    public String toString() {
        return "Empleados.Empleado{" +super.toString() +
                "horasTrabajadas=" + horasTrabajadas +
                ", direccion='" + direccion + '\'' +
                ", salarioPorHora=" + salarioBase +
                ", salario="+calcularTotal()+
                '}';
    }

    @Override
    public abstract double calcularTotal();
}


