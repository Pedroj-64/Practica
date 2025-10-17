package co.edu.uniquindio.factory;

/**
 * Implementación concreta del producto Transporte para el transporte marítimo.
 * 
 * @author Paula Moreno
 * @version 1.0
 */
public class TransporteMaritimo implements Transporte {
    
    private final String tipo;
    private final double velocidadPromedio; // km/h
    private final double costoPorKm;
    private final int capacidadContenedores;
    
    /**
     * Constructor para TransporteMaritimo.
     * 
     * @param tipo El tipo específico de transporte marítimo (ej: barco de contenedores, ferry)
     * @param velocidadPromedio La velocidad promedio en km/h
     * @param costoPorKm El costo por kilómetro
     * @param capacidadContenedores La capacidad de contenedores del barco
     */
    public TransporteMaritimo(String tipo, double velocidadPromedio, double costoPorKm, int capacidadContenedores) {
        this.tipo = tipo;
        this.velocidadPromedio = velocidadPromedio;
        this.costoPorKm = costoPorKm;
        this.capacidadContenedores = capacidadContenedores;
    }
    
    @Override
    public String entregar(String paquete) {
        return "Entregando " + paquete + " por vía marítima usando " + tipo + " con capacidad para " 
               + capacidadContenedores + " contenedores";
    }
    
    @Override
    public double calcularCosto(double distanciaKm) {
        // Base + costo variable por km, con descuento por volumen según capacidad
        double tarifaBase = 30000;
        double costoVariable = distanciaKm * costoPorKm;
        // A mayor capacidad, menor costo proporcional
        double factorDescuento = Math.max(0.5, 1 - (capacidadContenedores / 1000.0));
        return tarifaBase + (costoVariable * factorDescuento);
    }
    
    @Override
    public double tiempoEstimado(double distanciaKm) {
        // Distancia dividida por velocidad, más tiempo para carga/descarga en puertos
        double tiempoViaje = distanciaKm / velocidadPromedio;
        // A mayor capacidad, más tiempo en puerto
        double tiempoPuerto = 12 + (capacidadContenedores / 100);
        return tiempoViaje + tiempoPuerto;
    }
    
    @Override
    public String getTipo() {
        return "Marítimo: " + tipo + " (" + capacidadContenedores + " contenedores)";
    }
}