
package Clases;

import Clases.Hotel.Habitacion;
import Clases.Hotel.Hotel;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHabitacion {

    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuHabitacion(GestorHotel gestorHotel) {
        this.leer = new Scanner(System.in);
        this.gestorHotel = gestorHotel;
    }

    public GestorHotel getGestorHotel() {
        return gestorHotel;
    }

    public void setGestorHotel(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public void OperacionesConHabitaciones() throws Datos_Duplicados_Exeption {

        int op = -1;

        do {
            System.out.println("ingrese una opcion ");
            System.out.println("1. Agregar Habitacion");
            System.out.println("2. Listar Habitaciones");
            System.out.println("3. Eliminar Habitacion");
            System.out.println("4. Actualizar Habitacion");
            System.out.println("0. Salir");

            op = leer.nextInt();

            switch (op) {

                case 1:

                    Habitacion h = null;
                    gestorHotel.listarHoteles();

                    int numhotel = -1;
                    int capacidad;
                    Hotel hotel = null;

                    while (true) {
                        try {
                            System.out.println("ingrese el numero de hotel valido:");
                            numhotel = leer.nextInt();
                            leer.nextLine();

                            gestorHotel.existeHotel(numhotel);
                            hotel = gestorHotel.BuscarHotel(numhotel);

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("error solo datos enteros");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El hotel no existe");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("ingrese la capacidad de la habitacion: ");
                            capacidad = leer.nextInt();
                            leer.nextLine();

                            if (capacidad <= 0) {
                                throw new Datos_Invalidos_Exeption("la capacidad debe ser mayor a 0");
                            }

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("error solo datos enteros");
                            leer.nextLine();

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    int opciontipo = 0;

                    while (opciontipo != 1 && opciontipo != 2 && opciontipo != 3) {
                        try {
                            System.out.println("tipo de habitacion seleccione una de las siguientes : ");
                            System.out.println("1 Simple");
                            System.out.println("2 Presidencial");
                            System.out.println("3 Suite");

                            opciontipo = leer.nextInt();

                            if (opciontipo != 1 && opciontipo != 2 && opciontipo != 3) {
                                System.out.println("ingrese una opcion valida");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("error solo datos enteros");
                            leer.nextLine();
                        }
                    }

                    Tipo_Habitacion tipo = null;

                    switch (opciontipo) {
                        case 1:
                            tipo = Tipo_Habitacion.simple;
                            break;

                        case 2:
                            tipo = Tipo_Habitacion.presidencial;
                            break;

                        case 3:
                            tipo = Tipo_Habitacion.suite;
                            break;
                    }

                    int opcionEstado = 0;

                    while (opcionEstado != 1 && opcionEstado != 2 && opcionEstado != 3) {
                        try {
                            System.out.println("Seleccione el nuevo estado de la habitación:");
                            System.out.println("1 - Disponible");
                            System.out.println("2 - Reservada");
                            System.out.println("3 - En mantenimiento");

                            opcionEstado = leer.nextInt();
                            leer.nextLine();

                            if (opcionEstado != 1 && opcionEstado != 2 && opcionEstado != 3) {
                                System.out.println("Ingrese una opción válida.");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Error: solo se permiten números enteros.");
                            leer.nextLine();
                        }
                    }

                    EstadoHabitacion estado = null;

                    switch (opcionEstado) {
                        case 1:
                            estado = EstadoHabitacion.DISPONIBLE;
                            break;

                        case 2:
                            estado = EstadoHabitacion.RESERVADA;
                            break;

                        case 3:
                            estado = EstadoHabitacion.EN_MANTENIMIENTO;
                            break;
                    }

                    gestorHotel.agregarHabitacion(new Habitacion(capacidad, estado, hotel, tipo));

                    break;

                case 2:

                    gestorHotel.mostrarHabitaciones();
                    break;

                case 3:

                    while (true) {
                        try {
                            gestorHotel.mostrarHabitaciones();
                            System.out.println("ingrese un numero de habitacion a eliminar:");

                            int nroHabitacion = leer.nextInt();
                            leer.nextLine();

                            if (nroHabitacion <= 0) {
                                throw new Datos_Invalidos_Exeption("el id debe ser mayor a 0");
                            }

                            gestorHotel.eliminarHabitacion(nroHabitacion);
                            System.out.println("habitacion eliminada con exito");

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("error solo datos enteros");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("error la habitacion no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 4:

                    while (true) {
                        try {
                            gestorHotel.mostrarHabitaciones();
                            System.out.println("Ingrese un ID para actualizar:");

                            int buscado = leer.nextInt();
                            leer.nextLine();

                            int nuevacapacidad;

                            if (buscado <= 0) {
                                throw new Datos_Invalidos_Exeption("El ID debe ser mayor a 0");
                            }

                            Habitacion h1 = gestorHotel.buscarHabitacion(buscado);
                            System.out.println(h1.toString());

                            if (gestorHotel.existeHabitacion(h1.getId())) {

                                while (true) {
                                    try {
                                        System.out.println("Ingrese la capacidad de la habitación:");
                                        nuevacapacidad = leer.nextInt();
                                        leer.nextLine();

                                        if (nuevacapacidad <= 0) {
                                            throw new Datos_Invalidos_Exeption("La capacidad debe ser mayor a 0");
                                        }

                                        break;

                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: solo datos enteros");
                                        leer.nextLine();

                                    } catch (Datos_Invalidos_Exeption e) {
                                        System.out.println(e.getMessage());
                                    }
                                }

                                int optipo = 0;

                                while (optipo != 1 && optipo != 2 && optipo != 3) {
                                    try {
                                        System.out.println("Tipo de habitación:");
                                        System.out.println("1 Simple");
                                        System.out.println("2 Presidencial");
                                        System.out.println("3 Suite");

                                        optipo = leer.nextInt();
                                        leer.nextLine();

                                        if (optipo != 1 && optipo != 2 && optipo != 3) {
                                            System.out.println("Ingrese una opción válida");
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: solo datos enteros");
                                        leer.nextLine();
                                    }
                                }

                                Tipo_Habitacion tipoHabitacion = null;

                                switch (optipo) {
                                    case 1:
                                        tipoHabitacion = Tipo_Habitacion.simple;
                                        break;

                                    case 2:
                                        tipoHabitacion = Tipo_Habitacion.presidencial;
                                        break;

                                    case 3:
                                        tipoHabitacion = Tipo_Habitacion.suite;
                                        break;
                                }

                                int opEreserva = 0;

                                while (opEreserva != 1 && opEreserva != 2 && opEreserva != 3) {
                                    try {
                                        System.out.println("Seleccione el nuevo estado de la habitación:");
                                        System.out.println("1 - Disponible");
                                        System.out.println("2 - Reservada");
                                        System.out.println("3 - En mantenimiento");

                                        opEreserva = leer.nextInt();
                                        leer.nextLine();

                                        if (opEreserva != 1 && opEreserva != 2 && opEreserva != 3) {
                                            System.out.println("Ingrese una opción válida.");
                                        }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Error: solo se permiten números enteros.");
                                        leer.nextLine();
                                    }
                                }

                                EstadoHabitacion estadoreserva = null;

                                switch (opEreserva) {
                                    case 1:
                                        estadoreserva = EstadoHabitacion.DISPONIBLE;
                                        break;

                                    case 2:
                                        estadoreserva = EstadoHabitacion.RESERVADA;
                                        break;

                                    case 3:
                                        estadoreserva = EstadoHabitacion.EN_MANTENIMIENTO;
                                        break;
                                }

                                h1.setCapacidadOcupantes(nuevacapacidad);
                                h1.setTipoHabitacion(tipoHabitacion);
                                h1.setEstadoHabitacion(estadoreserva);

                                gestorHotel.actualizarHabitacion(h1.getId(), h1);

                                System.out.println("Habitación actualizada con éxito");
                            }

                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Error: solo datos enteros");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("Error: la habitación no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 0:
                    System.out.println("Salir");
                    break;
            }

        } while (op != 0);
    }
}
