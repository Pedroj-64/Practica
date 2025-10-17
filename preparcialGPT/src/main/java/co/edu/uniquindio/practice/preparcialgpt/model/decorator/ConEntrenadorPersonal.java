package co.edu.uniquindio.practice.preparcialgpt.model.decorator;

import co.edu.uniquindio.practice.preparcialgpt.model.Reserva;

/**
 * Decorador para agregar entrenador personal a la reserva
 */
public class ConEntrenadorPersonal extends ReservaDecorator {
    
    private static final double COSTO_ENTRENADOR_PERSONAL = 50000;
    private int duracionMinutos;
    private String nombreEntrenador;
    
    public ConEntrenadorPersonal(Reserva reservaDecorada) {
        this(reservaDecorada, 60, "Entrenador asignado");
    }
    
    public ConEntrenadorPersonal(Reserva reservaDecorada, int duracionMinutos, String nombreEntrenador) {
        super(reservaDecorada);
        this.duracionMinutos = Math.max(30, duracionMinutos);
        this.nombreEntrenador = nombreEntrenador != null && !nombreEntrenador.isEmpty() 
                              ? nombreEntrenador : "Entrenador asignado";
    }

    @Override
    public String getDescripcion() {
        return reservaDecorada.getDescripcion() + 
               "\n+ Entrenador Personal: " + nombreEntrenador + 
               " (" + duracionMinutos + " min)";
    }

    @Override
    public double getCosto() {
        // El costo base es por una hora, se ajusta según la duración
        double factorTiempo = duracionMinutos / 60.0;
        return reservaDecorada.getCosto() + (COSTO_ENTRENADOR_PERSONAL * factorTiempo);
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public String getNombreEntrenador() {
        return nombreEntrenador;
    }
}