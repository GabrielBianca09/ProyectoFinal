import Clases.Hotel.Habitacion;
import Clases.Hotel.Hotel;
import Clases.Hotel.Servicios.EmpleadoServicio;
import Clases.Hotel.Servicios.Servicio;
import Clases.Persona.Empleados.Empleado;
import Clases.Persona.Empleados.Mozos;
import Enums.EstadoHabitacion;
import Enums.Tipo_Habitacion;
import Enums.Tipo_de_Trabajo;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.Gestor;
import gestores.GestorHotel;

import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args) {

        Hotel h1=new Hotel("Hotel Costa Galana", "Av. Peralta Ramos 5725","Mar del Plata");
        Habitacion habitacion1=new Habitacion(5, EstadoHabitacion.DISPONIBLE,h1, Tipo_Habitacion.presidencial);
        Habitacion habitacion2=new Habitacion(8, EstadoHabitacion.DISPONIBLE,h1, Tipo_Habitacion.simple);
        Habitacion habitacion3=new Habitacion(4, EstadoHabitacion.DISPONIBLE,h1, Tipo_Habitacion.suite);

        GestorHotel gestorHotel=new GestorHotel();
        try {
            gestorHotel.agregarHabitacion(habitacion1);
            gestorHotel.agregarHabitacion(habitacion2);
            gestorHotel.agregarHabitacion(habitacion3);
            gestorHotel.mostrarHabitaciones();
        }catch (Datos_Invalidos_Exeption e){
            System.out.println("no se aceptan datos nulos");
        }catch (Datos_Duplicados_Exeption e){
            System.out.println(e.getMessage());
        }


        try {
            Empleado e=new Mozos("pepe","grillo","43434","pepe@gmail","2234",5,"la calle",50);
            EmpleadoServicio es=new EmpleadoServicio(e,15);
            Servicio  s=new Servicio(500,"cena", Tipo_de_Trabajo.ATENCION);
            s.Agregar1EmpleadoServicio(es);
            s.mostrarEmpleadosxServicio();
            gestorHotel.agregarServicio(s);
            System.out.println(gestorHotel.calcularSueldo(e));
            gestorHotel.mostrarServicios();


        }catch (Datos_Invalidos_Exeption| Datos_Duplicados_Exeption e){
            System.out.println("error");
        }
        
    }
}
