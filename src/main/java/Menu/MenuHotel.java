package Clases.Hotel;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuHotel {
    private Scanner sc;
    private GestorHotel gestorHotel;

    public MenuHotel(GestorHotel gestorHotel) {
        this.gestorHotel=gestorHotel;
        this.sc=new Scanner(System.in);
    }
    //este menu es una composicion la cual tiene el gestorhotel que la clase en la cual estan todas mis funciones
//de creacion,busqueada,eliminacion,actualizacion.
//todos los menus reciben el mismo gestor previamente creador en main.
//implementa funciones de ingreso de datos y uso de exepciones.

    public void menuHotel(){
        int op=-1;
        do {
            System.out.println("\n--- MENU hotel---");
            System.out.println("1. Agregar Hotel");
            System.out.println("2. Listar Hoteles");
            System.out.println("3. Eliminar hotel");
            System.out.println("4. Actualizar Hotel");
            System.out.println("0. Salir");
            try {
                op=sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        try {
                            System.out.println("ingrese el nombre del hotel:");
                            String hotel=sc.nextLine();
                            System.out.println("ingrese la direccion del hotel:");
                            String direccion=sc.nextLine();
                            System.out.println("ingrese el numero telefono del hotel:");
                            String telefono=sc.nextLine();

                            if (hotel.isBlank() || direccion.isBlank() || telefono.isBlank()) {
                                throw new Datos_Invalidos_Exeption("Ningun dato puede estar vacio");
                            }
                            gestorHotel.agregarHotel(new Hotel(hotel,direccion,telefono));
                        }catch (Datos_Invalidos_Exeption e){
                            System.out.println("no se puede poner datos nulos");
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println("no se puede poner datos duplicados");
                        }
                        break;

                    case 2:
                        gestorHotel.listarHoteles();
                        break;

                    case 3:
                        int ophotel=-1;
                        gestorHotel.listarHoteles();
                        System.out.println("ingrese el numero de hotel a eliminar:");
                        try {
                            ophotel=sc.nextInt();
                            sc.nextLine();
                            if (ophotel <0){
                                throw new Datos_Invalidos_Exeption("el id debe ser mayor a o igual a 0");
                            }
                            gestorHotel.eliminarHotel(ophotel);
                        }catch (Dato_No_Encontrado_Exeption e){
                            System.out.println("no se encontro el hotel");
                        }catch (Datos_Invalidos_Exeption e){
                            System.out.println("los datos eran invalidos");
                        }
                        catch (InputMismatchException e){
                            System.out.println("ingrese un numero de hotel valido");
                        }
                        break;

                    case 4:
                        gestorHotel.listarHoteles();
                        System.out.println("ingrese el numero de hotel a actualizar:");
                        try {
                            ophotel=sc.nextInt();
                            if (ophotel <0){
                                throw new Datos_Invalidos_Exeption("el id debe ser mayor a o igual a 0");
                            }
                            Hotel h=gestorHotel.BuscarHotel(ophotel);
                            System.out.println("ingrese el nombre del hotel:");
                            String hotel=sc.nextLine();
                            System.out.println("ingrese la direccion del hotel:");
                            String direccion=sc.nextLine();
                            System.out.println("ingrese el numero telefono del hotel:");
                            String telefono=sc.nextLine();
                            h.setDireccionHotel(direccion);
                            h.setNombreHotel(hotel);
                            h.setNumeroContactoHotel(telefono);
                            gestorHotel.actualizarHotel(ophotel,h);
                            System.out.println("se actualizo correctamente");
                            if (hotel.isBlank() || direccion.isBlank() || telefono.isBlank()) {
                                throw new Datos_Invalidos_Exeption("Ningun dato puede estar vacio");
                            }
                        }catch (Dato_No_Encontrado_Exeption e){
                            System.out.println("no se encontro el hotel");
                        }catch (Datos_Invalidos_Exeption e){
                            System.out.println("los datos eran invalidos");
                        }catch (Datos_Duplicados_Exeption e){
                            System.out.println("los datos duplicados");
                        }
                        catch (InputMismatchException e){
                            System.out.println("ingrese un numero de hotel valido");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del menu hotel");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Error al intentar el opcion, debe ser una opcion valida");
                sc.nextLine();
            }

        }while (op!=0);
    }
}
