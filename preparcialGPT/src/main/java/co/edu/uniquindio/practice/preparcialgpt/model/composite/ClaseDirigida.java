package co.edu.uniquindio.practice.preparcialgpt.model.composite;

/**
 * Representa una clase dirigida, como Spinning, Yoga, etc.
 */
public class ClaseDirigida extends ServicioBase {
    
    private String instructor;
    private int duracionMinutos;
    private int capacidadMaxima;
    
    public ClaseDirigida(String nombre, String descripcion, double precioBase, 
                          String instructor, int duracionMinutos, int capacidadMaxima) {
        super(nombre, descripcion, precioBase);
        this.instructor = instructor;
        this.duracionMinutos = duracionMinutos;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public ClaseDirigida(String nombre, String descripcion, double precioBase, 
                          String instructor, int duracionMinutos, int capacidadMaxima,
                          String... etiquetas) {
        super(nombre, descripcion, precioBase, etiquetas);
        this.instructor = instructor;
        this.duracionMinutos = duracionMinutos;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + 
               "\nInstructor: " + instructor + 
               "\nDuración: " + duracionMinutos + " minutos" +
               "\nCapacidad máxima: " + capacidadMaxima + " personas";
    }
}