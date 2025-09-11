package co.edu.uniquindio;

import co.edu.uniquindio.model.CamaraSeguridad;
import co.edu.uniquindio.model.factory.DeviceFactory;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        /**
         * -----------FACTORY METHOD--------------
         */

        CamaraSeguridad camarita= (CamaraSeguridad)DeviceFactory.deviceFactory("CamaraSeguridad", "Apple", "Lucecitas");
        System.out.println(camarita.toString());
        camarita.setVisionNocturna(true);
        System.out.println(camarita.toString());


        CamaraSeguridad camarita2= camarita.clone();
        System.out.println(camarita2.toString());



        String saludo= "HOLA MUNDO";
        String saludo2=saludo.toLowerCase();
        System.out.println(saludo);
        System.out.println(saludo2);


      
    }
}