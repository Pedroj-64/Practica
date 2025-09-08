package co.edu.uniquindio.model.factory;

import co.edu.uniquindio.model.CamaraSeguridad;
import co.edu.uniquindio.model.Device;
import co.edu.uniquindio.model.Luces;
import co.edu.uniquindio.model.Termostato;

public class DeviceFactory {

    public static Device deviceFactory(String tipo,String brand,String nombre){

        Device device = switch(tipo.toLowerCase()){
            case "luces" -> new Luces.Builder().brand(brand).nombre(nombre).build();
            case "termostato" -> new Termostato.Builder().brand(brand).nombre(nombre).build();
            case "camaraseguridad" -> new CamaraSeguridad.Builder().brand(brand).nombre(nombre).build();
            default -> throw new IllegalArgumentException("objeto no soportado = " + tipo);
        };

        return device;
       
    }

}
