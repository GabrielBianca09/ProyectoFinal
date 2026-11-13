package Clases.Hotel.Servicios;
import Clases.Persona.Empleados.Empleado;
import Interfaces.Identificable;

public class EmpleadoServicio implements Identificable {
    private static int cont=0;
    private int Esid;
    private Empleado empleado;
    private double salario_adicional;

    public EmpleadoServicio(Empleado empleado, double salario_adicional) {
        this.empleado = empleado;
        this.salario_adicional = salario_adicional;
        this.Esid=cont++;
    }

    @Override
    public int getId() {
        return Esid;
    }

    @Override
    public void actualizarDatos(Identificable NuevosDatos) {
        EmpleadoServicio empleadoServicio=(EmpleadoServicio) NuevosDatos;
        this.empleado=empleadoServicio.getEmpleado();
        this.salario_adicional=empleadoServicio.getSalario_adicional();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getSalario_adicional() {
        return salario_adicional;
    }

    public void setSalario_adicional(double salario_adicional) {
        this.salario_adicional = salario_adicional;
    }

    @Override
    public String toString() {
        return "EmpleadoServicio{" +
                "empleado=" + empleado +
                ", Esid=" + Esid +
                ", salario_adicional=" + salario_adicional +
                '}';
    }


}
