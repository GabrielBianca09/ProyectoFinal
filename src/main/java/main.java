import Clases.Persona.Admin.MenuAdministrador;
import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

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


    }



}


