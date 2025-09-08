package co.edu.uniquindio.model;

public class Luces extends Device {
    private int intensidad;

    private Luces(Builder builder){
        super(builder.brand,builder.nombre);
        this.intensidad=builder.intensidad;
    
    }

    public int getIntensidad(){
        return intensidad;
    }

    public void setIntensidad(int intensidad){
        this.intensidad=intensidad;
    }

    public static class Builder{
        private String brand,nombre;
        private int intensidad;

        public Builder brand(String brand){
            this.brand=brand;
            return this;
        }

        public Builder nombre(String nombre){
            this.nombre=nombre;
            return this;
        }

        public Builder intensidad(int intensidad){
            this.intensidad=intensidad;
            return this;    
        }

        public Luces build(){
            return new Luces(this); 
        }
    }
}
