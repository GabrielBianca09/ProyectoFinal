package Clases;

import Clases.Persona.Cliente.Pasajero;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPasajero {
    private Scanner sc;
    private GestorHotel gestorHotel;

    public MenuPasajero(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        this.sc =new Scanner(System.in);
    }

    public void menuPasajero(){
        int opcion=-1;
        do {
            System.out.println("ingrese una opcion");
            System.out.println("1 registrar Un cliente ");
            System.out.println("2 listar Clientes ");
            System.out.println("3 actualizar clientes");
            System.out.println("4 eliminar un cliente");
            System.out.println("5 salir");
            opcion=sc.nextInt();
            sc.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        try {
                            System.out.println("Ingrese nombre:");
                            String nombre = sc.nextLine();

                            System.out.println("Ingrese apellido:");
                            String apellido = sc.nextLine();

                            System.out.println("Ingrese DNI:");
                            String dni = sc.nextLine();

                            System.out.println("Ingrese email:");
                            String email = sc.nextLine();

                            System.out.println("Ingrese número de celular:");
                            String numeroCelular = sc.nextLine();

                            System.out.println("ingrese su direccion:");
                            String direccion = sc.nextLine();

                            Pasajero p=new Pasajero(nombre,apellido,dni,email,numeroCelular,direccion);
                            gestorHotel.agregarCliente(p);
                            System.out.println("cliente agregado exitosamente");


                        }catch (Datos_Invalidos_Exeption e){
                            System.out.println("Datos invalidos");
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println("el pasajero ya existe");
                        }

                        break;
            }

            }catch (InputMismatchException e){
                System.out.println("error no ingresaste un entero");
            }

        }while (opcion!=0);
    }
}
