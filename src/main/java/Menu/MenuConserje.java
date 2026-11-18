package Menu;

import Clases.Persona.Empleados.Conserje;
import Clases.Persona.Empleados.Empleado;
import Exepciones.OperacionInvalida;
import Gestores.GestorHotel;

public class MenuConserje {
    private GestorHotel gestorHotel;
    private Empleado empleado;

    public MenuConserje(GestorHotel gestorHotel, Empleado empleado) {
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
