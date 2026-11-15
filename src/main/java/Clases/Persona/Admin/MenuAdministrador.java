package Clases.Persona.Admin;

import Clases.Hotel.MenuHabitacion;
import Clases.Hotel.MenuHotel;
import Clases.Hotel.Reservas.MenuReserva;
import Clases.Hotel.Servicios.MenuServicio;
import Clases.Hotel.Servicios.MenuServiciosXCliente;
import Clases.Persona.Cliente.MenuCliente;
import Clases.Persona.Empleados.MenuEmpleado;
import gestores.Gestor;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdministrador {
    private Scanner sc;
    private GestorHotel gestorHotel;

    public MenuAdministrador(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        this.sc = new Scanner(System.in);
    }

    public void menuAdministrador(){
        int op=-1;
        do {
            System.out.println("ingrese que desea administrar");
            System.out.println("1 hoteles");
            System.out.println("2 clientes");
            System.out.println("3 habitaciones");
            System.out.println("4 Servicios");
            System.out.println("5 reservas");
            System.out.println("6 empleados");
            System.out.println("7 servicios por cliente");

            try {
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        MenuHotel menuHotel=new MenuHotel(gestorHotel);
                        menuHotel.menuHotel();
                        break;

                    case 2:
                        MenuCliente menuCliente=new MenuCliente(gestorHotel);
                        menuCliente.OperacionesConPasajeros();
                        break;

                    case 3:
                        MenuHabitacion menuHabitacion=new MenuHabitacion(gestorHotel);
                        menuHabitacion.operacionesConHabitaciones();
                        break;

                        case 4:
                            MenuServicio menuServicio=new MenuServicio(gestorHotel);
                            menuServicio.operacionesConServicios();
                            break;

                    case 5:
                        MenuReserva menuReserva=new MenuReserva(gestorHotel);
                        menuReserva.menuReserva();
                        break;

                    case 6:
                        MenuEmpleado menuEmpleado=new MenuEmpleado(gestorHotel);
                        menuEmpleado.OperacionesEmpleados();
                        break;

                    case 7:
                        MenuServiciosXCliente menuServiciosXCliente=new MenuServiciosXCliente(gestorHotel);
                        menuServiciosXCliente.menuConsumos();
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ingrese que desea administrar");
                sc.next();
            }

        }while (op!=0);
    }
}
