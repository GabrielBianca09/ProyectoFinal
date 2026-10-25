public class Empleado extends Persona{

    private int horasTrabajadas;
    private String direccion;
    private double salarioPorHora;
    private double salario;

    /// Constructor ------------------------------------

    public Empleado(String nombre, String apellido, String dni, String email, String numeroCelular, int horasTrabajadas, String direccion,  double salarioPorHora) {
        super(nombre, apellido, dni, email, numeroCelular);
        this.horasTrabajadas = horasTrabajadas;
        this.direccion = direccion;
        this.salarioPorHora = salarioPorHora;
    }

    /// Getters --------------------------------

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public double getSalario() {
        return salario;
    }

    /// Setters -----------------------------------

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /// ToString() --------------------------------

    @Override
    public String toString() {
        return "Empleado{" + super.toString() +
                "horasTrabajadas=" + horasTrabajadas +
                ", direccion='" + direccion + '\'' +
                ", salarioPorHora=" + salarioPorHora +
                ", salario=" + salario +
                '}';
    }
}


