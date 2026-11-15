package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import gestores.GestorHotel;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuReserva {
    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuReserva(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        leer = new Scanner(System.in);
    }

    public void menuReserva(){
        int opcion=-1;
        do {
            int opReserva;
            System.out.println("opcion 1 agregar reserva");
            System.out.println("opcion 2 finalizar reserva");
            System.out.println("opcion 3 Eliminar reserva");
            System.out.println("opcion 4 actualizar reserva");
            System.out.println("0. Salir");
            try {
                opReserva=leer.nextInt();
                switch (opReserva) {
                    case 1:
                        gestorHotel.mostrarHabitaciones();
                        System.out.println("ingrese el id de la habitacion");
                        int opcionhabitacion;
                        try {
                            opcionhabitacion=leer.nextInt();
                            Pasajero pasajero=pedirPasajero();
                            Reserva r=new Reserva(new Date(),pasajero);
                            if (opcionhabitacion<0) {
                                throw new Datos_Invalidos_Exeption("la opcion debe ser mayor o igual a 0");
                            }
                            int opcionAgregar=-1;
                            do {
                                System.out.println("desea agregar una habitacion cualquier int para segui 0 para salir");
                                opcionAgregar=leer.nextInt();
                                pedirDetalle(r);
                            }while (opcionAgregar!=0);
                            if (r.getHabitacionesXreserva().isEmpty()){
                                System.out.println("tiene que haber al menos 1 habitacion");
                            }
                            double total=r.calcularTotal();
                            gestorHotel.agregarReserva(r);
                            System.out.println("el total de la reserva es : "+ total);
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println(e.getMessage());
                        }
                            catch (Datos_Invalidos_Exeption e){


                            System.out.println("ingresaste datos invalidos");
                        }
                        catch (InputMismatchException e){
                            System.out.println("ingresaste un formato invalido");

                        }
                        break;

                    case 2:
                        try {
                            gestorHotel.mostrarReservas();
                            System.out.println("Ingrese el ID de la reserva a finalizar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            if (id < 0) {
                                throw new Datos_Invalidos_Exeption("El ID no puede ser negativo");
                            }

                            Reserva r = gestorHotel.buscarReserva(id);
                            r.finalizarReserva(id);
                            System.out.println("Reserva finalizada");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("La reserva no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 3:
                        try {
                            gestorHotel.mostrarReservas();
                            System.out.println("Ingrese el ID de la reserva a eliminar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            if (id < 0) {
                                throw new Datos_Invalidos_Exeption("El ID no puede ser negativo");
                            }

                            gestorHotel.eliminarReserva(id);
                            System.out.println("Reserva eliminada con exito");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("La reserva no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 4:
                        try {
                            gestorHotel.mostrarReservas();
                            System.out.println("Ingrese el ID de la reserva a actualizar:");
                            int id = leer.nextInt();
                            leer.nextLine();
                            if (id < 0) {
                                throw new Datos_Invalidos_Exeption("El ID no puede ser negativo");
                            }
                            Reserva r=gestorHotel.buscarReserva(id);
                            r.setPasajero(pedirPasajero());
                            gestorHotel.actualizarReserva(id,r);


                        }catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("el elemento no existe");
                        } catch (InputMismatchException e){
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                        }


                        break;

                    case 0:
                        System.out.println("Salir");
                        break;

                        default:
                            System.out.println("ingresaste una opcion incorrecta");
                            break;
                }
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un valor del tipo correcto.");
            }

        }while (opcion!=0);
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

    private void pedirDetalle(Reserva reserva) {
        try {
            gestorHotel.mostrarHabitaciones();
            System.out.println("Ingrese el ID de la habitacion:");
            int id = leer.nextInt();
            leer.nextLine();

            if (id <= 0) {
                throw new Datos_Invalidos_Exeption("El ID debe ser mayor a 0");
            }

            Habitacion h = gestorHotel.buscarHabitacion(id);

            System.out.println("Ingrese la cantidad de dias:");
            int dias = leer.nextInt();
            leer.nextLine();

            if (dias <= 0) {
                throw new Datos_Invalidos_Exeption("La cantidad de dias debe ser mayor a 0");
            }

            reserva.agregarHabitacion(h,dias);

        } catch (Dato_No_Encontrado_Exeption e) {
            System.out.println("La habitacion no existe");

        } catch (Habitacion_No_Disponible_Exeption e) {
            System.out.println("La habitacion no esta disponible");

        } catch (Datos_Invalidos_Exeption e) {
            System.out.println(e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un valor del tipo correcto.");
            leer.nextLine();
        }
    }
}





