package co.edu.uniquindio.practice.preparcialgpt.model.composite;

/**
 * Representa un servicio de spa dentro del centro deportivo
 */
public class Spa extends ServicioBase {
    
    private String tipo;
    private int duracionMinutos;
    private boolean incluyeProductos;
    
    public Spa(String nombre, String descripcion, double precioBase, 
              String tipo, int duracionMinutos, boolean incluyeProductos) {
        super(nombre, descripcion, precioBase);
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.incluyeProductos = incluyeProductos;
    }
    
    public Spa(String nombre, String descripcion, double precioBase, 
              String tipo, int duracionMinutos, boolean incluyeProductos,
              String... etiquetas) {
        super(nombre, descripcion, precioBase, etiquetas);
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.incluyeProductos = incluyeProductos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public boolean isIncluyeProductos() {
        return incluyeProductos;
    }

    public void setIncluyeProductos(boolean incluyeProductos) {
        this.incluyeProductos = incluyeProductos;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + 
               "\nTipo: " + tipo + 
               "\nDuración: " + duracionMinutos + " minutos" +
               "\nIncluye productos: " + (incluyeProductos ? "Sí" : "No");
    }
}