package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public final class Home {

    private List<Device> devices;
    private static Home instance;
    private String nombre;

    private Home(String nombre){
        this.nombre=nombre;
        devices=new ArrayList<>();
    }

    public static Home getInstance(String nombre){
        if(instance==null){
            instance=new Home(nombre);
            return instance;
        }else{
            return instance;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public List<Device> getDevices(){
        return devices;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void addDevice(Device device){
        devices.add(device);
    }

    public void delateDevice(Device device){
        devices.remove(device);
    }


}
