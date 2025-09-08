package co.edu.uniquindio.model;

public abstract class Device {

    private String brand,nombre;

    public Device(String brand,String nombre){
        this.brand=brand;
        this.nombre=nombre;
    }

    public String getBrand(){
        return brand;
    }

    public String getNombre(){
        return nombre;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

}
