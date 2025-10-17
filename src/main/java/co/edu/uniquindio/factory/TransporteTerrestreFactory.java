package co.edu.uniquindio.factory;

/**
 * Fábrica concreta que crea transportes terrestres.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteTerrestreFactory implements TransporteFactory {
    
    private final String tipo;
    private final double velocidadPromedio;
    private final double costoPorKm;
    
    /**
     * Constructor para TransporteTerrestreFactory.
     * 
     * @param tipo El tipo específico de transporte terrestre (ej: camión, motocicleta)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     */
    public TransporteTerrestreFactory(String tipo, double velocidadPromedio, double costoPorKm) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
    }
    
    /**
     * Constructor simple que usa valores predeterminados para camión.
     */
    public TransporteTerrestreFactory() {
        this("Camión", 60.0, 1000.0);
    }
    
    @Override
    public Transporte crearTransporte() {
        return new TransporteTerrestre(tipo, velocidadPromedio, costoPorKm);
    }
    
    @Override
    public String getDescripcion() {
        return "Fábrica de transporte terrestre - Tipo: " + tipo;
    }
}