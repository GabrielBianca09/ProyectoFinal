package Clases.Hotel;

import Exepciones.Datos_Invalidos_Exeption;
import Interfaces.Identificable;
//realiza funciones setar datos, actualizar datos y mostrar datos es la base de mi proyecto sobre este se crean las demas clases.
//todas mis clases implementan la interfaz indentificable, sobre esta permito que cada clase tenga un id y ademas me deja actualizar
// los datos de todos los que la implementen.
public class Hotel implements Identificable {

    private static int contador = 0;
    private int id_hotel;
    private String nombreHotel;
    private String direccionHotel;
    private String numeroContactoHotel;


    /// Constructor --------------------------------------
    public Hotel(String nombreHotel, String direccionHotel, String numeroContactoHotel) {
        setNumeroContactoHotel(numeroContactoHotel);
        setNombreHotel(nombreHotel);
        setDireccionHotel(direccionHotel);
        this.id_hotel =contador++;
    }

    public Hotel(int id_hotel, String nombreHotel, String direccionHotel, String numeroContactoHotel) {
        this.id_hotel = id_hotel;
        this.nombreHotel = nombreHotel;
        this.direccionHotel = direccionHotel;
        this.numeroContactoHotel = numeroContactoHotel;
    }

    /// Getters -------------------------------------------
    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getDireccionHotel() {
        return direccionHotel;
    }

    public String getNumeroContactoHotel() {
        return numeroContactoHotel;
    }
    public int getId_hotel() {
        return id_hotel;
    }

    /// Setters ----------------------------------------------

    public void setNombreHotel(String nombreHotel) {
        if (nombreHotel == null || nombreHotel.isBlank()) {
            throw new Datos_Invalidos_Exeption("El nombre del hotel no puede estar vacío");
        }
        this.nombreHotel = nombreHotel;
    }

    public void setDireccionHotel(String direccionHotel) {
        if (direccionHotel == null || direccionHotel.isBlank()) {
            throw new Datos_Invalidos_Exeption("La dirección del hotel no puede estar vacía");
        }
        this.direccionHotel = direccionHotel;
    }

    public void setNumeroContactoHotel(String numeroContactoHotel) {
        if (numeroContactoHotel == null || numeroContactoHotel.isBlank()) {
            throw new Datos_Invalidos_Exeption("El número de contacto del hotel no puede estar vacío");
        }
        this.numeroContactoHotel = numeroContactoHotel;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "direccionHotel='" + direccionHotel + '\'' +
                ", id_hotel=" + id_hotel +
                ", nombreHotel='" + nombreHotel + '\'' +
                ", numeroContactoHotel='" + numeroContactoHotel + '\'' +
                '}';
    }

    /// To String() --------------------------------------------



    @Override
    public int getId() {
        return id_hotel;
    }

    @Override
    public void actualizarDatos(Identificable NuevosDatos) {
        Hotel hotel = (Hotel) NuevosDatos;
        this.nombreHotel = hotel.getNombreHotel();
        this.direccionHotel = hotel.getDireccionHotel();
        this.numeroContactoHotel = hotel.getNumeroContactoHotel();
        this.id_hotel = hotel.getId_hotel();
    }
}
