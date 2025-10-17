package co.edu.uniquindio.factory;

/**
 * Implementación concreta del producto Transporte para el transporte aéreo.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteAereo implements Transporte {
    
    private final String tipo;
    private final double velocidadPromedio; // km/h
    private final double costoPorKm;
    private final boolean esInternacional;
    
    /**
     * Constructor para TransporteAereo.
     * 
     * @param tipo El tipo específico de transporte aéreo (ej: avión de carga, avioneta)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     * @param esInternacional Indica si el transporte es para envíos internacionales
     */
    public TransporteAereo(String tipo, double velocidadPromedio, double costoPorKm, boolean esInternacional) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
        this.esInternacional = esInternacional;
    }
    
    @Override
    public String entregar(String paquete) {
        String tipoEnvio = esInternacional ? "internacional" : "nacional";
        return "Entregando " + paquete + " por vía aérea " + tipoEnvio + " usando " + tipo;
    }
    
    @Override
    public double calcularCosto(double distanciaKm) {
        // Base + costo variable por km + tarifa adicional para internacional
        double tarifaBase = 50000;
        double costoVariable = distanciaKm * costoPorKm;
        double tarifaInternacional = esInternacional ? 100000 : 0;
        return tarifaBase + costoVariable + tarifaInternacional;
    }
    
    @Override
    public double tiempoEstimado(double distanciaKm) {
        // Distancia dividida por velocidad, más tiempo para trámites aduaneros si es internacional
        double tiempoVuelo = distanciaKm / velocidadPromedio;
        double tiempoTramites = esInternacional ? 5 : 2;
        return tiempoVuelo + tiempoTramites;
    }
    
    @Override
    public String getTipo() {
        String tipoEnvio = esInternacional ? "Internacional" : "Nacional";
        return "Aéreo " + tipoEnvio + ": " + tipo;
    }
}