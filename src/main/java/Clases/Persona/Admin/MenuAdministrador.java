package Clases.Persona.Admin;

import Clases.Hotel.MenuHabitacion;
import Clases.Hotel.MenuHotel;
import Clases.Hotel.Reservas.MenuReserva;
import Clases.Persona.Cliente.MenuCliente;
import Clases.Persona.Empleados.MenuEmpleado;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;
import java.util.InputMismatchException;
import java.util.Scanner;
//por ser el administrador valido sus credenciales.
//este menu es una composicion la cual tiene el gestorhotel que la clase en la cual estan todas mis funciones
//de creacion,busqueada,eliminacion,actualizacion.
//todos los menus reciben el mismo gestor previamente creador en main.
//implementa funciones de ingreso de datos y uso de exepciones.
//para mayor limpieza del codigo cada clase tiene su menu y se implementa en esta clase.

public class MenuAdministrador {
    private Scanner sc;
    private GestorHotel gestorHotel;
    private Administrador administrador;

    public MenuAdministrador(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        this.sc = new Scanner(System.in);
    }

    public void login()throws Dato_No_Encontrado_Exeption {
        Administrador admin = null;
        while (admin == null) {
            System.out.println("Usuario:");
            String usuario = sc.nextLine();
            System.out.println("Clave:");
            String clave = sc.nextLine();

            try {
                admin = gestorHotel.ValidacionAdministrador(usuario,clave);
            } catch (Datos_Invalidos_Exeption e) {
                System.out.println(e.getMessage());
            }
        }
       menuAdministrador();
    }

    public void menuAdministrador(){
        int op=-1;
        do {
            System.out.println("ingrese que desea administrar");
            System.out.println("1 hoteles");
            System.out.println("2 clientes");
            System.out.println("3 habitaciones");
            System.out.println("5 reservas");
            System.out.println("6 empleados");

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

                    case 5:
                        MenuReserva menuReserva=new MenuReserva(gestorHotel);
                        menuReserva.menuReserva();
                        break;

                    case 6:
                        MenuEmpleado menuEmpleado=new MenuEmpleado(gestorHotel);
                        menuEmpleado.OperacionesEmpleados();
                        break;

                }
            }catch (InputMismatchException e){
                System.out.println("ingrese que desea administrar");
                sc.next();
            }

        }while (op!=0);
    }
}
