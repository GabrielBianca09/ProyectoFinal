package Clases;

import Clases.Persona.Cliente.Pasajero;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCliente {
    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuCliente(GestorHotel gestorHotel) {
        this.leer = new Scanner(System.in);
        this.gestorHotel = gestorHotel;
    }



    public void OperacionesConPasajeros() {

        int op = -1;

        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1. Agregar CLIENTE");
            System.out.println("2. Listar CLIENTE");
            System.out.println("3. Buscar CLIENTE");
            System.out.println("4. Eliminar CLIENTE");
            System.out.println("5. Actualizar CLIENTE");
            System.out.println("0. Salir");

            try {
                op = leer.nextInt();
                leer.nextLine();

                switch (op) {

                    case 1:
                        try {
                            System.out.println("Ingrese nombre:");
                            String nombre = leer.nextLine();

                            System.out.println("Ingrese apellido:");
                            String apellido = leer.nextLine();

                            System.out.println("Ingrese DNI:");
                            String dni = leer.nextLine();

                            System.out.println("Ingrese email:");
                            String email = leer.nextLine();

                            System.out.println("Ingrese numero de celular:");
                            String numeroCelular = leer.nextLine();



                            Pasajero p = new (nombre,apellido,dni,email,numeroCelular);

                            gestorHotel.agregarCliente(p);

                            System.out.println("Pasajero agregado correctamente");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Duplicados_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        for (Pasajero p : gestorHotel.getHuespedes().getLista()) {
                            System.out.println(p);
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("Ingrese el ID del pasajero:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            Pasajero buscado = gestorHotel.buscarCliente(id);

                            System.out.println(buscado);

                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese un numero entero");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El pasajero no existe");
                        }
                        break;

                    case 4:
                        try {
                            System.out.println("Ingrese el ID del pasajero a eliminar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            if (id <= 0) {
                                throw new Datos_Invalidos_Exeption("El ID debe ser mayor a 0");
                            }

                            gestorHotel.eliminarHuesped(id);

                            System.out.println("Pasajero eliminado correctamente");

                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese un numero entero");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El pasajero no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            System.out.println("Ingrese el ID del pasajero a actualizar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            if (id <= 0) {
                                throw new Datos_Invalidos_Exeption("El ID debe ser mayor a 0");
                            }

                            Pasajero p = gestorHotel.buscarCliente(id);

                            System.out.println(p);

                            System.out.println("Ingrese nuevo nombre:");
                            String nombre = leer.nextLine();

                            System.out.println("Ingrese nuevo apellido:");
                            String apellido = leer.nextLine();

                            System.out.println("Ingrese nuevo DNI:");
                            String dni = leer.nextLine();

                            System.out.println("Ingrese nueva direccion de origen:");
                            String direccionOrigen = leer.nextLine();

                            System.out.println("ingrese nuervo mail");
                            String mail = leer.nextLine();
                            System.out.println("ingrese el nuevo telefono");
                            String telefono = leer.nextLine();
                            p.setNumeroCelular(telefono);
                            p.setEmail(mail);
                            p.setNombre(nombre);
                            p.setApellido(apellido);
                            p.setDni(dni);
                            p.setDireccionOrigen(direccionOrigen);

                            gestorHotel.actualizarCliente(id, p);

                            System.out.println("Pasajero actualizado correctamente");

                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese un numero entero");
                            leer.nextLine();

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println("El pasajero no existe");

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del menu de pasajeros");
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
}
