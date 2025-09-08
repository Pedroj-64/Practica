package co.edu.uniquindio.model;

public class Termostato extends Device {

    private String temperaturaPunta;

    private Termostato(Builder builder){
        super(builder.brand,builder.nombre);
        this.temperaturaPunta=builder.temperaturaPunta;

    }

    public void setTemperaturaPunta(String temperatura){
        this.temperaturaPunta=temperatura;
    }

    public String getTemperaturaPunta(){
        return temperaturaPunta;
    }

    public static class Builder{
        private String temperaturaPunta,brand,nombre;

        public Builder temperatura(String temperatura){
            this.temperaturaPunta=temperatura;
            return this;
        }

        public Builder brand(String brand){
            this.brand=brand;
            return this;
        }

        public Builder nombre(String nombre){
            this.nombre=nombre;
            return this;
        }

        public Termostato build(){
            return new Termostato(this);
        }
    }

}
