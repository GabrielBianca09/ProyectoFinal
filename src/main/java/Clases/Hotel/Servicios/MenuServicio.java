package Clases.Hotel.Servicios;

import Clases.Persona.Empleados.Empleado;
import Enums.Tipo_de_Trabajo;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import Exepciones.OperacionInvalida;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuServicio {
    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuServicio(GestorHotel gestorHotel) {
        this.gestorHotel =gestorHotel;
        leer = new Scanner(System.in);
    }

    public void operacionesConServicios() {

        int op = -1;

        do {
            System.out.println("\n--- MENU Servicio ---");
            System.out.println("1. Agregar Servicio");
            System.out.println("2. Listar Servicios");
            System.out.println("3. Eliminar Servicio");
            System.out.println("4. Actualizar Servicio");
            System.out.println("5. Agregar Empleado a un Servicio");
            System.out.println("6. Quitar Empleado de un Servicio");
            System.out.println("7. Listar Empleados de un Servicio");
            System.out.println("0. Salir");

            try {
                op = leer.nextInt();
                leer.nextLine();

                switch (op) {

                    case 1:
                        try {
                            System.out.println("Ingrese el nombre del servicio:");
                            String nombre = leer.nextLine();

                            if (nombre.isBlank()) {
                                throw new Datos_Invalidos_Exeption("El nombre no puede estar vacio");
                            }

                            System.out.println("Ingrese el precio:");
                            double precio = leer.nextDouble();
                            leer.nextLine();

                            if (precio <= 0) {
                                throw new Datos_Invalidos_Exeption("El precio debe ser mayor a 0");
                            }

                            Tipo_de_Trabajo tipo = pedirTipoTrabajo();

                            gestorHotel.agregarServicio(new Servicio(precio, nombre, tipo));
                            System.out.println("Servicio agregado correctamente");

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
                        gestorHotel.mostrarServicios();
                        break;

                    case 3:
                        try {
                            gestorHotel.mostrarServicios();
                            System.out.println("Ingrese el ID del servicio a eliminar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            gestorHotel.eliminarServicio(id);
                            System.out.println("Servicio eliminado con exito");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El servicio no existe");

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 4:
                        try {
                            gestorHotel.mostrarServicios();
                            System.out.println("Ingrese el ID del servicio a actualizar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            Servicio s = gestorHotel.buscarServicio(id);
                            System.out.println("Servicio encontrado: " + s);

                            System.out.println("Ingrese el nuevo nombre:");
                            String nombre = leer.nextLine();

                            if (nombre.isBlank()) {
                                throw new Datos_Invalidos_Exeption("El nombre no puede estar vacio");
                            }

                            System.out.println("Ingrese el nuevo precio:");
                            double precio = leer.nextDouble();
                            leer.nextLine();

                            if (precio <= 0) {
                                throw new Datos_Invalidos_Exeption("El precio debe ser mayor a 0");
                            }

                            s.setNombreServicio(nombre);
                            s.setPrecio(precio);
                            s.setTipo(pedirTipoTrabajo());

                            gestorHotel.actualizarServicio(s.getId(), s);
                            System.out.println("Servicio actualizado con exito");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El servicio no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 5:
                        try {
                            gestorHotel.mostrarServicios();
                            System.out.println("Ingrese el ID del servicio:");
                            int idServicio = leer.nextInt();
                            leer.nextLine();

                            Servicio s = gestorHotel.buscarServicio(idServicio);
                            gestorHotel.mostrarEmpleados();

                            System.out.println("Ingrese el ID del empleado:");
                            int idEmpleado = leer.nextInt();
                            leer.nextLine();

                            Empleado empleado = gestorHotel.buscarEmpleado(idEmpleado);

                            System.out.println("Ingrese el salario adicional:");
                            double adicional = leer.nextDouble();
                            leer.nextLine();

                            if (adicional < 0) {
                                throw new Datos_Invalidos_Exeption("El salario adicional no puede ser negativo");
                            }

                            s.Agregar1EmpleadoServicio(new EmpleadoServicio(empleado, adicional));
                            System.out.println("Empleado agregado al servicio");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Duplicados_Exeption e) {
                            System.out.println("El empleado ya esta en ese servicio");

                        } catch (OperacionInvalida e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 6:
                        try {
                            gestorHotel.mostrarServicios();
                            System.out.println("Ingrese el ID del servicio:");
                            int idServicio = leer.nextInt();
                            leer.nextLine();

                            Servicio s = gestorHotel.buscarServicio(idServicio);
                            s.mostrarEmpleadosxServicio();

                            System.out.println("Ingrese el ID del empleado a quitar:");
                            int idEmpleado = leer.nextInt();
                            leer.nextLine();

                            Empleado empleado = gestorHotel.buscarEmpleado(idEmpleado);

                            s.quitarEmpleado(empleado);
                            System.out.println("Empleado quitado del servicio");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 7:
                        try {
                            gestorHotel.mostrarServicios();
                            System.out.println("Ingrese el ID del servicio:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            gestorHotel.buscarServicio(id).mostrarEmpleadosxServicio();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El servicio no existe");

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del menu de servicios");
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

    private Tipo_de_Trabajo pedirTipoTrabajo() throws Datos_Invalidos_Exeption {
        System.out.println("Tipo de trabajo del servicio:");
        System.out.println("1. Limpieza");
        System.out.println("2. Mantenimiento");
        System.out.println("3. Cocina");
        System.out.println("4. Equipaje");
        System.out.println("5. Estacionamiento");
        System.out.println("6. Reservas");
        System.out.println("7. Entretenimiento");
        System.out.println("8. Atencion");

        int opcion = leer.nextInt();
        leer.nextLine();

        switch (opcion) {
            case 1:
                return Tipo_de_Trabajo.LIMPIEZA;
            case 2:
                return Tipo_de_Trabajo.MANTENIMIENTO;
            case 3:
                return Tipo_de_Trabajo.COCINA;
            case 4:
                return Tipo_de_Trabajo.EQUIPAJE;
            case 5:
                return Tipo_de_Trabajo.ESTACIONAMIENTO;
            case 6:
                return Tipo_de_Trabajo.RESERVAS;
            case 7:
                return Tipo_de_Trabajo.ENTRETENIMIENTO;
            case 8:
                return Tipo_de_Trabajo.ATENCION;
            default:
                throw new Datos_Invalidos_Exeption("Tipo de trabajo invalido");
        }
    }


}
