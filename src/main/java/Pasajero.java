public class Pasajero extends Persona {

    private String direccionOrigen;


    /// Contructor ----------------------------

    public Pasajero(String nombre, String apellido, String dni, String email, String direccionOrigen, String numeroCelular) {
        super(nombre,apellido,dni,email,numeroCelular);
        this.direccionOrigen = direccionOrigen;
    }

    ///  Getters --------------------------

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    /// Setters -----------------------------

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    /// ToString() ----------------------

    @Override
    public String toString() {
        return "Pasajero {" + super.toString() + "direccionOrigen=" + direccionOrigen + '}';
    }
}
