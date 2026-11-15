
package Clases.Persona.Empleados;

import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEmpleado {

    private Scanner leer;
    private GestorHotel gestorHotel;

    public MenuEmpleado(GestorHotel gestorHotel) {
        this.leer = new Scanner(System.in);
        this.gestorHotel = gestorHotel;
    }


    public void OperacionesEmpleados() {

        int op = -1;

        do {
            System.out.println("\n--- MENU Empleado ---");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Listar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Actualizar Empleado");
            System.out.println("0. Salir");

            try {
                op = leer.nextInt();
                leer.nextLine();

                switch (op) {

                    case 1:
                        try {
                            System.out.println("Seleccione el tipo de empleado:");
                            System.out.println("1. Artista");
                            System.out.println("2. Cocinero");
                            System.out.println("3. Conserje");
                            System.out.println("4. Recepcionista");
                            System.out.println("5. Mozos");
                            System.out.println("6. Botones");

                            int opcion = leer.nextInt();
                            leer.nextLine();

                            if (opcion < 1 || opcion > 6) {
                                throw new Datos_Invalidos_Exeption("datos invalidos");
                            }

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

                            System.out.println("Ingrese el salario base:");
                            double salario = leer.nextDouble();
                            leer.nextLine();

                            System.out.println("Ingrese cantidad de horas:");
                            int horas = leer.nextInt();
                            leer.nextLine();


                            Empleado empleado = null;

                            switch (opcion) {
                                case 1:
                                    empleado = new Artista(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                                case 2:
                                    empleado = new Cocinero(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                                case 3:
                                    empleado = new Conserje(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                                case 4:
                                    empleado = new Recepcionista(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                                case 5:
                                    empleado = new Mozos(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                                case 6:
                                    empleado = new Cadete(nombre, apellido, dni, email, celular, horas, direccion, salario);
                                    break;
                            }

                            gestorHotel.agregarEmpleado(empleado);

                            System.out.println("Empleado agregado correctamente");

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
                        try {
                            System.out.println("Ingrese el ID del empleado que desea actualizar:");
                            int id = leer.nextInt();
                            leer.nextLine();

                            Empleado empleado = gestorHotel.buscarEmpleado(id);
                            System.out.println("Empleado encontrado: " + empleado.getNombre());

                            System.out.println("Ingrese el nuevo nombre:");
                            String nombre = leer.nextLine();

                            System.out.println("Ingrese el nuevo apellido:");
                            String apellido = leer.nextLine();

                            System.out.println("Ingrese el nuevo DNI:");
                            String dni = leer.nextLine();

                            System.out.println("Ingrese el nuevo email:");
                            String email = leer.nextLine();

                            System.out.println("Ingrese el nuevo celular:");
                            String celular = leer.nextLine();

                            System.out.println("Ingrese la nueva cantidad de horas:");
                            int horas = leer.nextInt();
                            leer.nextLine();

                            System.out.println("Ingrese la nueva dirección:");
                            String direccion = leer.nextLine();

                            System.out.println("Ingrese el nuevo salario:");
                            double salario = leer.nextDouble();
                            leer.nextLine();


                            empleado.setNombre(nombre);
                            empleado.setApellido(apellido);
                            empleado.setDni(dni);
                            empleado.setEmail(email);
                            empleado.setNumeroCelular(celular);
                            empleado.setHorasTrabajadas(horas);
                            empleado.setDireccion(direccion);
                            empleado.setSalarioBase(salario);
                            gestorHotel.actualizarEmpleado(id,empleado);
                            System.out.println("Empleado actualizado correctamente");

                        } catch (Dato_No_Encontrado_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (Datos_Invalidos_Exeption e) {
                            System.out.println(e.getMessage());

                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar un valor del tipo correcto.");
                            leer.nextLine();
                        }

                        break;

                    case 0:
                        System.out.println("Saliendo del menú de empleados");
                        break;

                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero");
                leer.nextLine();
            }

        } while (op != 0);
    }
}
