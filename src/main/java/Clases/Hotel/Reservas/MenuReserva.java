package Clases;

import Exepciones.Datos_Invalidos_Exeption;
import gestores.GestorHotel;

import java.util.Scanner;

public class MenuReserva {
    private Scanner sc;
    private GestorHotel gestorHotel;

    public MenuReserva(GestorHotel gestorHotel) {
        this.gestorHotel = gestorHotel;
        sc = new Scanner(System.in);
    }

    public void menusReservas() throws Datos_Invalidos_Exeption {}
}
