package Clases.Persona;

import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.Identificable;
// es una clase abstracta que implementa los metodos de identificable que son getid y actualizar datos(no modifica el id).
//muestra de datos.
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
        setApellido(apellido);
        setDni(dni);
        setEmail(email);
        setNumeroCelular(numeroCelular);
        setNombre(nombre);
        this.id=cont++;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void actualizarDatos(Identificable actualizar) {
        Persona p=(Persona) actualizar;
        this.nombre =p.getNombre();
        this.apellido =p.getApellido();
        this.dni =p.getDni();
        this.email =p.getEmail();
        this.numeroCelular =p.getNumeroCelular();
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

    public void setNombre(String nombre){
        if (nombre == null || nombre.isBlank()) {
            throw new Datos_Invalidos_Exeption("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        if (apellido == null || apellido.isBlank()) {
            throw new Datos_Invalidos_Exeption("El apellido no puede estar vacío");
        }
        this.apellido = apellido;
    }

    public void setDni(String dni){
        if (dni == null || dni.isBlank()) {
            throw new Datos_Invalidos_Exeption("El DNI no puede estar vacío");
        }
        this.dni = dni;
    }

    public void setEmail(String email){
        if (email == null || email.isBlank()) {
            throw new Datos_Invalidos_Exeption("El email no puede estar vacío");
        }
        this.email = email;
    }

    public void setNumeroCelular(String numeroCelular){
        if (numeroCelular == null || numeroCelular.isBlank()) {
            throw new Datos_Invalidos_Exeption("El número de celular no puede estar vacío");
        }
        this.numeroCelular = numeroCelular;
    }

    public void setId(int id) {
        this.id = id;
    }

    /// ToString -------------------------------------------


    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                '}';
    }
}
