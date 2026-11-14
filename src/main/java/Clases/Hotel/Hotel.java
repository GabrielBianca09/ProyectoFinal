package Clases.Hotel;

import Interfaces.Identificable;

public class Hotel implements Identificable {

    private static int contador = 0;
    private int id_hotel;
    private String nombreHotel;
    private String direccionHotel;
    private String numeroContactoHotel;


    /// Constructor --------------------------------------
    public Hotel(String nombreHotel, String direccionHotel, String numeroContactoHotel) {
        this.nombreHotel = nombreHotel;
        this.direccionHotel = direccionHotel;
        this.numeroContactoHotel = numeroContactoHotel;
        this.id_hotel =contador++;
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
        this.nombreHotel = nombreHotel;
    }

    public void setDireccionHotel(String direccionHotel) {
        this.direccionHotel = direccionHotel;
    }

    public void setNumeroContactoHotel(String numeroContactoHotel) {
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
