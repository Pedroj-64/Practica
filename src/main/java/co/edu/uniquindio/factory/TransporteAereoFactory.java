package co.edu.uniquindio.factory;

/**
 * Fábrica concreta que crea transportes aéreos.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteAereoFactory implements TransporteFactory {
    
    private final String tipo;
    private final double velocidadPromedio;
    private final double costoPorKm;
    private final boolean esInternacional;
    
    /**
     * Constructor para TransporteAereoFactory.
     * 
     * @param tipo El tipo específico de transporte aéreo (ej: avión de carga, avioneta)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     * @param esInternacional Indica si el transporte es para envíos internacionales
     */
    public TransporteAereoFactory(String tipo, double velocidadPromedio, double costoPorKm, boolean esInternacional) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
        this.esInternacional = esInternacional;
    }
    
    /**
     * Constructor simple que usa valores predeterminados para avión de carga.
     * 
     * @param esInternacional Indica si el transporte es para envíos internacionales
     */
    public TransporteAereoFactory(boolean esInternacional) {
        this("Avión de carga", 800.0, 5000.0, esInternacional);
    }
    
    @Override
    public Transporte crearTransporte() {
        return new TransporteAereo(tipo, velocidadPromedio, costoPorKm, esInternacional);
    }
    
    @Override
    public String getDescripcion() {
        String tipoEnvio = esInternacional ? "internacional" : "nacional";
        return "Fábrica de transporte aéreo " + tipoEnvio + " - Tipo: " + tipo;
    }
}