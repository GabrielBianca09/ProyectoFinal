package Clases.Persona;

import Interfaces.Identificable;

public abstract class Persona implements Identificable {
    private static int cont=0;
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String numeroCelular;


    /// Constructores --------------------------------------


    public Persona(String nombre, String apellido, String dni, String email, String numeroCelular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.id=cont++;
    }


    @Override
    public int getId() {
        return id;
    }

    /// Getters -----------------------------------------






    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    /// Setters ------------------------------------------


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    /// ToString -------------------------------------------


    @Override
    public String toString() {
        return " " +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", numeroCelular=" + numeroCelular +
                '}';
    }


}
