package Clases.Hotel.Reservas;

import Clases.Hotel.Habitacion;
import Clases.Persona.Cliente.Pasajero;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.Habitacion_No_Disponible_Exeption;
import Gestores.GestorHotel;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

//este menu es una composicion la cual tiene el gestorhotel que la clase en la cual estan todas mis funciones
//de creacion,busqueada,eliminacion,actualizacion.
//todos los menus reciben el mismo gestor previamente creador en main.
//implementa funciones de ingreso de datos y uso de exepciones.

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
            System.out.println("opcion 1 agregar reserva check in");
            System.out.println("opcion 2 finalizar  check out");
            System.out.println("opcion 3 Eliminar reserva");
            System.out.println("opcion 4 actualizar reserva");
            System.out.println("opcion 5 listar reservas");
            System.out.println("0. Salir");
            try {
                opcion=leer.nextInt();
                switch (opcion) {

                    case 1:

                        Reserva r = null;

                        try {
                            gestorHotel.mostrarHabitaciones();

                            System.out.println("Ingrese cantidad de días:");
                            int cantidadDias = leer.nextInt();
                            leer.nextLine();

                            if (cantidadDias <= 0) {
                                throw new Datos_Invalidos_Exeption(
                                        "La cantidad de días debe ser mayor a cero"
                                );
                            }

                            System.out.println("ingrese los datos del cliente");
                            Pasajero pasajero = pedirPasajero();

                            LocalDateTime ahora = LocalDateTime.now();

                            r = new Reserva(ahora, pasajero, cantidadDias);

                            char salida = 's';
                            int opcionAgregar = -1;

                            do {
                                gestorHotel.mostrarHabitaciones();

                                System.out.println("Ingrese el ID de la habitación:");
                                opcionAgregar = leer.nextInt();
                                leer.nextLine();

                                if (opcionAgregar < 0) {
                                    throw new Datos_Invalidos_Exeption(
                                            "El ID no puede ser negativo"
                                    );
                                }

                                Habitacion h = gestorHotel.buscarHabitacion(opcionAgregar);

                                r.agregarHabitacion(h);

                                System.out.println("Habitación agregada correctamente");

                                System.out.println("¿Desea agregar otra habitación? (s/n)");
                                salida = Character.toLowerCase(leer.next().charAt(0));
                                leer.nextLine();

                            } while (salida != 'n');

                            if (r.getHabitacionesXreserva().isEmpty()) {
                                throw new Datos_Invalidos_Exeption(
                                        "La reserva debe tener al menos una habitación"
                                );
                            }

                            double total = r.calcularTotal();

                            gestorHotel.agregarReserva(r);

                            System.out.println("Reserva creada correctamente");
                            System.out.println("El total de la reserva es: " + total);

                        }
                        catch (InputMismatchException e) {

                            System.out.println("Ingresaste un formato inválido");
                            leer.nextLine();
                        }catch (Datos_Duplicados_Exeption |
                                 Dato_No_Encontrado_Exeption |
                                 Habitacion_No_Disponible_Exeption |
                                 Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());


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

                            Reserva r1 = gestorHotel.buscarReserva(id);

                            r1.devolverTodo();

                            System.out.println("Reserva finalizada correctamente");

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
                            gestorHotel.devolverReserva(id);
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
                            System.out.println("ingrese la cantida de dias");
                            int cantda = leer.nextInt();
                            leer.nextLine();
                            if ( cantda<= 0) {
                                throw new Datos_Invalidos_Exeption(
                                        "La cantidad de días debe ser mayor a cero"
                                );
                            }
                            System.out.println("Buscando reserva...");
                            Reserva r2=gestorHotel.buscarReserva(id);

                            System.out.println("Reserva encontrada. Actualizando...");
                            r2.setCantidadDias(cantda);
                            r2.setPasajero(pedirPasajero());
                            System.out.println("Guardando cambios...");
                            gestorHotel.actualizarReserva(id,r2);


                        }catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("el elemento no existe");
                        } catch (InputMismatchException e){
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                        }
                        break;

                    case 5:
                        gestorHotel.mostrarReservas();
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
                leer.nextLine();
            }

        }while (opcion!=0);
    }

    public Pasajero pedirPasajero() {

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

            return new Pasajero(nombre, apellido, dni, email, celular, direccion);

        } catch (Datos_Invalidos_Exeption e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    }






