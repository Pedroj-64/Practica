package co.edu.uniquindio.factory;

/**
 * Implementación concreta del producto Transporte para el transporte terrestre.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteTerrestre implements Transporte {
    
    private final String tipo;
    private final double velocidadPromedio; // km/h
    private final double costoPorKm;
    
    /**
     * Constructor para TransporteTerrestre.
     * 
     * @param tipo El tipo específico de transporte terrestre (ej: camión, motocicleta)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     */
    public TransporteTerrestre(String tipo, double velocidadPromedio, double costoPorKm) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
    }
    
    @Override
    public String entregar(String paquete) {
        return "Entregando " + paquete + " por vía terrestre usando " + tipo;
    }
    
    @Override
    public double calcularCosto(double distanciaKm) {
        // Base + costo variable por km
        return 10000 + (distanciaKm * costoPorKm);
    }
    
    @Override
    public double tiempoEstimado(double distanciaKm) {
        // Distancia dividida por velocidad, más tiempo adicional para carga y descarga
        return (distanciaKm / velocidadPromedio) + 1;
    }
    
    @Override
    public String getTipo() {
        return "Terrestre: " + tipo;
    }
}