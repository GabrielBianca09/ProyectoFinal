package Clases.Persona.Empleados.Recepcionista;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Reservas.Reserva;
import Clases.Persona.Cliente.Pasajero;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import gestores.Gestor;
import gestores.GestorHotel;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuRecepcionista {
    private GestorHotel gestorHotel;
    private Scanner leer;

    public MenuRecepcionista(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        this.leer = new Scanner(System.in);
    }

    public void menuRecepcionista(){
        int op=-1;
        do {
            System.out.println("ingrese opcion que desea realizar:");
            System.out.println("1- registrar Pasajero");
            System.out.println("3- agregar Habitacion a reserva");
            System.out.println("2- Registar Reserva");
            try {
                int opcionmenus=leer.nextInt();
                switch (opcionmenus) {
                    case 1:
                        try {
                            gestorHotel.agregarCliente(pedirPasajero());
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println("datos_duplicados");
                        }

                        break;

                    case 2:
                        try {
                            gestorHotel.agregarReserva(new Reserva(LocalDateTime.now(),pedirPasajero()));
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println("datos_duplicados");
                        }

                        break;

                    case 3:
                        gestorHotel.mostrarReservas();
                        System.out.println("ingrese el id de la reserva");
                        try {
                            int idReserva=leer.nextInt();
                            Reserva r=gestorHotel.buscarReserva(idReserva);
                            gestorHotel.mostrarHabitaciones();
                            System.out.println("ingrese el id de la habitacion");
                            int  idHab=leer.nextInt();
                            Habitacion h=gestorHotel.buscarHabitacion(idHab);
                            System.out.println("ingrese la cantidad de dias");
                            int cantidad=leer.nextInt();
                            if(cantidad<=0){
                                throw new Datos_Invalidos_Exeption("la cantidad de dias debe ser mayor a 0");
                            }
                            r.agregarHabitacion(h,cantidad);
                        }catch (InputMismatchException e){
                            System.out.println("ingreso un tipo de datos invalido");
                            leer.nextLine();
                        }catch (Dato_No_Encontrado_Exeption |Datos_Invalidos_Exeption e){
                            System.out.println(e.getMessage());
                        }catch (Habitacion_No_Disponible_Exeption e ){
                            System.out.println(e.getMessage());
                        }

                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("ingreso un tipo de datos invalido");
            }
        }while (op!=0);
    }

    public Pasajero pedirPasajero(){
        try {
            System.out.println("Ingrese el nombre:");
            String nombre = leer.nextLine();

            System.out.println("Ingrese el apellido:");
            String apellido = leer.nextLine();

            System.out.println("Ingrese el DNI:");
            String dni = leer.nextLine();

            System.out.println("Ingrese el email:");
            String email = leer.nextLine();

            System.out.println("Ingrese el celular:");
            String celular = leer.nextLine();

            System.out.println("Ingrese dirección:");
            String direccion = leer.nextLine();

            if (nombre.isBlank() || apellido.isBlank() || dni.isBlank() || email.isBlank() || celular.isBlank()) {
                throw new Datos_Invalidos_Exeption("los datos no pueden ser nulos");
            }
            return new Pasajero(nombre,apellido,dni,email,celular,direccion);

        }catch (Datos_Invalidos_Exeption e){
            System.out.println("Los datos no pueden ser nulos");
        }
        return null;
    }
}
