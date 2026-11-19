import Menu.MenuAdministrador;
import Clases.Persona.Empleados.*;
import Exepciones.Datos_Invalidos_Exeption;
import Gestores.GestorHotel;
import Menu.MenuConserje;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GestorHotel gestorHotel=new GestorHotel();
        Scanner leer =new Scanner(System.in);


        try {
            MenuAdministrador menuAdministrador=new MenuAdministrador(gestorHotel);
            menuAdministrador.menuAdministrador();
        }catch (Datos_Invalidos_Exeption e){
            System.out.println("datos_invalidos");
        }


        try {
            MenuConserje r=new MenuConserje(gestorHotel,new Conserje("pepe","grillo","4343345","rereara","2332",5,"loma",500));
            r.menuResepcicionista();
        }catch (Datos_Invalidos_Exeption e){
            System.out.println("datos_invalidos");
        }

    }

}


