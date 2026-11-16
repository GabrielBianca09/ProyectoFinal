package Clases.Hotel;

import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;
//este menu es una composicion la cual tiene el gestorhotel que la clase en la cual estan todas mis funciones
//de creacion,busqueada,eliminacion,actualizacion.
//todos los menus reciben el mismo gestor previamente creador en main.
//implementa funciones de ingreso de datos y uso de exepciones.
public class MenuHabitacion {

    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuHabitacion(GestorHotel gestorHotel) {
        this.leer = new Scanner(System.in);
        this.gestorHotel = gestorHotel;
    }

    public void operacionesConHabitaciones() {

        int op = -1;

        do {
            System.out.println("\n--- MENU Habitacion ---");
            System.out.println("1. Agregar Habitacion");
            System.out.println("2. Listar Habitaciones");
            System.out.println("3. Eliminar Habitacion");
            System.out.println("4. Actualizar Habitacion");
            System.out.println("0. Salir");

            try {
                op = leer.nextInt();
                leer.nextLine();

                switch (op) {

                    case 1:
                        try {
                            gestorHotel.listarHoteles();
                            System.out.println("Ingrese el numero de hotel:");
                            int numHotel = leer.nextInt();
                            leer.nextLine();

                            gestorHotel.existeHotel(numHotel);
                            Hotel hotel = gestorHotel.BuscarHotel(numHotel);

                            System.out.println("Ingrese la capacidad de la habitacion:");
                            int capacidad = leer.nextInt();
                            leer.nextLine();

                            if (capacidad <= 0) {
                                throw new Datos_Invalidos_Exeption("La capacidad debe ser mayor a 0");
                            }

                            Tipo_Habitacion tipo = pedirTipo();
                            EstadoHabitacion estado = pedirEstado();

                            gestorHotel.agregarHabitacion(new Habitacion(capacidad, estado, hotel, tipo));

                            System.out.println("Habitacion agregada correctamente");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El hotel no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Duplicados_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 2:
                        gestorHotel.mostrarHabitaciones();
                        break;

                    case 3:
                        try {
                            gestorHotel.mostrarHabitaciones();
                            System.out.println("Ingrese el numero de habitacion a eliminar:");
                            int nro = leer.nextInt();
                            leer.nextLine();

                            if (nro <= 0) {
                                throw new Datos_Invalidos_Exeption("El numero debe ser mayor a 0");
                            }

                            gestorHotel.eliminarHabitacion(nro);
                            System.out.println("Habitacion eliminada con exito");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("La habitacion no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 4:
                        try {
                            gestorHotel.mostrarHabitaciones();
                            System.out.println("Ingrese el ID de la habitacion a actualizar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            if (id <= 0) {
                                throw new Datos_Invalidos_Exeption("El ID debe ser mayor a 0");
                            }

                            Habitacion h = gestorHotel.buscarHabitacion(id);
                            System.out.println("Habitacion encontrada: " + h);

                            System.out.println("Ingrese la nueva capacidad:");
                            int capacidad = leer.nextInt();
                            leer.nextLine();

                            if (capacidad <= 0) {
                                throw new Datos_Invalidos_Exeption("La capacidad debe ser mayor a 0");
                            }

                            h.setCapacidadOcupantes(capacidad);
                            h.setTipoHabitacion(pedirTipo());
                            h.setEstadoHabitacion(pedirEstado());

                            gestorHotel.actualizarHabitacion(h.getId(), h);

                            System.out.println("Habitacion actualizada con exito");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("La habitacion no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del menu de habitaciones");
                        break;

                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero entero");
                leer.nextLine();
            }

        } while (op != 0);
    }

    private Tipo_Habitacion pedirTipo() throws Datos_Invalidos_Exeption {
        System.out.println("Tipo de habitacion:");
        System.out.println("1. Simple");
        System.out.println("2. Presidencial");
        System.out.println("3. Suite");

        int opcion = leer.nextInt();
        leer.nextLine();

        switch (opcion) {
            case 1: return Tipo_Habitacion.simple;
            case 2: return Tipo_Habitacion.presidencial;
            case 3: return Tipo_Habitacion.suite;
            default: throw new Datos_Invalidos_Exeption("Tipo de habitacion invalido");
        }
    }

    private EstadoHabitacion pedirEstado() throws Datos_Invalidos_Exeption {
        System.out.println("Estado de la habitacion:");
        System.out.println("1. Disponible");
        System.out.println("2. Reservada");
        System.out.println("3. En mantenimiento");

        int opcion = leer.nextInt();
        leer.nextLine();

        switch (opcion) {
            case 1: return EstadoHabitacion.DISPONIBLE;
            case 2: return EstadoHabitacion.RESERVADA;
            case 3: return EstadoHabitacion.EN_MANTENIMIENTO;
            default: throw new Datos_Invalidos_Exeption("Estado de habitacion invalido");
        }
    }
}