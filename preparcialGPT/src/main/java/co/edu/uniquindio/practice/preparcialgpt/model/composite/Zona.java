package co.edu.uniquindio.practice.preparcialgpt.model.composite;

/**
 * Representa una zona de musculación dentro del centro deportivo
 */
public class Zona extends ServicioBase {
    
    private String ubicacion;
    private int aforoMaximo;
    private boolean requiereInduccion;
    
    public Zona(String nombre, String descripcion, double precioBase, 
               String ubicacion, int aforoMaximo, boolean requiereInduccion) {
        super(nombre, descripcion, precioBase);
        this.ubicacion = ubicacion;
        this.aforoMaximo = aforoMaximo;
        this.requiereInduccion = requiereInduccion;
    }
    
    public Zona(String nombre, String descripcion, double precioBase, 
               String ubicacion, int aforoMaximo, boolean requiereInduccion,
               String... etiquetas) {
        super(nombre, descripcion, precioBase, etiquetas);
        this.ubicacion = ubicacion;
        this.aforoMaximo = aforoMaximo;
        this.requiereInduccion = requiereInduccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public boolean isRequiereInduccion() {
        return requiereInduccion;
    }

    public void setRequiereInduccion(boolean requiereInduccion) {
        this.requiereInduccion = requiereInduccion;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + 
               "\nUbicación: " + ubicacion + 
               "\nAforo máximo: " + aforoMaximo + " personas" +
               "\nRequiere inducción: " + (requiereInduccion ? "Sí" : "No");
    }
}