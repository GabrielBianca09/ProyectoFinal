package Clases.Persona.Admin;

import Clases.Persona.Persona;
import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.Identificable;
// esta clase es la que tiene el acceso a todos los datos y funciones del proyecto por lo cual recibe una clave y usuario para maximixar la seguridad.
//tiene una funcion de validacion,otra de actualizacion y tambien implementa identificable.

public class Administrador extends Persona implements Identificable {
    private static int cont=0;
    private int id_Admin;
    private String nombreUsuario;
    private String clave;

    public Administrador(String nombre, String apellido, String dni, String email, String numeroCelular, String clave,String nombreUsuario) {
        super(nombre, apellido, dni, email, numeroCelular);
        setClave(clave);
        this.id_Admin =cont++;
        setNombreUsuario(nombreUsuario);
    }

    public String getClave() {
        return clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            throw new Datos_Invalidos_Exeption("El nombre de usuario no puede estar vacío");
        }
         this.nombreUsuario = nombreUsuario;
    }

    public void setClave(String clave) {
        if (clave == null || clave.isBlank()) {
            throw new Datos_Invalidos_Exeption("La clave no puede estar vacía");
        }
        this.clave = clave;
    }


    public int getId_Admin() {
        return id_Admin;
    }

    @Override
    public int getId() {
        return id_Admin;
    }

    @Override
    public void actualizarDatos(Identificable actualizar) {
        Administrador admin = (Administrador) actualizar;
        this.nombreUsuario = admin.getNombreUsuario();
        this.clave = admin.getClave();
    }

    public boolean validarClave(String claveingresada,String nombreUsuario) {
        return this.nombreUsuario.equals(nombreUsuario) && this.clave.equals(claveingresada);
    }
}
