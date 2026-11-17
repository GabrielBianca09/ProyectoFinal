import Clases.Hotel.Habitacion;
import Clases.Hotel.Hotel;
import Clases.Hotel.Reservas.Reserva;
import Clases.Persona.Admin.MenuAdministrador;
import Clases.Persona.Cliente.Pasajero;
import Clases.Persona.Empleados.*;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.time.LocalDateTime;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GestorHotel gestorHotel=new GestorHotel();
        Scanner leer=new Scanner(System.in);

        try {
            MenuAdministrador menuAdministrador=new MenuAdministrador(gestorHotel);
            menuAdministrador.menuAdministrador();
        }catch (Datos_Invalidos_Exeption e){
            System.out.println("datos_invalidos");
        }

//        Hotel h1 = new Hotel("Hotel Costa Galana", "Av. Patricio Peralta Ramos 5725, Mar del Plata", "2234512345");
//        Hotel h2 = new Hotel("Hotel Provincial", "Av. Patricio Peralta Ramos 2502, Mar del Plata", "2234523456");
//        Hotel h3 = new Hotel("Hotel Hermitage", "Av. Colón 1643, Mar del Plata", "2234534567");
//        Hotel h4 = new Hotel("Hotel Bristol", "Av. Pedro Luro 2252, Mar del Plata", "2234545678");
//        Hotel h5 = new Hotel("Hotel Riviera", "Belgrano 2118, Mar del Plata", "2234556789");
//        Hotel h6 = new Hotel("Hotel Las Rocas", "Av. de los Trabajadores 1800, Mar del Plata", "2234567890");
//        Hotel h7 = new Hotel("Hotel Presidente", "Corrientes 1516, Mar del Plata", "2234578901");
//        Hotel h8 = new Hotel("Hotel América", "Bolívar 2338, Mar del Plata", "2234589012");
//        try {
//            gestorHotel.agregarHotel(h1);
//            gestorHotel.agregarHotel(h2);
//            gestorHotel.agregarHotel(h3);
//            gestorHotel.agregarHotel(h4);
//            gestorHotel.agregarHotel(h5);
//            gestorHotel.agregarHotel(h6);
//            gestorHotel.agregarHotel(h7);
//            gestorHotel.agregarHotel(h8);
//        }catch (Datos_Duplicados_Exeption |Datos_Invalidos_Exeption  e){
//            System.out.println("error al agregar Hotel"+e.getMessage());
//        }
//
//
//        // Habitaciones del Hotel Costa Galana
//        Habitacion ha1 = new Habitacion(1, EstadoHabitacion.DISPONIBLE, h1, Tipo_Habitacion.simple);
//        Habitacion ha2 = new Habitacion(2, EstadoHabitacion.DISPONIBLE, h1, Tipo_Habitacion.simple);
//        Habitacion ha3 = new Habitacion(2, EstadoHabitacion.DISPONIBLE, h1, Tipo_Habitacion.suite);
//        Habitacion ha4 = new Habitacion(4, EstadoHabitacion.DISPONIBLE, h1, Tipo_Habitacion.suite);
//        Habitacion ha5 = new Habitacion(4, EstadoHabitacion.DISPONIBLE, h1, Tipo_Habitacion.presidencial);
//
//        // Habitaciones del Hotel Provincial
//        Habitacion ha6 = new Habitacion(1, EstadoHabitacion.DISPONIBLE, h2, Tipo_Habitacion.simple);
//        Habitacion ha7 = new Habitacion(2, EstadoHabitacion.DISPONIBLE, h2, Tipo_Habitacion.simple);
//        Habitacion ha8 = new Habitacion(3, EstadoHabitacion.DISPONIBLE, h2, Tipo_Habitacion.suite);
//        Habitacion ha9 = new Habitacion(4, EstadoHabitacion.DISPONIBLE, h2, Tipo_Habitacion.presidencial);
//
//        // Habitaciones del Hotel Hermitage
//        Habitacion ha10 = new Habitacion(1, EstadoHabitacion.DISPONIBLE, h3, Tipo_Habitacion.presidencial);
//        Habitacion ha11 = new Habitacion(2, EstadoHabitacion.DISPONIBLE, h3, Tipo_Habitacion.suite);
//        Habitacion ha12 = new Habitacion(4, EstadoHabitacion.DISPONIBLE, h3, Tipo_Habitacion.presidencial);
//        try {
//            gestorHotel.agregarHabitacion(ha1);
//            gestorHotel.agregarHabitacion(ha2);
//            gestorHotel.agregarHabitacion(ha3);
//            gestorHotel.agregarHabitacion(ha4);
//            gestorHotel.agregarHabitacion(ha5);
//            gestorHotel.agregarHabitacion(ha6);
//            gestorHotel.agregarHabitacion(ha7);
//            gestorHotel.agregarHabitacion(ha8);
//            gestorHotel.agregarHabitacion(ha9);
//            gestorHotel.agregarHabitacion(ha10);
//            gestorHotel.agregarHabitacion(ha11);
//            gestorHotel.agregarHabitacion(ha12);
//        }catch (Datos_Duplicados_Exeption |Datos_Invalidos_Exeption e){
//            System.out.println("error al agregar habitacion");
//        }
//
//        //Clientes
//        Pasajero p1 = new Pasajero("Juan", "Perez", "35123456",
//                "juan@gmail.com", "2235123456", "Mar del Plata");
//
//        Pasajero p2 = new Pasajero("Maria", "Gonzalez", "38234567",
//                "maria@gmail.com", "2235234567", "Buenos Aires");
//
//        Pasajero p3 = new Pasajero("Carlos", "Rodriguez", "30456789",
//                "carlos@gmail.com", "2235345678", "Cordoba");
//
//        Pasajero p4 = new Pasajero("Lucia", "Fernandez", "41678901",
//                "lucia@gmail.com", "2235456789", "Rosario");
//
//        Pasajero p5 = new Pasajero("Martin", "Lopez", "33789123",
//                "martin@gmail.com", "2235567890", "Mendoza");
//
//        Pasajero p6 = new Pasajero("Sofia", "Martinez", "42901234",
//                "sofia@gmail.com", "2235678901", "La Plata");
//
//        Pasajero p7 = new Pasajero("Diego", "Sanchez", "29876543",
//                "diego@gmail.com", "2235789012", "Tandil");
//
//        Pasajero p8 = new Pasajero("Valentina", "Romero", "40567890",
//                "valentina@gmail.com", "2235890123", "Santa Fe");
//
//        Pasajero p9 = new Pasajero("Facundo", "Torres", "36789012",
//                "facundo@gmail.com", "2235901234", "Neuquen");
//
//        Pasajero p10 = new Pasajero("Camila", "Diaz", "43890123",
//                "camila@gmail.com", "2235012345", "Mar del Plata");
//
//        try {
//            gestorHotel.agregarCliente(p1);
//            gestorHotel.agregarCliente(p2);
//            gestorHotel.agregarCliente(p3);
//            gestorHotel.agregarCliente(p4);
//            gestorHotel.agregarCliente(p5);
//            gestorHotel.agregarCliente(p6);
//            gestorHotel.agregarCliente(p7);
//            gestorHotel.agregarCliente(p8);
//            gestorHotel.agregarCliente(p9);
//            gestorHotel.agregarCliente(p10);
//        }catch (Datos_Duplicados_Exeption |Datos_Invalidos_Exeption  e){
//            System.out.println("error al agregar cliente");
//        }
//
//
//        //Empleados
//        Empleado e1 = new Cocinero("Roberto", "Gomez", "25123456",
//                "roberto@gmail.com", "2234111111", 160, "Mar del Plata", 4500);
//
//        Empleado e2 = new Conserje("Laura", "Fernandez", "30234567",
//                "laura@gmail.com", "2234222222", 180, "Miramar", 5000);
//
//        Empleado e3 = new Mozos("Fernando", "Lopez", "28456789",
//                "fernando@gmail.com", "2234333333", 150, "Batan", 4200);
//
//        Empleado e4 = new cadete("Carolina", "Martinez", "32678901",
//                "carolina@gmail.com", "2234444444", 170, "Mar del Plata", 4800);
//
//        Empleado e5 = new Cocinero("Diego", "Rodriguez", "26789123",
//                "diego@gmail.com", "2234555555", 160, "Santa Clara del Mar", 4600);
//
//        Empleado e6 = new Mozos("Gabriela", "Sanchez", "34890123",
//                "gabriela@gmail.com", "2234666666", 190, "Mar del Plata", 5200);
//
//        Empleado e7 = new Conserje("Pablo", "Torres", "29123456",
//                "pablo@gmail.com", "2234777777", 140, "Necochea", 4000);
//
//        Empleado e8 = new cadete("Natalia", "Romero", "36567890",
//                "natalia@gmail.com", "2234888888", 175, "Mar del Plata", 4900);
//
//        try {
//            gestorHotel.agregarEmpleado(e1);
//            gestorHotel.agregarEmpleado(e2);
//            gestorHotel.agregarEmpleado(e3);
//            gestorHotel.agregarEmpleado(e4);
//            gestorHotel.agregarEmpleado(e5);
//            gestorHotel.agregarEmpleado(e6);
//            gestorHotel.agregarEmpleado(e7);
//            gestorHotel.agregarEmpleado(e8);
//        }catch (Datos_Duplicados_Exeption |Datos_Invalidos_Exeption e){
//            System.out.println("error al agregar empleados");
//        }
//
//
//
//        //reservas
//        Reserva r1 = new Reserva(LocalDateTime.of(2026, 11, 20, 14, 0), p1);
//
//        Reserva r2 = new Reserva(LocalDateTime.of(2026, 11, 21, 15, 0), p2);
//
//        Reserva r3 = new Reserva(LocalDateTime.of(2026, 11, 22, 12, 0), p3);
//
//        Reserva r4 = new Reserva(LocalDateTime.of(2026, 11, 23, 16, 0), p4);
//
//        Reserva r5 = new Reserva(LocalDateTime.of(2026, 11, 24, 14, 30), p5);
//
//        Reserva r6 = new Reserva(LocalDateTime.of(2026, 11, 25, 13, 0), p6);
//
//        Reserva r7 = new Reserva(LocalDateTime.of(2026, 11, 26, 15, 30), p7);
//
//        Reserva r8 = new Reserva(LocalDateTime.of(2026, 11, 27, 14, 0), p8);
//
//        Reserva r9 = new Reserva(LocalDateTime.of(2026, 11, 28, 12, 30), p9);
//
//        Reserva r10 = new Reserva(LocalDateTime.of(2026, 11, 29, 16, 0), p10);
//
//
//        try {
//            gestorHotel.agregarReserva(r1);
//            gestorHotel.agregarReserva(r2);
//            gestorHotel.agregarReserva(r3);
//            gestorHotel.agregarReserva(r4);
//            gestorHotel.agregarReserva(r5);
//            gestorHotel.agregarReserva(r6);
//            gestorHotel.agregarReserva(r7);
//            gestorHotel.agregarReserva(r8);
//            gestorHotel.agregarReserva(r9);
//            gestorHotel.agregarReserva(r10);
//        }catch (Datos_Duplicados_Exeption e){
//            System.out.println("eror al agregar reservas"+ e.getMessage());
//        }
//
//        gestorHotel.mostrarHabitaciones();
//        gestorHotel.mostrarReservas();
//        gestorHotel.mostrarEmpleados();
//        gestorHotel.mostrarhuespedes();





    }



}


