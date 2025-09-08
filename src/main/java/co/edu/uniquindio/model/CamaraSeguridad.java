package co.edu.uniquindio.model;

public class CamaraSeguridad extends Device implements Cloneable {

    private boolean visionNocturna;

    private CamaraSeguridad(Builder builder) {
        super(builder.brand, builder.nombre);
        this.visionNocturna = builder.visionNocturna;
    }

    public void setVisionNocturna(boolean vision) {
        this.visionNocturna = vision;
    }

    public boolean getVisionNocturna() {
        return visionNocturna;
    }

    @Override
    public CamaraSeguridad clone() throws CloneNotSupportedException{
        return (CamaraSeguridad)super.clone();
    }

    public static class Builder {
        private boolean visionNocturna;
        private String nombre, brand;

        public Builder visionNocturna(boolean visionNocturna) {
            this.visionNocturna = visionNocturna;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public CamaraSeguridad build(){
            return new CamaraSeguridad(this);
        }

    }

    public String toString() {
        return "CamaraSeguridad{" +
                "visionNocturna=" + visionNocturna +
                ", brand='" + getBrand() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                '}';
    }

}
