import Clases.Hotel.Hotel;
import Clases.Hotel.MenuHotel;
import Clases.Hotel.Servicios.EmpleadoServicio;
import Clases.Hotel.Servicios.MenuServicio;
import Clases.Hotel.Servicios.Servicio;
import Clases.Hotel.MenuHabitacion;
import Clases.Persona.Admin.MenuAdministrador;
import Clases.Persona.Empleados.Empleado;
import Clases.Persona.Empleados.MenuEmpleado;
import Clases.Persona.Empleados.Mozos;
import Enums.Tipo_de_Trabajo;
import Exepciones.Dato_No_Encontrado_Exeption;
import Exepciones.Datos_Duplicados_Exeption;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

public class main {
    public static void main(String[] args) {
        GestorHotel gestorHotel=new GestorHotel();

        try {
            MenuAdministrador menuAdministrador=new MenuAdministrador(gestorHotel);
            menuAdministrador.menuAdministrador();
        }catch (Datos_Invalidos_Exeption e){
            System.out.println("datos_invalidos");
        }
    }


}
