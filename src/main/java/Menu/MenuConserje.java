package Clases.Persona.Empleados;

import Clases.Hotel.Reservas.MenuReserva;
import Exepciones.OperacionInvalida;
import gestores.GestorHotel;

public class RecepcionConserje {
    private GestorHotel gestorHotel;
    private Empleado empleado;

    public RecepcionConserje(GestorHotel gestorHotel, Empleado empleado) {
        this.gestorHotel = gestorHotel;
        this.empleado = empleado;
    }

    public void menuResepcicionista(){
        if(empleado instanceof Conserje){
            System.out.println("------------------------------------");
            System.out.println("bienvenido al menu Conserje");
            System.out.println("------------------------------------");
            MenuReserva menuReserva=new MenuReserva(gestorHotel);
            menuReserva.menuReserva();
        }else {
            throw new OperacionInvalida("Solo el conserje puede realizar operaciones de recepcion");
        }
    }
}
