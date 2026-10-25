package Clases;

public class GestorReservas {
    private Gestor<Reserva>reservas;

    public GestorReservas() {
        this.reservas =new Gestor<>();
    }

    public Gestor<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Gestor<Reserva> reservas) {
        this.reservas = reservas;
    }
    public boolean agregarReserva(Reserva r){
        if(reservas.agregar(r)){
            return true;
        }
        return false;
    }

    public Reserva buscarReserva(int id){
        Reserva r=reservas.buscarPorid(id);
        return r;
    }

    public boolean eliminarReserva(int id){
        Reserva r=buscarReserva(id);
        if(r!=null){
            reservas.eliminarObjeto(id);
            return true;
        }
        return false;
    }
}
