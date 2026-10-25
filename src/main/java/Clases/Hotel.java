public class Hotel {

    private String nombreHotel;
    private String direccionHotel;
    private String numeroContactoHotel;


    /// Constructor --------------------------------------
    public Hotel(String nombreHotel, String direccionHotel, String numeroContactoHotel) {
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

    /// To String() --------------------------------------------

    @Override
    public String toString() {
        return "Hotel{" +
                "nombreHotel='" + nombreHotel + '\'' +
                ", direccionHotel='" + direccionHotel + '\'' +
                ", numeroContactoHotel='" + numeroContactoHotel + '\'' +
                '}';
    }
}
